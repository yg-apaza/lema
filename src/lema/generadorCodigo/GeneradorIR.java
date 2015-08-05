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
    
    //Matriz
    public static final int  _MAT_DEF =38;
    public static final int  _MAT_RRESERVAR =39;
    public static final int  _MAT_ERESERVAR =40;
    public static final int  _MAT_ENT_A_REAL =41;
    public static final int  _MAT_REAL_A_ENT =42;
    public static final int  _MAT_RPONER =43;
    public static final int  _MAT_EPONER =44;
    public static final int  _MAT_RSUMA =45;
    public static final int  _MAT_ESUMA =46;
    public static final int  _MAT_RRESTA=47;
    public static final int  _MAT_ERESTA=48;
    public static final int  _MAT_RIMPRIMIR=49;
    public static final int  _MAT_EIMPRIMIR=50;
    public static final int  _MAT_IMPRIMIR_CABECERA_E=51;
    public static final int  _MAT_IMPRIMIR_CABECERA_R=52;
    public static final int  _MAT_DEFAULT_POS=53;
    
    public static final int  STR_ERROR=54;
    public static final int  _MAT_COMPROBAR=55;
    
    public static final int _STR_ERROR2 = 56;
    public static final int _MAT_COMPROBAR_TAM = 57;
    
    
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
    
    public String dec_def_e =  "define void @$.act_e(i32 %nuevo) nounwind optsize {\n" + //nom
                                "  store i32 %nuevo, i32* @$, align 4, !tbaa !0\n" +   //nom
                                "  ret void\n" +
                                "}\n" +
                                "define void @$.act_r(double %nuevo) nounwind optsize {\n" + //nom
                                "  %1 = fptosi double %nuevo to i32\n" +    //nom
                                "  store i32 %1, i32* @$, align 4, !tbaa !0\n" +
                                "  ret void\n" +
                                "}\n";
    
    public String dec_def_r =  "define void @$.act_d(double %nuevo) nounwind optsize {\n" + //nom
                                "  store double %nuevo, double* @$, align 8, !tbaa !3\n" +
                                "  ret void\n" +
                                "}\n" +
                                "\n" +
                                "define void @$.act_e(i32 %nuevo) nounwind optsize {\n" + //nom
                                "  %1 = sitofp i32 %nuevo to double\n" +
                                "  store double %1, double* @$, align 8, !tbaa !3\n" +
                                "  ret void\n" +
                                "}\n";
    public String act_rea_e_e= "call void @$.act_e(i32 %$)\n";
    public String act_rea_r_r= "call void @$.act_r(double %$)\n";
    public String act_rea_e_r= "call void @$.act_e(double %$)\n";
    public String act_rea_r_e= "call void @$.act_d(i32 %$)\n";
    
    
    public String _ecargar = "%$ = load i32* @$, align 4\n";
    public String _rcargar = "%$ = load double* @$, align 4\n";
    
    //Imprimir 
    public String _str_c = "@.str_c$ = private unnamed_addr constant [$ x i8] c\"$\\00\", align 1\n";  //$id $tamaño  $ = mensaje
    
    public String _eimprimir = "call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([4 x i8]* @.str_pe, i32 0, i32 0), i32 %$) nounwind optsize\n";
    public String _rimprimir = "call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.str_pr, i32 0, i32 0), double %$) nounwind optsize\n";
    public String _cimprimir = "call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([$ x i8]* @.str_c$, i32 0, i32 0)) nounwind optsize\n"; //$ tamaño $id
    
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
    
    
   
    public String mainllini = "define i32 @main() nounwind  readnone optsize{";
    public String mainllter = "ret i32 0\n"+
                              "}";
    public String _posterior = "";
    
    
    //Matriz
    public String _dec_matriz_tam = "@$.fila = constant i32 $, align 4\n" +  
                                        "@$.columna = constant i32 $, align 4\n" +
                                        "define i32 @$.getFila() nounwind readnone optsize {\n" +
                                        "  %1 = load i32*  @$.fila, align 4\n" +
                                        "  ret i32 %1\n" +
                                        "}\n" +
                                        "define i32 @$.getColumna() nounwind readnone optsize {\n" +
                                        "  %1 = load i32*  @$.columna, align 4\n" +
                                        "  ret i32 %1\n" +
                                        "}\n"; ////Nom val - Nom Val - Nom Nom - Nom Nom 
    public String _mat_iniciar_e = "  %$.f = tail call i32 @$.getFila()\n" +
                                "  %$.c = tail call i32 @$.getColumna()\n" +
                                "  %$ = tail call i32** @_mat_ereservar(i32** undef, i32 %$.f, i32 %$.c) optsize\n"; //Nom Nom - Nom Nom - Nom Nom Nom
    public String _mat_iniciar_r = "$.f = tail call i32 @matriz_getFila()\n" +
                                "  %$.c = tail call i32 @matriz_getColumna()\n" +
                                "  %$ = tail call double** @_mat_rreservar(double** undef, i32 %$.f, i32 %$.c) optsize\n"; //Nom Nom - Nom Nom - Nom Nom Nom
    
    public String _mat_comprobar = "%$ = tail call i32 @$.getFila()\n" + //alea nom
                                    "%$ = tail call i32 @$.getColumna()\n" + //laea nom
                                    "%$ = tail call i32 @$.getFila()\n" + //alea nom
                                    "%$ = tail call i32 @$.getColumna()\n" + //laea nom
                                    "%$ = tail call i32 @_mat_comprobar(i32 $, i32 $, i32 $, i32 $)\n"; //R f1 c1 f2 c2

    public String _mat_comprobar_tam = "%$ = tail call i32 @$.getFila()\n" + //alea nom
                                    "%$ = tail call i32 @$.getColumna()\n" + //laea nom
                                    "%$ = tail call i32 @_mat_comprobar_tam(i32 $, i32 $, i32 $, i32 $)\n"; //R f1 c1 v1 v2
    
    public String _mat_eponer = "call i32** @_mat_eponer(i32** $, i32 $, i32 $, i32 $)\n"; //rpta mat fil col val
    public String _mat_rponer = "call double** @_mat_rponer(double** $, i32 $, i32 $, double $)"; //rpta mat fil col val
    
    public String _mat_eimprimir =  "%$ = tail call i32 @$.getFila()\n" + //alea nom
                                    "%$ = tail call i32 @$.getColumna()\n" + //laea nom
                                    "call void @_mat_eimprimir(i32** %$, i32 %$, i32 %$) optsize\n"; // mat fil col
    public String _mat_rimprimir =  "%$ = tail call i32 @$.getFila()\n" + //alea nom
                                    "%$ = tail call i32 @$.getColumna()\n" + //laea nom
                                    "call void @_mat_rimprimir(double** %$, i32 %$, i32 %$) optsize\n"; // mat fil col
    
    public String _mat_ent_a_real  = "%$ = tail call i32 @$.getFila()\n" + //alea nom
                                    "%$ = tail call i32 @$.getColumna()\n" + //laea nom
                                    "%$ = tail call double** @_mat_ent_a_real(i32** %$, i32 %$, i32 %$)\n"; //rpta mat fil col
    
    public String _mat_real_a_ent  = "%$ = tail call i32 @$.getFila()\n" + //alea nom
                                    "%$ = tail call i32 @$.getColumna()\n" + //laea nom
                                    "%z = tail call int** @_mat_real_a_ent(double** %4, i32 5, i32 4)\n"; //rpta mat fil col
     
    public String _mat_esuma = "%$ = tail call i32 @$.getFila()\n" + //alea nom
                                "%$ = tail call i32 @$.getColumna()\n" + //laea nom
                                "%$ = tail call i32 @$.getFila()\n" + //alea nom
                                "%$ = tail call i32 @$.getColumna()\n" + //laea nom
                                "%$ = tail call i32** @_mat_esuma(double** %$, double** %$, i32 %$, i32 %$) optsize\n";
    public String _mat_rsuma = "%$ = tail call i32 @$.getFila()\n" + //alea nom
                                "%$ = tail call i32 @$.getColumna()\n" + //laea nom
                                "%$ = tail call i32 @$.getFila()\n" + //alea nom
                                "%$ = tail call i32 @$.getColumna()\n" + //laea nom
                                "%$ = tail call double** @_mat_rsuma(double** %$, double** %$, i32 %$, i32 %$) optsize\n";
    
    
    
    
    public int contador = 1;
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
    public String declararVariable(String nom, String val, int tipo, boolean var_con){ //0 entero 1 real 2 entero matriz 3 real matriz 4 cadena -1 otros
        String dec = "";                                                               //true constante false variable 
        if(val.length()==0)
            val = _inicializarZeros;
        
        switch(tipo){
            case 0:
                _posterior += unir(dec_def_e, new String[]{nom, nom, nom, nom});
                if(var_con)
                    dec = unir(_evdeclarar, new String[]{nom, val});
                else
                    dec = unir(_ecdeclarar, new String[]{nom, val});
                break;
            case 1:
                _posterior += unir(dec_def_r, new String[]{nom, nom, nom, nom});
                if(var_con)
                    dec = unir(_rvdeclarar, new String[]{nom, val});
                else
                    dec = unir(_rcdeclarar, new String[]{nom, val});
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
    public String imprimir_cadena_cabecera(String id, String mensaje, String tam){
        cabecera.marcar(_IMPRIMIR_CAB); //l 
        return unir(_str_c, new String []{ id, tam, mensaje} );
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
                _posterior += imprimir_cadena_cabecera(id, cadena, tam);
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
    public String actualizar(String nom, String nuevo, int tipo, int tipoEnt){
        cabecera.marcar(_MAT_DEFAULT_POS);
        String tmp = "";
        switch(tipo){
           case 0:
               if(tipoEnt == 0)
                   return unir(act_rea_e_e, new String[]{nom, nuevo});
               else 
                   return unir(act_rea_e_r, new String[]{nom, nuevo});
           case 1:
               if(tipoEnt == 0)
                    return unir(act_rea_r_e, new String[]{nom, nuevo});
               else 
                   return unir(act_rea_r_r, new String[]{nom, nuevo});
       }   
       return tmp;
    }
    
    //MATRICES
    
    public String declarar_matriz(String nom, String fil, String col, int tipo){ //0 entero //0 real
        cabecera.marcar(_MAT_DEF );
        cabecera.marcar(_MAT_DEFAULT_POS);
        String tmp = "";
        switch(tipo){
            case 0:
                tmp = unir(_mat_iniciar_e, new String []{nom,nom,nom,nom,nom,nom,nom});
                cabecera.marcar(_MAT_ERESERVAR);
                break;
            case 1:
                tmp = unir(_mat_iniciar_r, new String []{nom,nom,nom,nom,nom,nom,nom});
                cabecera.marcar(_MAT_RRESERVAR);
                break;
        }
        _posterior +=  unir(_dec_matriz_tam, new String[]{nom, fil, nom, col, nom, nom, nom, nom}); // Nom val - Nom Val - Nom Nom - Nom Nom 
        return tmp;
    }
    public String mat_comprobar(String A, String B){
        cabecera.marcar(STR_ERROR);
        cabecera.marcar(_MAT_COMPROBAR);
        String at1 = generar_enumeracion();
        String at2 = generar_enumeracion();
        String bt1 = generar_enumeracion();
        String bt2 = generar_enumeracion();
        String rpta = generar_enumeracion();
        //f1 nom c1 nom 
        //f1 nom c1 nom //R f1 c1 f2 c2
        return unir(_mat_comprobar, new String[]{at1, A, at2, A, bt1, B, bt2, B, rpta, "%"+at1, "%"+at2, "%"+bt1, "%"+bt2});
    }
    public String _mat_comprobar_tam(String A, String ind1, String ind2, int var1, int var2){ //op 0 entero 1 real 2 entero matriz 3 real matriz 4 cadena -1 otros //val 0 valor 1 variable
        cabecera.marcar(_STR_ERROR2);
        cabecera.marcar(_MAT_COMPROBAR_TAM);
        if(var1==1)
            ind1 = "%" + ind1;
        if(var2==1)
            ind2 = "%" + ind2;
        String at1 = generar_enumeracion();
        String at2 = generar_enumeracion();
        String bt1 = generar_enumeracion();
        String bt2 = generar_enumeracion();
        String rpta = generar_enumeracion();
        //alea nom //alea nom //R f1 c1 v1 v2
        return unir(_mat_comprobar_tam, new String[]{at1, A, at2, A, rpta, "%"+at1, "%"+at2, ind1, ind2});
    }
    public String mat_ingresar_valor(String A, String ind1, String ind2, String val, int tipo, int var1, int var2){
        String tmp= _mat_comprobar_tam(A, ind1, ind2, var1, var2);
        if(var1==1)
            ind1 = "%" + ind1;
        if(var2==1)
            ind2 = "%" + ind2;
        switch(tipo){
            case 0:
                cabecera.marcar(_MAT_EPONER);
                tmp = tmp + unir(_mat_eponer, new String[]{ "%"+A, ind1, ind2, val}); //rpta mat fil col val
                break;
            case 1:
                cabecera.marcar(_MAT_RPONER);
                tmp = tmp + unir(_mat_eponer, new String[]{ "%"+A, ind1, ind2, val}); //rpta mat fil col val
                break;
        }
        return tmp;
    }
    public String mat_imprimir(String A, int tipo){
        String tmp = "";
        String at1 = generar_enumeracion();
        String at2 = generar_enumeracion();
        cabecera.marcar(_IMPRIMIR_CAB); 
        switch(tipo){
            case 0:
                cabecera.marcar(_MAT_EIMPRIMIR);
                cabecera.marcar(_MAT_IMPRIMIR_CABECERA_E);
                return unir(_mat_eimprimir , new String[]{at1, A, at2, A, A, at1, at2}); //alea nom //laea nom // mat fil col
            case 1:
                cabecera.marcar(_MAT_RIMPRIMIR);
                cabecera.marcar(_MAT_IMPRIMIR_CABECERA_R);
                return unir(_mat_rimprimir , new String[]{at1, A, at2, A, A, at1, at2}); //alea nom //laea nom // mat fil col
        }
        return tmp;
    }
    public String mat_castear(String rpta, String A, int tipo){
        String tmp = "";
        String at1 = generar_enumeracion();
        String at2 = generar_enumeracion();
        cabecera.marcar(_IMPRIMIR_CAB); 
        
        switch(tipo){
            case 0:
                return unir(_mat_real_a_ent , new String[]{at1, A, at2, A, A, rpta, A, at1, at2}); //alea nom //alea nom //rpta mat fil col
            case 1:
                return unir(_mat_ent_a_real , new String[]{at1, A, at2, A, A, rpta, A, at1, at2}); //alea nom //alea nom //rpta mat fil col
        }
        return tmp;
    }
    public String mat_sumar(String rpta, String A, String B, int tipo ){
        String tmp= mat_comprobar(A,B);
        String fil1 = generar_enumeracion();
        String col1 = generar_enumeracion();
        String fil2 = generar_enumeracion();
        String col2 = generar_enumeracion();
        
        switch(tipo){
            case 0:
                cabecera.marcar(_MAT_ESUMA);
                tmp += unir(_mat_esuma , new String[]{fil1, A, col1, A, fil2, B, col2, B, rpta, A, B, fil1, col1}); //fil1 nom1 //col1 nom1 //fil2 nom2 //col2 nom2 //rpta nom1 nom2 fil1 col1
                break;
            case 1:
                cabecera.marcar(_MAT_RSUMA);
                tmp += unir(_mat_esuma , new String[]{fil1, A, col1, A, fil2, B, col2, B, rpta, A, B, fil1, col1}); //fil1 nom1 //col1 nom1 //fil2 nom2 //col2 nom2 //rpta nom1 nom2 fil1 col1
                break;
        }
        return tmp;
    }
    public String finalizar(){
        return _posterior + cabecera.todaCabecera();
    }
    public String generar_enumeracion(){
        return "enu."+(contador++);
    }
    
    
    
    public String arquitectura(){
        return cabecera.getArquitectura();
    }
    public void setArquitectura(boolean a){
        cabecera.setArquitectura(a);
    }
}
