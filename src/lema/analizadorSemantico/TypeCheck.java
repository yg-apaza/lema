package lema.analizadorSemantico;

public class TypeCheck
{
    /** Matriz de compatibilidad para operaciones unarias
     * (negacion, inversa, transpuesta, negatividad)
     * (D1: Tipo Esperado, D2: Tipo Dado, D3: Operacion)
     */
    private static final boolean [][][] compatibilidad1 = 
        {
            // Entero
            {
                {true , false, false, true },
                {true , false, false, true },
                {true , false, false, false},
                {true , false, false, false},
                {false, false, false, false}
            },
            // Real
            {
                {true , false, false, true },
                {true , false, false, true },
                {true , false, false, false},
                {true , false, false, false},
                {false, false, false, false}
            },
            // Entero[]
            {
                {false, false, false, false},
                {false, false, false, false},
                {false, true , true , true },
                {false, true , true , true },
                {false, false, false, false}
            },
            // Real[]
            {
                {false, false, false, false},
                {false, false, false, false},
                {false, true ,  true,  true},
                {false, true ,  true,  true},
                {false, false, false, false}
            },
            // Cadena
            {
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false}
            }
        }
    ;
    
    /* Matriz de compatibilidad para operaciones binarias
     * (+, -, *, /, %, >, <, >=, <=, Y, O, ==, !=)
     * (D1: Tipo Esperado, D2: Tipo Dado 1, D3: Tipo Dado 2, D4: Operacion)
     */
    
    private static final boolean [][][][] compatibilidad2 =
        {
            // Entero
            {
                {
                    // Entero op Entero
                    {true , true , true , true , true , true , true , true , true , true , true , true , true },
                    // Entero op Real
                    {true , true , true , true , true , true , true , true , true , true , true , true , true },
                    // Entero op Entero[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Entero op Real[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Entero op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                },
                
                {
                    // Real op Entero
                    {true , true , true , true , true , true , true , true , true , true , true , true , true },
                    // Real op Real
                    {true , true , true , true , true , true , true , true , true , true , true , true , true },
                    // Real op Entero[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Real op Real[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Real op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                },
                
                {
                    // Entero[] op Entero
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Entero[] op Real
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Entero[] op Entero[]
                    {false, false, false, false, false, true , true , true , true , true , true , true , true },
                    // Entero[] op Real[]
                    {false, false, false, false, false, true , true , true , true , true , true , true , true },
                    // Entero[] op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                },
                
                {
                    // Real[] op Entero
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Real[] op Real
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Real[] op Entero[]
                    {false, false, false, false, false, true , true , true , true , true , true , true , true },
                    // Real[] op Real[]
                    {false, false, false, false, false, true , true , true , true , true , true , true , true },
                    // Real[] op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                },
                
                {
                    // Cadena op Entero
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Cadena op Real
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Cadena op Entero[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Cadena op Real[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Cadena op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                }
            },
            // Real
            {
                {
                    // Entero op Entero
                    {true , true , true , true , true , true , true , true , true , true , true , true , true },
                    // Entero op Real
                    {true , true , true , true , true , true , true , true , true , true , true , true , true },
                    // Entero op Entero[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Entero op Real[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Entero op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                },
                
                {
                    // Real op Entero
                    {true , true , true , true , true , true , true , true , true , true , true , true , true },
                    // Real op Real
                    {true , true , true , true , true , true , true , true , true , true , true , true , true },
                    // Real op Entero[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Real op Real[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Real op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                },
                
                {
                    // Entero[] op Entero
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Entero[] op Real
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Entero[] op Entero[]
                    {false, false, false, false, false, true , true , true , true , true , true , true , true },
                    // Entero[] op Real[]
                    {false, false, false, false, false, true , true , true , true , true , true , true , true },
                    // Entero[] op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                },
                
                {
                    // Real[] op Entero
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Real[] op Real
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Real[] op Entero[]
                    {false, false, false, false, false, true , true , true , true , true , true , true , true },
                    // Real[] op Real[]
                    {false, false, false, false, false, true , true , true , true , true , true , true , true },
                    // Real[] op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                },
                
                {
                    // Cadena op Entero
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Cadena op Real
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Cadena op Entero[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Cadena op Real[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Cadena op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                }
            },
            // Entero[]
            {
                {
                    // Entero op Entero
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Entero op Real
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Entero op Entero[]
                    {false, false, true , false, false, false, false, false, false, false, false, false, false},
                    // Entero op Real[]
                    {false, false, true , false, false, false, false, false, false, false, false, false, false},
                    // Entero op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                },
                
                {
                    // Real op Entero
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Real op Real
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Real op Entero[]
                    {false, false, true , false, false, false, false, false, false, false, false, false, false},
                    // Real op Real[]
                    {false, false, true , false, false, false, false, false, false, false, false, false, false},
                    // Real op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                },
                
                {
                    // Entero[] op Entero
                    {false, false, true , true , false, false, false, false, false, false, false, false, false},
                    // Entero[] op Real
                    {false, false, true , true , false, false, false, false, false, false, false, false, false},
                    // Entero[] op Entero[]
                    {true , true , true , false, false, false, false, false, false, false, false, false, false},
                    // Entero[] op Real[]
                    {true , true , true , false, false, false, false, false, false, false, false, false, false},
                    // Entero[] op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                },
                
                {
                    // Real[] op Entero
                    {false, false, true , true , false, false, false, false, false, false, false, false, false},
                    // Real[] op Real
                    {false, false, true , true , false, false, false, false, false, false, false, false, false},
                    // Real[] op Entero[]
                    {true , true , true , false, false, false, false, false, false, false, false, false, false},
                    // Real[] op Real[]
                    {true , true , true , false, false, false, false, false, false, false, false, false, false},
                    // Real[] op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                },
                
                {
                    // Cadena op Entero
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Cadena op Real
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Cadena op Entero[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Cadena op Real[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Cadena op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                }
            },
            // Real[]
            {
                {
                    // Entero op Entero
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Entero op Real
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Entero op Entero[]
                    {false, false, true , false, false, false, false, false, false, false, false, false, false},
                    // Entero op Real[]
                    {false, false, true , false, false, false, false, false, false, false, false, false, false},
                    // Entero op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                },
                
                {
                    // Real op Entero
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Real op Real
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Real op Entero[]
                    {false, false, true , false, false, false, false, false, false, false, false, false, false},
                    // Real op Real[]
                    {false, false, true , false, false, false, false, false, false, false, false, false, false},
                    // Real op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                },
                
                {
                    // Entero[] op Entero
                    {false, false, true , true , false, false, false, false, false, false, false, false, false},
                    // Entero[] op Real
                    {false, false, true , true , false, false, false, false, false, false, false, false, false},
                    // Entero[] op Entero[]
                    {true , true , true , false, false, false, false, false, false, false, false, false, false},
                    // Entero[] op Real[]
                    {true , true , true , false, false, false, false, false, false, false, false, false, false},
                    // Entero[] op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                },
                
                {
                    // Real[] op Entero
                    {false, false, true , true , false, false, false, false, false, false, false, false, false},
                    // Real[] op Real
                    {false, false, true , true , false, false, false, false, false, false, false, false, false},
                    // Real[] op Entero[]
                    {true , true , true , false, false, false, false, false, false, false, false, false, false},
                    // Real[] op Real[]
                    {true , true , true , false, false, false, false, false, false, false, false, false, false},
                    // Real[] op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                },
                
                {
                    // Cadena op Entero
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Cadena op Real
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Cadena op Entero[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Cadena op Real[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Cadena op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                }
            },
            // Cadena
            {
                {
                    // Entero op Entero
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Entero op Real
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Entero op Entero[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Entero op Real[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Entero op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                },
                
                {
                    // Real op Entero
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Real op Real
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Real op Entero[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Real op Real[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Real op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                },
                
                {
                    // Entero[] op Entero
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Entero[] op Real
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Entero[] op Entero[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Entero[] op Real[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Entero[] op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                },
                
                {
                    // Real[] op Entero
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Real[] op Real
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Real[] op Entero[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Real[] op Real[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Real[] op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                },
                
                {
                    // Cadena op Entero
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Cadena op Real
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Cadena op Entero[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Cadena op Real[]
                    {false, false, false, false, false, false, false, false, false, false, false, false, false},
                    // Cadena op Cadena
                    {false, false, false, false, false, false, false, false, false, false, false, false, false}
                }
            }
        }
    ;
    
    /* Matriz de compatibilidad para operaciones ternarias
     * (+, -, *, /, %, >, <, >=, <=, Y, O, ==, !=)
     * (D1: Tipo Esperado, D2: Tipo Dado 1, D3: Tipo Dado 2, D4: Tipo Dado 3)
     */
    private final static boolean [][][][] compatibilidad3 =
        {
            // Entero
            {
                {
                    // Entero op Entero op Entero
                    // Entero op Entero op Real
                    // Entero op Entero op Entero[]
                    // Entero op Entero op Real[]
                    // Entero op Entero op Cadena
                    {true , true , false, false, false},
                    // Entero op Real op Entero
                    // Entero op Real op Real
                    // Entero op Real op Entero[]
                    // Entero op Real op Real[]
                    // Entero op Real op Cadena
                    {true , true , false, false, false},
                    // Entero op Entero[] op Entero
                    // Entero op Entero[] op Real
                    // Entero op Entero[] op Entero[]
                    // Entero op Entero[] op Real[]
                    // Entero op Entero[] op Cadena
                    {false, false, false, false, false},
                    // Entero op Real[] op Entero
                    // Entero op Real[] op Real
                    // Entero op Real[] op Entero[]
                    // Entero op Real[] op Real[]
                    // Entero op Real[] op Cadena
                    {false, false, false, false, false},
                    // Entero op Cadena op Entero
                    // Entero op Cadena op Real
                    // Entero op Cadena op Entero[]
                    // Entero op Cadena op Real[]
                    // Entero op Cadena op Cadena
                    {false, false, false, false, false}
                },
                
                {
                    // Real op Entero op Entero
                    // Real op Entero op Real
                    // Real op Entero op Entero[]
                    // Real op Entero op Real[]
                    // Real op Entero op Cadena
                    {true , true , false, false, false},
                    // Real op Real op Entero
                    // Real op Real op Real
                    // Real op Real op Entero[]
                    // Real op Real op Real[]
                    // Real op Real op Cadena
                    {true , true , false, false, false},
                    // Real op Entero[] op Entero
                    // Real op Entero[] op Real
                    // Real op Entero[] op Entero[]
                    // Real op Entero[] op Real[]
                    // Real op Entero[] op Cadena
                    {false, false, false, false, false},
                    // Real op Real[] op Entero
                    // Real op Real[] op Real
                    // Real op Real[] op Entero[]
                    // Real op Real[] op Real[]
                    // Real op Real[] op Cadena
                    {false, false, false, false, false},
                    // Real op Cadena op Entero
                    // Real op Cadena op Real
                    // Real op Cadena op Entero[]
                    // Real op Cadena op Real[]
                    // Real op Cadena op Cadena
                    {false, false, false, false, false}
                },
                
                {
                    // Entero[] op Entero op Entero
                    // Entero[] op Entero op Real
                    // Entero[] op Entero op Entero[]
                    // Entero[] op Entero op Real[]
                    // Entero[] op Entero op Cadena
                    {false, false, false, false, false},
                    // Entero[] op Real op Entero
                    // Entero[] op Real op Real
                    // Entero[] op Real op Entero[]
                    // Entero[] op Real op Real[]
                    // Entero[] op Real op Cadena
                    {false, false, false, false, false},
                    // Entero[] op Entero[] op Entero
                    // Entero[] op Entero[] op Real
                    // Entero[] op Entero[] op Entero[]
                    // Entero[] op Entero[] op Real[]
                    // Entero[] op Entero[] op Cadena
                    {false, false, false, false, false},
                    // Entero[] op Real[] op Entero
                    // Entero[] op Real[] op Real
                    // Entero[] op Real[] op Entero[]
                    // Entero[] op Real[] op Real[]
                    // Entero[] op Real[] op Cadena
                    {false, false, false, false, false},
                    // Entero[] op Cadena op Entero
                    // Entero[] op Cadena op Real
                    // Entero[] op Cadena op Entero[]
                    // Entero[] op Cadena op Real[]
                    // Entero[] op Cadena op Cadena
                    {false, false, false, false, false}
                },
                
                {
                    // Real[] op Entero op Entero
                    // Real[] op Entero op Real
                    // Real[] op Entero op Entero[]
                    // Real[] op Entero op Real[]
                    // Real[] op Entero op Cadena
                    {false, false, false, false, false},
                    // Real[] op Real op Entero
                    // Real[] op Real op Real
                    // Real[] op Real op Entero[]
                    // Real[] op Real op Real[]
                    // Real[] op Real op Cadena
                    {false, false, false, false, false},
                    // Real[] op Entero[] op Entero
                    // Real[] op Entero[] op Real
                    // Real[] op Entero[] op Entero[]
                    // Real[] op Entero[] op Real[]
                    // Real[] op Entero[] op Cadena
                    {false, false, false, false, false},
                    // Real[] op Real[] op Entero
                    // Real[] op Real[] op Real
                    // Real[] op Real[] op Entero[]
                    // Real[] op Real[] op Real[]
                    // Real[] op Real[] op Cadena
                    {false, false, false, false, false},
                    // Real[] op Cadena op Entero
                    // Real[] op Cadena op Real
                    // Real[] op Cadena op Entero[]
                    // Real[] op Cadena op Real[]
                    // Real[] op Cadena op Cadena
                    {false, false, false, false, false}
                },
                
                {
                    // Cadena op Entero op Entero
                    // Cadena op Entero op Real
                    // Cadena op Entero op Entero[]
                    // Cadena op Entero op Real[]
                    // Cadena op Entero op Cadena
                    {false, false, false, false, false},
                    // Cadena op Real op Entero
                    // Cadena op Real op Real
                    // Cadena op Real op Entero[]
                    // Cadena op Real op Real[]
                    // Cadena op Real op Cadena
                    {false, false, false, false, false},
                    // Cadena op Entero[] op Entero
                    // Cadena op Entero[] op Real
                    // Cadena op Entero[] op Entero[]
                    // Cadena op Entero[] op Real[]
                    // Cadena op Entero[] op Cadena
                    {false, false, false, false, false},
                    // Cadena op Real[] op Entero
                    // Cadena op Real[] op Real
                    // Cadena op Real[] op Entero[]
                    // Cadena op Real[] op Real[]
                    // Cadena op Real[] op Cadena
                    {false, false, false, false, false},
                    // Cadena op Cadena op Entero
                    // Cadena op Cadena op Real
                    // Cadena op Cadena op Entero[]
                    // Cadena op Cadena op Real[]
                    // Cadena op Cadena op Cadena
                    {false, false, false, false, false}
                }
            },
            // Real
            {
                {
                    // Entero op Entero op Entero
                    // Entero op Entero op Real
                    // Entero op Entero op Entero[]
                    // Entero op Entero op Real[]
                    // Entero op Entero op Cadena
                    {true , true , false, false, false},
                    // Entero op Real op Entero
                    // Entero op Real op Real
                    // Entero op Real op Entero[]
                    // Entero op Real op Real[]
                    // Entero op Real op Cadena
                    {true , true , false, false, false},
                    // Entero op Entero[] op Entero
                    // Entero op Entero[] op Real
                    // Entero op Entero[] op Entero[]
                    // Entero op Entero[] op Real[]
                    // Entero op Entero[] op Cadena
                    {false, false, false, false, false},
                    // Entero op Real[] op Entero
                    // Entero op Real[] op Real
                    // Entero op Real[] op Entero[]
                    // Entero op Real[] op Real[]
                    // Entero op Real[] op Cadena
                    {false, false, false, false, false},
                    // Entero op Cadena op Entero
                    // Entero op Cadena op Real
                    // Entero op Cadena op Entero[]
                    // Entero op Cadena op Real[]
                    // Entero op Cadena op Cadena
                    {false, false, false, false, false}
                },
                
                {
                    // Real op Entero op Entero
                    // Real op Entero op Real
                    // Real op Entero op Entero[]
                    // Real op Entero op Real[]
                    // Real op Entero op Cadena
                    {true , true , false, false, false},
                    // Real op Real op Entero
                    // Real op Real op Real
                    // Real op Real op Entero[]
                    // Real op Real op Real[]
                    // Real op Real op Cadena
                    {true , true , false, false, false},
                    // Real op Entero[] op Entero
                    // Real op Entero[] op Real
                    // Real op Entero[] op Entero[]
                    // Real op Entero[] op Real[]
                    // Real op Entero[] op Cadena
                    {false, false, false, false, false},
                    // Real op Real[] op Entero
                    // Real op Real[] op Real
                    // Real op Real[] op Entero[]
                    // Real op Real[] op Real[]
                    // Real op Real[] op Cadena
                    {false, false, false, false, false},
                    // Real op Cadena op Entero
                    // Real op Cadena op Real
                    // Real op Cadena op Entero[]
                    // Real op Cadena op Real[]
                    // Real op Cadena op Cadena
                    {false, false, false, false, false}
                },
                
                {
                    // Entero[] op Entero op Entero
                    // Entero[] op Entero op Real
                    // Entero[] op Entero op Entero[]
                    // Entero[] op Entero op Real[]
                    // Entero[] op Entero op Cadena
                    {false, false, false, false, false},
                    // Entero[] op Real op Entero
                    // Entero[] op Real op Real
                    // Entero[] op Real op Entero[]
                    // Entero[] op Real op Real[]
                    // Entero[] op Real op Cadena
                    {false, false, false, false, false},
                    // Entero[] op Entero[] op Entero
                    // Entero[] op Entero[] op Real
                    // Entero[] op Entero[] op Entero[]
                    // Entero[] op Entero[] op Real[]
                    // Entero[] op Entero[] op Cadena
                    {false, false, false, false, false},
                    // Entero[] op Real[] op Entero
                    // Entero[] op Real[] op Real
                    // Entero[] op Real[] op Entero[]
                    // Entero[] op Real[] op Real[]
                    // Entero[] op Real[] op Cadena
                    {false, false, false, false, false},
                    // Entero[] op Cadena op Entero
                    // Entero[] op Cadena op Real
                    // Entero[] op Cadena op Entero[]
                    // Entero[] op Cadena op Real[]
                    // Entero[] op Cadena op Cadena
                    {false, false, false, false, false}
                },
                
                {
                    // Real[] op Entero op Entero
                    // Real[] op Entero op Real
                    // Real[] op Entero op Entero[]
                    // Real[] op Entero op Real[]
                    // Real[] op Entero op Cadena
                    {false, false, false, false, false},
                    // Real[] op Real op Entero
                    // Real[] op Real op Real
                    // Real[] op Real op Entero[]
                    // Real[] op Real op Real[]
                    // Real[] op Real op Cadena
                    {false, false, false, false, false},
                    // Real[] op Entero[] op Entero
                    // Real[] op Entero[] op Real
                    // Real[] op Entero[] op Entero[]
                    // Real[] op Entero[] op Real[]
                    // Real[] op Entero[] op Cadena
                    {false, false, false, false, false},
                    // Real[] op Real[] op Entero
                    // Real[] op Real[] op Real
                    // Real[] op Real[] op Entero[]
                    // Real[] op Real[] op Real[]
                    // Real[] op Real[] op Cadena
                    {false, false, false, false, false},
                    // Real[] op Cadena op Entero
                    // Real[] op Cadena op Real
                    // Real[] op Cadena op Entero[]
                    // Real[] op Cadena op Real[]
                    // Real[] op Cadena op Cadena
                    {false, false, false, false, false}
                },
                
                {
                    // Cadena op Entero op Entero
                    // Cadena op Entero op Real
                    // Cadena op Entero op Entero[]
                    // Cadena op Entero op Real[]
                    // Cadena op Entero op Cadena
                    {false, false, false, false, false},
                    // Cadena op Real op Entero
                    // Cadena op Real op Real
                    // Cadena op Real op Entero[]
                    // Cadena op Real op Real[]
                    // Cadena op Real op Cadena
                    {false, false, false, false, false},
                    // Cadena op Entero[] op Entero
                    // Cadena op Entero[] op Real
                    // Cadena op Entero[] op Entero[]
                    // Cadena op Entero[] op Real[]
                    // Cadena op Entero[] op Cadena
                    {false, false, false, false, false},
                    // Cadena op Real[] op Entero
                    // Cadena op Real[] op Real
                    // Cadena op Real[] op Entero[]
                    // Cadena op Real[] op Real[]
                    // Cadena op Real[] op Cadena
                    {false, false, false, false, false},
                    // Cadena op Cadena op Entero
                    // Cadena op Cadena op Real
                    // Cadena op Cadena op Entero[]
                    // Cadena op Cadena op Real[]
                    // Cadena op Cadena op Cadena
                    {false, false, false, false, false}
                }
            },
            // Entero[]
            {
                {
                    // Entero op Entero op Entero
                    // Entero op Entero op Real
                    // Entero op Entero op Entero[]
                    // Entero op Entero op Real[]
                    // Entero op Entero op Cadena
                    {false, false, false, false, false},
                    // Entero op Real op Entero
                    // Entero op Real op Real
                    // Entero op Real op Entero[]
                    // Entero op Real op Real[]
                    // Entero op Real op Cadena
                    {false, false, false, false, false},
                    // Entero op Entero[] op Entero
                    // Entero op Entero[] op Real
                    // Entero op Entero[] op Entero[]
                    // Entero op Entero[] op Real[]
                    // Entero op Entero[] op Cadena
                    {false, false, true , true , false},
                    // Entero op Real[] op Entero
                    // Entero op Real[] op Real
                    // Entero op Real[] op Entero[]
                    // Entero op Real[] op Real[]
                    // Entero op Real[] op Cadena
                    {false, false, true , true , false},
                    // Entero op Cadena op Entero
                    // Entero op Cadena op Real
                    // Entero op Cadena op Entero[]
                    // Entero op Cadena op Real[]
                    // Entero op Cadena op Cadena
                    {false, false, false, false, false}
                },
                
                {
                    // Real op Entero op Entero
                    // Real op Entero op Real
                    // Real op Entero op Entero[]
                    // Real op Entero op Real[]
                    // Real op Entero op Cadena
                    {false, false, false, false, false},
                    // Real op Real op Entero
                    // Real op Real op Real
                    // Real op Real op Entero[]
                    // Real op Real op Real[]
                    // Real op Real op Cadena
                    {false, false, false, false, false},
                    // Real op Entero[] op Entero
                    // Real op Entero[] op Real
                    // Real op Entero[] op Entero[]
                    // Real op Entero[] op Real[]
                    // Real op Entero[] op Cadena
                    {false, false, true , true , false},
                    // Real op Real[] op Entero
                    // Real op Real[] op Real
                    // Real op Real[] op Entero[]
                    // Real op Real[] op Real[]
                    // Real op Real[] op Cadena
                    {false, false, true , true , false},
                    // Real op Cadena op Entero
                    // Real op Cadena op Real
                    // Real op Cadena op Entero[]
                    // Real op Cadena op Real[]
                    // Real op Cadena op Cadena
                    {false, false, false, false, false}
                },
                
                {
                    // Entero[] op Entero op Entero
                    // Entero[] op Entero op Real
                    // Entero[] op Entero op Entero[]
                    // Entero[] op Entero op Real[]
                    // Entero[] op Entero op Cadena
                    {false, false, false, false, false},
                    // Entero[] op Real op Entero
                    // Entero[] op Real op Real
                    // Entero[] op Real op Entero[]
                    // Entero[] op Real op Real[]
                    // Entero[] op Real op Cadena
                    {false, false, false, false, false},
                    // Entero[] op Entero[] op Entero
                    // Entero[] op Entero[] op Real
                    // Entero[] op Entero[] op Entero[]
                    // Entero[] op Entero[] op Real[]
                    // Entero[] op Entero[] op Cadena
                    {false, false, false, false, false},
                    // Entero[] op Real[] op Entero
                    // Entero[] op Real[] op Real
                    // Entero[] op Real[] op Entero[]
                    // Entero[] op Real[] op Real[]
                    // Entero[] op Real[] op Cadena
                    {false, false, false, false, false},
                    // Entero[] op Cadena op Entero
                    // Entero[] op Cadena op Real
                    // Entero[] op Cadena op Entero[]
                    // Entero[] op Cadena op Real[]
                    // Entero[] op Cadena op Cadena
                    {false, false, false, false, false}
                },
                
                {
                    // Real[] op Entero op Entero
                    // Real[] op Entero op Real
                    // Real[] op Entero op Entero[]
                    // Real[] op Entero op Real[]
                    // Real[] op Entero op Cadena
                    {false, false, false, false, false},
                    // Real[] op Real op Entero
                    // Real[] op Real op Real
                    // Real[] op Real op Entero[]
                    // Real[] op Real op Real[]
                    // Real[] op Real op Cadena
                    {false, false, false, false, false},
                    // Real[] op Entero[] op Entero
                    // Real[] op Entero[] op Real
                    // Real[] op Entero[] op Entero[]
                    // Real[] op Entero[] op Real[]
                    // Real[] op Entero[] op Cadena
                    {false, false, false, false, false},
                    // Real[] op Real[] op Entero
                    // Real[] op Real[] op Real
                    // Real[] op Real[] op Entero[]
                    // Real[] op Real[] op Real[]
                    // Real[] op Real[] op Cadena
                    {false, false, false, false, false},
                    // Real[] op Cadena op Entero
                    // Real[] op Cadena op Real
                    // Real[] op Cadena op Entero[]
                    // Real[] op Cadena op Real[]
                    // Real[] op Cadena op Cadena
                    {false, false, false, false, false}
                },
                
                {
                    // Cadena op Entero op Entero
                    // Cadena op Entero op Real
                    // Cadena op Entero op Entero[]
                    // Cadena op Entero op Real[]
                    // Cadena op Entero op Cadena
                    {false, false, false, false, false},
                    // Cadena op Real op Entero
                    // Cadena op Real op Real
                    // Cadena op Real op Entero[]
                    // Cadena op Real op Real[]
                    // Cadena op Real op Cadena
                    {false, false, false, false, false},
                    // Cadena op Entero[] op Entero
                    // Cadena op Entero[] op Real
                    // Cadena op Entero[] op Entero[]
                    // Cadena op Entero[] op Real[]
                    // Cadena op Entero[] op Cadena
                    {false, false, false, false, false},
                    // Cadena op Real[] op Entero
                    // Cadena op Real[] op Real
                    // Cadena op Real[] op Entero[]
                    // Cadena op Real[] op Real[]
                    // Cadena op Real[] op Cadena
                    {false, false, false, false, false},
                    // Cadena op Cadena op Entero
                    // Cadena op Cadena op Real
                    // Cadena op Cadena op Entero[]
                    // Cadena op Cadena op Real[]
                    // Cadena op Cadena op Cadena
                    {false, false, false, false, false}
                }
            },
            // Real[]
            {
                {
                    // Entero op Entero op Entero
                    // Entero op Entero op Real
                    // Entero op Entero op Entero[]
                    // Entero op Entero op Real[]
                    // Entero op Entero op Cadena
                    {false, false, false, false, false},
                    // Entero op Real op Entero
                    // Entero op Real op Real
                    // Entero op Real op Entero[]
                    // Entero op Real op Real[]
                    // Entero op Real op Cadena
                    {false, false, false, false, false},
                    // Entero op Entero[] op Entero
                    // Entero op Entero[] op Real
                    // Entero op Entero[] op Entero[]
                    // Entero op Entero[] op Real[]
                    // Entero op Entero[] op Cadena
                    {false, false, true , true , false},
                    // Entero op Real[] op Entero
                    // Entero op Real[] op Real
                    // Entero op Real[] op Entero[]
                    // Entero op Real[] op Real[]
                    // Entero op Real[] op Cadena
                    {false, false, true , true , false},
                    // Entero op Cadena op Entero
                    // Entero op Cadena op Real
                    // Entero op Cadena op Entero[]
                    // Entero op Cadena op Real[]
                    // Entero op Cadena op Cadena
                    {false, false, false, false, false}
                },
                
                {
                    // Real op Entero op Entero
                    // Real op Entero op Real
                    // Real op Entero op Entero[]
                    // Real op Entero op Real[]
                    // Real op Entero op Cadena
                    {false, false, false, false, false},
                    // Real op Real op Entero
                    // Real op Real op Real
                    // Real op Real op Entero[]
                    // Real op Real op Real[]
                    // Real op Real op Cadena
                    {false, false, false, false, false},
                    // Real op Entero[] op Entero
                    // Real op Entero[] op Real
                    // Real op Entero[] op Entero[]
                    // Real op Entero[] op Real[]
                    // Real op Entero[] op Cadena
                    {false, false, true , true , false},
                    // Real op Real[] op Entero
                    // Real op Real[] op Real
                    // Real op Real[] op Entero[]
                    // Real op Real[] op Real[]
                    // Real op Real[] op Cadena
                    {false, false, true , true , false},
                    // Real op Cadena op Entero
                    // Real op Cadena op Real
                    // Real op Cadena op Entero[]
                    // Real op Cadena op Real[]
                    // Real op Cadena op Cadena
                    {false, false, false, false, false}
                },
                
                {
                    // Entero[] op Entero op Entero
                    // Entero[] op Entero op Real
                    // Entero[] op Entero op Entero[]
                    // Entero[] op Entero op Real[]
                    // Entero[] op Entero op Cadena
                    {false, false, false, false, false},
                    // Entero[] op Real op Entero
                    // Entero[] op Real op Real
                    // Entero[] op Real op Entero[]
                    // Entero[] op Real op Real[]
                    // Entero[] op Real op Cadena
                    {false, false, false, false, false},
                    // Entero[] op Entero[] op Entero
                    // Entero[] op Entero[] op Real
                    // Entero[] op Entero[] op Entero[]
                    // Entero[] op Entero[] op Real[]
                    // Entero[] op Entero[] op Cadena
                    {false, false, false, false, false},
                    // Entero[] op Real[] op Entero
                    // Entero[] op Real[] op Real
                    // Entero[] op Real[] op Entero[]
                    // Entero[] op Real[] op Real[]
                    // Entero[] op Real[] op Cadena
                    {false, false, false, false, false},
                    // Entero[] op Cadena op Entero
                    // Entero[] op Cadena op Real
                    // Entero[] op Cadena op Entero[]
                    // Entero[] op Cadena op Real[]
                    // Entero[] op Cadena op Cadena
                    {false, false, false, false, false}
                },
                
                {
                    // Real[] op Entero op Entero
                    // Real[] op Entero op Real
                    // Real[] op Entero op Entero[]
                    // Real[] op Entero op Real[]
                    // Real[] op Entero op Cadena
                    {false, false, false, false, false},
                    // Real[] op Real op Entero
                    // Real[] op Real op Real
                    // Real[] op Real op Entero[]
                    // Real[] op Real op Real[]
                    // Real[] op Real op Cadena
                    {false, false, false, false, false},
                    // Real[] op Entero[] op Entero
                    // Real[] op Entero[] op Real
                    // Real[] op Entero[] op Entero[]
                    // Real[] op Entero[] op Real[]
                    // Real[] op Entero[] op Cadena
                    {false, false, false, false, false},
                    // Real[] op Real[] op Entero
                    // Real[] op Real[] op Real
                    // Real[] op Real[] op Entero[]
                    // Real[] op Real[] op Real[]
                    // Real[] op Real[] op Cadena
                    {false, false, false, false, false},
                    // Real[] op Cadena op Entero
                    // Real[] op Cadena op Real
                    // Real[] op Cadena op Entero[]
                    // Real[] op Cadena op Real[]
                    // Real[] op Cadena op Cadena
                    {false, false, false, false, false}
                },
                
                {
                    // Cadena op Entero op Entero
                    // Cadena op Entero op Real
                    // Cadena op Entero op Entero[]
                    // Cadena op Entero op Real[]
                    // Cadena op Entero op Cadena
                    {false, false, false, false, false},
                    // Cadena op Real op Entero
                    // Cadena op Real op Real
                    // Cadena op Real op Entero[]
                    // Cadena op Real op Real[]
                    // Cadena op Real op Cadena
                    {false, false, false, false, false},
                    // Cadena op Entero[] op Entero
                    // Cadena op Entero[] op Real
                    // Cadena op Entero[] op Entero[]
                    // Cadena op Entero[] op Real[]
                    // Cadena op Entero[] op Cadena
                    {false, false, false, false, false},
                    // Cadena op Real[] op Entero
                    // Cadena op Real[] op Real
                    // Cadena op Real[] op Entero[]
                    // Cadena op Real[] op Real[]
                    // Cadena op Real[] op Cadena
                    {false, false, false, false, false},
                    // Cadena op Cadena op Entero
                    // Cadena op Cadena op Real
                    // Cadena op Cadena op Entero[]
                    // Cadena op Cadena op Real[]
                    // Cadena op Cadena op Cadena
                    {false, false, false, false, false}
                }
            },
            // Cadena
            {
                {
                    // Entero op Entero op Entero
                    // Entero op Entero op Real
                    // Entero op Entero op Entero[]
                    // Entero op Entero op Real[]
                    // Entero op Entero op Cadena
                    {false, false, false, false, false},
                    // Entero op Real op Entero
                    // Entero op Real op Real
                    // Entero op Real op Entero[]
                    // Entero op Real op Real[]
                    // Entero op Real op Cadena
                    {false, false, false, false, false},
                    // Entero op Entero[] op Entero
                    // Entero op Entero[] op Real
                    // Entero op Entero[] op Entero[]
                    // Entero op Entero[] op Real[]
                    // Entero op Entero[] op Cadena
                    {false, false, false, false, false},
                    // Entero op Real[] op Entero
                    // Entero op Real[] op Real
                    // Entero op Real[] op Entero[]
                    // Entero op Real[] op Real[]
                    // Entero op Real[] op Cadena
                    {false, false, false, false, false},
                    // Entero op Cadena op Entero
                    // Entero op Cadena op Real
                    // Entero op Cadena op Entero[]
                    // Entero op Cadena op Real[]
                    // Entero op Cadena op Cadena
                    {false, false, false, false, false}
                },
                
                {
                    // Real op Entero op Entero
                    // Real op Entero op Real
                    // Real op Entero op Entero[]
                    // Real op Entero op Real[]
                    // Real op Entero op Cadena
                    {false, false, false, false, false},
                    // Real op Real op Entero
                    // Real op Real op Real
                    // Real op Real op Entero[]
                    // Real op Real op Real[]
                    // Real op Real op Cadena
                    {false, false, false, false, false},
                    // Real op Entero[] op Entero
                    // Real op Entero[] op Real
                    // Real op Entero[] op Entero[]
                    // Real op Entero[] op Real[]
                    // Real op Entero[] op Cadena
                    {false, false, false, false, false},
                    // Real op Real[] op Entero
                    // Real op Real[] op Real
                    // Real op Real[] op Entero[]
                    // Real op Real[] op Real[]
                    // Real op Real[] op Cadena
                    {false, false, false, false, false},
                    // Real op Cadena op Entero
                    // Real op Cadena op Real
                    // Real op Cadena op Entero[]
                    // Real op Cadena op Real[]
                    // Real op Cadena op Cadena
                    {false, false, false, false, false}
                },
                
                {
                    // Entero[] op Entero op Entero
                    // Entero[] op Entero op Real
                    // Entero[] op Entero op Entero[]
                    // Entero[] op Entero op Real[]
                    // Entero[] op Entero op Cadena
                    {false, false, false, false, false},
                    // Entero[] op Real op Entero
                    // Entero[] op Real op Real
                    // Entero[] op Real op Entero[]
                    // Entero[] op Real op Real[]
                    // Entero[] op Real op Cadena
                    {false, false, false, false, false},
                    // Entero[] op Entero[] op Entero
                    // Entero[] op Entero[] op Real
                    // Entero[] op Entero[] op Entero[]
                    // Entero[] op Entero[] op Real[]
                    // Entero[] op Entero[] op Cadena
                    {false, false, false, false, false},
                    // Entero[] op Real[] op Entero
                    // Entero[] op Real[] op Real
                    // Entero[] op Real[] op Entero[]
                    // Entero[] op Real[] op Real[]
                    // Entero[] op Real[] op Cadena
                    {false, false, false, false, false},
                    // Entero[] op Cadena op Entero
                    // Entero[] op Cadena op Real
                    // Entero[] op Cadena op Entero[]
                    // Entero[] op Cadena op Real[]
                    // Entero[] op Cadena op Cadena
                    {false, false, false, false, false}
                },
                
                {
                    // Real[] op Entero op Entero
                    // Real[] op Entero op Real
                    // Real[] op Entero op Entero[]
                    // Real[] op Entero op Real[]
                    // Real[] op Entero op Cadena
                    {false, false, false, false, false},
                    // Real[] op Real op Entero
                    // Real[] op Real op Real
                    // Real[] op Real op Entero[]
                    // Real[] op Real op Real[]
                    // Real[] op Real op Cadena
                    {false, false, false, false, false},
                    // Real[] op Entero[] op Entero
                    // Real[] op Entero[] op Real
                    // Real[] op Entero[] op Entero[]
                    // Real[] op Entero[] op Real[]
                    // Real[] op Entero[] op Cadena
                    {false, false, false, false, false},
                    // Real[] op Real[] op Entero
                    // Real[] op Real[] op Real
                    // Real[] op Real[] op Entero[]
                    // Real[] op Real[] op Real[]
                    // Real[] op Real[] op Cadena
                    {false, false, false, false, false},
                    // Real[] op Cadena op Entero
                    // Real[] op Cadena op Real
                    // Real[] op Cadena op Entero[]
                    // Real[] op Cadena op Real[]
                    // Real[] op Cadena op Cadena
                    {false, false, false, false, false}
                },
                
                {
                    // Cadena op Entero op Entero
                    // Cadena op Entero op Real
                    // Cadena op Entero op Entero[]
                    // Cadena op Entero op Real[]
                    // Cadena op Entero op Cadena
                    {false, false, false, false, false},
                    // Cadena op Real op Entero
                    // Cadena op Real op Real
                    // Cadena op Real op Entero[]
                    // Cadena op Real op Real[]
                    // Cadena op Real op Cadena
                    {false, false, false, false, false},
                    // Cadena op Entero[] op Entero
                    // Cadena op Entero[] op Real
                    // Cadena op Entero[] op Entero[]
                    // Cadena op Entero[] op Real[]
                    // Cadena op Entero[] op Cadena
                    {false, false, false, false, false},
                    // Cadena op Real[] op Entero
                    // Cadena op Real[] op Real
                    // Cadena op Real[] op Entero[]
                    // Cadena op Real[] op Real[]
                    // Cadena op Real[] op Cadena
                    {false, false, false, false, false},
                    // Cadena op Cadena op Entero
                    // Cadena op Cadena op Real
                    // Cadena op Cadena op Entero[]
                    // Cadena op Cadena op Real[]
                    // Cadena op Cadena op Cadena
                    {false, false, false, false, false}
                }
            }
        }
    ;
}
