package lema.analizadorSemantico;

import java.util.ArrayList;
import lema.Mistake;
import lema.analizadorLexico.sym;
import lema.Converter;

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
                        nodo.getHijos().add(new Nodo(accion.elemVec, accion.acciones[accion.elemVec], nodo.getLinea(), nodo.getColumna(), (new ArrayList <>()), false));
                    else
                    {
                        /** Los elementos contenidos por la matriz son simples o vectores, TRUE Matrices, FALSE Simples*/
                        boolean flag = (accion.elemMat == elementosMat.get(0).getCodigo());
                        boolean iguales = true;

                        for(int i = 0; i < elementosMat.size(); i++)
                        {
                            if(elementosMat.get(i).getCodigo() == accion.elemMat)
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
                        if(nodo.getHijos().get(i).getCodigo() == accion.elemMat)
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
                break;

                
                case accion.declaracionMat:
                    /*Convertir indice*/
                    v = new AtributoVariable(
                                                nodo.getHijos().get(0).getValor(),
                                                nodo.getHijos().get(1).getValor(),
                                                true,
                                                Integer.parseInt(nodo.getHijos().get(2).getValor()),
                                                Integer.parseInt(nodo.getHijos().get(3).getValor()),
                                                false
                                            );
                    
                    if(!tablaSimbolos.putIdentificador(v.getId(), v))
                        errores.insertarError(Mistake.SEMANTICO, Mistake.ID_DECLARADO, (new String[] {v.getId(),String.valueOf(nodo.getHijos().get(1).getLinea()+1),String.valueOf(nodo.getHijos().get(1).getColumna())}));
                break;
                
                    
                case accion.declaracionMatIni:
                    /*Convertir indice*/
                    boolean indice1 = ( nodo.getHijos().get(2).getCodigo() == sym.numero ||
                                        nodo.getHijos().get(2).getCodigo() == sym.octa_e ||
                                        nodo.getHijos().get(2).getCodigo() == sym.hexa_e);
                    boolean indice2 = ( nodo.getHijos().get(3).getCodigo() == sym.numero ||
                                        nodo.getHijos().get(3).getCodigo() == sym.octa_e ||
                                        nodo.getHijos().get(3).getCodigo() == sym.hexa_e);
                    
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
                    else
                    {
                        v = new AtributoVariable(
                                                    nodo.getHijos().get(0).getValor(),
                                                    nodo.getHijos().get(1).getValor(),
                                                    true,
                                                    -1,
                                                    -1,
                                                    false
                                                );
                    }
                    
                    if(!tablaSimbolos.putIdentificador(v.getId(), v))
                        errores.insertarError(Mistake.SEMANTICO, Mistake.ID_DECLARADO, (new String[] {v.getId(),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));

                    switch(v.getTipo())
                    {
                        case "entero":
                            e = 2;
                        break;
                            
                        case "real":
                            e = 3;
                        break;
                            
                        case "cadena":
                            e = -1;
                        break;
                    }
                    
                    r = verificarExp(nodo.getHijos().get(4));
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
                        errores.insertarError(Mistake.SEMANTICO, Mistake.ID_DECLARADO, (new String[] {v.getId(),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                break;

                
                case accion.declaracionConsMat:
                    /*Convertir indice*/
                    v = new AtributoVariable(
                                                nodo.getHijos().get(0).getValor(),
                                                nodo.getHijos().get(1).getValor(),
                                                true,
                                                Integer.parseInt(nodo.getHijos().get(2).getValor()),
                                                Integer.parseInt(nodo.getHijos().get(3).getValor()),
                                                true
                                            );
                    
                    elementosMat = nodo.getHijos().get(4).getHijos();
                    
                    if(elementosMat.isEmpty())
                        errores.insertarError(Mistake.SEMANTICO, Mistake.NO_TAMANIO_CERO, (new String[] {String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                    else
                    {
                        /** Los elementos contenidos por la matriz son simples o vectores, TRUE Vectores, FALSE Simples*/
                        boolean flag = (accion.elemMat == elementosMat.get(0).getCodigo());
                        boolean iguales = true;
                        for(int i = 1; i < elementosMat.size(); i++)
                            if(!((elementosMat.get(i).getCodigo() == accion.elemMat) == flag))
                            {
                                errores.insertarError(Mistake.SEMANTICO, Mistake.DATOS_DISTINTOS, (new String[] {v.getId(),String.valueOf(elementosMat.get(i).getLinea()+1),String.valueOf(elementosMat.get(i).getColumna())}));
                                iguales = false;
                                break;
                            }
                        if(iguales)
                        {
                            if(!flag)
                            {
                                if(v.getDimension1() == 1)
                                {
                                    // Revisar
                                    ArrayList <Nodo> enlace = new ArrayList <>();
                                    enlace.add(new Nodo(accion.elemMat, accion.acciones[accion.elemMat], nodo.getLinea(), nodo.getColumna(), elementosMat, false));
                                    nodo.getHijos().get(4).setHijos(enlace);
                                    
                                    if(v.getDimension2() != elementosMat.size())
                                        errores.insertarWarning(Mistake.NUM_ELEMENTOS_INCORRECTOS, (new String[] {v.getId(),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                                    if(!tablaSimbolos.putIdentificador(v.getId(), v))
                                        errores.insertarError(Mistake.SEMANTICO, Mistake.ID_DECLARADO, (new String[] {v.getId(),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                                }
                                else
                                    errores.insertarError(Mistake.SEMANTICO, Mistake.MATRIZ_NO_FILA, (new String[] {v.getId(),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                            }
                            else
                            {
                                boolean d2 = true;
                                for (Nodo elementosMat1 : elementosMat) 
                                {
                                    for (int j = 0; j < elementosMat1.getHijos().size(); j++) 
                                    {
                                        if (elementosMat1.getHijos().get(j).getCodigo() == accion.elemMat) 
                                        {
                                            errores.insertarError(Mistake.SEMANTICO, Mistake.SOLO_MATRIZ, new String[]{String.valueOf(elementosMat1.getHijos().get(j).getLinea() + 1), String.valueOf(elementosMat1.getHijos().get(j).getColumna())});
                                            d2 = false;
                                            break;
                                        }
                                    }
                                }
                                if(d2)
                                {
                                    if(v.getDimension1() != elementosMat.size())
                                        errores.insertarWarning(Mistake.FILAS_NO_COINCIDE, (new String[] {v.getId(),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                                    for(int i = 0; i < elementosMat.size(); i++)
                                    {
                                        ArrayList<Nodo> elementosMat2 = elementosMat.get(i).getHijos();
                                        if(v.getDimension2() != elementosMat2.size())
                                            errores.insertarWarning(Mistake.COLUMNAS_INCORRECTAS, (new String[] {v.getId(),String.valueOf(i),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                                    }
                                    if(!tablaSimbolos.putIdentificador(v.getId(), v))
                                        errores.insertarError(Mistake.SEMANTICO, Mistake.ID_DECLARADO, (new String[] {v.getId(),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                                }
                            }
                        }
                    }
                break;
                
                    
                case accion.declaracionProt:
                    ArrayList <AtributoVariable> argumentos = new ArrayList <>();
                    ArrayList <Nodo> param = nodo.getHijos().get(2).getHijos();
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
                            argumentos.add(new AtributoVariable (
                                                                    datosMatriz.get(0).getValor(),
                                                                    "", true,
                                                                    Integer.parseInt(datosMatriz.get(1).getValor()),
                                                                    Integer.parseInt(datosMatriz.get(2).getValor()),
                                                                    false
                                                                ));
                        }
                    }
                        
                    f = new AtributoFuncion (
                                                nodo.getHijos().get(0).getValor(),
                                                nodo.getHijos().get(1).getValor(),
                                                argumentos,
                                                false
                                            );
                    if(!tablaSimbolos.putFuncion(f.getId(), f))
                        errores.insertarError(Mistake.SEMANTICO, Mistake.ID_DECLARADO, (new String[] {f.getId(),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
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
                                boolean flag = true;
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
                                    for (AtributoVariable argumento : f.getArgumentos())
                                        if(!tablaSimbolos.putIdentificador(argumento.getId(), argumento))
                                            errores.insertarError(Mistake.SEMANTICO, Mistake.ID_DECLARADO, (new String[] {argumento.getId(),String.valueOf(nodo.getLinea()+1),String.valueOf(nodo.getColumna())}));
                                }                                
                            }
                        }
                    }
                break;
                
               
                case accion.asignacion:
                    AtributoVariable t;
                    if((t = tablaSimbolos.buscarVariable(nodo.getHijos().get(0).getValor())) == null)
                        errores.insertarError(Mistake.SEMANTICO, Mistake.ID_DECLARADO, (new String[] {nodo.getHijos().get(0).getValor(),String.valueOf(nodo.getHijos().get(0).getLinea()+1),String.valueOf(nodo.getHijos().get(0).getColumna())}));
                    else
                    {
                        // Suponiendo que el nodo es un ID                       
                        if(t.esMatriz())
                        {
                            switch(t.getTipo())
                            {
                                case "entero":
                                    e = 2;
                                break;
                                    
                                case "real":
                                    e = 3;
                                break;
                                    
                                case "cadena":
                                    e = -1;
                                break;
                            }
                        }
                        else
                        {
                            switch(t.getTipo())
                            {
                                case "entero":
                                    e = 0;
                                break;
                                    
                                case "real":
                                    e = 1;
                                break;
                                    
                                case "cadena":
                                    e = 4;
                                break;
                            }
                        }
                        
                        r = verificarExp(nodo.getHijos().get(1));
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
                break;
                    
                    
                case accion.finFuncion:
                    tablaSimbolos.salirBloque();
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
    
    public int verificarExp(Nodo exp)
    {
        ArrayList <Integer> tiposOp = new ArrayList <>();
        int r = -1;
        if(!exp.esTerminal())
        {
            if(exp.getCodigo() != accion.llamadaFuncion && exp.getCodigo() != accion.accesoMat)
                for(int i = 0; i < exp.getHijos().size(); i++)
                    tiposOp.add(verificarExp(exp.getHijos().get(i)));
            
            if(exp.getCodigo() == accion.accesoMat)
                for(int i = 1; i < exp.getHijos().size(); i++)
                    tiposOp.add(verificarExp(exp.getHijos().get(i)));
            
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
                    if((f = tablaSimbolos.buscarFuncion(exp.getHijos().get(0).getValor())) == null)
                        errores.insertarError(Mistake.SEMANTICO, Mistake.FUNCION_NO_EXISTE, (new String[] {exp.getHijos().get(0).getValor(),String.valueOf(exp.getHijos().get(0).getLinea()+1),String.valueOf(exp.getHijos().get(0).getColumna())}));
                    else
                    {
                        switch(f.getTipoRetorno())
                        {
                            case "entero":
                                r = 0;
                            break;

                            case "real":
                                r = 1;
                            break;

                            case "cadena":
                                r = 4;
                            break;
                        }
                    }
                break;
                
                case accion.accesoMat:
                    AtributoVariable t;
                    if((t = tablaSimbolos.buscarVariable(exp.getHijos().get(0).getValor())) == null)
                        errores.insertarError(Mistake.SEMANTICO, Mistake.ID_DECLARADO, (new String[] {exp.getValor(),String.valueOf(exp.getHijos().get(0).getLinea()+1),String.valueOf(exp.getHijos().get(0).getColumna())}));
                    else
                    {
                        if(t.esMatriz())
                        {
                            for(int i = 0; i < tiposOp.size(); i++)
                            {
                                if(tiposOp.get(i) != 0)
                                {
                                    errores.insertarError(Mistake.SEMANTICO, Mistake.INDICE_NO_ENTERO, (new String[] {String.valueOf(i),exp.getHijos().get(0).getValor(),String.valueOf(exp.getHijos().get(0).getLinea()+1),String.valueOf(exp.getHijos().get(0).getColumna())}));
                                    return -1;
                                }
                            }
                            
                            switch(t.getTipo())
                            {
                                case "entero":
                                    r = 0;
                                break;

                                case "real":
                                    r = 1;
                                break;

                                case "cadena":
                                    r = 4;
                                break;
                            }
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
                            if(elementosMat.get(i).getCodigo() == accion.elemVec && elementosMat.get(i).getHijos().isEmpty())
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
                                errores.insertarError(Mistake.SEMANTICO, Mistake.ELEMENTO_NO_CORRECTO, (new String[] {String.valueOf(i),String.valueOf(exp.getLinea()+1),String.valueOf(exp.getColumna())}));
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
                                errores.insertarError(Mistake.SEMANTICO, Mistake.RETORNO_NO_COINCIDE, (new String[] {String.valueOf(i),String.valueOf(exp.getLinea()+1),String.valueOf(exp.getColumna())}));
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
                        if(t.esMatriz())
                        {
                            switch(t.getTipo())
                            {
                                case "entero":
                                    r = 2;
                                break;
                                    
                                case "real":
                                    r = 3;
                                break;
                                    
                                case "cadena":
                                    r = -1;
                                break;
                            }
                        }
                        else
                        {
                            switch(t.getTipo())
                            {
                                case "entero":
                                    r = 0;
                                break;
                                    
                                case "real":
                                    r = 1;
                                break;
                                    
                                case "cadena":
                                    r = 4;
                                break;
                            }
                        }
                    }
                break;
            }
        }
        return r;
    }
        
    public Entorno getTabla()
    {
        return tablaSimbolos;
    }
    
    public String toString()
    {
        return "" + raiz;
    }
}