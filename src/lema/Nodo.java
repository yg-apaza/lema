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

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public String getValor()
    {
        return valor;
    }

    public void setValor(String valor)
    {
        this.valor = valor;
    }

    public ArrayList<Nodo> getHijos()
    {
        return hijos;
    }

    public void setHijos(ArrayList<Nodo> hijos)
    {
        this.hijos = hijos;
    }

    public boolean isTerminal()
    {
        return terminal;
    }

    public void setTerminal(boolean terminal)
    {
        this.terminal = terminal;
    }
    
    public void print()
    {
        imprimir(this,0,0);
        System.out.print("\n");
    }
    
    public void imprimir(Nodo nodo,int ancho,int largo)
    {
        System.out.print("\n");
        if(!nodo.isTerminal())
        {   
            for(int j = 0;j < ancho;j++)
                System.out.print(" ");    
            
            System.out.print("|--["+nodo.getValor()+"]");
            largo = (6+nodo.getValor().length())/2;
            ancho = ancho + largo;
            largo = largo + ancho;
             
            for(int i = 0;i < nodo.getHijos().size();i++){                                        
                imprimir(nodo.getHijos().get(i),ancho,largo);
            } 
        }
        else{
            int bandera = 0;
            for(int j = 0;j < largo ;j++){
                if(bandera == 1)
                    System.out.print("-");                    
                else if(ancho == j){
                    System.out.print("|");
                    bandera = 1;
                }
                else
                    System.out.print(" ");
            }
            System.out.print(" " + nodo.getValor());
        }
    }
}