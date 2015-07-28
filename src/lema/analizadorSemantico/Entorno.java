package lema.analizadorSemantico;

import java.util.*;

public class Entorno
{
    static Entorno raiz = new Entorno();
    static Entorno actual = raiz;
    HashMap table;
    Entorno anterior;
    
    public Entorno()
    {
        this(null);
    }
    
    public Entorno(Entorno p)
    {
        table = new HashMap();
        anterior = p;     
    }

    public int putFuncion(String idFuncion, String sc, AtributoFuncion a)
    {
        return 0;
        /*
        if(raiz.table.containsKey(c))
	{
            System.out.print("FUNCION INGRESADA: " + c);
            push();
            return 1;
        }
        
        if(sc == null)
        {
            raiz.table.put(c, a);
            System.out.print("FUNCION INGRESADA: " + c);
            actual.table.put(c, a);
            push();
            return 0;
        }
        
        if(!raiz.table.containsKey(sc))
        {			
            System.out.print("FUNCION INGRESADA: " + c);
            push();
            return 2;
        }
	else
	{
            raiz.table.put(c,a);
            System.out.print("FUNCION INGRESADA: " + c);
            actual.table.put(c, a);
            push();
            return 0;
        }*/   
    }
    
    public void putBloque(String bloque)
    {
	Entorno.push();
        System.out.println(" BLOQUE INGRESADO: " + bloque);
    }

    public boolean putIdentificador(String name, AtributoVariable a)
    {
        if(!actual.table.containsKey(name))
	{
            actual.table.put(name, a);
            System.out.println("  NUEVO IDENTIFICADOR: " + name + " -> ENTORNO ACTUAL: " + actual);
            return true;
        }
        return false;    
    }
    
    public boolean putIdentificador(String id, AtributoFuncion a)
    {
        if(!actual.table.containsKey(id))
	{
            actual.table.put(id, a);
            System.out.println("  NUEVO IDENTIFICADOR: " + id + " -> ENTORNO ACTUAL: " + actual);
            return true;
        }
        return false;    
    }

    public String get(String name)
    {
        for(Entorno e = actual; e != null; e = e.anterior)
        { 
            String found = (String)(e.table.get(name));
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
        System.out.print(" ENTORNO TERMINDADO");
        System.out.println(" -> ENTORNO ACTUAL: " + actual);
    }

    public String toString() 
    {
        if(anterior != null)
            return anterior.toString()+table;
        else
            return "" + table;
    }
}