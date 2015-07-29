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
    
    public void putBloque(String bloque)
    {
	Entorno.push();
        //System.out.println(" BLOQUE INGRESADO: " + bloque);
    }

    public boolean putIdentificador(String nombre, AtributoVariable a)
    {
        if(!actual.tabla.containsKey(nombre))
	{
            actual.tabla.put(nombre, a);
            //System.out.println("  NUEVO IDENTIFICADOR: " + nombre + " -> ENTORNO ACTUAL: " + actual);
            return true;
        }
        return false;    
    }
    
    public boolean putIdentificador(String id, AtributoFuncion a)
    {
        if(!raiz.tabla.containsKey(id))
	{
            raiz.tabla.put(id, a);
            //System.out.println("NUEVO PROTOTIPO DE FUNCION: " + id + " -> ENTORNO ACTUAL: " + actual);
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

    private static void push()
    {
        actual = new Entorno(actual);
        //System.out.println(" -> ENTORNO ACTUAL: " + actual);
    }

    public void pop()
    {
        actual = actual.anterior;
        //System.out.print(" ENTORNO TERMINADO");
        //System.out.println(" -> ENTORNO ACTUAL: " + actual);
    }

    public String toString() 
    {
        if(anterior != null)
            return anterior.toString() + tabla;
        else
            return "" + tabla;
    }
}