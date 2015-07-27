package lema;

import java.util.ArrayList;

public class AST
{
    private Nodo raiz;
    private Env tabla;
    private int countB;
    private ArrayList<String> errores;
    
    public AST()
    {
        this(new Nodo());
    }
    
    public AST(Nodo raiz)
    {
        this.raiz = raiz;
        tabla = new Env();
        countB = 0;
        errores = new ArrayList<String>();
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
            String [][] valor;
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
                    
                    switch(a.getTipo())
                    {
                        case "entero":
                            a.setValor("0");
                        break;
                            
                        case "real":
                            a.setValor("0.0");
                        break;
                            
                        case "cadena":
                            a.setValor("Nulo");
                        break;
                    }
                    
                    if(!tabla.putIdentificador(a.getId(), a))
                        errores.add("Identificador " + a.getId() + " ya fue declarado");
                break;
                
                case accion.declaracionSimIni:
                    a = new AtributoVariable( nodo.getHijos().get(0).getValor(),
                                                               nodo.getHijos().get(1).getValor(),
                                                               false,
                                                               1, 1,
                                                               false);
                    a.setValor(nodo.getHijos().get(2).getValor());
                    if(!tabla.putIdentificador(a.getId(), a))
                        errores.add("Identificador " + a.getId() + " ya fue declarado");
                break;
                
                case accion.declaracionVec:
                    /*Convertir indice*/
                    a = new AtributoVariable( nodo.getHijos().get(0).getValor(),
                                                               nodo.getHijos().get(1).getValor(),
                                                               false,
                                                               1, Integer.parseInt(nodo.getHijos().get(2).getValor()),
                                                               false);
                    
                    valor = a.getValor();
                    
                    switch(a.getTipo())
                    {
                        case "entero":
                            for(int i = 0; i < a.getDimension1(); i++)
                                for(int j = 0; j < a.getDimension2(); j++)
                                    valor[i][j] = "0";
                        break;
                            
                        case "real":
                            for(int i = 0; i < a.getDimension1(); i++)
                                for(int j = 0; j < a.getDimension2(); j++)
                                    valor[i][j] = "0.0";
                        break;
                    }
                    
                    if(!tabla.putIdentificador(a.getId(), a))
                        errores.add("Identificador " + a.getId() + " ya fue declarado");
                break;
                
                case accion.declaracionVecIni:
                    /*Convertir indice*/
                    a = new AtributoVariable( nodo.getHijos().get(0).getValor(),
                                                               nodo.getHijos().get(1).getValor(),
                                                               false,
                                                               1, Integer.parseInt(nodo.getHijos().get(2).getValor()),
                                                               false);
                    
                    valor = a.getValor();
                    elementos = nodo.getHijos().get(3).getHijos();
                    if(a.getDimension2() == elementos.size())
                    {
                        for(int i = 0; i < elementos.size(); i++)
                            valor[0][i] = elementos.get(i).getValor();

                        if(!tabla.putIdentificador(a.getId(), a))
                            errores.add("Identificador " + a.getId() + " ya fue declarado");
                    }
                    else
                        errores.add("Tamaño del vector" + a.getId() + " no coincide con elementos introducidos");
                break;
                
                case accion.declaracionMat:
                    /*Convertir indice*/
                    a = new AtributoVariable( nodo.getHijos().get(0).getValor(),
                                                               nodo.getHijos().get(1).getValor(),
                                                               false,
                                                               Integer.parseInt(nodo.getHijos().get(2).getValor()),
                                                               Integer.parseInt(nodo.getHijos().get(3).getValor()),
                                                               false);
                    
                    valor = a.getValor();
                    
                    switch(a.getTipo())
                    {
                        case "entero":
                            for(int i = 0; i < a.getDimension1(); i++)
                                for(int j = 0; j < a.getDimension2(); j++)
                                    valor[i][j] = "0";
                        break;
                            
                        case "real":
                            for(int i = 0; i < a.getDimension1(); i++)
                                for(int j = 0; j < a.getDimension2(); j++)
                                    valor[i][j] = "0.0";
                        break;
                    }
                    
                    if(!tabla.putIdentificador(a.getId(), a))
                        errores.add("Identificador " + a.getId() + " ya fue declarado");
                break;
                
                case accion.declaracionMatIni:
                    /*Convertir indice*/
                    a = new AtributoVariable( nodo.getHijos().get(0).getValor(),
                                                               nodo.getHijos().get(1).getValor(),
                                                               false,
                                                               Integer.parseInt(nodo.getHijos().get(2).getValor()),
                                                               Integer.parseInt(nodo.getHijos().get(3).getValor()),
                                                               false);
                    
                    valor = a.getValor();
                    elementosMat = nodo.getHijos().get(4).getHijos();
                    
                    if(a.getDimension1() == elementosMat.size())
                    {
                        for(int i = 0; i < elementosMat.size(); i++)
                        {
                            ArrayList<Nodo> elementosMat2 = elementosMat.get(i).getHijos();
                            if(a.getDimension2() == elementosMat2.size())
                            {
                                for(int j = 0; j < elementosMat2.size(); j++)
                                    valor[i][j] = elementosMat2.get(j).getValor();
                            }
                            else
                                errores.add("Número de columnas de la fila " + i + " de la matriz " + a.getId() + " incorrecto");
                        }

                        if(!tabla.putIdentificador(a.getId(), a))
                            errores.add("Identificador " + a.getId() + " ya fue declarado");
                    }
                    else
                        errores.add("Número de filas de la matriz " + a.getId() + " no coincide con las inicializadas");
                break;
                
                case accion.declaracionConsSim:
                    a = new AtributoVariable( nodo.getHijos().get(0).getValor(),
                                                               nodo.getHijos().get(1).getValor(),
                                                               false,
                                                               1, 1,
                                                               true);
                    a.setValor(nodo.getHijos().get(2).getValor());
                    if(!tabla.putIdentificador(a.getId(), a))
                        errores.add("Identificador " + a.getId() + " ya fue declarado");
                break;
                
                case accion.declaracionConsVec:
                    /*Convertir indice*/
                    a = new AtributoVariable( nodo.getHijos().get(0).getValor(),
                                                               nodo.getHijos().get(1).getValor(),
                                                               false,
                                                               1, Integer.parseInt(nodo.getHijos().get(2).getValor()),
                                                               true);
                    
                    valor = a.getValor();
                    elementos = nodo.getHijos().get(3).getHijos();
                    if(a.getDimension2() == elementos.size())
                    {
                        for(int i = 0; i < elementos.size(); i++)
                            valor[0][i] = elementos.get(i).getValor();

                        if(!tabla.putIdentificador(a.getId(), a))
                            errores.add("Identificador " + a.getId() + " ya fue declarado");
                    }
                    else
                        errores.add("Tamaño del vector" + a.getId() + " no coincide con elementos introducidos");
                break;
                
                case accion.declaracionConsMat:
                    /*Convertir indice*/
                    a = new AtributoVariable( nodo.getHijos().get(0).getValor(),
                                                               nodo.getHijos().get(1).getValor(),
                                                               false,
                                                               Integer.parseInt(nodo.getHijos().get(2).getValor()),
                                                               Integer.parseInt(nodo.getHijos().get(3).getValor()),
                                                               true);
                    
                    valor = a.getValor();
                    elementosMat = nodo.getHijos().get(4).getHijos();
                    
                    if(a.getDimension1() == elementosMat.size())
                    {
                        for(int i = 0; i < elementosMat.size(); i++)
                        {
                            ArrayList<Nodo> elementosMat2 = elementosMat.get(i).getHijos();
                            if(a.getDimension2() == elementosMat2.size())
                            {
                                for(int j = 0; j < elementosMat2.size(); j++)
                                    valor[i][j] = elementosMat2.get(j).getValor();
                            }
                            else
                                errores.add("Número de columnas de la fila " + i + " de la matriz " + a.getId() + " incorrecto");
                        }

                        if(!tabla.putIdentificador(a.getId(), a))
                            errores.add("Identificador " + a.getId() + " ya fue declarado");
                    }
                    else
                        errores.add("Número de filas de la matriz " + a.getId() + " no coincide con las inicializadas");
                break;
                
                case accion.declaracionVar:
                    tabla.putBloque("Bloque" + countB);
                    countB++;
                break;
                
                case accion.finBloque:
                    tabla.pop();
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
    
    public Env getTabla()
    {
        return tabla;
    }
}