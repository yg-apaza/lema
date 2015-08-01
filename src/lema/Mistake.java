/*Kef*/
package lema;

import java.util.ArrayList;

public class Mistake
{
    private ArrayList<String> errorLexico;
    private ArrayList<String> errorSintactico;
    private ArrayList<String> errorSemantico;
    
    
    private final String [] listaLexico =
    {
        "Error Lexico: Token '$' no reconocido. Lin: $ Col: $"
    };
    
    private final String [] listaSintactico =
    {
        "Error Sintactico: $. Lin: $ Col: $"
    };
    
    public static final int ID_DECLARADO = 0;
    public static final int NO_TAMANIO_CERO = 1;
    public static final int DATOS_DISTINTOS = 2;
    public static final int NUM_ELEMENTOS_INCORRECTOS = 3;
    public static final int MATRIZ_NO_FILA = 4;
    public static final int SOLO_MATRIZ = 5;
    public static final int FILAS_NO_COINCIDE = 6;
    public static final int COLUMNAS_INCORRECTAS = 7;    
    public static final int NO_PROTOTIPO = 8;
    public static final int RETORNO_NO_COINCIDE = 9;
    public static final int ARGUMENTO_NUM_NO_COINCIDE = 10;
    public static final int ARGUMENTO_NO_MATRIZ = 11;
    public static final int ARGUMENTO_NO_COINCIDE = 12;
    public static final int ARGUMENTO_MATRIZ = 13;
    /*public static final int = 14;
    public static final int = 15;
    public static final int = 16;
    public static final int = 17;    
    public static final int = 18;
    public static final int ID_NO_DECLARADO = 19;
      */      
    
    private final String [] listaSemantico =
    {
        "Error Semántico: Identificado '$' ya se encuentra declarado. Lin: $ Col: $",
        "Error Semántico: No se puede inicializar matrices/vectores con tamaño 0. Lin: $ Col $",
        "Error Semántico: Datos introducidos en la matriz/vector $ distintos. Lin: $ Col $",
        "Warning Semántico: Número de elementos introducidos a la matriz/vector '$' incorrecto. Lin: $ Col: $",
        "Error Semántico: La matriz/vector '$' no debe poseer 1 fila. Lin: $ Col: $",
        "Error Semántico: Solo se permite matrices/vectores unidimensionales o bidimensionales. Lin: $ Col: $",
        "Warning Semántico: Número de filas de la matriz/vector '$' no coincide con las inicializadas. Lin: $ Col: $",
        "Warning Semántico: Número de columnas de la fila $ de la matriz/vector '$' incorrecto. Lin: $ Col: $",
        "Error Semántico: No hay un prototipo declarado para la función '$'. Lin: $ Col: $",
        "Error Semántico: Tipo de dato de retorno de la función '$' no coincide con su prototipo. Lin $ Col: $",
        "Error Semántico: Número de argumentos de la función '$' no coincide con su prototipo. Lin: $ Col: $",
        "Error Semántico: Argumento $ de la función '$' debe ser una matriz/vector. Lin: $ Col:$",
        "Error Semántico: Argumento $ de la función '$' no coincide con el prototipo. Lin: $ Col: $",
        "Error Semántico: Argumento $ de la función '$' no debe ser una matriz/vector. Lin: $ Col: $",
        "14Error Semántico: Tipo de dato asignado a la variable '$' no es compatible. Lin: $ Col: $",
        "15Error Semántico: La función '$' no existe. Lin: $ Col: $",
        "16Error Semántico: Índice $ de la matriz/vector '$' no es entero. Lin: $ Col: $",
        "17Error Semántico: El identificador '$' no es una matriz/vector. Lin: $ Col: $",
        "18Error Semántico: Elemento $ de la matriz/vector no es correcto. Lin: $ Col: $",
        "Error Semántico: Identificador '$' no declarado. Lin: $ Col: $"
    };
    
    public Mistake()
    {
        errorLexico     = new ArrayList<String>();
        errorSintactico = new ArrayList<String>();
        errorSemantico  = new ArrayList<String>();
    }
    
    public void insertarError(int tipo, int codigo, String[] datos)
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
    
    public String unir(String error, String[] datos)
    {
        int index = -1;
        
        for (String dato : datos) 
        {
            index = error.indexOf("$", index + 1);
            error = error.substring(0, index) + dato + error.substring(index+1);
            System.out.println(error);
        }
        
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
