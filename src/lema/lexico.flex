package lema;
import java_cup.runtime.*;

%%

%class Lexico
%line
%column
%cup

%{
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

L = [a-zA-Z_]
H = [A-F]
D = [0-9]
WHITE = [ \t\r\n]

%%

{WHITE} { /* Ignorar */ }
"/*"(.| {WHITE})*"*/" { /* Ignorar */ }

"const" {return symbol(sym.pr_const);}
"vacio" { return symbol(sym.pr_vacio);}
"entero" { return symbol(sym.pr_entero);}
"real" { return symbol(sym.pr_real);}

"(" { return symbol(sym.par_ab);}
")" { return symbol(sym.par_ce);}
"{" { return symbol(sym.ll_ab);}
"}" { return symbol(sym.ll_ce);}

"+" { return symbol(sym.mas);}
"-" { return symbol(sym.menos);}
"*" { return symbol(sym.prod);}
"/" { return symbol(sym.div);}
"%" { return symbol(sym.mod);}
"'" { return symbol(sym.transp);}
"^" { return symbol(sym.inv);}
"++" { return symbol(sym.incr);}
"--" { return symbol(sym.decr);}
"suma" { return symbol(sym.pr_suma);}
"resta" { return symbol(sym.pr_resta);}
"producto" { return symbol(sym.pr_prod);}
"transpuesta" { return symbol(sym.pr_transp);}
"inversa" { return symbol(sym.pr_inv);}

"==" { return symbol(sym.ident);}
"!=" { return symbol(sym.dif);}
"<" { return symbol(sym.menor);}
">" { return symbol(sym.mayor);}
"<=" { return symbol(sym.menor_igual);}
">=" { return symbol(sym.mayor_igual);}

"&&" { return symbol(sym.y);}
"||" { return symbol(sym.o);}
"!" { return symbol(sym.neg);}

"=" { return symbol(sym.igual);}
"+=" { return symbol(sym.a_suma);}
"-=" { return symbol(sym.a_resta);}
"*=" { return symbol(sym.a_prod);}
"/=" { return symbol(sym.a_div);}
"%=" {return symbol(sym.a_mod);}

"?" { return symbol(sym.sig_int);}
":" { return symbol(sym.sig_pun);}
"[" { return symbol(sym.cor_ab);}
"]" { return symbol(sym.cor_ce);}

"0"{D}+ {return symbol(sym.octa_e, yytext());}
"0"{D}+"."{D}+ { return symbol(sym.octa_r, yytext());}
"0x"({D}|{H})+ {return symbol(sym.hexa_e, yytext());}
"0x"({D}|{H})+"."({D}|{H})+ { return symbol(sym.hexa_r, yytext());}

{D}+ {  return symbol(sym.numero, yytext());}
{D}+"."{D}+ { return symbol(sym.real, yytext());}

\".*\" {  return symbol(sym.cadena, yytext());}

"leer" { return symbol(sym.pr_leer);}
"mostrar" { return symbol(sym.pr_mostrar);}
";" { return symbol(sym.punto_coma);}
"," { return symbol(sym.coma);}
"retornar" { return symbol(sym.pr_retornar);}

"si" { return symbol(sym.pr_si);}
"sino" { return symbol(sym.pr_sino);}
"mientras" { return symbol(sym.pr_mientras);}
"hacer" { return symbol(sym.pr_hacer);}
"para" { return symbol(sym.pr_para);}
"selector" { return symbol(sym.pr_selector);}
"saltar" { return symbol(sym.pr_saltar);}
"caso" { return symbol(sym.pr_caso);}
"pordefecto" { return symbol(sym.pr_default);}
"principal" { return symbol(sym.pr_principal);} 

{L}+({L}|{D})* {  return symbol(sym.id, yytext());}

. { return symbol(sym.error_lex, yytext());}