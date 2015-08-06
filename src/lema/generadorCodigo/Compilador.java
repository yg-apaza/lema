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
import javafx.util.Pair;
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
    private ArrayList< Pair<String, String> > cadenas;
    private GeneradorIR generador;
    
    public Compilador(AST arbol, String ruta)
    {
        this.arbol = arbol;
        archivo = "";
        this.ruta = ruta;
        asignaciones = new ArrayList<>();
        asignacionesConst = new ArrayList<> ();
        cadenas = new ArrayList<>();
        generador = new GeneradorIR();
        recorrer(null, arbol.getRaiz());
        System.out.println("POST ARBOL");
        System.out.println(arbol);
    }
    
    public void compilar()
    {
        /** False = 64 bits, True = 32 bits */
        generador.setArquitectura(false);
        
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
            int val1 = -1;
            int val2 = -1;
            switch(nodo.getCodigo())
            {
                case accion.declaracionSimIni:
                    if(padre.getCodigo() != accion.cabecera)
                    {
                        v = arbol.getTabla().getAll(nodo.getHijos().get(1).getValor());
                        Nodo asignacion = nodo.getHijos().get(2);
                        switch(v.getTipo())
                        {
                            case "entero":
                                
                                switch(asignacion.getCodigo())
                                {
                                    case Codigo.idC:
                                        archivo += generador.asignacion(v.getId(), 0, asignacion.getValor(), 1, 1);
                                    break;
                                        
                                    case sym.id:
                                        if(arbol.getTabla().esGlobal(asignacion.getValor()))
                                        {
                                            expCounter++;
                                            String var = "_var" + expCounter;
                                            AtributoVariable glob = arbol.getTabla().getAll(asignacion.getValor());
                                            archivo += generador.cargarVariable(var, asignacion.getValor(), getTipo(glob.getTipo(), false));
                                            archivo += generador.asignacion(v.getId(), 0, var, getTipo(glob.getTipo(), false), 1);
                                        }
                                        else
                                        {
                                            AtributoVariable var = arbol.getTabla().getAll(asignacion.getValor());
                                            archivo += generador.asignacion(v.getId(), 0, var.getId(), getTipo(var.getTipo(), false), 1);
                                        }
                                    break;
                                        
                                    case sym.numero:
                                        archivo += generador.asignacion(v.getId(), 0, asignacion.getValor(), 0, 0);
                                    break;
                                        
                                    case sym.real:
                                        archivo += generador.asignacion(v.getId(), 0, asignacion.getValor(), 1, 0);
                                    break;
                                }
                                
                            break;
                                
                            case "real":
                                
                                switch(asignacion.getCodigo())
                                {
                                    case Codigo.idC:
                                        archivo += generador.asignacion(v.getId(), 1, asignacion.getValor(), 1, 1);
                                    break;
                                        
                                    case sym.id:
                                        
                                        if(arbol.getTabla().esGlobal(asignacion.getValor()))
                                        {
                                            expCounter++;
                                            String var = "_var" + expCounter;
                                            AtributoVariable glob = arbol.getTabla().getAll(asignacion.getValor());
                                            archivo += generador.cargarVariable(var, asignacion.getValor(), getTipo(glob.getTipo(), false));
                                            archivo += generador.asignacion(v.getId(), 1, var, getTipo(glob.getTipo(), false), 1);
                                        }
                                        else
                                        {
                                            AtributoVariable var = arbol.getTabla().getAll(asignacion.getValor());
                                            archivo += generador.asignacion(v.getId(), 1, var.getId(), getTipo(var.getTipo(), false), 1);
                                        }                                        
                                    break;
                                        
                                    case sym.numero:
                                        archivo += generador.asignacion(v.getId(), 1, asignacion.getValor(), 0, 0);
                                    break;
                                        
                                    case sym.real:
                                        archivo += generador.asignacion(v.getId(), 1, asignacion.getValor(), 1, 0);
                                    break;
                                }
                                
                            break;
                                
                            case "cadena":
                                /* ... */
                            break;
                        }
                    }
                break;
                    
                case accion.asignacion:
                    /*
                    int tipo = 1;
                    String op = "";
                    op = nodo.getHijos().get(1).getValor();
                    val1 = -1;
                    val1 = etiqueta(nodo.getHijos().get(1));
                    AtributoVariable v1 = arbol.getTabla().getAll(nodo.getHijos().get(0).getValor());
                    if(!v1.getTipo().equals("cadena"))
                    {
                        if(nodo.getHijos().get(1).getCodigo() == sym.numero)
                        {
                            expCounter++;
                            op = "_var" + expCounter;
                            val1 = 1;
                            archivo += generador.castear(op, nodo.getHijos().get(1).getValor(), getTipo(v1.getTipo(), false), etiqueta(nodo.getHijos().get(1)));
                        }
                        else if((nodo.getHijos().get(1).getCodigo() == sym.id) && arbol.getTabla().esGlobal(nodo.getHijos().get(1).getValor()))
                        {
                            AtributoVariable v2 = arbol.getTabla().getAll(nodo.getHijos().get(1).getValor());
                            expCounter++;
                            op = "_var" + expCounter;
                            val1 = 1;
                            tipo = getTipo(v2.getTipo(), false);
                            archivo += generador.cargarVariable(op, v2.getId(), tipo);
                        }
                        else if(nodo.getHijos().get(1).getCodigo() == sym.id)
                        {
                            AtributoVariable v3 = arbol.getTabla().getAll(nodo.getHijos().get(1).getValor());
                            tipo = getTipo(v3.getTipo(), false);
                        }
                            
                        if(!arbol.getTabla().esGlobal(v1.getId()))
                            archivo += generador.asignar(v1.getId(), op, 1, val1);
                        else
                        {
                            if((getTipo(v1.getTipo(), false) == 0 && tipo == 0) || (getTipo(v1.getTipo(), false) == 1 && tipo == 1))
                                archivo += generador.actualizar(v1.getId(), op, getTipo(v1.getTipo(), false), getTipo(v1.getTipo(), false));
                            else if(getTipo(v1.getTipo(), false) == 0 && tipo == 1)
                            {
                                expCounter++;
                                String aux = "_var" + expCounter;
                                archivo += generador.castear(aux, op, 1, 1);
                                archivo += generador.actualizar(v1.getId(), aux, getTipo(v1.getTipo(), false), getTipo(v1.getTipo(), false));
                            }
                            else if(getTipo(v1.getTipo(), false) == 1 && tipo == 0)
                            {
                                expCounter++;
                                String aux = "_var" + expCounter;
                                archivo += generador.castear(aux, op, 0, 1);
                                archivo += generador.actualizar(v1.getId(), aux, getTipo(v1.getTipo(), false), getTipo(v1.getTipo(), false));
                            }
                        }
                    }
                    else
                    {
                        Pair <String, String> cad = new Pair(v1.getId(), nodo.getHijos().get(1).getValor());
                        cadenas.add(cad);
                    }*/
                break;
                    
                case Codigo.asignacionC:
                    String op1 = nodo.getHijos().get(1).getHijos().get(0).getValor();
                    val1 = etiqueta(nodo.getHijos().get(1).getHijos().get(0));
                    
                    switch(nodo.getHijos().get(1).getHijos().get(0).getCodigo())
                    {
                        case sym.id:
                            AtributoVariable v1 = arbol.getTabla().getAll(op1);
                            if(arbol.getTabla().esGlobal(op1))
                            {
                                expCounter++;
                                archivo += generador.cargarVariable("_var" + expCounter, v1.getId(), getTipo(v1.getTipo(), false));
                                op1 = "_var" + expCounter;
                                val1 = 1;
                            }
                            if(getTipo(v1.getTipo(), false) == 0)
                            {
                                expCounter++;
                                archivo += generador.castear("_var" + expCounter, op1, 0, 1);
                                op1 = "_var" + expCounter;
                                val1 = 1;
                            }
                        break;
                            
                        case sym.numero:
                            expCounter++;
                            archivo += generador.castear("_var" + expCounter, op1, 0, 0);
                            op1 = "_var" + expCounter;
                            val1 = 1;
                        break;
                    }
                    
                    String op2 = "";
                    try
                    {
                        op2 = nodo.getHijos().get(1).getHijos().get(1).getValor();
                        val2 = etiqueta(nodo.getHijos().get(1).getHijos().get(1));

                        switch(nodo.getHijos().get(1).getHijos().get(1).getCodigo())
                        {
                            case sym.id:
                                AtributoVariable v2 = arbol.getTabla().getAll(op2);
                                if(arbol.getTabla().esGlobal(op2))
                                {
                                    expCounter++;
                                    archivo += generador.cargarVariable("_var" + expCounter, v2.getId(), getTipo(v2.getTipo(), false));
                                    op2 = "_var" + expCounter;
                                    val2 = 1;
                                }
                                if(getTipo(v2.getTipo(), false) == 0)
                                {
                                    expCounter++;
                                    archivo += generador.castear("_var" + expCounter, op2, 0, 1);
                                    op2 = "_var" + expCounter;
                                    val2 = 1;
                                }
                            break;

                            case sym.numero:
                                expCounter++;
                                archivo += generador.castear("_var" + expCounter, op2, 0, 0);
                                op2 = "_var" + expCounter;
                                val2 = 1;
                            break;
                        }
                    }
                    catch(IndexOutOfBoundsException ex){}
                    
                    if(nodo.getHijos().get(0).esTerminal())
                    {
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

                            case accion.negacion:
                                archivo += generador.llamar_negacion(op1, nodo.getHijos().get(0).getValor(), 1, val1);
                            break;

                            case accion.negatividad:
                                archivo += generador.llamar_negatividad(op1, nodo.getHijos().get(0).getValor(), 1, val1);
                            break;
                        }
                    }
                    else
                    {
                        /* ACCESO A MATRIZ*/
                    }
                    
                break;
                    
                case accion.escritura:
                    
                break;
                
            }
            for(int i = 0; i < nodo.getHijos().size(); i++)
                compilar(nodo, nodo.getHijos().get(i));
        }
    }
    
    private void declararGlobalVars()
    {
        // Declarar todas las variables
        /* Revisar MATRICES GLOBALES */
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
                    if(!n.getHijos().get(0).getValor().equals("cadena"))
                    { 
                        if(p.getCodigo() != accion.cabecera)
                        {
                            n.getHijos().set(2, extender(n.getHijos().get(2), false));
                            pos = p.getHijos().indexOf(n);
                            ordenar(asignaciones);
                            p.getHijos().addAll(pos, asignaciones);
                            asignaciones.clear();
                        }
                        else
                        {
                            ArrayList<Nodo> hijosAsig = new ArrayList<>();
                            Nodo nuevo = extender(n.getHijos().get(2), false);
                            hijosAsig.add(n.getHijos().get(1));
                            hijosAsig.add(nuevo);
                            asignaciones.add(new Nodo(Codigo.asignacionGlobalC, Codigo.getNombre(Codigo.asignacionGlobalC), -1, -1, hijosAsig, false));
                            asignacionesConst.addAll(asignaciones);
                            n.getHijos().remove(2);
                            asignaciones.clear();
                        }
                    }
                    else
                    {
                        Pair<String,String> cad = new Pair(n.getHijos().get(1).getValor(),n.getHijos().get(2).getValor());
                        cadenas.add(cad);
                    }
                break;
                    
                case accion.asignacion:
                    System.out.println("sadfasdf");
                    if(n.getHijos().get(0).esTerminal())
                    {
                        AtributoVariable v = arbol.getTabla().getAll(n.getHijos().get(0).getValor());
                        if(!v.esMatriz())
                            n.getHijos().set(1, extender(n.getHijos().get(1), false));
                        else
                            n.getHijos().set(1, extender(n.getHijos().get(1), true));
                    }
                    else
                        n.getHijos().set(1, extender(n.getHijos().get(1), false));

                    pos = p.getHijos().indexOf(n);
                    ordenar(asignaciones);
                    p.getHijos().addAll(pos, asignaciones);
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
    
    public Nodo extender(Nodo n, boolean matriz)
    {
        if(!n.esTerminal())
        {
            ArrayList<Nodo> operandos = new ArrayList<Nodo>();
            for(int i = 0; i < n.getHijos().size(); i++)
                operandos.add(extender(n.getHijos().get(i), matriz));
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
                case accion.accesoMat:
                    if(!matriz)
                    {
                        expCounter++;
                        hijosAsig.add(new Nodo(Codigo.idC, "_var" + expCounter, -1, -1, null, true));
                        nuevo.setHijos(operandos);
                        hijosAsig.add(nuevo);
                        asignaciones.add(new Nodo(Codigo.asignacionC, Codigo.getNombre(Codigo.asignacionC), -1, -1, hijosAsig, false));
                        return (new Nodo(Codigo.idC, "_var" + expCounter, -1, -1, null, true)); 
                    }
                    else
                    {
                        expCounter++;
                        hijosAsig.add(new Nodo(Codigo.idMC, "_var" + expCounter, -1, -1, null, true));
                        nuevo.setHijos(operandos);
                        hijosAsig.add(nuevo);
                        asignaciones.add(new Nodo(Codigo.asignacionMC, Codigo.getNombre(Codigo.asignacionMC), -1, -1, hijosAsig, false));
                        return (new Nodo(Codigo.idMC, "_var" + expCounter, -1, -1, null, true)); 
                    }
                case accion.elemMat:
                case accion.llamadaFuncion:
                    return n;
                    
            }
        }
        else
        {
            switch(n.getCodigo())
            {
                case sym.numero:
                case sym.real:
                case sym.id:
                case Codigo.idC:
                case Codigo.idMC:
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
        /* idM e.e */
        if(n.getCodigo() == sym.id || n.getCodigo() == Codigo.idC)
            return 1;
        else
            return 0;
    }
    
}