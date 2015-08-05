package lema;

import java.util.*;
import lema.analizadorSemantico.AtributoFuncion;
import lema.analizadorSemantico.AtributoVariable;

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
        raiz = new EntornoNodo(new HashMap(), null, (new ArrayList<EntornoNodo>()));
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
    
    public boolean esGlobal(String name)
    {
        return raiz.tabla.containsKey(name);
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
    
    public ArrayList<AtributoVariable> getVariablesGlobales()
    {
        ArrayList<AtributoVariable> globales = new ArrayList<>();
        Set <String> keys = raiz.tabla.keySet();
        AtributoVariable found = null;
        for(String key : keys)
        {
            try
            {
                found = (AtributoVariable)(raiz.tabla.get(key));
            }
            catch(ClassCastException ex){}
            if (found != null)
                globales.add(found);
        }
        return globales;
    }
    
    public AtributoVariable getAll(String name)
    {
        return getAll(raiz, name);
    }
    
    private AtributoVariable getAll(EntornoNodo e, String name)
    {
        ArrayList<AtributoVariable> vars = new ArrayList<>();
        AtributoVariable found = null;

        try
        {
            found = (AtributoVariable)(e.tabla.get(name));
        }
        catch(ClassCastException ex)
        {
            found = null;
        }
        
        if(found == null)
        {
            for (EntornoNodo bloque : e.bloques)
                if ((found = getAll(bloque, name)) != null)
                    return found;
        }
        
        return found;
    }

    public void insertarBloque()
    {
        if(actual.bloques == null)
            actual.bloques = new ArrayList<EntornoNodo>();
        EntornoNodo nuevo = new EntornoNodo(new HashMap(), actual, new ArrayList<EntornoNodo>());
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