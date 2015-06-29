package lema;

import java.util.ArrayList;

public class Nodo
{
    public int codigo;
    public String valor;
    public ArrayList <Nodo> hijos;
    public boolean terminal; /*true = terminal, false = no terminal*/


    public Nodo()
    {
        this.codigo = -1;
        this.valor = null;
    }

    public Nodo(int codigo, String valor, ArrayList <Nodo> hijos , boolean terminal)
    {    
        this.codigo = codigo;
        this.valor = valor;
        this.hijos = hijos;
        this.terminal = terminal;    
    }

    /*public void insertar(String valor, boolean terminal)
    {
        hijos.add(valor);

        if(!terminal)
    {
        Nodo nuevo = new Nodo();
        hijos.add(nuevo);
    }    
    }*/    
}
