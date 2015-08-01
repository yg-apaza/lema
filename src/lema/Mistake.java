package lema;

import java.util.ArrayList;

public class Mistake
{
    private ArrayList<String> errorLexico;
    private ArrayList<String> errorSintactico;
    private ArrayList<String> errorSemantico;
    
    private final String [] listaLexico =
    {
        "Error Lexico: Token ? no reconocido. Lin: ? Col: ?"
    };
    
    private final String [] listaSintactico =
    {
        "Error Sintactico: Lin: ? Col: ?"
    };
    
    private final String [] listaSemantico =
    {
        
    };
    
    public Mistake()
    {
        errorLexico     = new ArrayList<String>();
        errorSintactico = new ArrayList<String>();
        errorSemantico  = new ArrayList<String>();
    }
    
    public void insertarError(int tipo, int codigo, ArrayList<String> datos)
    {
        String err = "";
        switch(tipo)
        {
            case 0:
                err = unir(listaLexico[codigo], datos);
                errorLexico.add(err);
            break;
                
            case 1:
                err = unir(listaSintactico[codigo], datos);
                errorSintactico.add(err);
            break;
            
            case 2:
                err = unir(listaSemantico[codigo], datos);
                errorSemantico.add(err);
            break;
        }
    }
    
    private String unir(String error, ArrayList<String> datos)
    {
        /*
        String dev = "";
        for(int i = 0; i < datos.size(); i++)
            System.out.println(error.replaceFirst("?", datos.get(i)));
                */
        return error;
    }
    
    public ArrayList<String> getError(int tipo)
    {
        switch(tipo)
        {
            case 0:
                return errorLexico;
            case 1:
                return errorSintactico;
            case 2:
                return errorSemantico;
        }
        return (new ArrayList<String>());
    }
}
