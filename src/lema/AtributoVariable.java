package lema;

public class AtributoVariable
{
    private String tipo;
    private String id;
    private boolean esMatriz;
    private int dimension1;
    private int dimension2;
    private String valor [][];
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
        this.valor = new String [dimension1][dimension2];
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

    public String[][] getValor()
    {
        return valor;
    }

    public void setValor(String[][] valor)
    {
        this.valor = valor;
    }
    
    public void setValor(String valor)
    {
        this.valor[0][0] = valor;
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
        String out = this.tipo + " " + this.id + "\n";
        for(int i = 0; i < valor.length; i++)
        {
            for(int j = 0; j < valor[0].length; j++)
                out += valor[i][j] + "\t";
            out += "\n";
        }
        return out;
    }    
}
