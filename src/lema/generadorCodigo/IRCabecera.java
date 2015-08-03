package lema.generadorCodigo;

public class IRCabecera {
    //Imprimir
    public String _imprimir_cab = "declare i32 @printf(i8* nocapture, ...) nounwind optsize\n"; //0
    public String _str_ie = "@.str_ie = private unnamed_addr constant [3 x i8] c\"%d\\00\", align 1\n"; //1  //leer
    public String _str_ir = "@.str_ir = private unnamed_addr constant [4 x i8] c\"%lf\\00\", align 1\n"; //2 //leer
    public String _str_pe = "@.str_pe = private unnamed_addr constant [12 x i8] c\"%i\\0A\\00\", align 1\n"; //3 //imprimir
    public String _str_pr = "@.str_pr = private unnamed_addr constant [12 x i8] c\"%F\\0A\\00\", align 1\n";//4  //imprimir
    
    //Operaciones
    public String _ent_a_real = "define double @_ent_a_real(i32 %a) nounwind readnone optsize {\n" +
                                "  %1 = sitofp i32 %a to double\n" +
                                "  ret double %1\n" +
                                "}\n";//5
    public String _real_a_ent ="define i32 @_real_a_ent(double %a) nounwind readnone optsize {\n" +
                                "  %1 = fptosi double %a to i32\n" +
                                "  ret i32 %1\n" +
                                "}\n";//6
    public String _esuma ="define i32 @_esuma(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fptosi double %a to i32\n" +
                            "  %2 = sitofp i32 %1 to double\n" +
                            "  %3 = fadd double %2, %b\n" +
                            "  %4 = fptosi double %3 to i32\n" +
                            "  ret i32 %4\n" +
                            "}\n";//7
    public String _eresta ="define i32 @_eresta(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fptosi double %a to i32\n" +
                            "  %2 = sitofp i32 %1 to double\n" +
                            "  %3 = fsub double %2, %b\n" +
                            "  %4 = fptosi double %3 to i32\n" +
                            "  ret i32 %4\n" +
                            "}\n";//8
    public String _edivision = "define i32 @_edivision(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fptosi double %a to i32\n" +
                            "  %2 = sitofp i32 %1 to double\n" +
                            "  %3 = fdiv double %2, %b\n" +
                            "  %4 = fptosi double %3 to i32\n" +
                            "  ret i32 %4\n" +
                            "}\n";//9
    public String _eproducto ="define i32 @_eproducto(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fptosi double %a to i32\n" +
                            "  %2 = sitofp i32 %1 to double\n" +
                            "  %3 = fmul double %2, %b\n" +
                            "  %4 = fptosi double %3 to i32\n" +
                            "  ret i32 %4\n" +
                            "}\n";//10
    public String _emodulo = "define i32 @_emodulo(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fptosi double %a to i32\n" +
                            "  %2 = fptosi double %b to i32\n" +
                            "  %3 = srem i32 %1, %2\n" +
                            "  ret i32 %3\n" +
                            "}\n";//11
    public String _emayor = "define i32 @_emayor(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fptosi double %a to i32\n" +
                            "  %2 = sitofp i32 %1 to double\n" +
                            "  %3 = fcmp ogt double %2, %b\n" +
                            "  %4 = zext i1 %3 to i32\n" +
                            "  ret i32 %4\n" +
                            "}\n";//12
    public String _emenor ="define i32 @_emenor(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fptosi double %a to i32\n" +
                            "  %2 = sitofp i32 %1 to double\n" +
                            "  %3 = fcmp olt double %2, %b\n" +
                            "  %4 = zext i1 %3 to i32\n" +
                            "  ret i32 %4\n" +
                            "}\n";//13
    public String _emayor_igual = "define i32 @_emayor_igual(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fptosi double %a to i32\n" +
                            "  %2 = sitofp i32 %1 to double\n" +
                            "  %3 = fcmp oge double %2, %b\n" +
                            "  %4 = zext i1 %3 to i32\n" +
                            "  ret i32 %4\n" +
                            "}\n";//14
    public String _emenor_igual ="define i32 @_emenor_igual(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fptosi double %a to i32\n" +
                            "  %2 = sitofp i32 %1 to double\n" +
                            "  %3 = fcmp ole double %2, %b\n" +
                            "  %4 = zext i1 %3 to i32\n" +
                            "  ret i32 %4\n" +
                            "}\n";//15
    public String _econjuncion ="define i32 @_econjuncion(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fptosi double %a to i32\n" +
                            "  %2 = fptosi double %b to i32\n" +
                            "  %3 = and i32 %2, %1\n" +
                            "  ret i32 %3\n" +
                            "}\n";//16
    public String _edisyuncion ="define i32 @_edisyuncion(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fptosi double %a to i32\n" +
                            "  %2 = fptosi double %b to i32\n" +
                            "  %3 = or i32 %2, %1\n" +
                            "  ret i32 %3\n" +
                            "}\n";//17
    public String _eidentico ="define i32 @_eidentico(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fptosi double %a to i32\n" +
                            "  %2 = sitofp i32 %1 to double\n" +
                            "  %3 = fcmp oeq double %2, %b\n" +
                            "  %4 = zext i1 %3 to i32\n" +
                            "  ret i32 %4\n" +
                            "}\n";//18
    public String _ediferente ="define i32 @_ediferente(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fptosi double %a to i32\n" +
                            "  %2 = sitofp i32 %1 to double\n" +
                            "  %3 = fcmp une double %2, %b\n" +
                            "  %4 = zext i1 %3 to i32\n" +
                            "  ret i32 %4\n" +
                            "}\n";//19
    public String _enegacion = "define i32 @_enegacion(double %a) nounwind readnone optsize {\n" +
                            "  %1 = fcmp oeq double %a, 0.000000e+00\n" +
                            "  %2 = zext i1 %1 to i32\n" +
                            "  ret i32 %2\n" +
                            "}\n";//20
    public String _enegatividad = "define i32 @_enegatividad(double %a) nounwind readnone optsize {\n" +
                            "  %1 = fsub double -0.000000e+00, %a\n" +
                            "  %2 = fptosi double %1 to i32\n" +
                            "  ret i32 %2\n" +
                            "}\n";//21
    public String _rsuma = "define double @_rsuma(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fadd double %a, %b\n" +
                            "  ret double %1\n" +
                            "}\n";//22
    public String _rresta = "define double @_rresta(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fsub double %a, %b\n" +
                            "  ret double %1\n" +
                            "}\n";//23
    public String _rdivision = "define double @_rdivision(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fdiv double %a, %b\n" +
                            "  ret double %1\n" +
                            "}\n";//24
    public String _rproducto = "define double @_rproducto(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fmul double %a, %b\n" +
                            "  ret double %1\n" +
                            "}\n";//25
    public String _rmodulo = "define double @_rmodulo(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fptosi double %a to i32\n" +
                            "  %2 = fptosi double %b to i32\n" +
                            "  %3 = srem i32 %1, %2\n" +
                            "  %4 = sitofp i32 %3 to double\n" +
                            "  ret double %4\n" +
                            "}\n";//26
    public String _rmayor = "define double @_rmayor(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fcmp ogt double %a, %b\n" +
                            "  %2 = zext i1 %1 to i32\n" +
                            "  %3 = sitofp i32 %2 to double\n" +
                            "  ret double %3\n" +
                            "}\n";//27
    public String _rmenor = "define double @_rmenor(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fcmp olt double %a, %b\n" +
                            "  %2 = zext i1 %1 to i32\n" +
                            "  %3 = sitofp i32 %2 to double\n" +
                            "  ret double %3\n" +
                            "}\n";//28
    public String _rmayor_igual = "define double @_rmayor_igual(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fcmp oge double %a, %b\n" +
                            "  %2 = zext i1 %1 to i32\n" +
                            "  %3 = sitofp i32 %2 to double\n" +
                            "  ret double %3\n" +
                            "}\n";//29
    public String _rmenor_igual = "define double @_rmenor_igual(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fcmp ole double %a, %b\n" +
                            "  %2 = zext i1 %1 to i32\n" +
                            "  %3 = sitofp i32 %2 to double\n" +
                            "  ret double %3\n" +
                            "}\n";//30
    public String _rconjuncion = "define double @_rconjuncion(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fptosi double %a to i32\n" +
                            "  %2 = fptosi double %b to i32\n" +
                            "  %3 = and i32 %2, %1\n" +
                            "  %4 = sitofp i32 %3 to double\n" +
                            "  ret double %4\n" +
                            "}\n";//31
    public String _rdisyuncion = "define double @_rdisyuncion(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fptosi double %a to i32\n" +
                            "  %2 = fptosi double %b to i32\n" +
                            "  %3 = or i32 %2, %1\n" +
                            "  %4 = sitofp i32 %3 to double\n" +
                            "  ret double %4\n" +
                            "}\n";//32
    public String _ridentico = "define double @_ridentico(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fcmp oeq double %a, %b\n" +
                            "  %2 = zext i1 %1 to i32\n" +
                            "  %3 = sitofp i32 %2 to double\n" +
                            "  ret double %3\n" +
                            "}\n";//33
    public String _rdiferente = "define double @_rdiferente(double %a, double %b) nounwind readnone optsize {\n" +
                            "  %1 = fcmp une double %a, %b\n" +
                            "  %2 = zext i1 %1 to i32\n" +
                            "  %3 = sitofp i32 %2 to double\n" +
                            "  ret double %3\n" +
                            "}\n";//34
    public String _rnegacion = "define double @_rnegacion(double %a) nounwind readnone optsize {\n" +
                            "  %1 = fcmp oeq double %a, 0.000000e+00\n" +
                            "  %2 = zext i1 %1 to i32\n" +
                            "  %3 = sitofp i32 %2 to double\n" +
                            "  ret double %3\n" +
                            "}\n";//35
    public String _rnegatividad = "define double @_rnegatividad(double %a) nounwind readnone optsize {\n" +
                            "  %1 = fsub double -0.000000e+00, %a\n" +
                            "  ret double %1\n" +
                            "}\n";//36
    //public String ="";
    
    public static boolean[] cabecera = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};

    public void marcar(int pos){
        cabecera[pos] = true;
    }
    public String getCab()
    {
        String temp ="";
        for(int i = 0; i < cabecera.length; i++)
            if(cabecera[i])
                temp += ret(i);
        return temp;
    }
    public String ret(int pos)
    {
        String tmp="";
        switch(pos)
        {
            case 0: return _imprimir_cab; //0
            case 1: return _str_ie ; //1
            case 2: return _str_ir; //2
            case 3: return _str_pe; //3
            case 4: return _str_pr; //4
            case 5: return _ent_a_real; //5
            case 6: return _real_a_ent; //6
            case 7: return _esuma; //7
            case 8: return _eresta; //8
            case 9: return _edivision; //9
            case 10: return _eproducto; //10
            case 11: return _emodulo; //11
            case 12: return _emayor; //12
            case 13: return _emenor; //13
            case 14: return _emayor_igual; //14
            case 15: return _emenor_igual; //15
            case 16: return _econjuncion; //16
            case 17: return _edisyuncion; //17
            case 18: return _eidentico; //18
            case 19: return _ediferente; //19
            case 20: return _enegacion; //20
            case 21: return _enegatividad; //21
            case 22: return _rsuma; //22
            case 23: return _rresta; //23
            case 24: return _rdivision; //24
            case 25: return _rproducto; //25
            case 26: return _rmodulo; //26
            case 27: return _rmayor; //27
            case 28: return _rmenor; //28
            case 29: return _rmayor_igual; //29
            case 30: return _rmenor_igual; //30
            case 31: return _rconjuncion; //31
            case 32: return _rdisyuncion; //32
            case 33: return _ridentico; //33
            case 34: return _rdiferente; //34
            case 35: return _rnegacion; //35
            case 36: return _rnegatividad; //36
        }
        return tmp;
    }
    public String todaCabecera()
    {
        String temp = "";
        for(int i = 0; i < cabecera.length; i++)
        {
            if(cabecera[i])
                temp += ret(i);
        }
        return temp;
    }
}
