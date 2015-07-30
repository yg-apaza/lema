package lema.analizadorSemantico;

public class accion
{
    public static final int programa = 0;               // Usado
    
    public static final int cabecera = 1;               // Usado
    public static final int programaPrincipal = 2;      // Usado
    public static final int defFuncion = 3;             // Usado
    
    public static final int bloque = 4;                 // Usado
    public static final int finBloque = 5;		// Usado
    
    public static final int declaracionConsSim = 6;     // Usado
    public static final int declaracionConsMat = 7; 	// Usado
    
    public static final int declaracionProt = 8;        // Usado
    public static final int parametroProt = 9;         	// Usado     
    public static final int parametroProtMat = 10;      // Usado
    
    public static final int declaracionVar = 11;        // Usado
	
    public static final int declaracionSim = 12;        // Usado
    public static final int declaracionMat = 13;        // Usado
    
    public static final int declaracionSimIni = 14;     // Usado
    public static final int declaracionMatIni = 15;     // Usado
    
    public static final int accesoMat = 16;             // Usado
      
    public static final int asignacion = 17;            // Usado
	
    public static final int hacerMientras = 18;         // Usado
    public static final int mientras = 19;              // Usado
    public static final int para = 20;                  // Usado
    public static final int si = 21;                    // Usado
    public static final int selector = 22;              // Usado
    public static final int llamadaFuncion = 23;        // Usado
    public static final int escritura = 24;             // Usado
    public static final int lectura = 25;               // Usado
    public static final int retornar = 26;              // Usado
    
    public static final int suma = 27;                  // Usado
    public static final int resta = 28;                 // Usado
    public static final int producto = 29;              // Usado
    public static final int division = 30;              // Usado    
    public static final int modulo = 31;                // Usado
    
    public static final int mayor = 32;                 // Usado
    public static final int mayor_igual = 33;           // Usado
    public static final int menor = 34;                 // Usado
    public static final int menor_igual = 35;           // Usado
    
    public static final int disyuncion = 36;            // Usado
    public static final int conjuncion = 37;            // Usado
    public static final int identico = 38;              // Usado
    public static final int diferente = 39;             // Usado   
    public static final int negacion = 40;              // Usado
	
    public static final int inversa = 41;               // Usado
    public static final int transpuesta = 42;           // Usado
    
    public static final int negatividad = 43;           // Usado
    public static final int positividad = 44;           // Usado
    
    public static final int operacionCond = 45;         // Usado
    
    public static final int argumento = 46;             // Usado     
    public static final int elemMat = 47;               // Usado
    
    public static final int funcion = 48;               // Usado
    public static final int parametroFun = 49;          // Usado
    public static final int parametroFunSim = 50;       // Usado
    public static final int parametroFunMat = 51;       // Usado   
	
    public static final int casos = 52;                 // Usado
    public static final int caso = 53;                  // Usado
    public static final int pordefecto = 54;            // Usado
    public static final int saltar = 55;                // Usado
    public static final int finFuncion = 56;            // Usado
    
    public static final String[] acciones = new String[]
    {
        "PROGRAMA",    
        "CABECERA",
        "PROGRAMA PRINCIPAL",
        "DEFINICION FUNCIONES",
        "BLOQUE",
        "FIN DE BLOQUE",
        "DECLARACION CONSTANTE SIMPLE",
        "DECLARACION CONSTANTE MATRIZ",		
        "DECLARACION PROTOTIPO",
        "PARAMETRO PROTOTIPO",
        "PARAMETRO PROTOTIPO MATRIZ",		
        "DECLARACIONES DE VARIABLES",
        "DECLARACION SIMPLE SIN INI",
        "DECLARACION MATRIZ SIN INI",
        "DECLARACION SIMPLE CON INI",
        "DECLARACION MATRIZ CON INI",
        "ACCESO A MATRIZ",		
        "ASIGNACION",
        "HACER MIENTRAS",
        "MIENTRAS",
        "PARA",
        "SI",
        "SELECTOR",
        "LLAMADA FUNCION",
        "ESCRITURA",
        "LECTURA",
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
        "ELEMENTOS",
        "FUNCION",
        "PARAMETRO FUNCION",
        "PARAMETRO FUNCION SIMPLE",
        "PARAMETRO FUNCION MATRIZ",
        "CASOS",
        "CASO",
        "POR DEFECTO",
        "SALTAR",
        "FIN DE FUNCION"
    };
}