package lema.analizadorSemantico;

import java.util.*;

public class Entorno
{
    private class EntornoNodo
    {
        private HashMap tabla;
        private EntornoNodo anterior;
        private ArrayList<EntornoNodo> bloques;

        public EntornoNodo()
        {
            this(null, null, null);
        }

        public EntornoNodo(HashMap tabla, EntornoNodo anterior, ArrayList<EntornoNodo> bloques)
        {
            this.tabla = tabla;
            this.anterior = anterior;
            this.bloques = bloques;
        }

        public HashMap getTabla()
        {
            return tabla;
        }
        
        public String toString()
        {
            return "" + tabla;
        }
    }

    private EntornoNodo raiz;
    private EntornoNodo actual;
    
    public Entorno()
    {
        raiz = new EntornoNodo(new HashMap(), null, null);
        actual = raiz;
    }

    public boolean putIdentificador(String id, AtributoVariable a)
    {
        EntornoNodo aux = actual;
        do
        {
            if(aux.tabla.containsKey(id))
                return false;
            aux = aux.anterior;
        }
        while(aux != null);
        
        actual.tabla.put(id, a);
        return true;
    }
    
    public boolean putFuncion(String id, AtributoFuncion a)
    {
        if(!raiz.tabla.containsKey(id))
	{
            raiz.tabla.put(id, a);
            return true;
        }
        return false;    
    }

    public AtributoVariable buscarVariable(String name)
    {
        for(EntornoNodo e = actual; e != null; e = e.anterior)
        {
            AtributoVariable found;
            try
            {
                found = (AtributoVariable)(e.tabla.get(name));
            }
            catch(ClassCastException ex)
            {
                return null;
            }
            if (found != null)
                return found;
        }
        return null;   
    }
    
    public AtributoFuncion buscarFuncion(String name)
    {
        AtributoFuncion found;
        try
        {
            found = (AtributoFuncion)(raiz.tabla.get(name));
        }
        catch(ClassCastException ex)
        {
            return null;
        }
        
        if (found != null)
            return found;
        return null;
    }
    
    public ArrayList<AtributoFuncion> getFunciones()
    {
        ArrayList<AtributoFuncion> funciones = new ArrayList<AtributoFuncion>();
        Set <String> keys = raiz.tabla.keySet();
        AtributoFuncion found = null;
        for(String key : keys)
        {
            try
            {
                found = (AtributoFuncion)(raiz.tabla.get(key));
            }
            catch(ClassCastException ex){}
            if (found != null)
                funciones.add(found);
        }
        return funciones;
    }

    public void insertarBloque()
    {
        if(actual.bloques == null)
            actual.bloques = new ArrayList<EntornoNodo>();
        EntornoNodo nuevo = new EntornoNodo(new HashMap(), actual, null);
        actual.bloques.add(nuevo);
        actual = nuevo;
    }

    public void salirBloque()
    {
        actual = actual.anterior;
    }
    
    public String toString() 
    {
        return toString(raiz);
    }
    
    private String toString(EntornoNodo e)
    {
        String out = e + "\n";
        if(e.bloques != null)
        {
            for(EntornoNodo b : e.bloques)
            {
                out += toString(b);
            }
        }
        return out;
    }
}