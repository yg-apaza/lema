package lema.analizadorSemantico;

import java.util.*;

public class Entorno
{
    static Entorno raiz = new Entorno();
    static Entorno actual = raiz;
    HashMap tabla;
    Entorno anterior;
    
    public Entorno()
    {
        this(null);
    }
    
    public Entorno(Entorno p)
    {
        tabla = new HashMap();
        anterior = p;     
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
        actual = new Entorno(actual);
    }

    public void salirBloque()
    {
        actual = actual.anterior;
    }

    public String toString() 
    {
        if(anterior != null)
            return anterior.toString() + tabla;
        else
            return "" + tabla;
    }
}