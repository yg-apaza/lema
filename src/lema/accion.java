package lema;

public class accion
{
    public static final int programa = 0;               // Usado
    
    public static final int cabecera = 1;               // Usado
    public static final int programaPrincipal = 2;      // Usado
    public static final int defFuncion = 3;             
    
    public static final int bloque = 4;                 // Usado
    
    public static final int declaracionConsSim = 5;     // Usado
    public static final int declaracionConsVec = 63;    // Usado
    public static final int declaracionConsMat = 64;    // Usado
    
    public static final int declaracionProt = 6;        // Usado
    public static final int parametroProt = 7;          // Usado     
    public static final int parametroVec = 8;           // Usado
    public static final int parametroMat = 65;          // Usado
    
    public static final int tipoNumero = 9;
    public static final int tipoVector = 10;
    public static final int tipoMatriz = 11;
    
    public static final int declaracionSim = 12;        // Usado
    public static final int declaracionVec = 13;        // Usado
    public static final int declaracionMat = 14;        // Usado
    
    public static final int declaracionSimIni = 15;     // Usado
    public static final int declaracionVecIni = 16;     // Usado
    public static final int declaracionMatIni = 17;     // Usado
      
    public static final int asignacion = 18;            // Usado
    public static final int asignacionVec = 19;
    public static final int asignacionMat = 20;
    
    public static final int hacerMientras = 21;
    public static final int mientras = 22;
    public static final int para = 23;
    public static final int si = 24;
    public static final int selector = 25;
    public static final int llamadaFuncion = 26;        // Usado
    public static final int escritura = 27;
    public static final int lectura = 28;
    public static final int actualizacion = 29;
    public static final int retornar = 30;
    
    public static final int suma = 31;                  // Usado
    public static final int resta = 32;                 // Usado
    public static final int producto = 33;              // Usado
    public static final int division = 34;              // Usado
    
    public static final int modulo = 35;                // Usado
    
    public static final int mayor = 36;                 // Usado
    public static final int mayor_igual = 37;           // Usado
    public static final int menor = 38;                 // Usado
    public static final int menor_igual = 39;           // Usado
    
    public static final int disyuncion = 40; /* O */    // Usado
    public static final int conjuncion = 41; /* Y */    // Usado
    public static final int identico = 42;              // Usado
    public static final int diferente = 43;             // Usado
    
    public static final int negacion = 44;              // Usado
    public static final int inversa = 45;               // Usado
    public static final int transpuesta = 46;           // Usado
    
    public static final int negatividad = 47;           // Usado
    public static final int positividad = 48;           // Usado
    
    public static final int operacionCond = 49;         // Usado
    
    public static final int argumento = 50;              // Usado    Parametro de llamada a funcion
    public static final int elemVec = 51;               // Usado
    public static final int elemMat = 52;               // Usado
    
    public static final int funcion = 53;
    public static final int parametroFun = 54;         
    public static final int parametroFunDes = 55;
    public static final int declaracion = 56;
    public static final int casos = 57;
    public static final int caso = 58;
    public static final int pordefecto = 59;
    public static final int declaracionVar = 60;        // Usado
    public static final int accesoMat = 61;             // Usado
    public static final int accesoVec = 62;             // Usado
    
    public static final String[] acciones = new String[]
    {
        "PROGRAMA",    
        "CABECERA",
        "PROGRAMA PRINCIPAL",
        "DEFINICION FUNCIONES",
        "BLOQUE",
        "DECLARACION CONSTANTE SIMPLE",
        "DECLARACION PROTOTIPOS",
        "PARAMETRO PROTOTIPO",
        "PARAMETRO PROTOTIPO VECTOR",
        "TIPO NUMERO",
        "TIPO VECTOR",
        "TIPO MATRIZ",
        "DECLARACION SIMPLE SIN INI",
        "DECLARACION VECTOR SIN INI",
        "DECLARACION MATRIZ SIN INI",
        "DECLARACION SIMPLE CON INI",
        "DECLARACION VECTOR CON INI",
        "DECLARACION MATRIZ CON INI",
        "ASIGNACION",
        "ASIGNACION VECTOR",
        "ASIGNACION MATRIZ",
        "HACER MIENTRAS",
        "MIENTRAS",
        "PARA",
        "SI",
        "SELECTOR",
        "LLAMADA FUNCION",
        "ESCRITURA",
        "LECTURA",
        "ACTUALIZACION",
        "RETORNAR",
        "SUMA",
        "RESTA",
        "PRODUCTO",
        "DIVISION",
        "MODULO",
        "MAYOR",
        "MAYOR IGUAL",
        "MENOR",
        "MENOR IGUAL",
        "DISYUNCION",
        "CONJUNCION",
        "IDENTICO",
        "DIFERENTE",
        "NEGACION",
        "INVERSA",
        "TRANSPUESTA",
        "NEGATIVIDAD",
        "POSITIVIDAD",
        "OPERACION CONDICIONAL",
        "ARGUMENTO",
        "ELEMENTOS VECTOR",
        "ELEMENTOS MATRIZ",
        "FUNCION",
        "PARAMETRO FUNCION",
        "DESCRIPCION PARAMETRO FUNCION",
        "DECLARACION",        
        "CASOS",
        "CASO",
        "POR DEFECTO",
        "DECLARACIONES DE VARIABLES",
        "ACCESO A MATRIZ",
        "ACCESO A VECTOR",
        "DECLARACION CONSTANTE VECTOR",
        "DECLARACION CONSTANTE MATRIZ",
        "PARAMETRO PROTOTIPO MATRIZ"
    };
}

