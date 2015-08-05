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
    private String archivo;
    private String ruta;
    private GeneradorIR generador;
        
    public Compilador(AST arbol, String ruta)
    {
        this.arbol = arbol;
        archivo = "";
        this.ruta = ruta;
        asignaciones = new ArrayList<>();
        generador = new GeneradorIR();
        recorrer(null, arbol.getRaiz());
    }
    
    public void compilar()
    {
        archivo += generador.arquitectura();
        declararGlobalVars();
        archivo += generador.llamar_principal();
        compilar(arbol.getRaiz());
        archivo += generador.terminar_principal();
        
        
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
    
    private void compilar(Nodo nodo)
    {
        if(!nodo.esTerminal())
        {
            switch(nodo.getCodigo())
            {
                case accion.declaracionSimIni:
                    
                break;
            }
            for(int i = 0; i < nodo.getHijos().size(); i++)
                compilar(nodo.getHijos().get(i));
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
                        ArrayList<Nodo> hijosSum = new ArrayList<Nodo>();
                        Nodo cero = new Nodo(sym.real, "0.0", -1, -1, null, true);
                        hijosSum.add(extender(n.getHijos().get(2)));
                        System.out.println("HIJO 1 - SUMA");
                        System.out.println(n.getHijos().size());
                        hijosSum.add(cero);
                        Nodo suma = new Nodo(accion.suma, accion.acciones[accion.suma], -1, -1, hijosSum, false);
                        n.getHijos().set(2, suma);
                        pos = p.getHijos().indexOf(n);
                        ordenar(asignaciones);
                        p.getHijos().addAll((pos == 0)?0:(pos-1), asignaciones);
                        asignaciones.clear();
                        
                    }
                    else
                    {
                        
                    }
                break;
                    
                case accion.asignacion:
                    n.getHijos().set(1, extender(n.getHijos().get(1)));
                    pos = p.getHijos().indexOf(n);
                    ordenar(asignaciones);
                    p.getHijos().addAll((pos == 0)?0:(pos-1), asignaciones);
                    
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
}