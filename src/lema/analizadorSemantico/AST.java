package lema.analizadorSemantico;

import java.util.ArrayList;

public class AST
{
    private Nodo raiz;
    private Entorno tablaSimbolos;
    private ArrayList<ArrayList<String>> errores;
    
    public AST()
    {
        this(new Nodo());
    }
    
    public AST(Nodo raiz)
    {
        this.raiz = raiz;
        tablaSimbolos = new Entorno();
        errores = new ArrayList<>();
        errores.add(new ArrayList<String>());
        errores.add(new ArrayList<String>());
    }
    
    public void verificar()
    {
        errores.get(0).clear();
        errores.get(1).clear();
        verificar(raiz);
    }
    
    private void verificar(Nodo nodo)
    {
        if(!nodo.esTerminal())
        {
            AtributoVariable v;
            AtributoFuncion f;
            ArrayList<Nodo> elementos;
            ArrayList<Nodo> elementosMat;

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
                        errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " Identificador '" + v.getId() + "' ya fue declarado");
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
                        errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " Identificador '" + v.getId() + "' ya fue declarado");
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
                        errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " Identificador '" + v.getId() + "' ya fue declarado");
                break;
                
                    
                case accion.declaracionMatIni:
                    /*Convertir indice*/
                    v = new AtributoVariable(
                                                nodo.getHijos().get(0).getValor(),
                                                nodo.getHijos().get(1).getValor(),
                                                true,
                                                Integer.parseInt(nodo.getHijos().get(2).getValor()),
                                                Integer.parseInt(nodo.getHijos().get(3).getValor()),
                                                false
                                            );
                    
                    elementosMat = nodo.getHijos().get(4).getHijos();
                    
                    if(elementosMat.isEmpty())
                        errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " No se puede inicializar matrices/vectores con tamaño 0");
                    else
                    {
                        /** Los elementos contenidos por la matriz son simples o vectores, TRUE Vectores, FALSE Simples*/
                        boolean flag = (accion.elemMat == elementosMat.get(0).getCodigo());
                        boolean iguales = true;
                        for(int i = 1; i < elementosMat.size(); i++)
                            if(!((elementosMat.get(i).getCodigo() == accion.elemMat) == flag))
                            {
                                errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " Datos introducidos en la matriz/vector '" + v.getId() + "' distintos");
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
                                    ArrayList<Nodo> enlace = new ArrayList<Nodo>();
                                    enlace.add(new Nodo(accion.elemMat, accion.acciones[accion.elemMat], nodo.getLinea(), nodo.getColumna(), elementosMat, false));
                                    nodo.getHijos().get(4).setHijos(enlace);
                                    
                                    if(v.getDimension2() != elementosMat.size())
                                        errores.get(1).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " Número de elementos introducidos a la matriz/vector '" + v.getId() + "' incorrecto");
                                    else if(!tablaSimbolos.putIdentificador(v.getId(), v))
                                                errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " Identificador '" + v.getId() + "' ya fue declarado");
                                }
                                else
                                    errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " La matriz/vector '" + v.getId() + "' no debe poseer 1 fila");
                            }
                            else
                            {
                                boolean d2 = true;
                                for(int i = 0; i < elementosMat.size(); i++)
                                {
                                    for(int j = 0; j < elementosMat.get(i).getHijos().size(); j++)
                                        if(elementosMat.get(i).getHijos().get(j).getCodigo() == accion.elemMat)
                                        {
                                            errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " Solo se permite matrices/vectores unidimensionales o bidimensionales");
                                            d2 = false;
                                            break;
                                        }
                                }
                                if(d2)
                                {
                                    if(v.getDimension1() == elementosMat.size())
                                    {
                                        boolean numero = true;
                                        for(int i = 0; i < elementosMat.size(); i++)
                                        {
                                            ArrayList<Nodo> elementosMat2 = elementosMat.get(i).getHijos();
                                            if(!(v.getDimension2() == elementosMat2.size()))
                                            {
                                                errores.get(1).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " Número de columnas de la fila " + i + " de la matriz/vector '" + v.getId() + "' incorrecto");
                                                numero = false;
                                            }
                                        }
                                        if(numero)
                                            if(!tablaSimbolos.putIdentificador(v.getId(), v))
                                                errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " Identificador '" + v.getId() + "' ya fue declarado");
                                    }
                                    else
                                        errores.get(1).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " Número de filas de la matriz/vector '" + v.getId() + "' no coincide con las inicializadas");
                                }
                            }
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
                        errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " Identificador '" + v.getId() + "' ya fue declarado");
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
                        errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " No se puede inicializar matrices/vectores con tamaño 0");
                    else
                    {
                        /** Los elementos contenidos por la matriz son simples o vectores, TRUE Vectores, FALSE Simples*/
                        boolean flag = (accion.elemMat == elementosMat.get(0).getCodigo());
                        boolean iguales = true;
                        for(int i = 1; i < elementosMat.size(); i++)
                            if(!((elementosMat.get(i).getCodigo() == accion.elemMat) == flag))
                            {
                                errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " Datos introducidos en la matriz/vector '" + v.getId() + "' distintos");
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
                                    ArrayList<Nodo> enlace = new ArrayList<Nodo>();
                                    enlace.add(new Nodo(accion.elemMat, accion.acciones[accion.elemMat], nodo.getLinea(), nodo.getColumna(), elementosMat, false));
                                    nodo.getHijos().get(4).setHijos(enlace);
                                    
                                    if(v.getDimension2() != elementosMat.size())
                                        errores.get(1).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " Número de elementos introducidos a la matriz/vector '" + v.getId() + "' incorrecto");
                                    else if(!tablaSimbolos.putIdentificador(v.getId(), v))
                                                errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " Identificador '" + v.getId() + "' ya fue declarado");
                                }
                                else
                                    errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " La matriz/vector '" + v.getId() + "' no debe poseer 1 fila");
                            }
                            else
                            {
                                boolean d2 = true;
                                for(int i = 0; i < elementosMat.size(); i++)
                                {
                                    for(int j = 0; j < elementosMat.get(i).getHijos().size(); j++)
                                        if(elementosMat.get(i).getHijos().get(j).getCodigo() == accion.elemMat)
                                        {
                                            errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " Solo se permite matrices/vectores unidimensionales o bidimensionales");
                                            d2 = false;
                                            break;
                                        }
                                }
                                if(d2)
                                {
                                    if(v.getDimension1() == elementosMat.size())
                                    {
                                        boolean numero = true;
                                        for(int i = 0; i < elementosMat.size(); i++)
                                        {
                                            ArrayList<Nodo> elementosMat2 = elementosMat.get(i).getHijos();
                                            if(!(v.getDimension2() == elementosMat2.size()))
                                            {
                                                errores.get(1).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " Número de columnas de la fila " + i + " de la matriz/vector '" + v.getId() + "' incorrecto");
                                                numero = false;
                                            }
                                        }
                                        if(numero)
                                            if(!tablaSimbolos.putIdentificador(v.getId(), v))
                                                errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " Identificador '" + v.getId() + "' ya fue declarado");
                                    }
                                    else
                                        errores.get(1).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " Número de filas de la matriz/vector '" + v.getId() + "' no coincide con las inicializadas");
                                }
                            }
                        }
                    }
                break;
                
                    
                case accion.declaracionProt:
                    ArrayList<AtributoVariable> argumentos = new ArrayList<AtributoVariable>();
                    ArrayList<Nodo> param = nodo.getHijos().get(2).getHijos();
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
                        errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() + " Identificador '" + f.getId() + "' ya fue declarado");
                break;
                
                
                case accion.funcion:
                    if((f = tablaSimbolos.buscarFuncion(nodo.getHijos().get(1).getValor())) == null)
                        errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() +
                                            " No hay un prototipo declarado para la función '" + nodo.getHijos().get(1).getValor() + "'");
                    else
                    {
                        if(!f.getTipoRetorno().equals(nodo.getHijos().get(0).getValor()))
                            errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() +
                                                " Tipo de dato de retorno de la función '" + f.getId() + "' no coincide con su prototipo");
                        else
                        {
                            if(f.getArgumentos().size() != nodo.getHijos().get(2).getHijos().size())
                                errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() +
                                                " Número de argumentos de la función '" + f.getId() + "' no coincide con su prototipo");
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
                                            errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() +
                                                                " Argumento " + (i + 1) + " de la función '" + f.getId() + "' debe ser una matriz/vector");
                                            flag = false;
                                        }
                                        else
                                        {
                                            if(!(aux.getTipo().equals(arg.get(i).getHijos().get(0).getValor()) &&
                                                (aux.getDimension1() == Integer.parseInt(arg.get(i).getHijos().get(2).getValor())) && 
                                                (aux.getDimension2() == Integer.parseInt(arg.get(i).getHijos().get(3).getValor()))))
                                            {
                                                errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() +
                                                                   " Argumento " + (i + 1) + " de la función '" + f.getId() + "' no coincide con el prototipo");
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
                                            errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() +
                                                                " Argumento " + (i + 1) + " de la función '" + f.getId() + "' no debe ser una matriz/vector");
                                            flag = false;
                                        }
                                        else
                                        {
                                            if(!aux.getTipo().equals(arg.get(i).getHijos().get(0).getValor()))
                                            {
                                                errores.get(0).add("Lin: " + (nodo.getLinea() + 1) + " Col: " + nodo.getColumna() +
                                                                    " Argumento " + (i + 1) + " de la función '" + f.getId() + "' no coincide con el prototipo");
                                                flag = false;
                                            }
                                            else
                                                aux.setId(arg.get(i).getHijos().get(1).getValor());
                                        }
                                    }
                                        
                                }
                                
                                if(flag)
                                    f.setDefinido(true);
                                
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
    
    public ArrayList<String> getErrores()
    {
        return errores.get(0);
    }
    
    public ArrayList<String> getWarnings()
    {
        return errores.get(1);
    }
    
    public Entorno getTabla()
    {
        return tablaSimbolos;
    }
}