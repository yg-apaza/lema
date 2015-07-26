package lema;

public class accion
{
    public static final int programa = 0;               // Usado
    
    public static final int cabecera = 1;               // Usado
    public static final int programaPrincipal = 2;      // Usado
    public static final int defFuncion = 3;             //Usado
    
    public static final int bloque = 4;                 // Usado
    
    public static final int declaracionConsSim = 5;     // Usado
    public static final int declaracionConsVec = 6;     // Usado
    public static final int declaracionConsMat = 7; 	// Usado
    
    public static final int declaracionProt = 8;        // Usado
    public static final int parametroProt = 9;          // Usado     
    public static final int parametroProtVec = 10;      // Usado
    public static final int parametroProtMat = 11;	// Usado
    
    public static final int declaracionVar = 12;        // Usado
	
    public static final int declaracionSim = 13;        // Usado
    public static final int declaracionVec = 14;        // Usado
    public static final int declaracionMat = 15;        // Usado
    
    public static final int declaracionSimIni = 16;     // Usado
    public static final int declaracionVecIni = 17;     // Usado
    public static final int declaracionMatIni = 18;     // Usado
	
	public static final int accesoVec = 19;         // Usado
    public static final int accesoMat = 20;             // Usado
      
    public static final int asignacion = 21;            // Usado
	
    public static final int hacerMientras = 22;         // Usado
    public static final int mientras = 23;              // Usado
    public static final int para = 24;                  // Usado
    public static final int si = 25;                    // Usado
    public static final int selector = 26;              // Usado
    public static final int llamadaFuncion = 27;        // Usado
    public static final int escritura = 28;             // Usado
    public static final int lectura = 29;               // Usado
    public static final int retornar = 30;              // Usado
    
    public static final int suma = 31;                  // Usado
    public static final int resta = 32;                 // Usado
    public static final int producto = 33;              // Usado
    public static final int division = 34;              // Usado    
    public static final int modulo = 35;                // Usado
    
    public static final int mayor = 36;                 // Usado
    public static final int mayor_igual = 37;           // Usado
    public static final int menor = 38;                 // Usado
    public static final int menor_igual = 39;           // Usado
    
    public static final int disyuncion = 40;		// Usado
    public static final int conjuncion = 41;		// Usado
    public static final int identico = 42;              // Usado
    public static final int diferente = 43;             // Usado   
    public static final int negacion = 44;              // Usado
	
    public static final int inversa = 45;               // Usado
    public static final int transpuesta = 46;           // Usado
    
    public static final int negatividad = 47;           // Usado
    public static final int positividad = 48;           // Usado
    
    public static final int operacionCond = 49;         // Usado
    
    public static final int argumento = 50;             // Usado 
    public static final int elemVec = 51;               // Usado
    public static final int elemMat = 52;               // Usado
    
    public static final int funcion = 53;               // Usado
    public static final int parametroFun = 54;          // Usado
    public static final int parametroFunSim = 55;       // Usado
    public static final int parametroFunVec = 56;       // Usado
    public static final int parametroFunMat = 57;       // Usado   
	
    public static final int casos = 58;                 // Usado
    public static final int caso = 59;                  // Usado
    public static final int pordefecto = 60;            // Usado
	public static final int saltar = 61;            // Usado
    
    public static final String[] acciones = new String[]
    {
        "PROGRAMA",    
        "CABECERA",
        "PROGRAMA PRINCIPAL",
        "DEFINICION FUNCIONES",
        "BLOQUE",
        "DECLARACION CONSTANTE SIMPLE",
        "DECLARACION CONSTANTE VECTOR",
        "DECLARACION CONSTANTE MATRIZ",		
        "DECLARACION PROTOTIPOS",
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
        "ELEMENTOS VECTOR",
        "ELEMENTOS MATRIZ",
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

