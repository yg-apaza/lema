package lema;
import java_cup.runtime.*;

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
"/*"([^*]|\*+[^/*])*"*"+"/"    { /* Ignorar */                          }

/* CONSTANTES */
"const"                         { return symbol(sym.pr_const,   (new Nodo(sym.pr_const, yytext(), yyline, yycolumn, null, true)));  }

/* TIPOS DE DATOS BASICOS */
"vacio"                         { return symbol(sym.pr_vacio,   (new Nodo(sym.pr_vacio, yytext(), yyline, yycolumn, null, true)));  }
"entero"                        { return symbol(sym.pr_entero,  (new Nodo(sym.pr_entero, yytext(), yyline, yycolumn, null, true))); }
"real"                          { return symbol(sym.pr_real,    (new Nodo(sym.pr_real, yytext(), yyline, yycolumn, null, true)));   }
"cadena"                        { return symbol(sym.pr_cadena,  (new Nodo(sym.pr_cadena, yytext(), yyline, yycolumn, null, true))); }

/* OPERADORES DE AGRUPACIÓN */
"("                             { return symbol(sym.par_ab);            }
")"                             { return symbol(sym.par_ce);            }
"{"                             { return symbol(sym.ll_ab);             }
"}"                             { return symbol(sym.ll_ce);             }

/* OPERADORES ARITMÉTICOS */
"+"                             { return symbol(sym.mas,        (new Nodo(sym.mas, yytext(), yyline, yycolumn, null, true)));       }
"-"                             { return symbol(sym.menos,      (new Nodo(sym.menos, yytext(), yyline, yycolumn, null, true)));     }
"*"                             { return symbol(sym.prod,       (new Nodo(sym.prod, yytext(), yyline, yycolumn, null, true)));      }
"/"                             { return symbol(sym.div,        (new Nodo(sym.div, yytext(), yyline, yycolumn, null, true)));       }
"%"                             { return symbol(sym.mod,        (new Nodo(sym.mod, yytext(), yyline, yycolumn, null, true)));       }
"'"                             { return symbol(sym.transp,     (new Nodo(sym.transp, yytext(), yyline, yycolumn, null, true)));    }
"^"                             { return symbol(sym.inv,        (new Nodo(sym.inv, yytext(), yyline, yycolumn, null, true)));       }
"++"                            { return symbol(sym.incr);              }
"--"                            { return symbol(sym.decr);              }
"suma"                          { return symbol(sym.pr_suma,    (new Nodo(sym.pr_suma, yytext(), yyline, yycolumn, null, true)));   }
"resta"                         { return symbol(sym.pr_resta,   (new Nodo(sym.pr_resta, yytext(), yyline, yycolumn, null, true)));  }
"producto"                      { return symbol(sym.pr_prod,    (new Nodo(sym.pr_prod, yytext(), yyline, yycolumn, null, true)));   }
"transpuesta"                   { return symbol(sym.pr_transp,  (new Nodo(sym.pr_transp, yytext(), yyline, yycolumn, null, true)));}
"inversa"                       { return symbol(sym.pr_inv,     (new Nodo(sym.pr_inv, yytext(), yyline, yycolumn, null, true)));    }

/* OPERADORES DE RELACIÓN */
"=="                            { return symbol(sym.ident,      (new Nodo(sym.ident, yytext(), yyline, yycolumn, null, true)));     }
"!="                            { return symbol(sym.dif,        (new Nodo(sym.dif, yytext(), yyline, yycolumn, null, true)));       }
"<"                             { return symbol(sym.menor,      (new Nodo(sym.menor, yytext(), yyline, yycolumn, null, true)));     }
">"                             { return symbol(sym.mayor,      (new Nodo(sym.mayor, yytext(), yyline, yycolumn, null, true)));     }
"<="                            { return symbol(sym.menor_igual,(new Nodo(sym.menor_igual, yytext(), yyline, yycolumn, null, true)));}
">="                            { return symbol(sym.mayor_igual,(new Nodo(sym.mayor_igual, yytext(), yyline, yycolumn, null, true)));}

/* OPERADORES LÓGICOS */
"&&"                            { return symbol(sym.y,          (new Nodo(sym.y, yytext(), yyline, yycolumn, null, true)));         }
"||"                            { return symbol(sym.o,          (new Nodo(sym.o, yytext(), yyline, yycolumn, null, true)));         }
"!"                             { return symbol(sym.neg,        (new Nodo(sym.neg, yytext(), yyline, yycolumn, null, true)));         }

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
\"[^\"]*\"                      { return symbol(sym.cadena,     (new Nodo(sym.cadena, yytext(), yyline, yycolumn, null, true)));    }

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