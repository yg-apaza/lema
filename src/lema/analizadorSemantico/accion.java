package lema.analizadorSemantico;

public class accion
{
    public static final int programa = 0;               // Usado
    
    public static final int cabecera = 1;               // Usado
    public static final int programaPrincipal = 2;      // Usado
    public static final int defFuncion = 3;             //Usado
    
    public static final int bloque = 4;                 // Usado
    public static final int finBloque = 5;		// Usado
    
    public static final int declaracionConsSim = 6;     // Usado
    public static final int declaracionConsVec = 7;     // Usado
    public static final int declaracionConsMat = 8; 	// Usado
    
    public static final int declaracionProt = 9;        // Usado
    public static final int parametroProt = 10;         // Usado     
    public static final int parametroProtVec = 11;      // Usado
    public static final int parametroProtMat = 12;	// Usado
    
    public static final int declaracionVar = 13;        // Usado
	
    public static final int declaracionSim = 14;        // Usado
    public static final int declaracionVec = 15;        // Usado
    public static final int declaracionMat = 16;        // Usado
    
    public static final int declaracionSimIni = 17;     // Usado
    public static final int declaracionVecIni = 18;     // Usado
    public static final int declaracionMatIni = 19;     // Usado
    
    public static final int accesoVec = 20;             // Usado
    public static final int accesoMat = 21;             // Usado
      
    public static final int asignacion = 22;            // Usado
	
    public static final int hacerMientras = 23;         // Usado
    public static final int mientras = 24;              // Usado
    public static final int para = 25;                  // Usado
    public static final int si = 26;                    // Usado
    public static final int selector = 27;              // Usado
    public static final int llamadaFuncion = 28;        // Usado
    public static final int escritura = 29;             // Usado
    public static final int lectura = 30;               // Usado
    public static final int retornar = 31;              // Usado
    
    public static final int suma = 32;                  // Usado
    public static final int resta = 33;                 // Usado
    public static final int producto = 34;              // Usado
    public static final int division = 35;              // Usado    
    public static final int modulo = 36;                // Usado
    
    public static final int mayor = 37;                 // Usado
    public static final int mayor_igual = 38;           // Usado
    public static final int menor = 39;                 // Usado
    public static final int menor_igual = 40;           // Usado
    
    public static final int disyuncion = 41;		// Usado
    public static final int conjuncion = 42;		// Usado
    public static final int identico = 43;              // Usado
    public static final int diferente = 44;             // Usado   
    public static final int negacion = 45;              // Usado
	
    public static final int inversa = 46;               // Usado
    public static final int transpuesta = 47;           // Usado
    
    public static final int negatividad = 48;           // Usado
    public static final int positividad = 49;           // Usado
    
    public static final int operacionCond = 50;         // Usado
    
    public static final int argumento = 51;             // Usado     
    public static final int elemMat = 52;               // Usado
    
    public static final int funcion = 53;               // Usado
    public static final int parametroFun = 54;          // Usado
    public static final int parametroFunSim = 55;       // Usado
    public static final int parametroFunVec = 56;       // Usado
    public static final int parametroFunMat = 57;       // Usado   
	
    public static final int casos = 58;                 // Usado
    public static final int caso = 59;                  // Usado
    public static final int pordefecto = 60;            // Usado
    public static final int saltar = 61;                // Usado
    
    public static final String[] acciones = new String[]
    {
        "PROGRAMA",    
        "CABECERA",
        "PROGRAMA PRINCIPAL",
        "DEFINICION FUNCIONES",
        "BLOQUE",
        "FIN DE BLOQUE",
        "DECLARACION CONSTANTE SIMPLE",
        "DECLARACION CONSTANTE VECTOR",
        "DECLARACION CONSTANTE MATRIZ",		
        "DECLARACION PROTOTIPO",
        "PARAMETRO PROTOTIPO",
        "PARAMETRO PROTOTIPO VECTOR",
        "PARAMETRO PROTOTIPO MATRIZ",		
        "DECLARACIONES DE VARIABLES",
        "DECLARACION SIMPLE SIN INI",
        "DECLARACION VECTOR SIN INI",
        "DECLARACION MATRIZ SIN INI",
        "DECLARACION SIMPLE CON INI",
        "DECLARACION VECTOR CON INI",
        "DECLARACION MATRIZ CON INI",
        "ACCESO A VECTOR",
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
        "PARAMETRO FUNCION VECTOR",
        "PARAMETRO FUNCION MATRIZ",
        "CASOS",
        "CASO",
        "POR DEFECTO",
        "SALTAR"        
    };
}