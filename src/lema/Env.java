package lema;

import java.util.*;

public class Env
{
    static Env raiz = new Env(null);
    static Env top = raiz;
    HashMap table;  
    Env prev;  
    
    public Env()
    {
        this(null);
    }
    
    public Env(Env p)
    {
        table = new HashMap();
        prev = p;     
    }

    public int putFuncion(String c, String sc, AtributoFuncion a)
    {
        if(raiz.table.containsKey(c))
	{
            System.out.print("FUNCION INGRESADA: "+c);
            push();
            return 1;
        }
        
        if(sc == null)
        {
            raiz.table.put(c,a);
            System.out.print("FUNCION INGRESADA: "+c);
            top.table.put(c, a);
            push();
            return 0;
        }
        
        if(!raiz.table.containsKey(sc))
        {			
            System.out.print("FUNCION INGRESADA: "+c);
            push();
            return 2;
        }
	else
	{
            raiz.table.put(c,a);
            System.out.print("FUNCION INGRESADA: " + c);
            top.table.put(c, a);
            push();
            return 0;
        }    
    }
    
    public void putBloque(String bloque)
    {
	Env.push();
        System.out.println(" BLOQUE INGRESADO: " + bloque);
    }

    public boolean putIdentificador(String name, AtributoVariable a)
    {
        if(!top.table.containsKey(name))
	{
            top.table.put(name, a);
            System.out.println("  NUEVO IDENTIFICADOR: "+name+" -> ENTORNO ACTUAL: "+top);
            return true;
        }
        return false;    
    }

    public String get(String name)
    {
        for(Env e = top; e != null; e = e.prev)
        { 
            String found = (String)(e.table.get(name));
            if (found != null) return found;
        }
        return null;   
    }

    public static void push()
    {
        top = new Env(top);
        System.out.println(" -> ENTORNO ACTUAL: "+top);
    }

    public void pop()
    {
        top = top.prev;
        System.out.print(" ENTORNO TERMINDADO");
        System.out.println(" -> ENTORNO ACTUAL: "+top);
    }

    public String toString() 
    {
        if(prev != null) return prev.toString()+table;
        else return ""+table;
    }
}