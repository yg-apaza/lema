package lema.analizadorLexico;

import java_cup.runtime.*;
import lema.analizadorSemantico.Nodo;
import java.util.ArrayList;
import lema.Mistake;

%%

%public
%class Lexico
%line
%column
%cup

%{
    /** Variable encargada de guardar errores léxicos */
    public Mistake e;
    
    /**
        * Constructor de clase Lexico.
        *
        * @param    in  lectura de entrada.
        * @param    e   errores encontrados por el compilador.    
    */    
    public Lexico(java.io.Reader in, Mistake e)
    {
        this.e = e;
        this.zzReader = in;
    }
    
    /**
        * Crea un nuevo token no terminal encontrado.
        *
        * @param    type    código del token aceptado por LeMa.
        * @return   nuevo   <tt>Symbol</tt> creado para almacenar al token
    */
    private Symbol symbol(int type)
    {
        return new Symbol(type, yyline, yycolumn);
    }
    
    /**
        * Crea un nuevo token terminal encontrado.
        *
        * @param    type    código del token aceptado por LeMa.
        * @param    value   estructura que almacena tokens terminales.
        * @return   nuevo   <tt>Symbol</tt> creado para almacenar al token.
    */
    private Symbol symbol(int type, Object value)
    {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

L = [a-zA-Z]
H = [0-9A-F]
O = [0-7]
D = [0-9]
WHITE = [ \t\r\n]

%%

/** Token: Espacio en blanco y salto de línea */
{WHITE}                         {                                       }

/** Token: Comentario en Bloque */
"/*"([^*]|\*+[^/*])*"*"+"/"     {                                       }

/** Token: Comentario en Línea */
"//"([^\n]*)                    {                                       }

/** Token: Palabra reservada 'const' */
"const"                         { return symbol(sym.pr_const);          }

/** Token: Palabra reservada 'vacio' */
"vacio"                         { return symbol(sym.pr_vacio,   (new Nodo(sym.pr_vacio, yytext(), yyline, yycolumn, null, true)));  }

/** Token: Palabra reservada 'entero' */
"entero"                        { return symbol(sym.pr_entero,  (new Nodo(sym.pr_entero, yytext(), yyline, yycolumn, null, true)));  }

/** Token: Palabra reservada 'real' */
"real"                          { return symbol(sym.pr_real,    (new Nodo(sym.pr_real, yytext(), yyline, yycolumn, null, true)));     }

/** Token: Palabra reservada 'cadena' */
"cadena"                        { return symbol(sym.pr_cadena,  (new Nodo(sym.pr_cadena, yytext(), yyline, yycolumn, null, true))); }

/** Token: Operador de Agrupación '(' */
"("                             { return symbol(sym.par_ab);            }

/** Token: Operador de Agrupación ')' */
")"                             { return symbol(sym.par_ce);            }

/** Token: Operador de Agrupación '{' */
"{"                             { return symbol(sym.ll_ab);             }

/** Token: Operador de Agrupación '}' */
"}"                             { return symbol(sym.ll_ce);             }

/** Token: Operador Aritmético '+' */
"+"                             { return symbol(sym.mas);               }

/** Token: Operador Aritmético '-' */
"-"                             { return symbol(sym.menos);             }

/** Token: Operador Aritmético '*' */
"*"                             { return symbol(sym.prod);              }

/** Token: Operador Aritmético '/' */
"/"                             { return symbol(sym.div);               }

/** Token: Operador Aritmético '%' */
"%"                             { return symbol(sym.mod);               }

/** Token: Operador Aritmético ''' */
"'"                             { return symbol(sym.transp);            }

/** Token: Operador Aritmético '^' */
"^"                             { return symbol(sym.inv);               }

/** Token: Operador Aritmético '++' */
"++"                            { return symbol(sym.incr);              }

/** Token: Operador Aritmético '--' */
"--"                            { return symbol(sym.decr);              }

/** Token: Palabra reservada 'suma' */
"suma"                          { return symbol(sym.pr_suma);           }

/** Token: Palabra reservada 'resta' */
"resta"                         { return symbol(sym.pr_resta);          }

/** Token: Palabra reservada 'producto' */
"producto"                      { return symbol(sym.pr_prod);           }

/** Token: Palabra reservada 'transpuesta' */
"transpuesta"                   { return symbol(sym.pr_transp);         }

/** Token: Palabra reservada 'inversa' */
"inversa"                       { return symbol(sym.pr_inv);            }

/** Token: Operador Relacional '==' */
"=="                            { return symbol(sym.ident);             }

/** Token: Operador Relacional '!=' */
"!="                            { return symbol(sym.dif);               }

/** Token: Operador Relacional '<' */
"<"                             { return symbol(sym.menor);             }

/** Token: Operador Relacional '>' */
">"                             { return symbol(sym.mayor);             }

/** Token: Operador Relacional '<=' */
"<="                            { return symbol(sym.menor_igual);       }

/** Token: Operador Relacional '>=' */
">="                            { return symbol(sym.mayor_igual);       }

/** Token: Operador Lógico '&&' */
"&&"                            { return symbol(sym.y);                 }

/** Token: Operador Lógico '||' */
"||"                            { return symbol(sym.o);                 }

/** Token: Operador Lógico '!' */
"!"                             { return symbol(sym.neg);               }

/** Token: Operador de Asignación '=' */
"="                             { return symbol(sym.igual);             }

/** Token: Operador de Asignación '+=' */
"+="                            { return symbol(sym.a_suma);            }

/** Token: Operador de Asignación '-=' */
"-="                            { return symbol(sym.a_resta);           }

/** Token: Operador de Asignación '*=' */
"*="                            { return symbol(sym.a_prod);            }

/** Token: Operador de Asignación '/=' */
"/="                            { return symbol(sym.a_div);             }

/** Token: Operador de Asignación '%=' */
"%="                            { return symbol(sym.a_mod);             }

/** Token: Operador Condicional '?' */
"?"                             { return symbol(sym.sig_int);           }

/** Token: Operador Condicional ':' */
":"                             { return symbol(sym.sig_pun);           }

/** Token: Operador de Acceso a Campo '[' */
"["                             { return symbol(sym.cor_ab);            }

/** Token: Operador de Acceso a Campo ']' */
"]"                             { return symbol(sym.cor_ce);            }

/** Token: Número Octal Entero */
"0"{O}+                         { return symbol(sym.octa_e,     (new Nodo(sym.octa_e, yytext(), yyline, yycolumn, null, true)));    }

/** Token: Número Octal Real */
"0"{O}+"."{O}+                  { return symbol(sym.octa_r,     (new Nodo(sym.octa_r, yytext(), yyline, yycolumn, null, true)));    }

/** Token: Número Hexadecimal Entero */
"0x"{H}+                        { return symbol(sym.hexa_e,     (new Nodo(sym.hexa_e, yytext(), yyline, yycolumn, null, true)));    }

/** Token: Número Hexadecimal Real */
"0x"{H}+"."{H}+                 { return symbol(sym.hexa_r,     (new Nodo(sym.hexa_r, yytext(), yyline, yycolumn, null, true)));}

/** Token: Número Entero */
{D}+                            { return symbol(sym.numero,     (new Nodo(sym.numero, yytext(), yyline, yycolumn, null, true)));    }

/** Token: Número Real */
{D}+"."{D}+                     { return symbol(sym.real,       (new Nodo(sym.real, yytext(), yyline, yycolumn, null, true)));      }

/** Token: Cadena */
\"[^\"\n]*\"                    { return symbol(sym.cadena,     (new Nodo(sym.cadena, yytext(), yyline, yycolumn, null, true)));    }

/** Token: Palabra reservada 'leer' */
"leer"                          { return symbol(sym.pr_leer);           }

/** Token: Palabra reservada 'mostrar' */
"mostrar"                       { return symbol(sym.pr_mostrar);        }

/** Token: Separador ';' */
";"                             { return symbol(sym.punto_coma);        }

/** Token: Separador ',' */
","                             { return symbol(sym.coma);              }

/** Token: Palabra reservada 'retornar' */
"retornar"                      { return symbol(sym.pr_retornar);       }

/** Token: Palabra reservada 'si' */
"si"                            { return symbol(sym.pr_si);             }

/** Token: Palabra reservada 'sino' */
"sino"                          { return symbol(sym.pr_sino);           }

/** Token: Palabra reservada 'mientras' */
"mientras"                      { return symbol(sym.pr_mientras);       }

/** Token: Palabra reservada 'hacer' */
"hacer"                         { return symbol(sym.pr_hacer);          }

/** Token: Palabra reservada 'para' */
"para"                          { return symbol(sym.pr_para);           }

/** Token: Palabra reservada 'selector' */
"selector"                      { return symbol(sym.pr_selector);       }

/** Token: Palabra reservada 'saltar' */
"saltar"                        { return symbol(sym.pr_saltar);         }

/** Token: Palabra reservada 'caso' */
"caso"                          { return symbol(sym.pr_caso);           }

/** Token: Palabra reservada 'pordefecto' */
"pordefecto"                    { return symbol(sym.pr_default);        }

/** Token: Palabra reservada 'principal' */
"principal"                     { return symbol(sym.pr_principal);      }

/** Token: Identificador */
{L}+({L}|{D}|"_")*              { return symbol(sym.id,         (new Nodo(sym.id, yytext(), yyline, yycolumn, null, true)) );       }

/** Token: Error */
.                               { String[] datos = {yytext(),
                                                    String.valueOf(yyline + 1),
                                                    String.valueOf(yycolumn)};
                                  e.insertarError(0, 0, datos);         }
