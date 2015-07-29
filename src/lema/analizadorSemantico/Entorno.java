package lema.analizadorSemantico;

import java.util.*;

public class Entorno
{
    Entorno raiz = new Entorno();
    Entorno actual = raiz;
    Entorno anterior;
    ArrayList<Entorno> hijos;
    
    private HashMap tabla;
    
    
    public Entorno()
    {
        this(null);
    }
    
    public Entorno(Entorno p)
    {
        tabla = new HashMap();
        anterior = p;
        hijos = null;
    }

    public boolean putIdentificador(String nombre, AtributoVariable a)
    {
        if(!actual.tabla.containsKey(nombre))
	{
            actual.tabla.put(nombre, a);
            return true;
        }
        return false;    
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

    public String get(String name)
    {
        for(Entorno e = actual; e != null; e = e.anterior)
        { 
            String found = (String)(e.tabla.get(name));
            if (found != null)
                return found;
        }
        return null;   
    }

    public void insertarBloque()
    {
        if(hijos == null)
            hijos = new ArrayList<Entorno>();
        actual = new Entorno(actual);
        hijos.add(actual);
    }

    public void salirBloque()
    {
        actual = actual.anterior;
    }

    public ArrayList<Entorno> getHijos()
    {
        return hijos;
    }

    public void setHijos(ArrayList<Entorno> hijos)
    {
        this.hijos = hijos;
    }

    private String toString(Entorno e)
    {
        String out = "" + tabla;
        if(e.getHijos() != null)
        {
            for (Entorno hijo : e.getHijos())
            {
                out += hijo.tabla;
            }
        }

        return out;
    }
    
    public String toString() 
    {
        return this.toString(raiz);
        /*
        if(anterior != null)
            return anterior.toString() + tabla;
        else
            return "" + tabla;
                */
    }
}