package lema;

import java.util.ArrayList;

public class AtributoFuncion
{
    private String tipoRetorno;
    private String id;
    private ArrayList<AtributoVariable> argumentos;
    
    public AtributoFuncion()
    {
        this("vacio", "NULL_ID", null);
    }
    
    public AtributoFuncion(String tipoRetorno, String id, ArrayList<AtributoVariable> argumentos)
    {
        this.tipoRetorno = tipoRetorno;
        this.id = id;
        this.argumentos = argumentos;
    }

    public String getTipoRetorno()
    {
        return tipoRetorno;
    }

    public void setTipoRetorno(String tipoRetorno)
    {
        this.tipoRetorno = tipoRetorno;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public ArrayList<AtributoVariable> getArgumentos()
    {
        return argumentos;
    }

    public void setArgumentos(ArrayList<AtributoVariable> argumentos)
    {
        this.argumentos = argumentos;
    }
}
