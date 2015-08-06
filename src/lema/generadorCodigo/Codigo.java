package lema.generadorCodigo;

public class Codigo
{
    public static final int asignacionC = 60;
    public static final int asignacionGlobalC = 61;
    public static final int idC = 62;
    public static final int idMC = 63;
    public static final int asignacionMC = 64;
    public static final int idEntMostrar = 65;
    public static final int idRealMostrar = 66;
    public static final int asignacionMostrarSim = 67;
    public static final int idEntMMostrar = 68;
    public static final int idRealMMostrar = 69;
    public static final int asignacionMostrarM = 70;
    
    public static final String codigosC[] = 
    {
        "ASIGNACION_C",
        "ASIGNACION_GLOBAL_C",
        "ID_C",
        "ID_MATRIZ_C",
        "ASIGNACION_MATRIZ_C",
        "ID_ENTERO_MOSTRAR",
        "ID_REAL_MOSTRAR",
        "ASIGNACION_MOSTRAR_SIMPLE",
        "ID_ENTERO_M_MOSTRAR",
        "ID_REAL_M_MOSTRAR"
    };
            
    public static String getNombre(int cod)
    {
        return codigosC[cod - 60];
    }
}
