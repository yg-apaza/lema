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

    public int putFuncion(String idFuncion, String sc, AtributoFuncion a)
    {
        return 0;
        /*
        if(raiz.tabla.containsKey(c))
	{
            System.out.print("FUNCION INGRESADA: " + c);
            push();
            return 1;
        }
        
        if(sc == null)
        {
            raiz.tabla.put(c, a);
            System.out.print("FUNCION INGRESADA: " + c);
            actual.tabla.put(c, a);
            push();
            return 0;
        }
        
        if(!raiz.tabla.containsKey(sc))
        {			
            System.out.print("FUNCION INGRESADA: " + c);
            push();
            return 2;
        }
	else
	{
            raiz.tabla.put(c,a);
            System.out.print("FUNCION INGRESADA: " + c);
            actual.tabla.put(c, a);
            push();
            return 0;
        }*/
    }
    
    public void putBloque(String bloque)
    {
	Entorno.push();
        System.out.println(" BLOQUE INGRESADO: " + bloque);
    }

    public boolean putIdentificador(String nombre, AtributoVariable a)
    {
        if(!actual.tabla.containsKey(nombre))
	{
            actual.tabla.put(nombre, a);
            System.out.println("  NUEVO IDENTIFICADOR: " + nombre + " -> ENTORNO ACTUAL: " + actual);
            return true;
        }
        return false;    
    }
    
    public boolean putIdentificador(String id, AtributoFuncion a)
    {
        if(!raiz.tabla.containsKey(id))
	{
            raiz.tabla.put(id, a);
            System.out.println("  NUEVO PROTOTIPO DE FUNCION: " + id + " -> ENTORNO ACTUAL: " + actual);
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

    public static void push()
    {
        actual = new Entorno(actual);
        System.out.println(" -> ENTORNO ACTUAL: " + actual);
    }

    public void pop()
    {
        actual = actual.anterior;
        System.out.print(" ENTORNO TERMINADO");
        System.out.println(" -> ENTORNO ACTUAL: " + actual);
    }

    public String toString() 
    {
        if(anterior != null)
            return anterior.toString() + tabla;
        else
            return "" + tabla;
    }
}