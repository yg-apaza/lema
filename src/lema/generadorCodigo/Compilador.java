package lema.generadorCodigo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import lema.analizadorLexico.sym;
import lema.analizadorSemantico.AST;
import lema.analizadorSemantico.AtributoVariable;
import lema.analizadorSemantico.Nodo;
import lema.analizadorSemantico.accion;

public class Compilador
{
    private AST arbol;
    private int expCounter = 0;
    private ArrayList<Nodo> asignaciones;
    private ArrayList<Nodo> asignacionesConst;
    private String archivo;
    private String ruta;
    private GeneradorIR generador;
    
    public Compilador(AST arbol, String ruta)
    {
        this.arbol = arbol;
        archivo = "";
        this.ruta = ruta;
        asignaciones = new ArrayList<>();
        asignacionesConst = new ArrayList<> ();
        generador = new GeneradorIR();
        recorrer(null, arbol.getRaiz());
    }
    
    public void compilar()
    {
        archivo += generador.arquitectura();
        declararGlobalVars();
        archivo += generador.llamar_principal();
        compilar(null ,arbol.getRaiz());
        archivo += generador.terminar_principal();
        archivo += generador.finalizar();
        
        
        /** Generación de Código */
        File bash = new File("bash.sh");
        File fll = new File(ruta + ".ll");
        File fbc = new File(ruta + ".bc");
        File fs  = new File(ruta + ".s");
        File fex = new File(ruta);
        PrintWriter out = null;
        try
        {
            System.out.println("Generando archivo " + fex.getAbsolutePath() + " (Ejecutable) ...");
            
            out = new PrintWriter(fll);
            out.print(archivo);
            out.close();
            
            String exe1 = "llvm-as \"" + fll.getAbsolutePath() + "\"";
            String exe2 = "opt -S \"" + fll.getAbsolutePath() + "\"";
            String exe3 = "llc \"" + fbc.getAbsolutePath() + "\"";
            String exe4 = "gcc -o \"" + fex.getAbsolutePath() + "\" \"" + fs.getAbsolutePath() + "\"";
            
            out = new PrintWriter(bash);
            out.print(exe1 + "\n" + exe2 + "\n" + exe3 + "\n" + exe4);
            out.close();
            
            boolean correcto = true;
            
            BufferedReader br;
            BufferedReader stdError;
            String linea;
            Process p1 = Runtime.getRuntime().exec("./bash.sh");
            br = new BufferedReader(new InputStreamReader(p1.getInputStream()));
            stdError = new BufferedReader(new InputStreamReader(p1.getErrorStream())); 
            while ((linea = br.readLine()) != null)
                System.out.println(linea);
            while ((linea = stdError.readLine()) != null)
            {
                System.out.println(linea);
                correcto = false;
            }
            p1.waitFor();
            
            if(correcto)
                System.out.println("Finalizado: Ejecutable generado. Compilación exitosa");
            else
                System.out.println("Finalizado: Ocurrieron errores durante la compilación");
            
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Imposible generar " + fll.getAbsolutePath());
        }
        catch (IOException ex)
        {
            System.out.println("Error de compilación");
        } catch (InterruptedException ex)
        {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            out.close();
        }
    }
    
    private void compilar(Nodo padre, Nodo nodo)
    {
        if(!nodo.esTerminal())
        {
            AtributoVariable v;
            switch(nodo.getCodigo())
            {
                case accion.declaracionSimIni:
                    if(padre.getCodigo() != accion.cabecera)
                    {
                        
                        v = arbol.getTabla().getAll(nodo.getHijos().get(1).getValor());
                        String datoAsig = nodo.getHijos().get(2).getValor();
                        
                        if(v.getTipo().equals("entero") && !v.esMatriz())
                        {
                            expCounter++;
                            datoAsig = "_var" + expCounter;
                            archivo += generador.castear(datoAsig, nodo.getHijos().get(2).getValor(), 1, etiqueta(nodo.getHijos().get(2)));
                        }
                        archivo += generador.asignar(nodo.getHijos().get(1).getValor(), datoAsig, getTipo(v.getTipo(), false), etiqueta(nodo.getHijos().get(2)));
                    }
                break;
                    
                case Codigo.asignacionC:
                    String op1 = nodo.getHijos().get(1).getHijos().get(0).getValor();
                    String op2 = nodo.getHijos().get(1).getHijos().get(1).getValor();
                    int val1 = etiqueta(nodo.getHijos().get(1).getHijos().get(0));
                    int val2 = etiqueta(nodo.getHijos().get(1).getHijos().get(1));
                    System.out.println("ANTES " + op2);
                    if(nodo.getHijos().get(1).getHijos().get(0).getCodigo() == sym.numero)
                    {
                        expCounter++;
                        op1 = "_var" + expCounter;
                        val1 = 1;
                        archivo += generador.castear(op1, nodo.getHijos().get(1).getHijos().get(0).getValor(), 0, etiqueta(nodo.getHijos().get(1).getHijos().get(0)));
                    }
                    
                    if(nodo.getHijos().get(1).getHijos().get(1).getCodigo() == sym.numero)
                    {
                        expCounter++;
                        op2 = "_var" + expCounter;
                        val2 = 1;
                        archivo += generador.castear(op2, nodo.getHijos().get(1).getHijos().get(1).getValor(), 0, etiqueta(nodo.getHijos().get(1).getHijos().get(1)));
                    }
                    System.out.println(op2);
                    switch(nodo.getHijos().get(1).getCodigo())
                    {
                        case accion.suma:
                            archivo += generador.llamar_suma(op1, op2, nodo.getHijos().get(0).getValor(), 1, val1, val2);
                        break;
                            
                        case accion.resta:
                            archivo += generador.llamar_resta(op1, op2, nodo.getHijos().get(0).getValor(), 1, val1, val2);
                        break;
                            
                        case accion.producto:
                            archivo += generador.llamar_producto(op1, op2, nodo.getHijos().get(0).getValor(), 1, val1, val2);
                        break;
                            
                        case accion.division:
                            archivo += generador.llamar_division(op1, op2, nodo.getHijos().get(0).getValor(), 1, val1, val2);
                        break;
                            
                        case accion.modulo:
                            archivo += generador.llamar_modulo(op1, op2, nodo.getHijos().get(0).getValor(), 1, val1, val2);
                        break;
                            
                        case accion.mayor:
                            archivo += generador.llamar_mayor(op1, op2, nodo.getHijos().get(0).getValor(), 1, val1, val2);
                        break;
                            
                        case accion.mayor_igual:
                            archivo += generador.llamar_mayor_igual(op1, op2, nodo.getHijos().get(0).getValor(), 1, val1, val2);
                        break;
                            
                        case accion.menor:
                            archivo += generador.llamar_menor(op1, op2, nodo.getHijos().get(0).getValor(), 1, val1, val2);
                        break;
                            
                        case accion.menor_igual:
                            archivo += generador.llamar_menor_igual(op1, op2, nodo.getHijos().get(0).getValor(), 1, val1, val2);
                        break;
                            
                        case accion.disyuncion:
                            archivo += generador.llamar_disyuncion(op1, op2, nodo.getHijos().get(0).getValor(), 1, val1, val2);
                        break;
                            
                        case accion.conjuncion:
                            archivo += generador.llamar_conjuncion(op1, op2, nodo.getHijos().get(0).getValor(), 1, val1, val2);
                        break;
                            
                        case accion.identico:
                            archivo += generador.llamar_identico(op1, op2, nodo.getHijos().get(0).getValor(), 1, val1, val2);
                        break;
                    }
                    
                break;
            }
            for(int i = 0; i < nodo.getHijos().size(); i++)
                compilar(nodo, nodo.getHijos().get(i));
        }
    }
    
    private void declararGlobalVars()
    {
        // Declarar todas las variables
        ArrayList <AtributoVariable> vars = arbol.getTabla().getVariablesGlobales();
        for(AtributoVariable v: vars)
            archivo += (generador.declararVariable(v.getId(), "", getTipo(v.getTipo(), v.esMatriz()), v.esConstante()));
    }
    
    private void recorrer(Nodo p, Nodo n)
    {
        if(!n.esTerminal())
        {
            int pos = -1;
            switch(n.getCodigo())
            {
                case accion.declaracionSimIni:
                    if(p.getCodigo() != accion.cabecera)
                    {
                        n.getHijos().set(2, extender(n.getHijos().get(2)));
                        pos = p.getHijos().indexOf(n);
                        ordenar(asignaciones);
                        p.getHijos().addAll((pos == 0)?0:(pos-1), asignaciones);
                        asignaciones.clear();
                        
                    }
                    else
                    {
                        ArrayList<Nodo> hijosAsig = new ArrayList<>();
                        Nodo nuevo = extender(n.getHijos().get(2));
                        hijosAsig.add(n.getHijos().get(1));
                        hijosAsig.add(nuevo);
                        asignaciones.add(new Nodo(Codigo.asignacionGlobalC, Codigo.getNombre(Codigo.asignacionGlobalC), -1, -1, hijosAsig, false));
                        asignacionesConst.addAll(asignaciones);
                        n.getHijos().remove(2);
                        asignaciones.clear();
                    }
                break;
                    
                case accion.asignacion:
                    n.getHijos().set(1, extender(n.getHijos().get(1)));
                    pos = p.getHijos().indexOf(n);
                    ordenar(asignaciones);
                    p.getHijos().addAll((pos == 0)?0:(pos-1), asignaciones);
                    
                    asignaciones.clear();
                break;
                
                case accion.programaPrincipal:
                    n.getHijos().addAll(0, asignacionesConst);
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
                    asignaciones.add(new Nodo(Codigo.asignacionC, Codigo.getNombre(Codigo.asignacionC), -1, -1, hijosAsig, false));
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
    
    private int getTipo(String tipo, boolean matriz)
    {
        if(matriz)
            switch(tipo)
            {
                case "entero":
                    return 2;
                case "real":
                    return 3;
                case "cadena":
                    return -1;
            }
        else
            switch(tipo)
            {
                case "entero":
                    return 0;
                case "real":
                    return 1;
                case "cadena":
                    return 4;
            }
        return -1;
    }
    
    private void ordenar(ArrayList<Nodo> asigs)
    {
        NodoComparator c = new NodoComparator();
        asigs.sort(c);
    }
    
    public class NodoComparator implements Comparator<Nodo>
    {
        @Override
        public int compare(Nodo a, Nodo b)
        {
            int ind1 = Integer.parseInt(a.getHijos().get(0).getValor().substring(a.getHijos().get(0).getValor().indexOf("r")+1));
            int ind2 = Integer.parseInt(b.getHijos().get(0).getValor().substring(b.getHijos().get(0).getValor().indexOf("r")+1));
            
            return ind1 < ind2 ? -1 : ind1 == ind2 ? 0 : 1;
        }
    }
    
    public int etiqueta(Nodo n)
    {
        if(n.getCodigo() == sym.id)
            return 1;
        else
            return 0;
    }
}