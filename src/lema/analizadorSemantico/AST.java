package lema.analizadorSemantico;

import lema.Entorno;
import java.util.ArrayList;
import lema.Mistake;
import lema.analizadorLexico.sym;

public class AST
{
    private Nodo raiz;
    private Entorno tablaSimbolos;
    private TypeCheck tc;
    private Mistake errores;
    
    public AST()
    {
        this(new Nodo(),null);
    }
    
    public AST(Nodo raiz, Mistake errores)
    {
        this.raiz = raiz;
        tablaSimbolos = new Entorno();
        this.errores = errores;
        tc = new TypeCheck();
    }
    
    private void fix(Nodo nodo)
    {
        if(!nodo.esTerminal())
        {
            switch(nodo.getCodigo())
            {
                case accion.elemMat:
                    ArrayList<Nodo> elementosMat = nodo.getHijos();
                    if(elementosMat.isEmpty())
                        nodo.getHijos().add(new Nodo(accion.elemVec, accion.acciones[accion.elemVec], nodo.getLinea(), nodo.getColumna(), (new ArrayList <Nodo>()), false));
                    else
                    {
                        /** Los elementos contenidos por la matriz son simples o vectores, TRUE Matrices, FALSE Simples*/
                        boolean flag = (accion.elemMat == elementosMat.get(0).getCodigo() && !elementosMat.get(0).esTerminal());
                        boolean iguales = true;

                        for(int i = 0; i < elementosMat.size(); i++)
                        {
                            if((elementosMat.get(i).getCodigo() == accion.elemMat) && !elementosMat.get(i).esTerminal())
                            {
                                elementosMat.get(i).setCodigo(accion.elemVec);
                                elementosMat.get(i).setValor(accion.acciones[accion.elemVec]);
                            }
                        }

                        for(int i = 1; i < elementosMat.size(); i++)
                        {
                            if(!((elementosMat.get(i).getCodigo() == accion.elemVec) == flag))
                            {
                                iguales = false;
                                break;
                            }
                        }
                        if(iguales && !flag)
                        {
                            ArrayList<Nodo> enlace = new ArrayList<>();
                            enlace.add(new Nodo(accion.elemVec, accion.acciones[accion.elemVec], nodo.getLinea(), nodo.getColumna(), elementosMat, false));
                            nodo.setHijos(enlace);
                        }
                    }
                break;

                case accion.elemVec:
                    for(int i = 0; i < nodo.getHijos().size(); i++)
                    {
                        if((nodo.getHijos().get(i).getCodigo() == accion.elemMat) && !nodo.getHijos().get(i).esTerminal())
                        {
                            nodo.getHijos().get(i).setCodigo(accion.elemVec);
                            nodo.getHijos().get(i).setValor(accion.acciones[accion.elemVec]);
                        }
                    }
                break;

            }
            
            for(int i = 0; i < nodo.getHijos().size(); i++)
                fix(nodo.getHijos().get(i));
        }
        else
        {
            switch(nodo.getCodigo())
            {
                case sym.hexa_e:
                    nodo.setCodigo(sym.numero);
                    nodo.setValor(Converter.hexToInt(nodo.getValor()));
                break;
                    
                case sym.hexa_r:
                    nodo.setCodigo(sym.real);
                    nodo.setValor(Converter.hexToDouble(nodo.getValor()));
                break;
               
                case sym.octa_e:
                    nodo.setCodigo(sym.numero);
                    nodo.setValor(Converter.octToInt(nodo.getValor()));
                break;
                
                case sym.octa_r:
                    nodo.setCodigo(sym.real);
                    nodo.setValor(Converter.octToDouble(nodo.getValor()));
                break;
            }
        }
    }
    
    public void verificar()
    {
        fix(raiz);
        verificar(raiz);
        verificarSaltar(raiz, false);
        ArrayList<AtributoFuncion> funciones = tablaSimbolos.getFunciones();
        for (AtributoFuncion fun : funciones)
            if (!fun.esDefinido())
                errores.insertarError(Mistake.SEMANTICO, Mistake.FUNCION_NO_DEFINIDA, new String[]{fun.getId(), String.valueOf(0), String.valueOf(0)});
    }
    
    private void verificar(Nodo nodo)
    {
        if(!nodo.esTerminal())
        {
            AtributoVariable v;
            AtributoFuncion f;
            ArrayList<Nodo> elementosMat;
            int e = -1;
            int r = -1;
            boolean indice1;
            boolean indice2;
            boolean flag;
            switch(nodo.getCodigo())
            {
                case accion.declaracionSim:
                    v = new AtributoVariable(
                                                nodo.getHijos().get(0).getValor(),
                                                nodo.getHijos().get(1).getValor(),
                                                false,
                                                1, 1,
                                                false 
                                            );
                    if(!tablaSimbolos.putIdentificador(v.getId(), v))
                        errores.insertarError(Mistake.SEMANTICO, Mistake.ID_DECLARADO, (new String[] {v.getId(),String.valueOf(nodo.getHijos().get(1).getLinea()+1),String.valueOf(nodo.getHijos().get(1).getColumna())}));
                break;
                
                    
                case accion.declaracionSimIni:
                    v = new AtributoVariable(
                                                nodo.getHijos().get(0).getValor(),
                                                nodo.getHijos().get(1).getValor(),
                                                false,
                                                1, 1,
                                                false
                                            );
                    if(!tablaSimbolos.putIdentificador(v.getId(), v))
                        errores.insertarError(Mistake.SEMANTICO, Mistake.ID_DECLARADO, (new String[] {v.getId(),String.valueOf(nodo.getHijos().get(1).getLinea()+1),String.valueOf(nodo.getHijos().get(1).getColumna())}));
                    else
                    {
                        e = getTipo(v.getTipo(), v.esMatriz());

                        r = verificarExp(nodo.getHijos().get(2), v.esConstante());
                        try
                        {
                            if(!TypeCheck.compatibilidad1[e][r][4])
                                errores.insertarError(Mistake.SEMANTICO, Mistake.TIPO_NO_COMPATIBLE, (new String[] {v.getId(),String.valueOf(nodo.getHijos().get(2).getLinea()+1),String.valueOf(nodo.getHijos().get(2).getColumna())}));
                        }
                        catch(ArrayIndexOutOfBoundsException ex)
                        {
                            errores.insertarError(Mistake.SEMANTICO, Mistake.TIPO_NO_COMPATIBLE, (new String[] {v.getId(),String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));
                        }
                    }
                break;

                case accion.declaracionMat:
                    v = new AtributoVariable(
                            nodo.getHijos().get(0).getValor(),
                            nodo.getHijos().get(1).getValor(),
                            true,
                            -1,
                            -1,
                            false
                        );
                    
                    indice1 = ( nodo.getHijos().get(2).getCodigo() == sym.numero ||
                                nodo.getHijos().get(2).getCodigo() == sym.octa_e ||
                                nodo.getHijos().get(2).getCodigo() == sym.hexa_e );
                    indice2 = ( nodo.getHijos().get(3).getCodigo() == sym.numero ||
                                nodo.getHijos().get(3).getCodigo() == sym.octa_e ||
                                nodo.getHijos().get(3).getCodigo() == sym.hexa_e );
                    
                    if(indice1 || indice2)
                    {
                        v = new AtributoVariable(
                                                    nodo.getHijos().get(0).getValor(),
                                                    nodo.getHijos().get(1).getValor(),
                                                    true,
                                                    indice1?Integer.parseInt(nodo.getHijos().get(2).getValor()):-1,
                                                    indice2?Integer.parseInt(nodo.getHijos().get(3).getValor()):-1,
                                                    false
                                                );
                    }
                    
                    e = 1;
                    if(!indice1)
                    {
                        r = verificarExp(nodo.getHijos().get(2), v.esConstante());
                        try
                        {
                            if(!TypeCheck.compatibilidad1[e][r][4]) 
                                errores.insertarError(Mistake.SEMANTICO, Mistake.INDICE_NO_ENTERO, (new String[] {"0", v.getId(), String.valueOf(nodo.getHijos().get(2).getLinea()+1),String.valueOf(nodo.getHijos().get(2).getColumna())}));
                        }
                        catch(ArrayIndexOutOfBoundsException ex)
                        {   
                            errores.insertarError(Mistake.SEMANTICO, Mistake.INDICE_NO_ENTERO, (new String[] {"0", v.getId(), String.valueOf(nodo.getHijos().get(2).getLinea()+1),String.valueOf(nodo.getHijos().get(2).getColumna())}));
                        }
                    }

                    if(!indice2)
                    {
                        r = verificarExp(nodo.getHijos().get(3), v.esConstante());
                        try
                        {
                            if(!TypeCheck.compatibilidad1[e][r][4]) 
                                errores.insertarError(Mistake.SEMANTICO, Mistake.INDICE_NO_ENTERO, (new String[] {"1", v.getId(), String.valueOf(nodo.getHijos().get(3).getLinea()+1),String.valueOf(nodo.getHijos().get(3).getColumna())}));
                        }
                        catch(ArrayIndexOutOfBoundsException ex)
                        {  
                            errores.insertarError(Mistake.SEMANTICO, Mistake.INDICE_NO_ENTERO, (new String[] {"1", v.getId(), String.valueOf(nodo.getHijos().get(3).getLinea()+1),String.valueOf(nodo.getHijos().get(3).getColumna())}));
                        }
                    }
                    
                    if(!tablaSimbolos.putIdentificador(v.getId(), v))
                        errores.insertarError(Mistake.SEMANTICO, Mistake.ID_DECLARADO, (new String[] {v.getId(),String.valueOf(nodo.getHijos().get(1).getLinea()+1),String.valueOf(nodo.getHijos().get(1).getColumna())}));                break;
                
                    
                case accion.declaracionMatIni:
                    
                    v = new AtributoVariable
                        (
                            nodo.getHijos().get(0).getValor(),
                            nodo.getHijos().get(1).getValor(),
                            true,
                            -1,
                            -1,
                            false
                        );
                    
                    indice1 = ( nodo.getHijos().get(2).getCodigo() == sym.numero ||
                                nodo.getHijos().get(2).getCodigo() == sym.octa_e ||
                                nodo.getHijos().get(2).getCodigo() == sym.hexa_e );
                    indice2 = ( nodo.getHijos().get(3).getCodigo() == sym.numero ||
                                nodo.getHijos().get(3).getCodigo() == sym.octa_e ||
                                nodo.getHijos().get(3).getCodigo() == sym.hexa_e );
                    
                    if(indice1 || indice2)
                    {
                        v = new AtributoVariable(
                                                    nodo.getHijos().get(0).getValor(),
                                                    nodo.getHijos().get(1).getValor(),
                                                    true,
                                                    indice1?Integer.parseInt(nodo.getHijos().get(2).getValor()):-1,
                                                    indice2?Integer.parseInt(nodo.getHijos().get(3).getValor()):-1,
                                                    false
                                                );
                    }
                    
                    e = 1;
                    if(!indice1)
                    {
                        r = verificarExp(nodo.getHijos().get(2), v.esConstante());
                        try
                        {
                            if(!TypeCheck.compatibilidad1[e][r][4]) 
                                errores.insertarError(Mistake.SEMANTICO, Mistake.INDICE_NO_ENTERO, (new String[] {"0", v.getId(), String.valueOf(nodo.getHijos().get(2).getLinea()+1),String.valueOf(nodo.getHijos().get(2).getColumna())}));
                        }
                        catch(ArrayIndexOutOfBoundsException ex)
                        { 
                            errores.insertarError(Mistake.SEMANTICO, Mistake.INDICE_NO_ENTERO, (new String[] {"0", v.getId(), String.valueOf(nodo.getHijos().get(2).getLinea()+1),String.valueOf(nodo.getHijos().get(2).getColumna())}));
                        }
                    }

                    if(!indice2)
                    {
                        r = verificarExp(nodo.getHijos().get(3), v.esConstante());
                        try
                        {
                            if(!TypeCheck.compatibilidad1[e][r][4])
                                errores.insertarError(Mistake.SEMANTICO, Mistake.INDICE_NO_ENTERO, (new String[] {"1", v.getId(), String.valueOf(nodo.getHijos().get(3).getLinea()+1),String.valueOf(nodo.getHijos().get(3).getColumna())}));
                        }
                        catch(ArrayIndexOutOfBoundsException ex)
                        {   
                            errores.insertarError(Mistake.SEMANTICO, Mistake.INDICE_NO_ENTERO, (new String[] {"1", v.getId(), String.valueOf(nodo.getHijos().get(3).getLinea()+1),String.valueOf(nodo.getHijos().get(3).getColumna())}));
                        }
                    }
                    
                    if(!tablaSimbolos.putIdentificador(v.getId(), v))
                        errores.insertarError(Mistake.SEMANTICO, Mistake.ID_DECLARADO, (new String[] {v.getId(),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                    else
                    {
                        e = getTipo(v.getTipo(), v.esMatriz());
                        r = verificarExp(nodo.getHijos().get(4), v.esConstante());
                        try
                        {
                            if(!TypeCheck.compatibilidad1[e][r][4])
                                errores.insertarError(Mistake.SEMANTICO, Mistake.TIPO_NO_COMPATIBLE, (new String[] {v.getId(),String.valueOf(nodo.getHijos().get(4).getLinea()+1),String.valueOf(nodo.getHijos().get(4).getColumna())}));
                            else if(nodo.getHijos().get(4).getCodigo() == accion.elemMat)
                            {
                                if(indice1 && v.getDimension1() != nodo.getHijos().get(4).getHijos().size())
                                    errores.insertarWarning(Mistake.FILAS_NO_COINCIDE, (new String[] {v.getId(),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                                if(indice1 && indice2)
                                    for(int i = 0; i < nodo.getHijos().get(4).getHijos().size(); i++)
                                    {
                                        ArrayList<Nodo> elementosMat2 = nodo.getHijos().get(4).getHijos().get(i).getHijos();
                                        if(v.getDimension2() != elementosMat2.size())
                                            errores.insertarWarning(Mistake.COLUMNAS_INCORRECTAS, (new String[] {String.valueOf(i), v.getId(),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                                    }
                            }
                        }
                        catch(ArrayIndexOutOfBoundsException ex)
                        {
                            errores.insertarError(Mistake.SEMANTICO, Mistake.TIPO_NO_COMPATIBLE, (new String[] {v.getId(),String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));
                        }
                    }
                break;
                
                    
                case accion.declaracionConsSim:
                    v = new AtributoVariable(
                                                nodo.getHijos().get(0).getValor(),
                                                nodo.getHijos().get(1).getValor(),
                                                false,
                                                1, 1,
                                                true
                                            );
                    if(!tablaSimbolos.putIdentificador(v.getId(), v))
                        errores.insertarError(Mistake.SEMANTICO, Mistake.ID_DECLARADO, (new String[] {v.getId(),String.valueOf(nodo.getHijos().get(1).getLinea()+1),String.valueOf(nodo.getHijos().get(1).getColumna())}));
                    else
                    {
                        e = getTipo(v.getTipo(), v.esMatriz());
                        r = verificarExp(nodo.getHijos().get(2), v.esConstante());
                        try
                        {
                            if(!TypeCheck.compatibilidad1[e][r][4])
                                errores.insertarError(Mistake.SEMANTICO, Mistake.TIPO_NO_COMPATIBLE, (new String[] {v.getId(),String.valueOf(nodo.getHijos().get(2).getLinea()+1),String.valueOf(nodo.getHijos().get(2).getColumna())}));
                        }
                        catch(ArrayIndexOutOfBoundsException ex)
                        {
                            errores.insertarError(Mistake.SEMANTICO, Mistake.TIPO_NO_COMPATIBLE, (new String[] {v.getId(),String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));
                        }
                    }
                break;

                
                case accion.declaracionConsMat:
                    indice1 = ( nodo.getHijos().get(2).getCodigo() == sym.numero ||
                                nodo.getHijos().get(2).getCodigo() == sym.octa_e ||
                                nodo.getHijos().get(2).getCodigo() == sym.hexa_e );
                    indice2 = ( nodo.getHijos().get(3).getCodigo() == sym.numero ||
                                nodo.getHijos().get(3).getCodigo() == sym.octa_e ||
                                nodo.getHijos().get(3).getCodigo() == sym.hexa_e );
                    
                    if(indice1 && indice2)
                    {
                        v = new AtributoVariable(
                                                    nodo.getHijos().get(0).getValor(),
                                                    nodo.getHijos().get(1).getValor(),
                                                    true,
                                                    indice1?Integer.parseInt(nodo.getHijos().get(2).getValor()):-1,
                                                    indice2?Integer.parseInt(nodo.getHijos().get(3).getValor()):-1,
                                                    true
                                                );
                        if(!tablaSimbolos.putIdentificador(v.getId(), v))
                            errores.insertarError(Mistake.SEMANTICO, Mistake.ID_DECLARADO, (new String[] {v.getId(),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                        else
                        {
                            e = getTipo(v.getTipo(), v.esMatriz());
                            r = verificarExp(nodo.getHijos().get(4), v.esConstante());
                            try
                            {
                                if(!TypeCheck.compatibilidad1[e][r][4])
                                    errores.insertarError(Mistake.SEMANTICO, Mistake.TIPO_NO_COMPATIBLE, (new String[] {v.getId(),String.valueOf(nodo.getHijos().get(4).getLinea()+1),String.valueOf(nodo.getHijos().get(4).getColumna())}));
                                else
                                {
                                    if(indice1 && v.getDimension1() != nodo.getHijos().get(4).getHijos().size())
                                        errores.insertarWarning(Mistake.FILAS_NO_COINCIDE, (new String[] {v.getId(),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                                    if(indice1 && indice2)
                                        for(int i = 0; i < nodo.getHijos().get(4).getHijos().size(); i++)
                                        {
                                            ArrayList<Nodo> elementosMat2 = nodo.getHijos().get(4).getHijos().get(i).getHijos();
                                            if(v.getDimension2() != elementosMat2.size())
                                                errores.insertarWarning(Mistake.COLUMNAS_INCORRECTAS, (new String[] {String.valueOf(i), v.getId(),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                                        }
                                }
                            }
                            catch(ArrayIndexOutOfBoundsException ex)
                            {
                                errores.insertarError(Mistake.SEMANTICO, Mistake.TIPO_NO_COMPATIBLE, (new String[] {v.getId(),String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));
                            }
                        }
                    }
                    else 
                        errores.insertarError(Mistake.SEMANTICO, Mistake.INDICE_CONSTANTE, (new String[] {nodo.getHijos().get(1).getValor(),String.valueOf(nodo.getHijos().get(1).getLinea()+1),String.valueOf(nodo.getHijos().get(1).getColumna())}));
                break;
                
                    
                case accion.declaracionProt:
                    ArrayList <AtributoVariable> argumentos = new ArrayList <>();
                    ArrayList <Nodo> param = nodo.getHijos().get(2).getHijos();
                    flag = true;
                    for(int i = 0; i < param.size(); i++)
                    {
                        if(param.get(i).esTerminal())
                            argumentos.add(
                                            new AtributoVariable(param.get(i).getValor(),
                                            "", false, 1, 1, false)
                                          );
                        else
                        {
                            ArrayList<Nodo> datosMatriz = param.get(i).getHijos();
                            indice1 = ( datosMatriz.get(1).getCodigo() == sym.numero ||
                                        datosMatriz.get(1).getCodigo() == sym.octa_e ||
                                        datosMatriz.get(1).getCodigo() == sym.hexa_e );
                            indice2 = ( datosMatriz.get(2).getCodigo() == sym.numero ||
                                        datosMatriz.get(2).getCodigo() == sym.octa_e ||
                                        datosMatriz.get(2).getCodigo() == sym.hexa_e );
                            if(indice1 && indice2 && datosMatriz.get(1).esTerminal() && datosMatriz.get(2).esTerminal())
                                argumentos.add(new AtributoVariable (
                                                                        datosMatriz.get(0).getValor(),
                                                                        "", true,
                                                                        Integer.parseInt(datosMatriz.get(1).getValor()),
                                                                        Integer.parseInt(datosMatriz.get(2).getValor()),
                                                                        false
                                                                    ));
                            else
                            {
                                flag = false;
                                errores.insertarError(Mistake.SEMANTICO, Mistake.ARGUMENTO_INDICE, 
                                        (new String[]{  String.valueOf(i),
                                                        String.valueOf(nodo.getHijos().get(1).getValor()),
                                                        String.valueOf(nodo.getHijos().get(2).getHijos().get(i).getLinea() + 1),
                                                        String.valueOf(nodo.getHijos().get(2).getHijos().get(i).getColumna())}));
                                
                            }
                        }
                    }
                    if(flag)
                    {
                        f = new AtributoFuncion (
                                                    nodo.getHijos().get(0).getValor(),
                                                    nodo.getHijos().get(1).getValor(),
                                                    argumentos,
                                                    false
                                                );
                        if(!tablaSimbolos.putFuncion(f.getId(), f))
                            errores.insertarError(Mistake.SEMANTICO, Mistake.ID_DECLARADO, (new String[] {f.getId(),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                    }
                break;
                
                
                case accion.funcion:
                    if((f = tablaSimbolos.buscarFuncion(nodo.getHijos().get(1).getValor())) == null)
                        errores.insertarError(Mistake.SEMANTICO, Mistake.NO_PROTOTIPO, (new String[] {nodo.getHijos().get(1).getValor(),String.valueOf(nodo.getHijos().get(1).getLinea()+1),String.valueOf(nodo.getHijos().get(1).getColumna())}));
                    else
                    {
                        if(!f.getTipoRetorno().equals(nodo.getHijos().get(0).getValor()))
                            errores.insertarError(Mistake.SEMANTICO, Mistake.RETORNO_NO_COINCIDE, (new String[] {nodo.getHijos().get(1).getValor(),String.valueOf(nodo.getHijos().get(1).getLinea()+1),String.valueOf(nodo.getHijos().get(1).getColumna())}));
                        else
                        {
                            if(f.getArgumentos().size() != nodo.getHijos().get(2).getHijos().size())
                                errores.insertarError(Mistake.SEMANTICO, Mistake.ARGUMENTO_NUM_NO_COINCIDE, (new String[] {f.getId(),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                            else
                            {
                                ArrayList<Nodo> arg = nodo.getHijos().get(2).getHijos();
                                flag = true;
                                for(int i = 0; i < f.getArgumentos().size(); i++)
                                {
                                    AtributoVariable aux = f.getArgumentos().get(i);
                                    if(aux.esMatriz())
                                    {
                                        if(arg.get(i).getCodigo() == accion.parametroFunSim)
                                        {
                                            errores.insertarError(Mistake.SEMANTICO, Mistake.ARGUMENTO_NO_MATRIZ, (new String[] {String.valueOf(i+1),f.getId(),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                                            flag = false;
                                        }
                                        else
                                        {
                                            if(arg.get(i).getHijos().get(2).esTerminal() && arg.get(i).getHijos().get(3).esTerminal())
                                            {
                                                if(!(aux.getTipo().equals(arg.get(i).getHijos().get(0).getValor()) &&
                                                    (aux.getDimension1() == Integer.parseInt(arg.get(i).getHijos().get(2).getValor())) && 
                                                    (aux.getDimension2() == Integer.parseInt(arg.get(i).getHijos().get(3).getValor()))))
                                                {
                                                    errores.insertarError(Mistake.SEMANTICO, Mistake.ARGUMENTO_NO_COINCIDE, (new String[] {String.valueOf(i+1),f.getId(),String.valueOf(arg.get(i).getHijos().get(1).getLinea()+1),String.valueOf(arg.get(i).getHijos().get(1).getColumna())}));
                                                    flag = false;
                                                }
                                                else
                                                    aux.setId(arg.get(i).getHijos().get(1).getValor());
                                            }
                                            else 
                                                errores.insertarError(Mistake.SEMANTICO, Mistake.ARGUMENTO_INDICE, (new String[] {String.valueOf(i+1),f.getId(),String.valueOf(arg.get(i).getHijos().get(1).getLinea()+1),String.valueOf(arg.get(i).getHijos().get(1).getColumna())}));
                                        }
                                    }
                                    else
                                    {
                                        if(arg.get(i).getCodigo() == accion.parametroFunMat)
                                        {
                                            errores.insertarError(Mistake.SEMANTICO, Mistake.ARGUMENTO_MATRIZ, (new String[] {String.valueOf(i+1),f.getId(),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                                            flag = false;
                                        }
                                        else
                                        {
                                            if(!aux.getTipo().equals(arg.get(i).getHijos().get(0).getValor()))
                                            {
                                                errores.insertarError(Mistake.SEMANTICO, Mistake.ARGUMENTO_NO_COINCIDE, (new String[] {String.valueOf(i+1),f.getId(),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                                                flag = false;
                                            }
                                            else
                                                aux.setId(arg.get(i).getHijos().get(1).getValor());
                                        }
                                    }                                        
                                }
                                
                                if(flag)
                                {
                                    f.setDefinido(true);
                                    tablaSimbolos.insertarBloque();
                                    for(AtributoVariable argumento : f.getArgumentos())
                                        if(!tablaSimbolos.putIdentificador(argumento.getId(), argumento))
                                            errores.insertarError(Mistake.SEMANTICO, Mistake.ID_DECLARADO, (new String[] {argumento.getId(),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                                    if(!retorna(nodo.getHijos().get(4), getTipo(f.getTipoRetorno(), false)))
                                        errores.insertarError(Mistake.SEMANTICO, Mistake.NO_RETORNO_FUNCION, (new String[] {f.getId(),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                                }
                            }
                        }
                    }
                break;
                
               
                case accion.asignacion:
                    AtributoVariable t;
                    if(nodo.getHijos().get(0).esTerminal())
                    {
                        if((t = tablaSimbolos.buscarVariable(nodo.getHijos().get(0).getValor())) == null)
                            errores.insertarError(Mistake.SEMANTICO, Mistake.ID_NO_DECLARADO, (new String[] {nodo.getHijos().get(0).getValor(),String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));
                        else
                        {
                            if(!t.esConstante())
                            {
                                // El nodo es un ID
                                e = getTipo(t.getTipo(), t.esMatriz());
                                r = verificarExp(nodo.getHijos().get(1), t.esConstante());
                                try
                                {
                                    if(!TypeCheck.compatibilidad1[e][r][4])
                                        errores.insertarError(Mistake.SEMANTICO, Mistake.TIPO_NO_COMPATIBLE, (new String[] {t.getId(),String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));

                                }
                                catch(ArrayIndexOutOfBoundsException ex)
                                {
                                    errores.insertarError(Mistake.SEMANTICO, Mistake.TIPO_NO_COMPATIBLE, (new String[] {t.getId(),String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));
                                }
                            }
                            else
                                errores.insertarError(Mistake.SEMANTICO, Mistake.CONSTANTE_NO_MODIFICAR, (new String[] {t.getId(),String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));
                        }
                    }
                    else
                    {
                        if((t = tablaSimbolos.buscarVariable(nodo.getHijos().get(0).getHijos().get(0).getValor())) == null)
                            errores.insertarError(Mistake.SEMANTICO, Mistake.ID_NO_DECLARADO, (new String[] {nodo.getHijos().get(0).getHijos().get(0).getValor(), String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));
                        else
                        {
                            if(!t.esConstante())
                            {
                                e = getTipo(t.getTipo(), false);
                                r = verificarExp(nodo.getHijos().get(1), t.esConstante());
                                try
                                {
                                    if(!TypeCheck.compatibilidad1[e][r][4])
                                        errores.insertarError(Mistake.SEMANTICO, Mistake.TIPO_NO_COMPATIBLE, (new String[] {t.getId(),String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));
                                    else
                                    {
                                        e = 1;
                                        r = verificarExp(nodo.getHijos().get(0).getHijos().get(1), false);
                                        try
                                        {
                                            if(!TypeCheck.compatibilidad1[e][r][4])
                                                errores.insertarError(Mistake.SEMANTICO, Mistake.INDICE_NO_ENTERO, (new String[] {"0", t.getId(),String.valueOf(nodo.getHijos().get(0).getHijos().get(1).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getHijos().get(1).getColumna())}));
                                            else
                                            {
                                                r = verificarExp(nodo.getHijos().get(0).getHijos().get(2), false);
                                                try
                                                {
                                                    if(!TypeCheck.compatibilidad1[e][r][4]) 
                                                        errores.insertarError(Mistake.SEMANTICO, Mistake.INDICE_NO_ENTERO, (new String[] {"1", t.getId(),String.valueOf(nodo.getHijos().get(0).getHijos().get(2).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getHijos().get(2).getColumna())}));
                                                }
                                                catch(ArrayIndexOutOfBoundsException ex)
                                                {
                                                    errores.insertarError(Mistake.SEMANTICO, Mistake.INDICE_NO_ENTERO, (new String[] {"1", t.getId(),String.valueOf(nodo.getHijos().get(0).getHijos().get(2).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getHijos().get(2).getColumna())}));
                                                }
                                            }
                                        }
                                        catch(ArrayIndexOutOfBoundsException ex)
                                        { 
                                            errores.insertarError(Mistake.SEMANTICO, Mistake.INDICE_NO_ENTERO, (new String[] {"0", t.getId(),String.valueOf(nodo.getHijos().get(0).getHijos().get(1).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getHijos().get(1).getColumna())}));
                                        }
                                    }
                                }
                                catch(ArrayIndexOutOfBoundsException ex)
                                {
                                    errores.insertarError(Mistake.SEMANTICO, Mistake.TIPO_NO_COMPATIBLE, (new String[] {t.getId(),String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));
                                }
                            }
                            else
                                errores.insertarError(Mistake.SEMANTICO, Mistake.CONSTANTE_NO_MODIFICAR, (new String[] {t.getId(),String.valueOf(nodo.getHijos().get(0).getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getHijos().get(0).getColumna())}));
                        }
                    }
                break;
                    
                
                case accion.condicion:
                    e = 1;
                    r = verificarExp(nodo.getHijos().get(0), false);
                    try
                    {
                        if(!TypeCheck.compatibilidad1[e][r][4])
                            errores.insertarError(Mistake.SEMANTICO, Mistake.CONDICION_NO_COMPATIBLE, (new String[] {String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));
                    }
                    catch(ArrayIndexOutOfBoundsException ex)
                    { 
                        errores.insertarError(Mistake.SEMANTICO, Mistake.CONDICION_NO_COMPATIBLE, (new String[] {String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));
                    }
                break;
                
                case accion.selector:
                    e = 1;
                    r = verificarExp(nodo.getHijos().get(0), false);
                    try
                    {
                        if(!TypeCheck.compatibilidad1[e][r][4])
                            errores.insertarError(Mistake.SEMANTICO, Mistake.TIPO_NO_FUNCION, (new String[] {"selector", String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));
                    }
                    catch(ArrayIndexOutOfBoundsException ex)
                    {
                        errores.insertarError(Mistake.SEMANTICO, Mistake.TIPO_NO_FUNCION, (new String[] {"selector", String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));
                    }
                break;
                
                case accion.para:
                    tablaSimbolos.insertarBloque();
                break;
                
                case accion.finPara:
                    tablaSimbolos.salirBloque();
                break;
                
                case accion.lectura:
                    if((t = tablaSimbolos.buscarVariable(nodo.getHijos().get(0).getValor())) == null)
                            errores.insertarError(Mistake.SEMANTICO, Mistake.ID_NO_DECLARADO, (new String[] {nodo.getHijos().get(0).getValor(), String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));
                    {
                        e = 1;
                        if(!t.esConstante())
                        {
                            r = verificarExp(nodo.getHijos().get(0), t.esConstante());
                            try
                            {
                                if(!TypeCheck.compatibilidad1[e][r][4])
                                    errores.insertarError(Mistake.SEMANTICO, Mistake.VARIABLE_NO_FUNCION, (new String[] {t.getId(), "leer", String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));

                            }
                            catch(ArrayIndexOutOfBoundsException ex)
                            { 
                                errores.insertarError(Mistake.SEMANTICO, Mistake.VARIABLE_NO_FUNCION, (new String[] {t.getId(), "leer", String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));
                            }
                        }
                        else
                            errores.insertarError(Mistake.SEMANTICO, Mistake.CONSTANTE_NO_MODIFICAR, (new String[] {t.getId(), String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));
                    }
                break;
                    
                case accion.escritura:
                    r = verificarExp(nodo.getHijos().get(0), false);
                    if(r == -1) 
                        errores.insertarError(Mistake.SEMANTICO, Mistake.TIPO_NO_FUNCION, (new String[] {"mostrar", String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));
                break;
                
                case accion.finFuncion:
                    tablaSimbolos.salirBloque();
                break;
                    
                case accion.llamadaFuncion:
                    if((f = tablaSimbolos.buscarFuncion(nodo.getHijos().get(0).getValor())) == null)
                        errores.insertarError(Mistake.SEMANTICO, Mistake.FUNCION_NO_EXISTE, (new String[] {nodo.getHijos().get(0).getValor(),String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));
                    else
                    {
                        ArrayList<AtributoVariable> argumentosFun = f.getArgumentos();
                        ArrayList<Nodo> argumentosExs = nodo.getHijos().get(1).getHijos();
                        if(argumentosFun.size() != argumentosExs.size())
                            errores.insertarError(Mistake.SEMANTICO, Mistake.ARGUMENTO_NUM_NO_COINCIDE, (new String[] {f.getId(), String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));
                        else
                        {
                            for(int i = 0; i < argumentosFun.size(); i++)
                            {
                                e = getTipo(argumentosFun.get(i).getTipo(), argumentosFun.get(i).esMatriz());
                                r = verificarExp(argumentosExs.get(i), false);
                                
                                try
                                {
                                    if(!TypeCheck.compatibilidad1[e][r][4]) 
                                        errores.insertarError(Mistake.SEMANTICO, Mistake.ARGUMENTO_NO_COINCIDE, (new String[] {String.valueOf(i), f.getId(), String.valueOf(argumentosExs.get(i).getLinea() + 1),String.valueOf(argumentosExs.get(i).getColumna())}));

                                }
                                catch(ArrayIndexOutOfBoundsException ex)
                                { 
                                    errores.insertarError(Mistake.SEMANTICO, Mistake.ARGUMENTO_NO_COINCIDE, (new String[] {String.valueOf(i), f.getId(), String.valueOf(argumentosExs.get(i).getLinea() + 1),String.valueOf(argumentosExs.get(i).getColumna())}));
                                }
                            }
                        }
                    }
                        
                break;
                    
                case accion.declaracionVar:
                    tablaSimbolos.insertarBloque();
                break;
                
                    
                case accion.finBloque:
                    tablaSimbolos.salirBloque();
                break;
            }
            
            for(int i = 0; i < nodo.getHijos().size(); i++)
                    verificar(nodo.getHijos().get(i));
        }
    }
    
    public int verificarExp(Nodo exp, boolean constante)
    {
        ArrayList <Integer> tiposOp = new ArrayList <>();
        int r = -1;
        if(!exp.esTerminal())
        {
            if(exp.getCodigo() != accion.llamadaFuncion && exp.getCodigo() != accion.accesoMat)
                for(int i = 0; i < exp.getHijos().size(); i++)
                    tiposOp.add(verificarExp(exp.getHijos().get(i), constante));
            
            if(exp.getCodigo() == accion.accesoMat)
                for(int i = 1; i < exp.getHijos().size(); i++)
                    tiposOp.add(verificarExp(exp.getHijos().get(i), constante));
            
            switch(exp.getCodigo())
            {
                case accion.suma:
                    r =  tc.tipoCompatible(tiposOp, 0, 1);
                break;
                
                case accion.resta:
                    r =  tc.tipoCompatible(tiposOp, 1, 1);
                break;
                    
                case accion.producto:
                    r =  tc.tipoCompatible(tiposOp, 2, 1);
                break;
                
                case accion.division:
                    r =  tc.tipoCompatible(tiposOp, 3, 1);
                break;
                    
                case accion.modulo:
                    r =  tc.tipoCompatible(tiposOp, 4, 1);
                break;
                    
                case accion.mayor:
                    r =  tc.tipoCompatible(tiposOp, 5, 1);
                break;
                    
                case accion.menor:
                    r =  tc.tipoCompatible(tiposOp, 6, 1);
                break;
                    
                case accion.mayor_igual:
                    r =  tc.tipoCompatible(tiposOp, 7, 1);
                break;
                    
                case accion.menor_igual:
                    r =  tc.tipoCompatible(tiposOp, 8, 1);
                break;
                    
                case accion.conjuncion:
                    r =  tc.tipoCompatible(tiposOp, 9, 1);
                break;
                    
                case accion.disyuncion:
                    r =  tc.tipoCompatible(tiposOp, 10, 1);
                break;
                    
                case accion.identico:
                    r =  tc.tipoCompatible(tiposOp, 11, 1);
                break;
                    
                case accion.diferente:
                    r =  tc.tipoCompatible(tiposOp, 12, 1);
                break;

                case accion.negacion:
                    r =  tc.tipoCompatible(tiposOp, 0, 0);
                break;
                    
                case accion.inversa:
                    r =  tc.tipoCompatible(tiposOp, 1, 0);
                break;
                
                case accion.transpuesta:
                    r =  tc.tipoCompatible(tiposOp, 2, 0);
                break;
                    
                case accion.negatividad:
                    r =  tc.tipoCompatible(tiposOp, 3, 0);
                break;
                    
                case accion.operacionCond:
                    r = tc.tipoCompatible(tiposOp, 0, 2);
                break;
                
                case accion.llamadaFuncion:
                    AtributoFuncion f;
                    if((f = tablaSimbolos.buscarFuncion(exp.getHijos().get(0).getValor())) != null)
                        r = getTipo(f.getTipoRetorno(), false);
                break;
                
                case accion.accesoMat:
                    AtributoVariable t;
                    if((t = tablaSimbolos.buscarVariable(exp.getHijos().get(0).getValor())) == null)
                        errores.insertarError(Mistake.SEMANTICO, Mistake.ID_NO_DECLARADO, (new String[] {exp.getHijos().get(0).getValor(),String.valueOf(exp.getHijos().get(0).getLinea()+1),String.valueOf(exp.getHijos().get(0).getColumna())}));
                    else
                    {
                        if(t.esMatriz())
                        {
                            for(int i = 0; i < tiposOp.size(); i++)
                            {
                                if(tiposOp.get(i) != 0 && tiposOp.get(i) != 1)
                                {
                                    errores.insertarError(Mistake.SEMANTICO, Mistake.INDICE_NO_ENTERO, (new String[] {String.valueOf(i),exp.getHijos().get(0).getValor(),String.valueOf(exp.getHijos().get(0).getLinea()+1),String.valueOf(exp.getHijos().get(0).getColumna())}));
                                    return -1;
                                }
                            }
                            r = getTipo(t.getTipo(), false);
                        }
                        else
                            errores.insertarError(Mistake.SEMANTICO, Mistake.ID_NO_MATRIZ, (new String[] {exp.getHijos().get(0).getValor(),String.valueOf(exp.getHijos().get(0).getLinea()+1),String.valueOf(exp.getHijos().get(0).getColumna())}));
                    }
                break;
                    
                case accion.elemMat:
                    ArrayList<Nodo> elementosMat = exp.getHijos();
                    /** Los elementos contenidos por la matriz son simples o vectores, TRUE Vectores, FALSE Simples*/
                    boolean noVacio = true;
                    for(int i = 0; i < elementosMat.size(); i++)
                    {
                            if(elementosMat.get(i).getCodigo() == accion.elemVec && elementosMat.get(i).getHijos().isEmpty() && !elementosMat.get(i).esTerminal())
                            {
                               errores.insertarError(Mistake.SEMANTICO, Mistake.NO_TAMANIO_CERO, (new String[] {String.valueOf(elementosMat.get(i).getLinea()+1),String.valueOf(elementosMat.get(i).getColumna())}));
                               noVacio = false;
                            }
                    }
                    if(noVacio)
                    {
                        for(int i = 0; i < tiposOp.size(); i++)
                        {
                            if(!(tiposOp.get(i) == 2 || tiposOp.get(i) == 3))
                            {
                                errores.insertarError(Mistake.SEMANTICO, Mistake.FILA_NO_CORRECTO, (new String[] {String.valueOf(i),String.valueOf(exp.getLinea()+1),String.valueOf(exp.getColumna())}));
                                return -1;
                            }
                        }
                        r = 3;
                    }
                break;
                
                case accion.elemVec:
                    ArrayList<Nodo> elementosVec = exp.getHijos();
                    /** Los elementos contenidos por la matriz son simples o vectores, TRUE Vectores, FALSE Simples*/
                    boolean noVacioVec = true;

                    if(elementosVec.isEmpty())
                    {
                       errores.insertarError(Mistake.SEMANTICO, Mistake.NO_TAMANIO_CERO, (new String[] {String.valueOf(exp.getLinea()+1),String.valueOf(exp.getColumna())}));
                       noVacioVec = false;
                    }
                    if(noVacioVec)
                    {
                        for(int i = 0; i < tiposOp.size(); i++)
                        {
                            if(!(tiposOp.get(i) == 0 || tiposOp.get(i) == 1))
                            {
                                errores.insertarError(Mistake.SEMANTICO, Mistake.ELEMENTO_NO_CORRECTO, (new String[] {String.valueOf(i),String.valueOf(exp.getLinea()+1),String.valueOf(exp.getColumna())}));
                                return -1;
                            }
                        }
                        r = 3;
                    }
                break;
            }
        }
        else
        {
            switch(exp.getCodigo())
            {
                case sym.numero:
                case sym.octa_e:
                case sym.hexa_e:
                    r = 0;
                break;
                
                case sym.real:
                case sym.octa_r:
                case sym.hexa_r:
                    r = 1;
                break;
                    
                case sym.cadena:
                    r = 4;
                break;
                
                case sym.id:
                    AtributoVariable t;
                    if((t = tablaSimbolos.buscarVariable(exp.getValor())) == null)
                        errores.insertarError(Mistake.SEMANTICO, Mistake.ID_NO_DECLARADO, (new String[] {exp.getValor(),String.valueOf(exp.getLinea()+1),String.valueOf(exp.getColumna())}));
                    else
                    {
                        if(!constante)
                            r = getTipo(t.getTipo(), t.esMatriz());
                        else
                            errores.insertarError(Mistake.SEMANTICO, Mistake.NO_VARIABLE, (new String[] {t.getId(),String.valueOf(exp.getLinea()+1),String.valueOf(exp.getColumna())}));
                    }
                break;
            }
        }
        return r;
    }
    
    private boolean retorna(Nodo nodo, int tipo)
    {
        if(!nodo.esTerminal())
        {
            switch(nodo.getCodigo())
            {
                case accion.retornar:
                    int r = verificarExp(nodo.getHijos().get(0), false);
                    boolean flag = true;
                    try
                    {
                        if(!TypeCheck.compatibilidad1[tipo][r][4])
                        {
                            errores.insertarError(Mistake.SEMANTICO, Mistake.RETORNO_NO_COMPATIBLE, (new String[] {String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                            flag = false;    
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException ex)
                    {
                        errores.insertarError(Mistake.SEMANTICO, Mistake.RETORNO_NO_COMPATIBLE, (new String[] {String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                        flag = false;
                    }
                    if(flag) return true;
            }
            for(int i = 0; i < nodo.getHijos().size(); i++)
                if(retorna(nodo.getHijos().get(i), tipo)) return true;
        }
        return false;
    }
    
    public void verificarSaltar(Nodo nodo, boolean s)
    {
        if(!nodo.esTerminal())
        {
            switch(nodo.getCodigo())
            {
                case accion.saltar:
                    if(!s)
                        errores.insertarError(Mistake.SEMANTICO, Mistake.SALTAR_FUERA, (new String[] {String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                break;
                    
                case accion.mientras:
                    s = true;
                break;
                
                case accion.hacerMientras:
                    s = true;
                break;
                    
                case accion.para:
                    s = true;
                break;
            }
            
            for(int i = 0; i < nodo.getHijos().size(); i++)
                verificarSaltar(nodo.getHijos().get(i), s);
        }
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
    
    public Entorno getTabla()
    {
        return tablaSimbolos;
    }
    
    public Nodo getRaiz()
    {
        return raiz;
    }
    
    public String toString()
    {
        return "" + raiz;
    }
}