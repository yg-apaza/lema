package lema.generadorCodigo;

public class Codigo
{
    public static final int asignacionC = 60;
    public static final int asignacionGlobalC = 61;
    
    public static final String codigosC[] = 
    {
        "ASIGNACION_C",
        "ASIGNACION_GLOBAL_C"
    };
            
    public static String getNombre(int cod)
    {
        return codigosC[cod - 60];
    }
}
