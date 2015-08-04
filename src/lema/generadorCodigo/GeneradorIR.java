package lema.generadorCodigo;

public class GeneradorIR {
    public static final int _IMPRIMIR_CAB =0;
    public static final int _LEER_CAB =1;
    public static final int _STR_IE  =2;
    public static final int _STR_IR =3;
    public static final int _STR_PE =4;
    public static final int _STR_PR =5;
    public static final int _ENT_A_DOUBLE =6;
    public static final int _DOUBLE_A_ENT =7;
    public static final int _ESUMA =8;
    public static final int _ERESTA =9;
    public static final int _EDIVISION =10;
    public static final int _EPRODUCTO =11;
    public static final int _EMODULO =12;
    public static final int _EMAYOR =13;
    public static final int _EMENOR =14;
    public static final int _EMAYOR_IGUAL =15;
    public static final int _EMENOR_IGUAL =16;
    public static final int _ECONJUNCION =17;
    public static final int _EDISYUNCION =18;
    public static final int _EIDENTICO =19;
    public static final int _EDIFERENTE =20;
    public static final int _ENEGACION =21;
    public static final int _ENEGATIVIDAD =22;
    public static final int _RSUMA =23;
    public static final int _RRESTA =24;
    public static final int _RDIVISION =25;
    public static final int _RPRODUCTO =26;
    public static final int _RMODULO =27;
    public static final int _RMAYOR =28;
    public static final int _RMENOR =29;
    public static final int _RMAYOR_IGUAL =30;
    public static final int _RMENOR_IGUAL =31;
    public static final int _RCONJUNCION =32;
    public static final int _RDISYUNCION =33;
    public static final int _RIDENTICO =34;
    public static final int _RDIFERENTE =35;
    public static final int _RNEGACION =36;
    public static final int _RNEGATIVIDAD =37;

    
    
    //Principal
    public IRCabecera cabecera;
    public String _iniPrincipal = "define i32 @main() nounwind readnone optsize {\n";
    public String _terPrincipal = "ret i32 0\n" +
                                  "}\n";
    
    //Declaracion de constantes
    public String _ecdeclarar = "@$ = constant i32 $\n";
    public String _rcdeclarar = "@$ = constant double $\n";
    //Declaracion de variables
    public String _evdeclarar = "@$ = global i32 $\n";
    public String _rvdeclarar = "@$ = global double $\n";
    //Declaracion de matrices constantes
    public String _emcdeclarar = "@$ = constant <$ x i32> $\n";
    public String _rmcdeclarar = "@$ = constant <$ x double> $\n";
    //Declaracion de matrices variables
    public String _emvdeclarar = "@$ = global <$ x i32> $\n";
    public String _rmvdeclarar = "@$ = global <$ x double> $\n";
    
    public String _ecargar = "%$ = load i32* @$, align 4\n";
    public String _rcargar = "%$ = load double* @$, align 4\n";
    
    //Imprimir 
    public String _str_c = "@.str_c$ = private unnamed_addr constant [$ x i8] c\"$\\00\", align 1\n";  //$id $tamaño  $ = mensaje
    
    public String _eimprimir = "call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([4 x i8]* @.str_pe, i32 0, i32 0), i32 %$) nounwind optsize\n";
    public String _rimprimir = "call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.str_pr, i32 0, i32 0), double %$) nounwind optsize\n";
    public String _cimprimir = "call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([$ x i8]* @.str_c$, i32 0, i32 0)) nounwind optsize"; //$ tamaño $id
    
    public String _eleer = "%$ = alloca i32, align 4\n" +
                            "  call i32 (i8*, ...)* @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8]* @.str_ie, i32 0, i32 0), i32* %$) nounwind optsize\n" +
                            "  %$ = load i32* %$, align 4\n";
                           //t t t v
    public String _rleer = "%$ = alloca double, align 8\n" +
                            "  call i32 (i8*, ...)* @__isoc99_scanf(i8* getelementptr inbounds ([4 x i8]* @.str_ir, i32 0, i32 0), double* %$) nounwind optsize\n" +
                            "  %$ = load double* %$, align 8\n";
                            //t t t v

    //
    public String _inicializarZeros = "zeroinitializer";
    
    //
    public String _fun_declarar_cabecera = "define $ @$($) nounwind readnone optsize {\n";
    public String _fun_declarar_fin = "ret $ $\n" +
                                       "}\n";
    
    //flujo de control si
    public String _si_cabecera = "br i1 %$ifcond, label %$then, label %$else\n" +
                                  "$then:\n";
    public String _saltar_continuar = "br label %$ifcontinuar\n";
    public String _else = "$else:\n";
    public String _continuar = "$ifcontinuar:\n";
    
    //Flujo de control loop
    public String _para_cabecera = "br label %$loop\n" +
                                    "$loop:"; 
    public String _para_fin = "br i1 %$loopcond, label %$loop, label %$afterloop\n" +
                              "$afterloop:";
    

    //Operaciones de conversion
    public String _ent_a_real = "%$ = tail call double @_ent_a_real(i32 $)\n";
    public String _real_a_ent = "%$ = tail call i32 @_real_a_ent(double $)\n";
    
    //Operaciones aritmticas y logicas con retorno entero
    public String _esuma = "%$ = tail call i32 @_esuma(double $, double $)\n";
    public String _eresta = "%$ = tail call i32 @_eresta(double $, double $)\n";
    public String _edivision = "%$ = tail call i32 @_edivision(double $, double $)\n";
    public String _eproducto = "%$ = tail call i32 @_eproducto(double $, double $)\n";
    public String _emodulo = "%$ = tail call i32 @_emodulo(double $, double $)\n";
    public String _emayor = "%$ = tail call i32 @_emayor(double $, double $)\n";
    public String _emenor = "%$ = tail call i32 @_emenor(double $, double $)\n";
    public String _emayor_igual = "%$ = tail call i32 @_emayor_igual(double $, double $)\n";
    public String _emenor_igual = "%$ = tail call i32 @_emenor_igual(double $, double $)\n";
    public String _econjuncion = "%$ = tail call i32 @_econjuncion(double $, double $)\n";
    public String _edisyuncion = "%$ = tail call i32 @_edisyuncion(double $, double $)\n";
    public String _eidentico = "%$ = tail call i32 @_eidentico(double $, double $)\n";
    public String _ediferente = "%$ = tail call i32 @_ediferente(double $, double $)\n";
    public String _enegacion = "%$ = tail call i32 @_enegacion(double $)\n";
    public String _enegatividad = "%$ = tail call i32 @_enegatividad(double $)\n";
    
    //Operaciones aritmticas y logicas con retorno real
    public String _rsuma = "%$ = tail call double @_rsuma(double $, double $)\n";
    public String _rresta = "%$ = tail call double @_rresta(double $, double $)\n";
    public String _rdivision = "%$ = tail call double @_rdivision(double $, double $)\n";
    public String _rproducto = "%$ = tail call double @_rproducto(double $, double $)\n";
    public String _rmodulo = "%$ = tail call double @_rmodulo(double $, double $)\n";
    public String _rmayor = "%$ = tail call double @_rmayor(double $, double $)\n";
    public String _rmenor = "%$ = tail call double @_rmenor(double $, double $)\n";
    public String _rmayor_igual = "%$ = tail call double @_rmayorpublic_igual(double $, double $)\n";
    public String _rmenor_igual = "%$ = tail call double @_rmenorpublic_igual(double $, double $)\n";
    public String _rconjuncion = "%$ = tail call double @_rconjuncion(double $, double $)\n";
    public String _rdisyuncion = "%$ = tail call double @_rdisyuncion(double $, double $)\n";
    public String _ridentico = "%$ = tail call double @_ridentico(double $, double $)\n";
    public String _rdiferente = "%$ = tail call double @_rdiferente(double $, double $)\n";
    public String _rnegacion = "%$ = tail call double @_rnegacion(double $)\n";
    public String _rnegatividad = "%$ = tail call double @_rnegatividad(double $)\n";
    
    //Operaciones con matrices
    public String _msuma = "%$ = tail call <$ x i32>  @_emsuma(<$ x i32>$, <$ x i32>$)";
    public String _mresta = "%$ = tail call <$ x i32>  @_mresta(<$ x i32>$, <$ x i32>$)";
    public String _mmayor = "%$ = tail call <$ x i32>  @_mmayor(<$ x i32>$, <$ x i32>$)";
    public String _mmenor = "%$ = tail call <$ x i32>  @_mmenor(<$ x i32>$, <$ x i32>$)";                
    public String _mmayorpublic_igual = "%$ = tail call <$ x i32>  @_mmayorpublic_igual(<$ x i32>$, <$ x i32>$)";
    public String _mmenorpublic_igual = "%$ = tail call <$ x i32>  @_mmenorpublic_igual(<$ x i32>$, <$ x i32>$)";               
    public String _mconjuncion = "%$ = tail call <$ x i32>  @_mconjuncion(<$ x i32>$, <$ x i32>$)";
    public String _mdisyuncion = "%$ = tail call <$ x i32>  @_mdisyuncion(<$ x i32>$, <$ x i32>$)";
    public String _midentico = "%$ = tail call <$ x i32>  @_midentico(<$ x i32>$, <$ x i32>$)";
    public String _mdiferente = "%$ = tail call <$ x i32>  @_mdiferente(<$ x i32>$, <$ x i32>$)";
    public String _mnegacion = "%$ = tail call <$ x i32>  @_mnegacion(<$ x i32>$, <$ x i32>$)";
    public String _minversa = "%$ = tail call <$ x i32>  @_minversa(<$ x i32>$, <$ x i32>$)";
    public String _mtranspuesta = "%$ = tail call <$ x i32>  @_mtranspuesta(<$ x i32>$, <$ x i32>$)";
    public String _mnegatividad = "%$ = tail call <$ x i32>  @_mnegatividad(<$ x i32>$, <$ x i32>$)";
    
   
    public String mainllini = "define i32 @main() nounwind  readnone optsize{";
    public String mainllter = "ret i32 0\n"+
                              "}";
    public String operaciones;
    
    public GeneradorIR(){
        cabecera = new IRCabecera();
    }
    
    // Iniciar programa
    public String llamar_principal(){
        return _iniPrincipal;
    }
    public String terminar_principal(){
        return _terPrincipal;
    }
   
    public String declarar_fun_cabecera(int type, String nom, String []arg, int [] tipos){ //type = 0 entero 1 real 2 entero -1 otros
        String r = "";
        switch(type){
            case 0:
                r = llenar_arg(arg,tipos);
                r = unir(_fun_declarar_cabecera , new String []{ "i32", nom, r} );
                break;
            case 1:
                r = llenar_arg(arg,tipos);
                r = unir(_fun_declarar_cabecera , new String []{ "double", nom, r} );
                break;
        }
        return r;
    }
    public String declarar_fun_fin(int type, String nomRet, boolean ret){ //ret = 0 retorno vacio, ret = X retorno valor
        String r = "";
        if(ret)
            nomRet = "1";
        else nomRet = "%" + nomRet;
                
        switch(type){
            case 0:
                r = unir(_fun_declarar_fin , new String []{ "i32",nomRet} );
                break;
            case 1:
                r = unir(_fun_declarar_fin , new String []{ "double",nomRet} );
                break;
        }
        return r;
    }

    
    //Declarar variable
    public String declararVariable(String nom, String val, int tipo, boolean var_con, int tam){ //0 entero 1 real 2 entero matriz 3 real matriz 4 cadena -1 otros
        String dec = "";                                                               //true constante false variable 
        if(val.length()==0)
            val = _inicializarZeros;
        
        switch(tipo){
            case 0:
                if(var_con)
                    dec = unir(_evdeclarar, new String[]{nom, val});
                else
                    dec = unir(_ecdeclarar, new String[]{nom, val});
                break;
            case 1:
                if(var_con)
                    dec = unir(_rvdeclarar, new String[]{nom, val});
                else
                    dec = unir(_rcdeclarar, new String[]{nom, val});
                break;
            case 2:
                val = llenar_vec(val,"i32");
                String te = ""+tam;
                if(var_con)
                    dec = unir(_emcdeclarar, new String[]{nom, te, val});
                else
                    dec = unir(_emvdeclarar, new String[]{nom, te, val});
                break;
            case 3:
                val = llenar_vec(val,"double");
                String tr = ""+tam;
                if(var_con)
                    dec = unir(_rmcdeclarar, new String[]{nom, tr, val});
                else
                    dec = unir(_rmvdeclarar, new String[]{nom, tr, val});
                break;
        }
        return dec;
    }
    public String cargarVariable(String resultado, String referencia, int tipo){ //0 entero 1 real 2 entero matriz 3 real matriz 4
        String temp = "";
        switch(tipo){
            case 0:
                temp =  unir(_ecargar, new String []{ resultado, referencia} );
                break;
            case 1: 
                temp =  unir(_rcargar, new String []{ resultado, referencia} );
                break;
        }
        return temp;
    }
    
    //Salida
    public String imprimir_cadena_cabecera(String id, String tam, String mensaje){
        cabecera.marcar(_IMPRIMIR_CAB); //l 
        
        return unir(_eimprimir, new String []{ id, tam, mensaje} );
    }
    public String imprimir(String cadena, int tipo, String id){ //0 entero 1 real 2 entero matriz 3 real matriz 4 cadena -1 otros //id solo para cadenas
        cabecera.marcar(_IMPRIMIR_CAB); //_imprimir_cab 
        String r = "";
        switch(tipo){
            case 0: 
                cabecera.marcar(_STR_PE);
                r = unir(_eimprimir, new String []{ cadena} );
                break;
            case 1:
                cabecera.marcar(_STR_PR);
                r = unir(_rimprimir, new String []{ cadena} );
                break;
            case 4:
                String tam = "" + (cadena.length()+1);
                r = unir(_cimprimir,new String[]{tam,id});
                break;
        }
        return r;
    }
    public String leer(String cadena, int tipo){
        cabecera.marcar(_LEER_CAB);
        String r = "";
        String tmp = "_"+cadena;
        switch(tipo){
            case 0: 
                cabecera.marcar(_STR_IE);
                r = unir(_eleer, new String []{ tmp, tmp, cadena, tmp } ); //t t t v
                break;
            case 1:
                cabecera.marcar(_STR_IR);
                r = unir(_rleer, new String []{ tmp, tmp, cadena, tmp } ); //t t t v
                break;
        }
        return r;
    }
    
    
    //Flujo de control para si_else
    public String si_iniciar(String num){
        return unir(_si_cabecera , new String []{ num, num, num} );
    }
    public String si_saltar_continuar(String num){
        return unir(_saltar_continuar , new String []{ num} );
    }
    public String si_else(String num){
        return unir(_else , new String []{ num} );
    }
    public String si_continuar(String num){
        return unir(_continuar , new String []{ num} );
    }
    
    //Flujo de control para
    public String para_iniciar(String num){
        return unir(_para_cabecera , new String []{ num, num} );
    }
    public String para_fin(String num){
        return unir(_para_fin , new String []{ num, num, num} );
    }
    
    
    
    public String castear(String resultado, String operando1,int op, int val1){ //op 0 entero 1 real 2 entero matriz 3 real matriz 4 cadena -1 otros //val 0 valor 1 variable
        String temp = "";
        switch(op){
            case 0:
                cabecera.marcar(_ENT_A_DOUBLE); //  _ent_a_double //5
                temp = operar_unario(_ent_a_real, operando1, resultado, val1);
                break;
            case 1:
                cabecera.marcar(_DOUBLE_A_ENT); // _double_a_ent //6
                temp = operar_unario(_real_a_ent, operando1, resultado, val1);
                break;
        }
        return temp;
    }
    public String llamar_suma(String operando1, String operando2, String resultado, int op, int val1, int val2){
        String temp = "";
        
        switch(op){
            case 0:
                cabecera.marcar(_ESUMA); // _esuma //7
                temp = operar_binario(_esuma, operando1, operando2, resultado, val1, val2);
                break;
            case 1:
                cabecera.marcar(_RSUMA); // _rsuma //22
                temp = operar_binario(_rsuma, operando1, operando2, resultado, val1, val2);
                break;
        }
        return temp;
    }
    
    public String llamar_resta(String operando1, String operando2, String resultado, int op, int val1, int val2){
        String temp = "";
        switch(op){
            case 0:
                cabecera.marcar(_ERESTA); //_eresta //8
                temp = operar_binario(_eresta, operando1, operando2, resultado, val1, val2);
                break;
            case 1:
                cabecera.marcar(_RRESTA); //_rresta //23
                temp = operar_binario(_rresta, operando1, operando2, resultado, val1, val2);
                break;
        }
        return temp;
    }
    public String llamar_division(String operando1, String operando2, String resultado, int op, int val1, int val2){
        String temp = "";
        switch(op){
            case 0:
                cabecera.marcar(_EDIVISION); //_edivision //9
                temp = operar_binario(_edivision, operando1, operando2, resultado, val1, val2);
                break;
            case 1:
                cabecera.marcar(_RDIVISION); //_rdivision //24
                temp = operar_binario(_rdivision, operando1, operando2, resultado, val1, val2);
                break;
        }
        return temp;
    }
    public String llamar_producto(String operando1, String operando2, String resultado, int op, int val1, int val2){
        String temp = "";
        switch(op){
            case 0:
                cabecera.marcar(_EPRODUCTO); //
                temp = operar_binario(_eproducto, operando1, operando2, resultado, val1, val2);
                break;
            case 1:
                cabecera.marcar(_RPRODUCTO); //
                temp = operar_binario(_rproducto, operando1, operando2, resultado, val1, val2);
                break;
        }
        return temp;
    }
    public String llamar_modulo(String operando1, String operando2, String resultado, int op, int val1, int val2){
        String temp = "";
        switch(op){
            case 0:
                cabecera.marcar(_EMODULO); //
                temp = operar_binario(_emodulo, operando1, operando2, resultado, val1, val2);
                break;
            case 1:
                cabecera.marcar(_RMODULO); //
                temp = operar_binario(_rmodulo, operando1, operando2, resultado, val1, val2);
                break;
        }
        return temp;
    }
    public String llamar_mayor(String operando1, String operando2, String resultado, int op, int val1, int val2){
        String temp = "";
        switch(op){
            case 0:
                cabecera.marcar(_EMAYOR);
                temp = operar_binario(_emayor, operando1, operando2, resultado, val1, val2);
                break;
            case 1:
                cabecera.marcar(_RMAYOR);
                temp = operar_binario(_rmayor, operando1, operando2, resultado, val1, val2);
                break;
        }
        return temp;
    }
    public String llamar_menor(String operando1, String operando2, String resultado, int op, int val1, int val2){
        String temp = "";
        switch(op){
            case 0:
                cabecera.marcar(_EMENOR);
                temp = operar_binario(_emenor, operando1, operando2, resultado, val1, val2);
                break;
            case 1:
                cabecera.marcar(_RMENOR);
                temp = operar_binario(_rmenor, operando1, operando2, resultado, val1, val2);
                break;
        }
        return temp;
    }
    public String llamar_mayor_igual(String operando1, String operando2, String resultado, int op, int val1, int val2){
        String temp = "";
        switch(op){
            case 0:
                cabecera.marcar(_EMAYOR_IGUAL);
                temp = operar_binario(_emayor_igual, operando1, operando2, resultado, val1, val2);
                break;
            case 1:
                cabecera.marcar(_RMAYOR_IGUAL);
                temp = operar_binario(_rmayor_igual, operando1, operando2, resultado, val1, val2);
                break;
        }
        return temp;
    }
    public String llamar_menor_igual(String operando1, String operando2, String resultado, int op, int val1, int val2){
        String temp = "";
        switch(op){
            case 0:
                cabecera.marcar(_EMENOR_IGUAL);
                temp = operar_binario(_emenor_igual, operando1, operando2, resultado, val1, val2);
                break;
            case 1:
                cabecera.marcar(_RMENOR_IGUAL);
                temp = operar_binario(_rmenor_igual, operando1, operando2, resultado, val1, val2);
                break;
        }
        return temp;
    }
    public String llamar_conjuncion(String operando1, String operando2, String resultado, int op, int val1, int val2){
        String temp = "";
        switch(op){
            case 0:
                cabecera.marcar(_ECONJUNCION);
                temp = operar_binario(_econjuncion, operando1, operando2, resultado, val1, val2);
                break;
            case 1:
                cabecera.marcar(_RCONJUNCION);
                temp = operar_binario(_rconjuncion, operando1, operando2, resultado, val1, val2);
                break;
        }
        return temp;
    }
    public String llamar_disyuncion(String operando1, String operando2, String resultado, int op, int val1, int val2){
        String temp = "";
        switch(op){
            case 0:
                cabecera.marcar(_EDISYUNCION);
                temp = operar_binario(_edisyuncion, operando1, operando2, resultado, val1, val2);
                break;
            case 1:
                cabecera.marcar(_RDISYUNCION);
                temp = operar_binario(_rdisyuncion, operando1, operando2, resultado, val1, val2);
                break;
        }
        return temp;
    }
    public String llamar_identico(String operando1, String operando2, String resultado, int op, int val1, int val2){
        String temp = "";
        switch(op){
            case 0:
                cabecera.marcar(_EIDENTICO);
                temp = operar_binario(_eidentico, operando1, operando2, resultado, val1, val2);
                break;
            case 1:
                cabecera.marcar(_RIDENTICO);
                temp = operar_binario(_ridentico, operando1, operando2, resultado, val1, val2);
                break;
        }
        return temp;
    }
    public String llamar_diferente(String operando1, String operando2, String resultado, int op, int val1, int val2){
        String temp = "";
        switch(op){
            case 0:
                cabecera.marcar(_EDIFERENTE);
                temp = operar_binario(_ediferente, operando1, operando2, resultado, val1, val2);
                break;
            case 1:
                cabecera.marcar(_RDIFERENTE);
                temp = operar_binario(_rdiferente, operando1, operando2, resultado, val1, val2);
                break;
        }
        return temp;
    }
    public String llamar_negacion(String operando1, String operando2, String resultado, int op, int val1, int val2){
        String temp = "";
        switch(op){
            case 0:
                cabecera.marcar(_ENEGACION);
                temp = operar_unario(_enegacion, operando1, resultado, val1);
                break;
            case 1:
                cabecera.marcar(_RNEGACION);
                temp = operar_unario(_rnegacion, operando1, resultado, val1);
                break;
        }
        return temp;
    }
    public String llamar_negatividad(String operando1, String operando2, String resultado, int op, int val1, int val2){
        String temp = "";
        switch(op){
            case 0:
                cabecera.marcar(_ENEGATIVIDAD);
                temp = operar_unario(_enegatividad, operando1, resultado, val1);
                break;
            case 1:
                cabecera.marcar(_RNEGATIVIDAD);
                temp = operar_unario(_rnegatividad, operando1, resultado, val1);
                break;
        }
        return temp;
    }
    // Generar llamada para operaciones
    public String operar_binario(String operacion, String operando1, String operando2, String resultado, int val1, int val2){ //op 0 entero 1 real 2 entero matriz 3 real matriz 4 cadena -1 otros //val 0 valor 1 variable
        if(val1==1)
            operando1 = "%" + operando1;
        if(val2==1)
            operando2 = "%" + operando2;

        return unir(operacion, new String []{ resultado, operando1, operando2} );
    }
    public String operar_unario(String operacion, String operando1, String resultado, int val1){ //op 0 entero 1 real 2 entero matriz 3 real matriz 4 cadena -1 otros //val 0 valor 1 variable
        if(val1==1)
            operando1 = "%" + operando1;

        return unir(operacion, new String []{ resultado, operando1} );
    }
    
    
    
    //Operaciones de ayuda
    private String unir(String error, String[] datos){
        int index = -1;
        
        for (String dato : datos) {
            index = error.indexOf("$", index + 1);
            error = error.substring(0, index) + dato + error.substring(index+1);
        }
        return error;
    }
    private String llenar_arg(String[] datos, int[] tipos){
        String error="";
        int index = -1;
        String coma = "";
        int i = 0;
        int tipo;
        for (String dato : datos) {
            tipo = tipos[i];
            if(tipo == 0)
                error = error + coma + " i32 %"+dato ;
            else if(tipo == 1)
                error = error + coma + " double %"+dato;
            coma = ",";
            i++;
        }
        return error;
    }
    private String llenar_vec(String error, String tipo){
        if(error.length() == 0)
            return error;
        int index = -1;
        error = tipo + " " + error;
        index = error.indexOf(",", index + 1);
        while(index != -1) {
            error = error.substring(0, index) + "," + tipo + " "+ error.substring(index+1);
            index = error.indexOf(",", index + 1);
        }
        return error;
    }
    public String finalizar(){
        return cabecera.todaCabecera();
    }
}
