package lema;

import lema.analizadorSemantico.AST;
import lema.analizadorSemantico.Nodo;
import lema.analizadorSintactico.parser;
import lema.analizadorLexico.sym;
import lema.analizadorLexico.Lexico;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        if(args.length == 0)
        {
            System.out.println("Debe ingresar un archivo");
        }
        else
        {
            if(args.length == 1)
            {
                Compilar(args[0]);
            }
            else
            {
                System.out.println("Archivo: " + args[0] + "\n");
                switch(Integer.parseInt(args[1]))
                {
                    case 0:
                        ALexico(args[0]);
                        break;
                    case 1:
                        ASintactico(args[0]);
                        break;
                    case 2:
                        ASemantico(args[0]);
                        break;
                }
            }
        }
    }
    
    public static void ALexico(String file) throws FileNotFoundException, IOException
    {
        System.out.println("ANALIZADOR LEXICO");
        System.out.println("------------------------------------------------------------");
        System.out.flush();
        Reader reader = new BufferedReader(new FileReader(file));
        
        Lexico lexico = new Lexico(reader);
        String resultado = "";
        
        Symbol token = lexico.next_token();
        
        while(token.sym != 0)
        {
            switch(token.sym)
            {
                case sym.pr_const:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Constante\n";
                    break;
                case sym.pr_vacio:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Tipo de dato vacío\n";
                    break;
                case sym.pr_entero:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Tipo de dato entero\n";
                    break;
                case sym.pr_real:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Tipo de dato real\n";
                    break;
                case sym.pr_cadena:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Tipo de dato cadena\n";
                    break;
                case sym.par_ab:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Paréntesis abierto\n";
                    break;
                case sym.par_ce:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Paréntesis cerrado\n";
                    break;
                case sym.ll_ab:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Llave abierta\n";
                    break;
                case sym.ll_ce:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Llave cerrada\n";
                    break;
                case sym.mas:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador suma\n";
                    break;
                case sym.menos:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador resta\n";
                    break;
                case sym.prod:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador producto\n";
                    break;
                case sym.div:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador división\n";
                    break;
                case sym.mod:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador módulo\n";
                    break;
                case sym.transp:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador transpuesta\n";
                    break;
                case sym.inv:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador inversa\n";
                    break;
                case sym.incr:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador incremento\n";
                    break;
                case sym.decr:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador decremento\n";
                    break;
                case sym.pr_suma:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Palabra reservada suma\n";
                    break;
                case sym.pr_resta:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Palabra reservada resta\n";
                    break;
                case sym.pr_prod:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Palabra reservada producto\n";
                    break;
                case sym.pr_transp:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Palabra reservada transpuesta\n";
                    break;
                case sym.pr_inv:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Palabra reservada inversa\n";
                    break;
                case sym.ident:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador identico\n";
                    break;
                case sym.dif:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador diferente\n";
                    break;
                case sym.menor:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador menor\n";
                    break;
                case sym.mayor:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador mayor\n";
                    break;    
                case sym.menor_igual:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador menor igual\n";
                    break;
                case sym.mayor_igual:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador mayor igual\n";
                    break;
                case sym.y:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador conjuntivo\n";
                    break;
                case sym.o:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador disyuntivo\n";
                    break;    
                case sym.neg:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador negación\n";
                    break;
                case sym.igual:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador igual\n";
                    break;
                case sym.a_suma:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador con asignación suma\n";
                    break;
                case sym.a_resta:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador con asignación resta\n";
                    break;    
                case sym.a_prod:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador con asignación producto\n";
                    break;
                case sym.a_div:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador con asignación división\n";
                    break;
                case sym.a_mod:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador con asignación módulo\n";
                    break;
                case sym.sig_int:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador ?\n";
                    break;
                case sym.sig_pun:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Operador :\n";
                    break;    
                case sym.cor_ab:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Corchete abierto\n";
                    break;
                case sym.cor_ce:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Corchete cerrado\n";
                    break;
                case sym.octa_e:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Número octal entero " + ((Nodo)(token.value)).getValor() + "\n";
                    break;
                case sym.octa_r:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Número octal real " + ((Nodo)(token.value)).getValor() + "\n";
                    break;
                case sym.hexa_e:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Número hexadecimal entero " + ((Nodo)(token.value)).getValor() + "\n";
                    break;
                case sym.hexa_r:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Número hexadecimal real " + ((Nodo)(token.value)).getValor() + "\n";
                    break;
                case sym.numero:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Número entero " + ((Nodo)(token.value)).getValor() + "\n";
                    break;     
                case sym.real:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Número real " + ((Nodo)(token.value)).getValor() + "\n";
                    break;
                case sym.cadena:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Cadena de caracteres " + ((Nodo)(token.value)).getValor() + "\n";
                    break;
                case sym.pr_leer:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Palabra reservada leer\n";
                    break;     
                case sym.pr_mostrar:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Palabra reservada mostrar\n";
                    break;
                case sym.punto_coma:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Punto y coma\n";
                    break;
                case sym.coma:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Coma\n";
                    break;     
                case sym.pr_retornar:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Palabra reservada retornar\n";
                    break;
                case sym.pr_si:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Palabra reservada si\n";
                    break;    
                case sym.pr_sino:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Palabra reservada sino\n";
                    break;     
                case sym.pr_mientras:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Palabra reservada mientras\n";
                    break;
                case sym.pr_hacer:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Palabra reservada hacer\n";
                    break;    
                case sym.pr_para:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Palabra reservada para\n";
                    break;     
                case sym.pr_selector:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Palabra reservada selector\n";
                    break;
                case sym.pr_saltar:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Palabra reservada saltar\n";
                    break;    
                case sym.pr_caso:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Palabra reservada caso\n";
                    break;             
                case sym.pr_default:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Palabra reservada pordefecto\n";
                    break;     
                case sym.pr_principal:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Funcion principal\n";
                    break;
                case sym.id:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token: Identificador " + ((Nodo)(token.value)).getValor() + "\n";
                    break;
                case sym.err:
                    resultado = resultado + "LINEA: " + (token.left + 1) + " -> Token '"+ token.value + "' no reconocido\n";
            }
            
            token = lexico.next_token();
        }
        
        System.out.println(resultado);
        System.out.flush();
        System.out.println();
        System.out.flush();
    }
   
    public static void ASintactico(String file)
    {
        System.out.println("ANALIZADOR SINTACTICO");
        System.out.flush();
        System.out.println("------------------------------------------------------------");
        System.out.flush();
        try
        {
            parser p = new parser(new Lexico(new FileReader(file)));
            Object result = p.parse();
            
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println();
        System.out.flush();
    }
   
    public static void ASemantico(String file)
    {
        System.out.println("ANALIZADOR SEMANTICO");
        System.out.flush();
        System.out.println("------------------------------------------------------------");
        System.out.flush();
        
        try
        {
            parser p = new parser(new Lexico(new FileReader(file)));
            Object result = p.parse();
            Nodo raiz = p.getRaiz();
            raiz.print();
            
            /* Prueba */
            System.out.println("-----------------------------------------------");
            System.out.println(raiz.getLinea());
            System.out.println("-----------------------------------------------");
            /* Fin de la Prueba */
            
            AST ast = new AST(raiz);
            ast.verificar();
            ArrayList<String> errores = ast.getErrores();
            if(errores.isEmpty())
                System.out.println("No se encontraron errores");
            else
                for(int i = 0; i < errores.size(); i++)
                    System.out.println(errores.get(i));
            System.out.println(ast.getTabla().toString());
            System.out.flush();
            
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println();
        System.out.flush();
    }
   
    public static void Compilar(String file)
    {
        System.out.println("Compilar archivo: " + file);
    }
}
