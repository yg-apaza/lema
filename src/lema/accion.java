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
    public static final int parametroProt = 7;
    
    public static final int tipoNumero = 8;
    public static final int tipoVector = 9;
    public static final int tipoMatriz = 10;
    
    public static final int declaracionSim = 11;
    public static final int declaracionVec = 12;
    public static final int declaracionMat = 13;
    
    public static final int declaracionSimIni = 14;
    public static final int declaracionVecIni = 15;
    public static final int declaracionMatIni = 16;
    
    public static final int asignacionSim = 17;
    public static final int asignacionVec = 18;
    public static final int asignacionMat = 19;
    
    public static final int hacerMientras = 19;
    public static final int mientras = 20;
    public static final int para = 21;
    public static final int si = 22;
    public static final int selector = 23;
    public static final int llamadaFuncion = 24;
    public static final int escritura = 25;
    public static final int lectura = 26;
    public static final int actualizacion = 27;
    public static final int retornar = 28;
    
    public static final int suma = 29;
    public static final int resta = 30;
    public static final int producto = 31;
    public static final int division = 32;
    
    public static final int modulo = 33;
    
    public static final int mayor = 34;
    public static final int mayor_igual = 35;
    public static final int menor = 36;
    public static final int menor_igual = 37;
    
    public static final int disyuncion = 38; /* O */
    public static final int conjuncion = 39; /* Y */
    public static final int identico = 40;
    public static final int diferente = 41;
    
    public static final int inversa = 42;
    public static final int transpuesta = 43;
    
    public static final int negatividad = 44;
    public static final int positividad = 45;
    
    public static final int operacionCond = 46;
    
    public static final int argumento = 47;
    
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
        "ARGUMENTO"
    };
}
