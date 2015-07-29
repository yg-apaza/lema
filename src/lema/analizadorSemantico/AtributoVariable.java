package lema.analizadorSemantico;

public class AtributoVariable
{
    private String tipo;
    private String id;
    private boolean esMatriz;
    private int dimension1;
    private int dimension2;
    private boolean constante;
    
    public AtributoVariable()
    {
        this("vacio", "NULL_ID", false, 1, 1, false);
    }

    public AtributoVariable(String tipo, String id, boolean esMatriz, int dimension1, int dimension2, boolean constante)
    {
        this.tipo = tipo;
        this.id = id;
        this.esMatriz = esMatriz;
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;        
        this.constante = constante;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public boolean isEsMatriz()
    {
        return esMatriz;
    }

    public void setEsMatriz(boolean esMatriz)
    {
        this.esMatriz = esMatriz;
    }

    public int getDimension1()
    {
        return dimension1;
    }

    public void setDimension1(int dimension1)
    {
        this.dimension1 = dimension1;
    }

    public int getDimension2()
    {
        return dimension2;
    }

    public void setDimension2(int dimension2)
    {
        this.dimension2 = dimension2;
    }

    public boolean isConstante()
    {
        return constante;
    }

    public void setConstante(boolean constante)
    {
        this.constante = constante;
    }
    
    public String toString()
    {
        return tipo + " " + id + " " + (esMatriz?"Matriz":"Simple") + " " + dimension1 + " " + dimension2 + " " + (constante?"Constante":"No constante");
    }    
}
