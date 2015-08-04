package lema.generadorCodigo;

public class Compilador {   
   /*
     

    //Principal
    
    public String _iniPrincipal = "define i32 @main() nounwind readnone optsize {\n";
    public String _terPrincipal = "ret i32 0\n" +
                                  "}";
    
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
    
    //Imprimir 
    public String _str_ie = "@.str_ie = private unnamed_addr constant [3 x i8] c\"%d\\00\", align 1\n";
    public String _str_ir = "@.str_ir = private unnamed_addr constant [4 x i8] c\"%lf\\00\", align 1\n";
    public String _str_pe = "@.str_pe = private unnamed_addr constant [4 x i8] c\"%i\\0A\\00\", align 1\n";
    public String _str_pr = "@.str_pr = private unnamed_addr constant [5 x i8] c\"%lf\\0A\\00\", align 1\n";     
            
    public String _eimprimir = "call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([12 x i8]* @.str_pe, i32 0, i32 0), i32 %$) nounwind optsize\n";
    public String _rimprimir = "call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([12 x i8]* @.str_pr, i32 0, i32 0), double %$) nounwind optsize\n";
    
    public String _eleer = "%$ = alloca i32, align 4\n" +
                            "store i32 0, i32* %$, align 4, !tbaa !0\n" +
                            "call i32 (i8*, ...)* @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8]* @.str_ie, i32 0, i32 0), i32* %$) nounwind optsize\n";
    public String _rleer = "%$ = alloca double, align 8\n" +
                            "store double 0.000000e+00, double* %$, align 8, !tbaa !3\n" +
                            "call i32 (i8*, ...)* @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8]* @.str_ir, i32 0, i32 0), double* %$) nounwind optsize\n";

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
    
    
    //Incremento y decremento
    public String _eincrementar = "%$ = tail call i32 @_eincrementar(i32 $)\n";
    public String _edecrementar = "%$ = tail call i32 @_edecrementar(i32 $)\n";
    public String _rincrementar = "%$ = tail call double @_rincrementar(double $)\n";
    public String _rdecrementar = "%$ = tail call double @_rdecrementar(double $)\n";
    
    //Operaciones con enteros
    public String _esuma = "%$ = tail call i32 @_esuma(i32 $, i32 $)\n";
    public String _eresta = "%$ = tail call i32 @_eresta(i32 $, i32 $)\n";
    public String _edivision = "%$ = tail call i32 @_edivision(i32 $, i32 $)\n";
    public String _eproducto = "%$ = tail call i32 @_eproducto(i32 $, i32 $)\n";
    public String _emodulo = "%$ = tail call i32 @_emodulo(i32 $, i32 $)\n";
    public String _emayor = "%$ = tail call i32 @_emayor(i32 $, i32 $)\n";
    public String _emenor = "%$ = tail call i32 @_emenor(i32 $, i32 $)\n";
    public String _emayor_igual = "%$ = tail call i32 @_emayor_igual(i32 $, i32 $)\n";
    public String _emenor_igual = "%$ = tail call i32 @_emenor_igual(i32 $, i32 $)\n";
    public String _econjuncion = "%$ = tail call i32 @_econjuncion(i32 $, i32 $)\n";
    public String _edisyuncion = "%$ = tail call i32 @_edisyuncion(i32 $, i32 $)\n";
    public String _eidentico = "%$ = tail call i32 @_eidentico(i32 $, i32 $)\n";
    public String _ediferente = "%$ = tail call i32 @_ediferente(i32 $, i32 $)\n";
    public String _enegacion = "%$ = tail call i32 @_enegacion(i32 $)\n";
    public String _enegatividad = "%$ = tail call i32 @_enegatividad(i32 $)\n";
    
    //Operaciones con reales
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
    
    public String suma = "define i32 @square_unsigned(i32 %a) {\n" +
                    "  %1 = add i32 %a, %a\n" +
                    "  ret i32 %1\n"
                    ;
    public String division = "define i32 @square_unsigned(i32 %a) {\n" +
                    "  %1 = div i32 %a, %a\n" +
                    "  ret i32 %1\n"
                    ;
    public String producto = "define i32 @square_unsigned(i32 %a) {\n" +
                    "  %1 = mul i32 %a, %a\n" +
                    "  ret i32 %1\n"
                    ;
    public String mainllini = "define i32 @main() nounwind  readnone optsize{";
    public String mainllter = "ret i32 0\n"+
                              "}";
    public String operaciones;
    
    
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
                r = llenar2(arg,tipos);
                r = unir(_fun_declarar_cabecera , new String []{ "i32", nom, r} );
                break;
            case 1:
                r = llenar2(arg,tipos);
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
        if(val==null)
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
                val = llenar(val,"i32");
                String te = ""+tam;
                if(var_con)
                    dec = unir(_emcdeclarar, new String[]{nom, te, val});
                else
                    dec = unir(_emvdeclarar, new String[]{nom, te, val});
                break;
            case 3:
                val = llenar(val,"double");
                String tr = ""+tam;
                if(var_con)
                    dec = unir(_rmcdeclarar, new String[]{nom, tr, val});
                else
                    dec = unir(_rmvdeclarar, new String[]{nom, tr, val});
                break;
        }
        return dec;
    }
    
    //Salida
    public String imprimir(String cadena, int tipo){
        String r = "";
        switch(tipo){
            case 0: 
                r = unir(_eimprimir, new String []{ cadena} );
                break;
            case 1:
                r = unir(_rimprimir, new String []{ cadena} );
                break;
        }
        return r;
    }
    public String leer(String cadena, int tipo){
        String r = "";
        switch(tipo){
            case 0: 
                r = unir(_eleer, new String []{ cadena, cadena, cadena} );
                break;
            case 1:
                r = unir(_rleer, new String []{ cadena, cadena, cadena} );
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
    
    
    //Operaciones de actualizacion
    public String llamar_eincrementar(String op, String resultado){
        return unir(_eincrementar, new String []{ resultado, op} );
    }
    public String llamar_edecrementar(String op, String resultado){
        return unir(_edecrementar, new String []{ resultado, op} );
    }
    public String llamar_rincrementar(String op, String resultado){
        return unir(_rincrementar, new String []{ resultado, op} );
    }
    public String llamar_rdecrementar(String op, String resultado){
        return unir(_rdecrementar, new String []{ resultado, op} );
    }
    
    
    // Generar llamada para operaciones con enteros
    
    public String llamar_esuma(String operando1, String operando2, String resultado){
        return unir(_esuma, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_eresta(String operando1, String operando2, String resultado){
        return unir(_eresta, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_edivision(String operando1, String operando2, String resultado){
        return unir(_edivision, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_eproducto(String operando1, String operando2, String resultado){
        return unir(_eproducto, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_emodulo(String operando1, String operando2, String resultado){
        return unir(_emodulo, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_emayor(String operando1, String operando2, String resultado){
        return unir(_emayor, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_emenor(String operando1, String operando2, String resultado){
        return unir(_emenor, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_emayor_igual(String operando1, String operando2, String resultado){
        return unir(_emayor_igual, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_emenor_igual(String operando1, String operando2, String resultado){
        return unir(_emenor_igual, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_econjuncion(String operando1, String operando2, String resultado){
        return unir(_econjuncion, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_edisyuncion(String operando1, String operando2, String resultado){
        return unir(_edisyuncion, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_eidentico(String operando1, String operando2, String resultado){
        return unir(_eidentico, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_ediferente(String operando1, String operando2, String resultado){
        return unir(_ediferente, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_enegacion(String operando, String resultado){
        return unir(_enegacion, new String []{ resultado, operando} );
    }
    public String llamar_enegatividad(String operando, String resultado){
        return unir(_enegatividad, new String []{ resultado, operando} );
    }
    
    // Generar llamada para operaciones con reales
    
    public String llamar_rsuma(String operando1, String operando2, String resultado){
        return unir(_rsuma, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_rresta(String operando1, String operando2, String resultado){
        return unir(_rresta, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_rdivision(String operando1, String operando2, String resultado){
        return unir(_rdivision, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_rproducto(String operando1, String operando2, String resultado){
        return unir(_rproducto, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_rmodulo(String operando1, String operando2, String resultado){
        return unir(_rmodulo, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_rmayor(String operando1, String operando2, String resultado){
        return unir(_rmayor, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_rmenor(String operando1, String operando2, String resultado){
        return unir(_rmenor, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_rmayor_igual(String operando1, String operando2, String resultado){
        return unir(_rmayor_igual, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_rmenor_igual(String operando1, String operando2, String resultado){
        return unir(_rmenor_igual, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_rconjuncion(String operando1, String operando2, String resultado){
        return unir(_rconjuncion, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_rdisyuncion(String operando1, String operando2, String resultado){
        return unir(_rdisyuncion, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_ridentico(String operando1, String operando2, String resultado){
        return unir(_ridentico, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_rdiferente(String operando1, String operando2, String resultado){
        return unir(_rdiferente, new String []{ resultado, operando1, operando2} );
    }
    public String llamar_rnegacion(String operando, String resultado){
        return unir(_rnegacion, new String []{ resultado, operando} );
    }
    public String llamar_rnegatividad(String operando, String resultado){
        return unir(_rnegatividad, new String []{ resultado, operando} );
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
    private String llenar2(String[] datos, int[] tipos){
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
    private String llenar(String error, String tipo){
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
    */ 
   
}
