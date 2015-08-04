package lema.analizadorSemantico;

public class accion
{
    /** Valor asignado para denotar al Nodo 'PROGRAMA' */ 
    public static final int programa = 0;
    
    /** Valor asignado para denotar al Nodo 'CABECERA' */
    public static final int cabecera = 1;
    
    /** Valor asignado para denotar al Nodo 'PROGRAMA PRINCIPAL' */
    public static final int programaPrincipal = 2;
    
    /** Valor asignado para denotar al Nodo 'DEFINICIÓN FUNCIONES' */
    public static final int defFuncion = 3;
    
    /** Valor asignado para denotar al Nodo 'BLOQUE' */
    public static final int bloque = 4;                
    
    /** Valor asignado para denotar al Nodo 'FIN DE BLOQUE' */
    public static final int finBloque = 5;
    
    /** Valor asignado para denotar al Nodo 'DECLARACION CONSTANTE SIMPLE' */
    public static final int declaracionConsSim = 6;
    
    /** Valor asignado para denotar al Nodo 'DECLARACION CONSTANTE MATRIZ' */
    public static final int declaracionConsMat = 7;
    
    /** Valor asignado para denotar al Nodo 'DECLARACION PROTOTIPO' */
    public static final int declaracionProt = 8; 
    
    /** Valor asignado para denotar al Nodo 'PARAMETRO PROTOTIPO' */
    public static final int parametroProt = 9;
    
    /** Valor asignado para denotar al Nodo 'PARAMETRO PROTOTIPO MATRIZ' */
    public static final int parametroProtMat = 10;
    
    /** Valor asignado para denotar al Nodo 'DECLARACIONES DE VARIABLES' */
    public static final int declaracionVar = 11; 
    
    /** Valor asignado para denotar al Nodo 'DECLARACION SIMPLE SIN INI' */
    public static final int declaracionSim = 12;
    
    /** Valor asignado para denotar al Nodo 'DECLARACION MATRIZ SIN INI' */
    public static final int declaracionMat = 13;
    
    /** Valor asignado para denotar al Nodo 'DECLARACION SIMPLE CON INI' */
    public static final int declaracionSimIni = 14;
    
    /** Valor asignado para denotar al Nodo 'DECLARACION MATRIZ CON INI' */
    public static final int declaracionMatIni = 15;
    
    /** Valor asignado para denotar al Nodo 'ACCESO A MATRIZ' */
    public static final int accesoMat = 16;
    
    /** Valor asignado para denotar al Nodo 'ASIGNACION' */
    public static final int asignacion = 17;
    
    /** Valor asignado para denotar al Nodo 'HACER MIENTRAS' */
    public static final int hacerMientras = 18;
    
    /** Valor asignado para denotar al Nodo 'MIENTRAS' */
    public static final int mientras = 19;
    
    /** Valor asignado para denotar al Nodo 'PARA' */
    public static final int para = 20; 
	
    /** Valor asignado para denotar al Nodo 'FIN DE SENTENCIA PARA' */
    public static final int finPara = 21;
    
    /** Valor asignado para denotar al Nodo 'SI' */
    public static final int si = 22;
    
    /** Valor asignado para denotar al Nodo 'SELECTOR' */
    public static final int selector = 23;
    
    /** Valor asignado para denotar al Nodo 'LLAMADA FUNCION */
    public static final int llamadaFuncion = 24; 
    
    /** Valor asignado para denotar al Nodo 'ESCRITURA' */
    public static final int escritura = 25;
    
    /** Valor asignado para denotar al Nodo 'LECTURA' */
    public static final int lectura = 26;
    
    /** Valor asignado para denotar al Nodo 'RETORNAR' */
    public static final int retornar = 27;
    
    /** Valor asignado para denotar al Nodo 'SUMA' */
    public static final int suma = 28; 
    
    /** Valor asignado para denotar al Nodo 'RESTA' */
    public static final int resta = 29;
    
    /** Valor asignado para denotar al Nodo 'PRODUCTO' */
    public static final int producto = 30;
    
    /** Valor asignado para denotar al Nodo 'DIVISION' */
    public static final int division = 31; 
    
    /** Valor asignado para denotar al Nodo 'MODULO' */
    public static final int modulo = 32;
    
    /** Valor asignado para denotar al Nodo 'MAYOR' */
    public static final int mayor = 33;
    
    /** Valor asignado para denotar al Nodo 'MAYOR IGUAL' */
    public static final int mayor_igual = 34;
    
    /** Valor asignado para denotar al Nodo 'MENOR' */
    public static final int menor = 35;
    
    /** Valor asignado para denotar al Nodo 'MENOR IGUAL' */
    public static final int menor_igual = 36;
    
    /** Valor asignado para denotar al Nodo 'DISYUNCION' */
    public static final int disyuncion = 37;
    
    /** Valor asignado para denotar al Nodo 'CONJUNCION' */
    public static final int conjuncion = 38;
    
    /** Valor asignado para denotar al Nodo 'IDENTICO' */
    public static final int identico = 39; 
    
    /** Valor asignado para denotar al Nodo 'DIFERENTE' */
    public static final int diferente = 40;   
    
    /** Valor asignado para denotar al Nodo 'NEGACION' */
    public static final int negacion = 41;
    
    /** Valor asignado para denotar al Nodo 'INVERSA' */
    public static final int inversa = 42;
    
    /** Valor asignado para denotar al Nodo 'TRANSPUESTA' */
    public static final int transpuesta = 43;
    
    /** Valor asignado para denotar al Nodo 'NEGATIVIDAD' */
    public static final int negatividad = 44;
    
    /** Valor asignado para denotar al Nodo 'CONDICION' */
    public static final int condicion = 45;
	
    /** Valor asignado para denotar al Nodo 'OPERACION CONDICIONAL' */
    public static final int operacionCond = 46;
    
    /** Valor asignado para denotar al Nodo 'ARGUMENTO' */
    public static final int argumento = 47;               
    
    /** Valor asignado para denotar al Nodo 'ELEMENTO MATRIZ' */
    public static final int elemMat = 48;
    
    /** Valor asignado para denotar al Nodo 'ELEMENTO VECTOR' */
    public static final int elemVec = 49;
    
    /** Valor asignado para denotar al Nodo 'FUNCION' */
    public static final int funcion = 50;
    
    /** Valor asignado para denotar al Nodo 'PARAMETRO FUNCION' */
    public static final int parametroFun = 51;
    
    /** Valor asignado para denotar al Nodo 'PARAMETRO FUNCION SIMPLE' */
    public static final int parametroFunSim = 52;
    
    /** Valor asignado para denotar al Nodo 'PARAMETRO FUNCION MATRIZ' */
    public static final int parametroFunMat = 53;  
    
    /** Valor asignado para denotar al Nodo 'FIN DE FUNCION' */
    public static final int finFuncion = 54;   
	
    /** Valor asignado para denotar al Nodo 'CASOS' */
    public static final int casos = 55;
    
    /** Valor asignado para denotar al Nodo 'CASO' */
    public static final int caso = 56;
    
    /** Valor asignado para denotar al Nodo 'POR DEFECTO' */
    public static final int pordefecto = 57;
    
    /** Valor asignado para denotar al Nodo 'SALTAR' */
    public static final int saltar = 58;
       
    /** Arreglo asignado para almacenar todas las etiquetas que puede tener un Nodo */
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
        "FIN DE SENTENCIA PARA",
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
        "CONDICION",
        "OPERACION CONDICIONAL",
        "ARGUMENTO",
        "ELEMENTO MATRIZ",
        "ELEMENTO VECTOR",
        "FUNCION",
        "PARAMETRO FUNCION",
        "PARAMETRO FUNCION SIMPLE",
        "PARAMETRO FUNCION MATRIZ",
        "FIN DE FUNCION",
        "CASOS",
        "CASO",
        "POR DEFECTO",
        "SALTAR"
    };
}
