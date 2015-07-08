package lema;

public class accion
{
    public static final int programa = 0;
    
    public static final int cabecera = 1;
    public static final int programaPrincipal = 2;
    public static final int defFuncion = 3;
    
    public static final int bloque = 4;
    
    public static final int declaracionCons = 5;
    
    public static final int declaracionProt = 6;
    public static final int parametroPro = 7;
    public static final int parametroProDes = 8;
    
    public static final int tipoNumero = 9;
    public static final int tipoVector = 10;
    public static final int tipoMatriz = 11;
    
    public static final int declaracionSim = 12;
    public static final int declaracionVec = 13;
    public static final int declaracionMat = 14;
    
    public static final int declaracionSimIni = 15;
    public static final int declaracionVecIni = 16;
    public static final int declaracionMatIni = 17;
      
    public static final int asignacionSim = 18;
    public static final int asignacionVec = 19;
    public static final int asignacionMat = 20;
    
    public static final int hacerMientras = 21;
    public static final int mientras = 22;
    public static final int para = 23;
    public static final int si = 24;
    public static final int selector = 25;
    public static final int llamadaFuncion = 26;
    public static final int escritura = 27;
    public static final int lectura = 28;
    public static final int actualizacion = 29;
    public static final int retornar = 30;
    
    public static final int suma = 31;
    public static final int resta = 32;
    public static final int producto = 33;
    public static final int division = 34;
    
    public static final int modulo = 35;
    
    public static final int mayor = 36;
    public static final int mayor_igual = 37;
    public static final int menor = 38;
    public static final int menor_igual = 39;
    
    public static final int disyuncion = 40; /* O */
    public static final int conjuncion = 41; /* Y */
    public static final int identico = 42;
    public static final int diferente = 43;
    
    public static final int inversa = 44;
    public static final int transpuesta = 45;
    
    public static final int negatividad = 46;
    public static final int positividad = 47;
    
    public static final int operacionCond = 48;
    
    public static final int argumento = 49;
    public static final int fila = 50;
    public static final int columna = 51;
    
    public static final int funcion = 52;
    public static final int parametroFun = 53;
    public static final int parametroFunDes = 54;
    public static final int declaracion = 55;
    public static final int casos = 56;
    public static final int caso = 57;
    public static final int pordefecto = 58;
    public static final int declaracionVar = 59;
    
    public static final String[] acciones = new String[]
    {
        "PROGRAMA",    
        "CABECERA",
        "PROGRAMA PRINCIPAL",
        "DEFINICION FUNCIONES",
        "BLOQUE",
        "DECLARACION CONSTANTES",
        "DECLARACION PROTOTIPOS",
        "PARAMETRO PROTOTIPO",
        "DESCRIPCION PARAMETRO PROTOTIPO",
        "TIPO NUMERO",
        "TIPO VECTOR",
        "TIPO MATRIZ",
        "DECLARACION SIMPLE SIN INI",
        "DECLARACION VECTOR SIN INI",
        "DECLARACION MATRIZ SIN INI",
        "DECLARACION SIMPLE CON INI",
        "DECLARACION VECTOR CON INI",
        "DECLARACION MATRIZ CON INI",
        "ASIGNACION SIMPLE",
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
        "INVERSA",
        "TRANSPUESTA",
        "NEGATIVIDAD",
        "POSITIVIDAD",
        "OPERACION CONDICIONAL",
        "ARGUMENTO",
        "FILA",
        "COLUMNA",
        "FUNCION",
        "PARAMETRO FUNCION",
        "DESCRIPCION PARAMETRO FUNCION",
        "DECLARACION",        
        "CASOS",
        "CASO",
        "POR DEFECTO",
        "DECLARACIONES DE VARIABLES"
    };
}

