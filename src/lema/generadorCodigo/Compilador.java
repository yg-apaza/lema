package lema.generadorCodigo;

import java.util.ArrayList;
import lema.analizadorLexico.sym;
import lema.analizadorSemantico.AST;
import lema.analizadorSemantico.Nodo;
import lema.analizadorSemantico.accion;

public class Compilador
{
    private AST arbol;
    private int expCounter = 0;
    private ArrayList<Nodo> asignaciones;
    
    public Compilador(AST arbol)
    {
        this.arbol = arbol;
        asignaciones = new ArrayList<Nodo>();
        recorrer(null, arbol.getRaiz());
        System.out.println(asignaciones);
    }
    
    public void recorrer(Nodo p, Nodo n)
    {
        if(!n.esTerminal())
        {
            switch(n.getCodigo())
            {
                case accion.declaracionSimIni:
                    n.getHijos().set(2, extender(n.getHijos().get(2)));
                    int i = p.getHijos().indexOf(n);
                    p.getHijos().addAll((i == 0)?0:(i-1), asignaciones);
                    
                    asignaciones.clear();
                break;
            }
            for(int i = 0; i < n.getHijos().size(); i++)
                recorrer(n, n.getHijos().get(i));
        }
    }
    
    public Nodo extender(Nodo n)
    {
        if(!n.esTerminal())
        {
            ArrayList<Nodo> operandos = new ArrayList<Nodo>();
            for(int i = 0; i < n.getHijos().size(); i++)
                operandos.add(extender(n.getHijos().get(i)));
            ArrayList<Nodo> hijosAsig = new ArrayList<Nodo>();
            Nodo nuevo = n;
            switch(n.getCodigo())
            {
                case accion.suma:
                case accion.resta:
                case accion.producto:
                case accion.division:
                case accion.modulo:
                case accion.mayor:
                case accion.mayor_igual:
                case accion.menor:
                case accion.menor_igual:
                case accion.disyuncion:
                case accion.conjuncion:
                case accion.identico:
                case accion.diferente:
                case accion.negacion:
                case accion.negatividad:
                case accion.operacionCond:
                    expCounter++;
                    hijosAsig.add(new Nodo(sym.id, "_var" + expCounter, -1, -1, null, true));
                    nuevo.setHijos(operandos);
                    hijosAsig.add(nuevo);
                    asignaciones.add(new Nodo(accion.asignacion, accion.acciones[accion.asignacion], -1, -1, hijosAsig, false));
                    return (new Nodo(sym.id, "_var" + expCounter, -1, -1, null, true)); 
            }
        }
        else
        {
            switch(n.getCodigo())
            {
                case sym.numero:
                case sym.real:
                case sym.id:
                    return n;
            }
        }
        
        return null;
        
    }
    
}
