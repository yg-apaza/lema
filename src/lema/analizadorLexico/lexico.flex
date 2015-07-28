package lema.lexico;
import java_cup.runtime.*;
import lema.analizadorSemantico.Nodo;

%%

%class Lexico
%line
%column
%cup

%{
    private Symbol symbol(int type)
    {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value)
    {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

L = [a-zA-Z_]
H = [0-9A-F]
O = [0-8]
D = [0-9]
WHITE = [ \t\r\n]

%%

/* IGNORAR ESPACIOS EN BLANCO Y SALTOS DE LÍNEA */
{WHITE}                         { /* Ignorar */                         }

/* IGNORAR COMENTARIOS */
"/*"([^*]|\*+[^/*])*"*"+"/"     { /* Ignorar */                         }
"//"([^\n]*)                    { /* Ignorar */                         }

/* CONSTANTES */
"const"                         { return symbol(sym.pr_const);          }

/* TIPOS DE DATOS BASICOS */
"vacio"                         { return symbol(sym.pr_vacio,   (new Nodo(sym.pr_vacio, yytext(), yyline, yycolumn, null, true)));  }
"entero"                        { return symbol(sym.pr_entero, (new Nodo(sym.pr_entero, yytext(), yyline, yycolumn, null, true)));  }
"real"                          { return symbol(sym.pr_real,  (new Nodo(sym.pr_real, yytext(), yyline, yycolumn, null, true)));     }
"cadena"                        { return symbol(sym.pr_cadena,  (new Nodo(sym.pr_cadena, yytext(), yyline, yycolumn, null, true))); }

/* OPERADORES DE AGRUPACIÓN */
"("                             { return symbol(sym.par_ab);            }
")"                             { return symbol(sym.par_ce);            }
"{"                             { return symbol(sym.ll_ab);             }
"}"                             { return symbol(sym.ll_ce);             }

/* OPERADORES ARITMÉTICOS */
"+"                             { return symbol(sym.mas);               }
"-"                             { return symbol(sym.menos);             }
"*"                             { return symbol(sym.prod);              }
"/"                             { return symbol(sym.div);               }
"%"                             { return symbol(sym.mod);               }
"'"                             { return symbol(sym.transp);            }
"^"                             { return symbol(sym.inv);               }
"++"                            { return symbol(sym.incr);              }
"--"                            { return symbol(sym.decr);              }
"suma"                          { return symbol(sym.pr_suma);           }
"resta"                         { return symbol(sym.pr_resta);          }
"producto"                      { return symbol(sym.pr_prod);           }
"transpuesta"                   { return symbol(sym.pr_transp);         }
"inversa"                       { return symbol(sym.pr_inv);            }

/* OPERADORES DE RELACIÓN */
"=="                            { return symbol(sym.ident);             }
"!="                            { return symbol(sym.dif);               }
"<"                             { return symbol(sym.menor);             }
">"                             { return symbol(sym.mayor);             }
"<="                            { return symbol(sym.menor_igual);       }
">="                            { return symbol(sym.mayor_igual);       }

/* OPERADORES LÓGICOS */
"&&"                            { return symbol(sym.y);                 }
"||"                            { return symbol(sym.o);                 }
"!"                             { return symbol(sym.neg);               }

/* OPERADORES DE ASIGNACIÓN */
"="                             { return symbol(sym.igual);             }
"+="                            { return symbol(sym.a_suma);            }
"-="                            { return symbol(sym.a_resta);           }
"*="                            { return symbol(sym.a_prod);            }
"/="                            { return symbol(sym.a_div);             }
"%="                            { return symbol(sym.a_mod);             }

/* OPERADOR CONDICIONAL */
"?"                             { return symbol(sym.sig_int);           }
":"                             { return symbol(sym.sig_pun);           }

/* OPERADOR DE ACCESO A CAMPO */
"["                             { return symbol(sym.cor_ab);            }
"]"                             { return symbol(sym.cor_ce);            }

/* NÚMERO OCTAL ENTERO Y REAL */
"0"{O}+                         { return symbol(sym.octa_e,     (new Nodo(sym.octa_e, yytext(), yyline, yycolumn, null, true)));    }
"0"{O}+"."{O}+                  { return symbol(sym.octa_r,     (new Nodo(sym.octa_r, yytext(), yyline, yycolumn, null, true)));    }

/* NÚMERO HEXADECIMAL ENTERO Y REAL */
"0x"{H}+                        { return symbol(sym.hexa_e,     (new Nodo(sym.hexa_e, yytext(), yyline, yycolumn, null, true)));    }
"0x"{H}+"."{H}+                 { return symbol(sym.hexa_r,     (new Nodo(sym.hexa_r, yytext(), yyline, yycolumn, null, true)));}

/* NÚMERO SIMPLE ENTERO Y REAL*/
{D}+                            { return symbol(sym.numero,     (new Nodo(sym.numero, yytext(), yyline, yycolumn, null, true)));    }
{D}+"."{D}+                     { return symbol(sym.real,       (new Nodo(sym.real, yytext(), yyline, yycolumn, null, true)));      }

/* CADENAS */
\"[^\"\n]*\"                    { return symbol(sym.cadena,     (new Nodo(sym.cadena, yytext(), yyline, yycolumn, null, true)));    }

/* INSTRUCCIONES DE ENTRADA Y SALIDA */
"leer"                          { return symbol(sym.pr_leer);           }
"mostrar"                       { return symbol(sym.pr_mostrar);        }

/* SEPARADORES */
";"                             { return symbol(sym.punto_coma);        }
","                             { return symbol(sym.coma);              }

/* FUNCIONES */
"retornar"                      { return symbol(sym.pr_retornar);       }

/* SENTENCIAS CONDICIONALES */
"si"                            { return symbol(sym.pr_si);             }
"sino"                          { return symbol(sym.pr_sino);           }

/* SENTENCIAS DE REPETICIÓN */
"mientras"                      { return symbol(sym.pr_mientras);       }
"hacer"                         { return symbol(sym.pr_hacer);          }
"para"                          { return symbol(sym.pr_para);           }

/* SENTENCIAS DE SELECCIÓN MÚLTIPLE */
"selector"                      { return symbol(sym.pr_selector);       }
"saltar"                        { return symbol(sym.pr_saltar);         }
"caso"                          { return symbol(sym.pr_caso);           }
"pordefecto"                    { return symbol(sym.pr_default);        }

/* MENÚ PRINCIPAL */
"principal"                     { return symbol(sym.pr_principal);      }

/* IDENTIFICADOR */
{L}+({L}|{D})*                  { return symbol(sym.id,         (new Nodo(sym.id, yytext(), yyline, yycolumn, null, true)) );       }

/* ERROR */
.                               { return symbol(sym.err, yytext());     }