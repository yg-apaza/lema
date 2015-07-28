package lema;

import java.util.ArrayList;

public class Nodo
{
    private int              codigo;
    private String           valor;
    private int              linea;
    private int              columna;
    private ArrayList <Nodo> hijos;
    private boolean          terminal; /*true = terminal, false = no terminal*/
    
    public Nodo()
    {
        this.codigo     = -1;
        this.valor      = "NULL";
        this.linea      = -1;
        this.columna    = -1;
        this.hijos      = null;
        this.terminal   = true;
    }

    public Nodo(int codigo, String valor, int linea, int columna, ArrayList<Nodo> hijos, boolean terminal)
    {
        this.codigo     = codigo;
        this.valor      = valor;
        this.linea      = linea;
        this.columna    = columna;
        this.hijos      = hijos;
        this.terminal   = terminal;
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

    public int getLinea()
    {
        return linea;
    }

    public void setLinea(int linea)
    {
        this.linea = linea;
    }

    public int getColumna()
    {
        return columna;
    }

    public void setColumna(int columna)
    {
        this.columna = columna;
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
    /*
    public void printTest()
    {
        imprimirTest(this,0,0);
        System.out.print("\n");
    }
    
    public void imprimirTest(Nodo nodo,int ancho,int largo)
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
             
            for(int i = 0;i < nodo.getHijos().size();i++)                                        
                imprimirTest(nodo.getHijos().get(i),ancho,largo);
        }
        else
        {
            int bandera = 0;
            for(int j = 0;j < largo ;j++)
            {
                if(bandera == 1)
                    System.out.print("-");                    
                else if(ancho == j)
                {
                    System.out.print("|");
                    bandera = 1;
                }
                else
                    System.out.print(" ");
            }
            System.out.print(" " + nodo.getValor());
        }
    }
    */
    
    public void print(){
        imprimir(this,0,0,-1,this.getValor());
    }
    
    public void imprimir(Nodo nodo,int ancho,int largo,int u,String padre)
    {
        System.out.println("");
        System.out.flush();
        if(!nodo.isTerminal())
        {
            for(int j = 0;j < ancho;j++)
            {
                System.out.print(" ");
                System.out.flush();
            } 

            System.out.print("|--[ " + nodo.getValor() + " ]" + " --> ( " + padre + " + " + u + " )" + " Lin: " + nodo.getLinea() + " Col: " + nodo.getColumna());
            System.out.flush();
            largo = (8+nodo.getValor().length())/2;
            ancho = ancho + largo;
            largo = largo + ancho;

            for(int i = 0;i < nodo.getHijos().size();i++){
                imprimir(nodo.getHijos().get(i),ancho,largo,i,nodo.getValor());
            } 
        }
        else
        {
            int bandera = 0;
            for(int j = 0;j < largo ;j++){
                if(bandera == 1)
                {
                    System.out.print("-");
                    System.out.flush();
                }
                else if(ancho == j)
                {
                    System.out.print("|");
                    System.out.flush();
                    bandera = 1;
                }
                else
                {
                    System.out.print(" ");
                    System.out.flush();
                }
            }

            System.out.print("[ " + nodo.getValor() + " ] --> ( " + padre + " + " + u + " )");
            System.out.flush();
        }
    }
    
}
