package lema;

import java.util.ArrayList;

public class Mistake
{
    private final ArrayList<String> errorLexico;
    private final ArrayList<String> errorSintactico;
    private final ArrayList<String> errorSemantico;
    private final ArrayList<String> warnings;
    
    /* Errores Generales */
    public static final int LEXICO = 0;
    public static final int SINTACTICO = 1;
    public static final int SEMANTICO = 2;
    
    /* Errores del Análisis Léxico */
    public static final int TOKEN_INVALIDO = 0;
    
    /* Errores del Análisis Sintáctico */
    public static final int ERROR_SINTACTICO = 0;
    
    /* Errores del Análisis Semántico */
    public static final int ID_DECLARADO = 0;
    public static final int NO_TAMANIO_CERO = 1;
    public static final int DATOS_DISTINTOS = 2;
    public static final int MATRIZ_NO_FILA = 3;
    public static final int SOLO_MATRIZ = 4;        
    public static final int NO_PROTOTIPO = 5;
    public static final int RETORNO_NO_COINCIDE = 6;
    public static final int ARGUMENTO_NUM_NO_COINCIDE = 7;
    public static final int ARGUMENTO_NO_MATRIZ = 8;
    public static final int ARGUMENTO_NO_COINCIDE = 9;
    public static final int ARGUMENTO_MATRIZ = 10;
    public static final int TIPO_NO_COMPATIBLE = 11;
    public static final int FUNCION_NO_EXISTE = 12;
    public static final int INDICE_NO_ENTERO = 13;
    public static final int ID_NO_MATRIZ = 14;    
    public static final int ELEMENTO_NO_CORRECTO = 15;
    public static final int ID_NO_DECLARADO = 16;
    public static final int FUNCION_NO_DEFINIDA = 17;
    public static final int NO_VARIABLE = 18;

    /* Warnings */
    public static final int NUM_ELEMENTOS_INCORRECTOS = 0;
    public static final int FILAS_NO_COINCIDE = 1;
    public static final int COLUMNAS_INCORRECTAS = 2;
    
    private final String [] listaLexico =
    {
        "Error Lexico: Token '$' no reconocido. Lin: $ Col: $"
    };
    
    private final String [] listaSintactico =
    {
        "Error Sintactico: $. Lin: $ Col: $"
    };
    
    private final String [] listaSemantico =
    {
        "Error Semántico: Identificador '$' ya se encuentra declarado. Lin: $ Col: $",
        "Error Semántico: No se puede inicializar matrices/vectores con tamaño 0. Lin: $ Col $",
        "Error Semántico: Datos introducidos en la matriz/vector $ distintos. Lin: $ Col $",
        "Error Semántico: La matriz/vector '$' no debe poseer 1 fila. Lin: $ Col: $",
        "Error Semántico: Solo se permite matrices/vectores unidimensionales o bidimensionales. Lin: $ Col: $",        
        "Error Semántico: No hay un prototipo declarado para la función '$'. Lin: $ Col: $",
        "Error Semántico: Tipo de dato de retorno de la función '$' no coincide con su prototipo. Lin $ Col: $",
        "Error Semántico: Número de argumentos de la función '$' no coincide con su prototipo. Lin: $ Col: $",
        "Error Semántico: Argumento $ de la función '$' debe ser una matriz/vector. Lin: $ Col:$",
        "Error Semántico: Argumento $ de la función '$' no coincide con el prototipo. Lin: $ Col: $",
        "Error Semántico: Argumento $ de la función '$' no debe ser una matriz/vector. Lin: $ Col: $",
        "Error Semántico: Tipo de dato asignado a la variable '$' no es compatible. Lin: $ Col: $",
        "Error Semántico: La función '$' no existe. Lin: $ Col: $",
        "Error Semántico: Índice $ de la matriz/vector '$' no es entero. Lin: $ Col: $",
        "Error Semántico: El identificador '$' no es una matriz/vector. Lin: $ Col: $",
        "Error Semántico: Elemento $ de la matriz/vector no es correcto. Lin: $ Col: $",
        "Error Semántico: Identificador '$' no declarado. Lin: $ Col: $",
        "Error Semántico: La función '$' no está definida. Lin: $ Col: $",
        "Error Semántico: Variable '$' no puede ser asginado a una constante. Lin: $ Col: $"
    };
    
    private final String[] listaWarnings =
    {
        "Warning Semántico: Número de elementos introducidos a la matriz/vector '$' incorrecto. Lin: $ Col: $",
        "Warning Semántico: Número de filas de la matriz/vector '$' no coincide con las inicializadas. Lin: $ Col: $",
        "Warning Semántico: Número de columnas de la fila $ de la matriz/vector '$' incorrecto. Lin: $ Col: $"
    };
    
    public Mistake()
    {
        errorLexico     = new ArrayList <>();
        errorSintactico = new ArrayList <>();
        errorSemantico  = new ArrayList <>();
        warnings        = new ArrayList <>();
    }
    
    public void insertarError(int tipo, int codigo, String[] datos)
    {
        switch(tipo)
        {
            case 0:
                errorLexico.add(unir(listaLexico[codigo], datos));
            break;
                
            case 1:
                errorSintactico.add(unir(listaSintactico[codigo], datos));
            break;
            
            case 2:
                errorSemantico.add(unir(listaSemantico[codigo], datos));
            break;
        }
    }
    
    public void insertarWarning(int codigo, String[] datos)
    {
        warnings.add(unir(listaWarnings[codigo], datos));
    }
    
    public String unir(String error, String[] datos)
    {
        int index = -1;
        
        for (String dato : datos) 
        {
            index = error.indexOf("$", index + 1);
            error = error.substring(0, index) + dato + error.substring(index+1);
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
        return (new ArrayList <>());
    }    
}
