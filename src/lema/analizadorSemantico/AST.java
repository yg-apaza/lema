package lema.analizadorSemantico;

import java.util.ArrayList;

public class AST
{
    private Nodo raiz;
    private Entorno tablaSimbolos;
    private ArrayList<String> errores;
    
    public AST()
    {
        this(new Nodo());
    }
    
    public AST(Nodo raiz)
    {
        this.raiz = raiz;
        tablaSimbolos = new Entorno();
        errores = new ArrayList<>();
    }
    
    public void verificar()
    {
        errores.clear();
        verificar(raiz);
    }
    
    private void verificar(Nodo nodo)
    {
        if(!nodo.isTerminal())
        {
            AtributoVariable a;
            ArrayList<Nodo> elementos;
            ArrayList<Nodo> elementosMat;

            switch(nodo.getCodigo())
            {
                case accion.declaracionSim:
                    a = new AtributoVariable( nodo.getHijos().get(0).getValor(),
                                                               nodo.getHijos().get(1).getValor(),
                                                               false,
                                                               1, 1,
                                                               false);
                    if(!tablaSimbolos.putIdentificador(a.getId(), a))
                        errores.add("Lin: " + (nodo.getLinea()+1) + " Col: " + nodo.getColumna() + " Identificador '" + a.getId() + "' ya fue declarado");
                break;
                
                case accion.declaracionSimIni:
                    a = new AtributoVariable( nodo.getHijos().get(0).getValor(),
                                                               nodo.getHijos().get(1).getValor(),
                                                               false,
                                                               1, 1,
                                                               false);
                    if(!tablaSimbolos.putIdentificador(a.getId(), a))
                        errores.add("Lin: " + (nodo.getLinea()+1) + " Col: " + nodo.getColumna() + " Identificador '" + a.getId() + "' ya fue declarado");
                break;
                
                case accion.declaracionVec:
                    /*Convertir indice*/
                    a = new AtributoVariable( nodo.getHijos().get(0).getValor(),
                                                               nodo.getHijos().get(1).getValor(),
                                                               true,
                                                               1, Integer.parseInt(nodo.getHijos().get(2).getValor()),
                                                               false);
                    
                    if(!tablaSimbolos.putIdentificador(a.getId(), a))
                        errores.add("Lin: " + (nodo.getLinea()+1) + " Col: " + nodo.getColumna() + " Identificador '" + a.getId() + "' ya fue declarado");
                break;
                
                case accion.declaracionVecIni:
                    /*Convertir indice*/
                    a = new AtributoVariable( nodo.getHijos().get(0).getValor(),
                                                               nodo.getHijos().get(1).getValor(),
                                                               true,
                                                               1, Integer.parseInt(nodo.getHijos().get(2).getValor()),
                                                               false);
                    
                    elementos = nodo.getHijos().get(3).getHijos();
                    if(a.getDimension2() == elementos.size())
                    {
                        if(!tablaSimbolos.putIdentificador(a.getId(), a))
                            errores.add("Lin: " + (nodo.getLinea()+1) + " Col: " + nodo.getColumna() + " Identificador '" + a.getId() + "' ya fue declarado");
                    }
                    else
                        errores.add("Lin: " + (nodo.getLinea()+1) + " Col: " + nodo.getColumna() + " Tamaño del vector '" + a.getId() + "' no coincide con elementos introducidos");
                break;
                
                case accion.declaracionMat:
                    /*Convertir indice*/
                    a = new AtributoVariable( nodo.getHijos().get(0).getValor(),
                                                               nodo.getHijos().get(1).getValor(),
                                                               true,
                                                               Integer.parseInt(nodo.getHijos().get(2).getValor()),
                                                               Integer.parseInt(nodo.getHijos().get(3).getValor()),
                                                               false);
                    
                    if(!tablaSimbolos.putIdentificador(a.getId(), a))
                        errores.add("Lin: " + (nodo.getLinea()+1) + " Col: " + nodo.getColumna() + " Identificador '" + a.getId() + "' ya fue declarado");
                break;
                
                case accion.declaracionMatIni:
                    /*Convertir indice*/
                    a = new AtributoVariable( nodo.getHijos().get(0).getValor(),
                                                               nodo.getHijos().get(1).getValor(),
                                                               true,
                                                               Integer.parseInt(nodo.getHijos().get(2).getValor()),
                                                               Integer.parseInt(nodo.getHijos().get(3).getValor()),
                                                               false);
                    
                    elementosMat = nodo.getHijos().get(4).getHijos();
                    
                    if(a.getDimension1() == elementosMat.size())
                    {
                        for(int i = 0; i < elementosMat.size(); i++)
                        {
                            ArrayList<Nodo> elementosMat2 = elementosMat.get(i).getHijos();
                            if(!(a.getDimension2() == elementosMat2.size()))
                                errores.add("Lin: " + (nodo.getLinea()+1) + " Col: " + nodo.getColumna() + " Número de columnas de la fila " + i + " de la matriz '" + a.getId() + "' incorrecto");
                        }

                        if(!tablaSimbolos.putIdentificador(a.getId(), a))
                            errores.add("Lin: " + (nodo.getLinea()+1) + " Col: " + nodo.getColumna() + " Identificador '" + a.getId() + "' ya fue declarado");
                    }
                    else
                        errores.add("Lin: " + (nodo.getLinea()+1) + " Col: " + nodo.getColumna() + " Número de filas de la matriz '" + a.getId() + "' no coincide con las inicializadas");
                break;
                
                case accion.declaracionConsSim:
                    a = new AtributoVariable( nodo.getHijos().get(0).getValor(),
                                                               nodo.getHijos().get(1).getValor(),
                                                               false,
                                                               1, 1,
                                                               true);
                    if(!tablaSimbolos.putIdentificador(a.getId(), a))
                        errores.add("Lin: " + (nodo.getLinea()+1) + " Col: " + nodo.getColumna() + " Identificador '" + a.getId() + "' ya fue declarado");
                break;
                
                case accion.declaracionConsVec:
                    /*Convertir indice*/
                    a = new AtributoVariable( nodo.getHijos().get(0).getValor(),
                                                               nodo.getHijos().get(1).getValor(),
                                                               true,
                                                               1, Integer.parseInt(nodo.getHijos().get(2).getValor()),
                                                               true);
                    
                    elementos = nodo.getHijos().get(3).getHijos();
                    if(a.getDimension2() == elementos.size())
                    {
                        if(!tablaSimbolos.putIdentificador(a.getId(), a))
                            errores.add("Lin: " + (nodo.getLinea()+1) + " Col: " + nodo.getColumna() + " Identificador '" + a.getId() + "' ya fue declarado");
                    }
                    else
                        errores.add("Lin: " + (nodo.getLinea()+1) + " Col: " + nodo.getColumna() + " Tamaño del vector '" + a.getId() + "' no coincide con elementos introducidos");
                break;
                
                case accion.declaracionConsMat:
                    /*Convertir indice*/
                    a = new AtributoVariable( nodo.getHijos().get(0).getValor(),
                                                               nodo.getHijos().get(1).getValor(),
                                                               true,
                                                               Integer.parseInt(nodo.getHijos().get(2).getValor()),
                                                               Integer.parseInt(nodo.getHijos().get(3).getValor()),
                                                               true);
                    
                    elementosMat = nodo.getHijos().get(4).getHijos();
                    
                    if(a.getDimension1() == elementosMat.size())
                    {
                        for(int i = 0; i < elementosMat.size(); i++)
                        {
                            ArrayList<Nodo> elementosMat2 = elementosMat.get(i).getHijos();
                            if(!(a.getDimension2() == elementosMat2.size()))
                                errores.add("Lin: " + (nodo.getLinea()+1) + " Col: " + nodo.getColumna() + " Número de columnas de la fila " + i + " de la matriz '" + a.getId() + "' incorrecto");
                        }

                        if(!tablaSimbolos.putIdentificador(a.getId(), a))
                            errores.add("Lin: " + (nodo.getLinea()+1) + " Col: " + nodo.getColumna() + " Identificador '" + a.getId() + "' ya fue declarado");
                    }
                    else
                        errores.add("Lin: " + (nodo.getLinea()+1) + " Col: " + nodo.getColumna() + " Número de filas de la matriz '" + a.getId() + "' no coincide con las inicializadas");
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
        return errores;
    }
    
    public Entorno getTabla()
    {
        return tablaSimbolos;
    }
}