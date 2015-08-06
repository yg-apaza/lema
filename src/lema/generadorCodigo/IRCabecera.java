package lema.generadorCodigo;

public class IRCabecera {
    //Imprimir
    public String _imprimir_cab = "declare i32 @printf(i8* nocapture, ...) nounwind optsize\n"; 
    public String _leer_cab = "declare i32 @__isoc99_scanf(i8*, ...) optsize\n";
    public String _str_ie = "@.str_ie = private unnamed_addr constant [3 x i8] c\"%d\\00\", align 1\n"; //1  //leer
    public String _str_ir = "@.str_ir = private unnamed_addr constant [4 x i8] c\"%lf\\00\", align 1\n"; //2 //leer
    public String _str_pe = "@.str_pe = private unnamed_addr constant [4 x i8] c\"%i\\0A\\00\", align 1\n"; //3 //imprimir
    public String _str_pr = "@.str_pr = private unnamed_addr constant [5 x i8] c\"%lf\\0A\\00\", align 1\n";//4  //imprimir
    
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
    //MATRICES
    public String _mat_def = "declare noalias i8* @malloc(i32) nounwind optsize\n";
    public String _mat_rreservar = "define noalias double** @_mat_rreservar(double** nocapture %A, i32 %fil, i32 %col) nounwind optsize {\n" +
                            "  %1 = shl i32 %fil, 2\n" +
                            "  %2 = tail call noalias i8* @malloc(i32 %1) nounwind optsize\n" +
                            "  %3 = bitcast i8* %2 to double**\n" +
                            "  %4 = icmp sgt i32 %fil, 0\n" +
                            "  br i1 %4, label %.lr.ph, label %._crit_edge\n" +
                            "\n" +
                            ".lr.ph:                                           ; preds = %0\n" +
                            "  %5 = shl i32 %col, 3\n" +
                            "  br label %6\n" +
                            "\n" +
                            "; <label>:6                                       ; preds = %6, %.lr.ph\n" +
                            "  %i.01 = phi i32 [ 0, %.lr.ph ], [ %10, %6 ]\n" +
                            "  %7 = tail call noalias i8* @malloc(i32 %5) nounwind optsize\n" +
                            "  %8 = bitcast i8* %7 to double*\n" +
                            "  %9 = getelementptr inbounds double** %3, i32 %i.01\n" +
                            "  store double* %8, double** %9, align 4, !tbaa !0\n" +
                            "  %10 = add nsw i32 %i.01, 1\n" +
                            "  %exitcond = icmp eq i32 %10, %fil\n" +
                            "  br i1 %exitcond, label %._crit_edge, label %6\n" +
                            "\n" +
                            "._crit_edge:                                      ; preds = %6, %0\n" +
                            "  ret double** %3\n" +
                            "}\n";
    public String _mat_ereservar = "define noalias i32** @_mat_ereservar(i32** nocapture %A, i32 %fil, i32 %col) nounwind optsize {\n" +
                            "  %1 = shl i32 %fil, 2\n" +
                            "  %2 = tail call noalias i8* @malloc(i32 %1) nounwind optsize\n" +
                            "  %3 = bitcast i8* %2 to i32**\n" +
                            "  %4 = icmp sgt i32 %fil, 0\n" +
                            "  br i1 %4, label %.lr.ph, label %._crit_edge\n" +
                            "\n" +
                            ".lr.ph:                                           ; preds = %0\n" +
                            "  %5 = shl i32 %col, 2\n" +
                            "  br label %6\n" +
                            "\n" +
                            "; <label>:6                                       ; preds = %6, %.lr.ph\n" +
                            "  %i.01 = phi i32 [ 0, %.lr.ph ], [ %10, %6 ]\n" +
                            "  %7 = tail call noalias i8* @malloc(i32 %5) nounwind optsize\n" +
                            "  %8 = bitcast i8* %7 to i32*\n" +
                            "  %9 = getelementptr inbounds i32** %3, i32 %i.01\n" +
                            "  store i32* %8, i32** %9, align 4, !tbaa !0\n" +
                            "  %10 = add nsw i32 %i.01, 1\n" +
                            "  %exitcond = icmp eq i32 %10, %fil\n" +
                            "  br i1 %exitcond, label %._crit_edge, label %6\n" +
                            "\n" +
                            "._crit_edge:                                      ; preds = %6, %0\n" +
                            "  ret i32** %3\n" +
                            "}\n";
    
    public String _mat_ent_a_real = "define noalias double** @_mat_ent_a_real(i32** nocapture %A, i32 %fil, i32 %col) nounwind optsize {\n" +
                            "  %1 = tail call double** @_mat_rreservar(double** undef, i32 %fil, i32 %col) optsize\n" +
                            "  %2 = icmp sgt i32 %fil, 0\n" +
                            "  br i1 %2, label %.preheader.lr.ph, label %._crit_edge3\n" +
                            "\n" +
                            ".preheader.lr.ph:                                 ; preds = %0\n" +
                            "  %3 = icmp sgt i32 %col, 0\n" +
                            "  br label %.preheader\n" +
                            "\n" +
                            ".preheader:                                       ; preds = %._crit_edge, %.preheader.lr.ph\n" +
                            "  %i.02 = phi i32 [ 0, %.preheader.lr.ph ], [ %14, %._crit_edge ]\n" +
                            "  br i1 %3, label %.lr.ph, label %._crit_edge\n" +
                            "\n" +
                            ".lr.ph:                                           ; preds = %.preheader\n" +
                            "  %4 = getelementptr inbounds i32** %A, i32 %i.02\n" +
                            "  %5 = load i32** %4, align 4, !tbaa !0\n" +
                            "  %6 = getelementptr inbounds double** %1, i32 %i.02\n" +
                            "  %7 = load double** %6, align 4, !tbaa !0\n" +
                            "  br label %8\n" +
                            "\n" +
                            "; <label>:8                                       ; preds = %8, %.lr.ph\n" +
                            "  %j.01 = phi i32 [ 0, %.lr.ph ], [ %13, %8 ]\n" +
                            "  %9 = getelementptr inbounds i32* %5, i32 %j.01\n" +
                            "  %10 = load i32* %9, align 4, !tbaa !3\n" +
                            "  %11 = sitofp i32 %10 to double\n" +
                            "  %12 = getelementptr inbounds double* %7, i32 %j.01\n" +
                            "  store double %11, double* %12, align 4, !tbaa !4\n" +
                            "  %13 = add nsw i32 %j.01, 1\n" +
                            "  %exitcond = icmp eq i32 %13, %col\n" +
                            "  br i1 %exitcond, label %._crit_edge, label %8\n" +
                            "\n" +
                            "._crit_edge:                                      ; preds = %8, %.preheader\n" +
                            "  %14 = add nsw i32 %i.02, 1\n" +
                            "  %exitcond4 = icmp eq i32 %14, %fil\n" +
                            "  br i1 %exitcond4, label %._crit_edge3, label %.preheader\n" +
                            "\n" +
                            "._crit_edge3:                                     ; preds = %._crit_edge, %0\n" +
                            "  ret double** %1\n" +
                            "}\n";
    public String _mat_real_a_ent = "define noalias i32** @_mat_real_a_ent(double** nocapture %A, i32 %fil, i32 %col) nounwind optsize {\n" +
                            "  %1 = tail call i32** @_mat_ereservar(i32** undef, i32 %fil, i32 %col) optsize\n" +
                            "  %2 = icmp sgt i32 %fil, 0\n" +
                            "  br i1 %2, label %.preheader.lr.ph, label %._crit_edge3\n" +
                            "\n" +
                            ".preheader.lr.ph:                                 ; preds = %0\n" +
                            "  %3 = icmp sgt i32 %col, 0\n" +
                            "  br label %.preheader\n" +
                            "\n" +
                            ".preheader:                                       ; preds = %._crit_edge, %.preheader.lr.ph\n" +
                            "  %i.02 = phi i32 [ 0, %.preheader.lr.ph ], [ %14, %._crit_edge ]\n" +
                            "  br i1 %3, label %.lr.ph, label %._crit_edge\n" +
                            "\n" +
                            ".lr.ph:                                           ; preds = %.preheader\n" +
                            "  %4 = getelementptr inbounds double** %A, i32 %i.02\n" +
                            "  %5 = load double** %4, align 4, !tbaa !0\n" +
                            "  %6 = getelementptr inbounds i32** %1, i32 %i.02\n" +
                            "  %7 = load i32** %6, align 4, !tbaa !0\n" +
                            "  br label %8\n" +
                            "\n" +
                            "; <label>:8                                       ; preds = %8, %.lr.ph\n" +
                            "  %j.01 = phi i32 [ 0, %.lr.ph ], [ %13, %8 ]\n" +
                            "  %9 = getelementptr inbounds double* %5, i32 %j.01\n" +
                            "  %10 = load double* %9, align 4, !tbaa !4\n" +
                            "  %11 = fptosi double %10 to i32\n" +
                            "  %12 = getelementptr inbounds i32* %7, i32 %j.01\n" +
                            "  store i32 %11, i32* %12, align 4, !tbaa !3\n" +
                            "  %13 = add nsw i32 %j.01, 1\n" +
                            "  %exitcond = icmp eq i32 %13, %col\n" +
                            "  br i1 %exitcond, label %._crit_edge, label %8\n" +
                            "\n" +
                            "._crit_edge:                                      ; preds = %8, %.preheader\n" +
                            "  %14 = add nsw i32 %i.02, 1\n" +
                            "  %exitcond4 = icmp eq i32 %14, %fil\n" +
                            "  br i1 %exitcond4, label %._crit_edge3, label %.preheader\n" +
                            "\n" +
                            "._crit_edge3:                                     ; preds = %._crit_edge, %0\n" +
                            "  ret i32** %1\n" +
                            "}\n";
    public String _mat_rponer = "define double** @_mat_rponer(double** %A, i32 %fil, i32 %col, i32 %val) nounwind optsize {\n" +
                            "  %1 = sitofp i32 %val to double\n" +
                            "  %2 = getelementptr inbounds double** %A, i32 %fil\n" +
                            "  %3 = load double** %2, align 4, !tbaa !0\n" +
                            "  %4 = getelementptr inbounds double* %3, i32 %col\n" +
                            "  store double %1, double* %4, align 4, !tbaa !4\n" +
                            "  ret double** %A\n" +
                            "}\n";
    public String _mat_eponer = "define i32** @_mat_eponer(i32** %A, i32 %fil, i32 %col, i32 %val) nounwind optsize {\n" +
                            "  %1 = getelementptr inbounds i32** %A, i32 %fil\n" +
                            "  %2 = load i32** %1, align 4, !tbaa !0\n" +
                            "  %3 = getelementptr inbounds i32* %2, i32 %col\n" +
                            "  store i32 %val, i32* %3, align 4, !tbaa !3\n" +
                            "  ret i32** %A\n" +
                            "}\n";
    public String _mat_rsuma = "define noalias double** @_mat_rsuma(double** nocapture %A, double** nocapture %B, i32 %fil, i32 %col) nounwind optsize {\n" +
                            "  %1 = tail call double** @_mat_rreservar(double** undef, i32 %fil, i32 %col) optsize\n" +
                            "  %2 = icmp sgt i32 %fil, 0\n" +
                            "  br i1 %2, label %.preheader.lr.ph, label %._crit_edge3\n" +
                            "\n" +
                            ".preheader.lr.ph:                                 ; preds = %0\n" +
                            "  %3 = icmp sgt i32 %col, 0\n" +
                            "  br label %.preheader\n" +
                            "\n" +
                            ".preheader:                                       ; preds = %._crit_edge, %.preheader.lr.ph\n" +
                            "  %i.02 = phi i32 [ 0, %.preheader.lr.ph ], [ %18, %._crit_edge ]\n" +
                            "  br i1 %3, label %.lr.ph, label %._crit_edge\n" +
                            "\n" +
                            ".lr.ph:                                           ; preds = %.preheader\n" +
                            "  %4 = getelementptr inbounds double** %A, i32 %i.02\n" +
                            "  %5 = load double** %4, align 4, !tbaa !0\n" +
                            "  %6 = getelementptr inbounds double** %B, i32 %i.02\n" +
                            "  %7 = load double** %6, align 4, !tbaa !0\n" +
                            "  %8 = getelementptr inbounds double** %1, i32 %i.02\n" +
                            "  %9 = load double** %8, align 4, !tbaa !0\n" +
                            "  br label %10\n" +
                            "\n" +
                            "; <label>:10                                      ; preds = %10, %.lr.ph\n" +
                            "  %j.01 = phi i32 [ 0, %.lr.ph ], [ %17, %10 ]\n" +
                            "  %11 = getelementptr inbounds double* %5, i32 %j.01\n" +
                            "  %12 = load double* %11, align 4, !tbaa !4\n" +
                            "  %13 = getelementptr inbounds double* %7, i32 %j.01\n" +
                            "  %14 = load double* %13, align 4, !tbaa !4\n" +
                            "  %15 = fadd double %12, %14\n" +
                            "  %16 = getelementptr inbounds double* %9, i32 %j.01\n" +
                            "  store double %15, double* %16, align 4, !tbaa !4\n" +
                            "  %17 = add nsw i32 %j.01, 1\n" +
                            "  %exitcond = icmp eq i32 %17, %col\n" +
                            "  br i1 %exitcond, label %._crit_edge, label %10\n" +
                            "\n" +
                            "._crit_edge:                                      ; preds = %10, %.preheader\n" +
                            "  %18 = add nsw i32 %i.02, 1\n" +
                            "  %exitcond4 = icmp eq i32 %18, %fil\n" +
                            "  br i1 %exitcond4, label %._crit_edge3, label %.preheader\n" +
                            "\n" +
                            "._crit_edge3:                                     ; preds = %._crit_edge, %0\n" +
                            "  ret double** %1\n" +
                            "}\n";
    public String _mat_esuma = "define noalias i32** @_mat_esuma(double** nocapture %A, double** nocapture %B, i32 %fil, i32 %col) nounwind optsize {\n" +
                            "  %1 = tail call i32** @_mat_ereservar(i32** undef, i32 %fil, i32 %col) optsize\n" +
                            "  %2 = icmp sgt i32 %fil, 0\n" +
                            "  br i1 %2, label %.preheader.lr.ph, label %._crit_edge3\n" +
                            "\n" +
                            ".preheader.lr.ph:                                 ; preds = %0\n" +
                            "  %3 = icmp sgt i32 %col, 0\n" +
                            "  br label %.preheader\n" +
                            "\n" +
                            ".preheader:                                       ; preds = %._crit_edge, %.preheader.lr.ph\n" +
                            "  %i.02 = phi i32 [ 0, %.preheader.lr.ph ], [ %19, %._crit_edge ]\n" +
                            "  br i1 %3, label %.lr.ph, label %._crit_edge\n" +
                            "\n" +
                            ".lr.ph:                                           ; preds = %.preheader\n" +
                            "  %4 = getelementptr inbounds double** %A, i32 %i.02\n" +
                            "  %5 = load double** %4, align 4, !tbaa !0\n" +
                            "  %6 = getelementptr inbounds double** %B, i32 %i.02\n" +
                            "  %7 = load double** %6, align 4, !tbaa !0\n" +
                            "  %8 = getelementptr inbounds i32** %1, i32 %i.02\n" +
                            "  %9 = load i32** %8, align 4, !tbaa !0\n" +
                            "  br label %10\n" +
                            "\n" +
                            "; <label>:10                                      ; preds = %10, %.lr.ph\n" +
                            "  %j.01 = phi i32 [ 0, %.lr.ph ], [ %18, %10 ]\n" +
                            "  %11 = getelementptr inbounds double* %5, i32 %j.01\n" +
                            "  %12 = load double* %11, align 4, !tbaa !4\n" +
                            "  %13 = getelementptr inbounds double* %7, i32 %j.01\n" +
                            "  %14 = load double* %13, align 4, !tbaa !4\n" +
                            "  %15 = fadd double %12, %14\n" +
                            "  %16 = fptosi double %15 to i32\n" +
                            "  %17 = getelementptr inbounds i32* %9, i32 %j.01\n" +
                            "  store i32 %16, i32* %17, align 4, !tbaa !3\n" +
                            "  %18 = add nsw i32 %j.01, 1\n" +
                            "  %exitcond = icmp eq i32 %18, %col\n" +
                            "  br i1 %exitcond, label %._crit_edge, label %10\n" +
                            "\n" +
                            "._crit_edge:                                      ; preds = %10, %.preheader\n" +
                            "  %19 = add nsw i32 %i.02, 1\n" +
                            "  %exitcond4 = icmp eq i32 %19, %fil\n" +
                            "  br i1 %exitcond4, label %._crit_edge3, label %.preheader\n" +
                            "\n" +
                            "._crit_edge3:                                     ; preds = %._crit_edge, %0\n" +
                            "  ret i32** %1\n" +
                            "}\n";
    public String _mat_rresta = "define noalias double** @_mat_rresta(double** nocapture %A, double** nocapture %B, i32 %fil, i32 %col) nounwind optsize {\n" +
                            "  %1 = tail call double** @_mat_rreservar(double** undef, i32 %fil, i32 %col) optsize\n" +
                            "  %2 = icmp sgt i32 %fil, 0\n" +
                            "  br i1 %2, label %.preheader.lr.ph, label %._crit_edge3\n" +
                            "\n" +
                            ".preheader.lr.ph:                                 ; preds = %0\n" +
                            "  %3 = icmp sgt i32 %col, 0\n" +
                            "  br label %.preheader\n" +
                            "\n" +
                            ".preheader:                                       ; preds = %._crit_edge, %.preheader.lr.ph\n" +
                            "  %i.02 = phi i32 [ 0, %.preheader.lr.ph ], [ %18, %._crit_edge ]\n" +
                            "  br i1 %3, label %.lr.ph, label %._crit_edge\n" +
                            "\n" +
                            ".lr.ph:                                           ; preds = %.preheader\n" +
                            "  %4 = getelementptr inbounds double** %A, i32 %i.02\n" +
                            "  %5 = load double** %4, align 4, !tbaa !0\n" +
                            "  %6 = getelementptr inbounds double** %B, i32 %i.02\n" +
                            "  %7 = load double** %6, align 4, !tbaa !0\n" +
                            "  %8 = getelementptr inbounds double** %1, i32 %i.02\n" +
                            "  %9 = load double** %8, align 4, !tbaa !0\n" +
                            "  br label %10\n" +
                            "\n" +
                            "; <label>:10                                      ; preds = %10, %.lr.ph\n" +
                            "  %j.01 = phi i32 [ 0, %.lr.ph ], [ %17, %10 ]\n" +
                            "  %11 = getelementptr inbounds double* %5, i32 %j.01\n" +
                            "  %12 = load double* %11, align 4, !tbaa !4\n" +
                            "  %13 = getelementptr inbounds double* %7, i32 %j.01\n" +
                            "  %14 = load double* %13, align 4, !tbaa !4\n" +
                            "  %15 = fsub double %12, %14\n" +
                            "  %16 = getelementptr inbounds double* %9, i32 %j.01\n" +
                            "  store double %15, double* %16, align 4, !tbaa !4\n" +
                            "  %17 = add nsw i32 %j.01, 1\n" +
                            "  %exitcond = icmp eq i32 %17, %col\n" +
                            "  br i1 %exitcond, label %._crit_edge, label %10\n" +
                            "\n" +
                            "._crit_edge:                                      ; preds = %10, %.preheader\n" +
                            "  %18 = add nsw i32 %i.02, 1\n" +
                            "  %exitcond4 = icmp eq i32 %18, %fil\n" +
                            "  br i1 %exitcond4, label %._crit_edge3, label %.preheader\n" +
                            "\n" +
                            "._crit_edge3:                                     ; preds = %._crit_edge, %0\n" +
                            "  ret double** %1\n" +
                            "}\n";
    public String _mat_eresta = "define noalias i32** @_mat_eresta(double** nocapture %A, double** nocapture %B, i32 %fil, i32 %col) nounwind optsize {\n" +
                            "  %1 = tail call i32** @_mat_ereservar(i32** undef, i32 %fil, i32 %col) optsize\n" +
                            "  %2 = icmp sgt i32 %fil, 0\n" +
                            "  br i1 %2, label %.preheader.lr.ph, label %._crit_edge3\n" +
                            "\n" +
                            ".preheader.lr.ph:                                 ; preds = %0\n" +
                            "  %3 = icmp sgt i32 %col, 0\n" +
                            "  br label %.preheader\n" +
                            "\n" +
                            ".preheader:                                       ; preds = %._crit_edge, %.preheader.lr.ph\n" +
                            "  %i.02 = phi i32 [ 0, %.preheader.lr.ph ], [ %19, %._crit_edge ]\n" +
                            "  br i1 %3, label %.lr.ph, label %._crit_edge\n" +
                            "\n" +
                            ".lr.ph:                                           ; preds = %.preheader\n" +
                            "  %4 = getelementptr inbounds double** %A, i32 %i.02\n" +
                            "  %5 = load double** %4, align 4, !tbaa !0\n" +
                            "  %6 = getelementptr inbounds double** %B, i32 %i.02\n" +
                            "  %7 = load double** %6, align 4, !tbaa !0\n" +
                            "  %8 = getelementptr inbounds i32** %1, i32 %i.02\n" +
                            "  %9 = load i32** %8, align 4, !tbaa !0\n" +
                            "  br label %10\n" +
                            "\n" +
                            "; <label>:10                                      ; preds = %10, %.lr.ph\n" +
                            "  %j.01 = phi i32 [ 0, %.lr.ph ], [ %18, %10 ]\n" +
                            "  %11 = getelementptr inbounds double* %5, i32 %j.01\n" +
                            "  %12 = load double* %11, align 4, !tbaa !4\n" +
                            "  %13 = getelementptr inbounds double* %7, i32 %j.01\n" +
                            "  %14 = load double* %13, align 4, !tbaa !4\n" +
                            "  %15 = fsub double %12, %14\n" +
                            "  %16 = fptosi double %15 to i32\n" +
                            "  %17 = getelementptr inbounds i32* %9, i32 %j.01\n" +
                            "  store i32 %16, i32* %17, align 4, !tbaa !3\n" +
                            "  %18 = add nsw i32 %j.01, 1\n" +
                            "  %exitcond = icmp eq i32 %18, %col\n" +
                            "  br i1 %exitcond, label %._crit_edge, label %10\n" +
                            "\n" +
                            "._crit_edge:                                      ; preds = %10, %.preheader\n" +
                            "  %19 = add nsw i32 %i.02, 1\n" +
                            "  %exitcond4 = icmp eq i32 %19, %fil\n" +
                            "  br i1 %exitcond4, label %._crit_edge3, label %.preheader\n" +
                            "\n" +
                            "._crit_edge3:                                     ; preds = %._crit_edge, %0\n" +
                            "  ret i32** %1\n" +
                            "}\n" +
                            "\n" +
                            "define i32 @main() nounwind optsize {\n" +
                            "  %1 = tail call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([10 x i8]* @.str5, i32 0, i32 0)) nounwind optsize\n" +
                            "  %2 = tail call i32 @comprobar(i32 1, i32 3, i32 4, i32 5) optsize\n" +
                            "  %3 = tail call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.str6, i32 0, i32 0)) nounwind optsize\n" +
                            "  ret i32 0\n" +
                            "}\n";
    public String  _mat_rimprimir = "define void @_mat_rimprimir(double** nocapture %A, i32 %fil, i32 %col) nounwind optsize {\n" +
                            "  %1 = icmp sgt i32 %fil, 0\n" +
                            "  br i1 %1, label %.preheader.lr.ph, label %._crit_edge3\n" +
                            "\n" +
                            ".preheader.lr.ph:                                 ; preds = %0\n" +
                            "  %2 = icmp sgt i32 %col, 0\n" +
                            "  br label %.preheader\n" +
                            "\n" +
                            ".preheader:                                       ; preds = %._crit_edge, %.preheader.lr.ph\n" +
                            "  %i.02 = phi i32 [ 0, %.preheader.lr.ph ], [ %10, %._crit_edge ]\n" +
                            "  br i1 %2, label %.lr.ph, label %._crit_edge\n" +
                            "\n" +
                            ".lr.ph:                                           ; preds = %.preheader\n" +
                            "  %3 = getelementptr inbounds double** %A, i32 %i.02\n" +
                            "  br label %4\n" +
                            "\n" +
                            "; <label>:4                                       ; preds = %4, %.lr.ph\n" +
                            "  %j.01 = phi i32 [ 0, %.lr.ph ], [ %9, %4 ]\n" +
                            "  %5 = load double** %3, align 4, !tbaa !0\n" +
                            "  %6 = getelementptr inbounds double* %5, i32 %j.01\n" +
                            "  %7 = load double* %6, align 4, !tbaa !4\n" +
                            "  %8 = tail call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([5 x i8]* @.str_m_r, i32 0, i32 0), double %7) nounwind optsize\n" +
                            "  %9 = add nsw i32 %j.01, 1\n" +
                            "  %exitcond = icmp eq i32 %9, %col\n" +
                            "  br i1 %exitcond, label %._crit_edge, label %4\n" +
                            "\n" +
                            "._crit_edge:                                      ; preds = %4, %.preheader\n" +
                            "  %putchar = tail call i32 @putchar(i32 10) nounwind\n" +
                            "  %10 = add nsw i32 %i.02, 1\n" +
                            "  %exitcond4 = icmp eq i32 %10, %fil\n" +
                            "  br i1 %exitcond4, label %._crit_edge3, label %.preheader\n" +
                            "\n" +
                            "._crit_edge3:                                     ; preds = %._crit_edge, %0\n" +
                            "  ret void\n" +
                            "}\n";
    public String  _mat_eimprimir = "define void @_mat_eimprimir(i32** nocapture %A, i32 %fil, i32 %col) nounwind optsize {\n" +
                            "  %1 = icmp sgt i32 %fil, 0\n" +
                            "  br i1 %1, label %.preheader.lr.ph, label %._crit_edge3\n" +
                            "\n" +
                            ".preheader.lr.ph:                                 ; preds = %0\n" +
                            "  %2 = icmp sgt i32 %col, 0\n" +
                            "  br label %.preheader\n" +
                            "\n" +
                            ".preheader:                                       ; preds = %._crit_edge, %.preheader.lr.ph\n" +
                            "  %i.02 = phi i32 [ 0, %.preheader.lr.ph ], [ %10, %._crit_edge ]\n" +
                            "  br i1 %2, label %.lr.ph, label %._crit_edge\n" +
                            "\n" +
                            ".lr.ph:                                           ; preds = %.preheader\n" +
                            "  %3 = getelementptr inbounds i32** %A, i32 %i.02\n" +
                            "  br label %4\n" +
                            "\n" +
                            "; <label>:4                                       ; preds = %4, %.lr.ph\n" +
                            "  %j.01 = phi i32 [ 0, %.lr.ph ], [ %9, %4 ]\n" +
                            "  %5 = load i32** %3, align 4, !tbaa !0\n" +
                            "  %6 = getelementptr inbounds i32* %5, i32 %j.01\n" +
                            "  %7 = load i32* %6, align 4, !tbaa !3\n" +
                            "  %8 = tail call i32 (i8*, ...)* @printf(i8* getelementptr inbounds ([4 x i8]* @.str_m_e, i32 0, i32 0), i32 %7) nounwind optsize\n" +
                            "  %9 = add nsw i32 %j.01, 1\n" +
                            "  %exitcond = icmp eq i32 %9, %col\n" +
                            "  br i1 %exitcond, label %._crit_edge, label %4\n" +
                            "\n" +
                            "._crit_edge:                                      ; preds = %4, %.preheader\n" +
                            "  %putchar = tail call i32 @putchar(i32 10) nounwind\n" +
                            "  %10 = add nsw i32 %i.02, 1\n" +
                            "  %exitcond4 = icmp eq i32 %10, %fil\n" +
                            "  br i1 %exitcond4, label %._crit_edge3, label %.preheader\n" +
                            "\n" +
                            "._crit_edge3:                                     ; preds = %._crit_edge, %0\n" +
                            "  ret void\n" +
                            "}\n";
    
    public String _mat_imprimir_cabecera_e = "@.str_m_e = private unnamed_addr constant [4 x i8] c\"%d \\00\", align 1\n";
    public String _mat_imprimir_cabecera_r = "@.str_m_r = private unnamed_addr constant [5 x i8] c\"%lf \\00\", align 1\n";
    public String _mat_default_pos = "declare void @exit(i32) noreturn nounwind optsize\n" +
                                        "declare i32 @puts(i8* nocapture) nounwind\n" +
                                        "declare i32 @putchar(i32)\n" +
                                                                    "\n" +
                                        "!0 = metadata !{metadata !\"any pointer\", metadata !1}\n" +
                                        "!1 = metadata !{metadata !\"omnipotent char\", metadata !2}\n" +
                                        "!2 = metadata !{metadata !\"Simple C/C++ TBAA\", null}\n" +
                                        "!3 = metadata !{metadata !\"int\", metadata !1}\n" +
                                        "!4 = metadata !{metadata !\"double\", metadata !1}\n";
    
    public String str_error = "@str_error = internal constant [31 x i8] c\"Error de dimension de matrices\\00\"\n";
    public String _mat_comprobar = "define i32 @_mat_comprobar(i32 %a, i32 %b, i32 %c, i32 %d) nounwind optsize {\n" +
                                    "  %1 = icmp eq i32 %a, %c\n" +
                                    "  %2 = icmp eq i32 %b, %d\n" +
                                    "  %3 = and i1 %1, %2\n" +
                                    "  br i1 %3, label %5, label %4\n" +
                                    "\n" +
                                    "; <label>:4                                       ; preds = %0\n" +
                                    "  %puts = tail call i32 @puts(i8* getelementptr inbounds ([31 x i8]* @str_error, i32 0, i32 0))\n" +
                                    "  tail call void @exit(i32 0) noreturn nounwind optsize\n" +
                                    "  unreachable\n" +
                                    "\n" +
                                    "; <label>:5                                       ; preds = %0\n" +
                                    "  ret i32 1\n" +
                                    "}\n" ;
                          
    
    public String _str_error2 = "@str_error2 = internal constant [29 x i8] c\"Error de dimension de matriz\\00\"\n";
    public String _mat_comprobar_tam = "define i32 @_mat_comprobar_tam(i32 %a, i32 %b, i32 %c, i32 %d) nounwind optsize {\n" +
                                    "  %1 = icmp slt i32 %c, %a\n" +
                                    "  %2 = icmp slt i32 %d, %b\n" +
                                    "  %3 = and i1 %1, %2\n" +
                                    "  br i1 %3, label %5, label %4\n" +
                                    "\n" +
                                    "; <label>:4                                       ; preds = %0\n" +
                                    "  %puts = tail call i32 @puts(i8* getelementptr inbounds ([29 x i8]* @str_error2, i32 0, i32 0))\n" +
                                    "  tail call void @exit(i32 0) noreturn nounwind optsize\n" +
                                    "  unreachable\n" +
                                    "\n" +
                                    "; <label>:5                                       ; preds = %0\n" +
                                    "  ret i32 1\n" +
                                    "}\n";
    
    public String  asig_e = "define i32 @asig_e(i32 %nuevo) nounwind readnone optsize {\n" +
                        "  ret i32 %nuevo\n" +
                        "}\n";
    public String asig_r = "define double @asig_r(double %nuevo) nounwind readnone optsize {\n" +
                        "  ret double %nuevo\n" +
                        "}\n";
    
    public String _mat_rmayor = "define i32 @_mat_rmayor(double** nocapture %A, double** nocapture %B, i32 %fil, i32 %col) nounwind readonly optsize {\n" +
            "  br label %1\n" +
            "\n" +
            "; <label>:1                                       ; preds = %17, %0\n" +
            "  %i.0 = phi i32 [ 0, %0 ], [ %18, %17 ]\n" +
            "  %2 = icmp slt i32 %i.0, %fil\n" +
            "  br i1 %2, label %.preheader, label %.loopexit\n" +
            "\n" +
            ".preheader:                                       ; preds = %1\n" +
            "  %3 = getelementptr inbounds double** %A, i32 %i.0\n" +
            "  %4 = getelementptr inbounds double** %B, i32 %i.0\n" +
            "  br label %5\n" +
            "\n" +
            "; <label>:5                                       ; preds = %.preheader, %15\n" +
            "  %j.0 = phi i32 [ %16, %15 ], [ 0, %.preheader ]\n" +
            "  %6 = icmp slt i32 %j.0, %col\n" +
            "  br i1 %6, label %7, label %17\n" +
            "\n" +
            "; <label>:7                                       ; preds = %5\n" +
            "  %8 = load double** %3, align 4, !tbaa !0\n" +
            "  %9 = getelementptr inbounds double* %8, i32 %j.0\n" +
            "  %10 = load double* %9, align 4, !tbaa !4\n" +
            "  %11 = load double** %4, align 4, !tbaa !0\n" +
            "  %12 = getelementptr inbounds double* %11, i32 %j.0\n" +
            "  %13 = load double* %12, align 4, !tbaa !4\n" +
            "  %14 = fcmp ogt double %10, %13\n" +
            "  br i1 %14, label %15, label %.loopexit\n" +
            "\n" +
            "; <label>:15                                      ; preds = %7\n" +
            "  %16 = add nsw i32 %j.0, 1\n" +
            "  br label %5\n" +
            "\n" +
            "; <label>:17                                      ; preds = %5\n" +
            "  %18 = add nsw i32 %i.0, 1\n" +
            "  br label %1\n" +
            "\n" +
            ".loopexit:                                        ; preds = %1, %7\n" +
            "  %.0 = phi i32 [ 0, %7 ], [ 1, %1 ]\n" +
            "  ret i32 %.0\n" +
            "}\n";
    public String _mat_rmenor = "define i32 @_mat_rmenor(double** nocapture %A, double** nocapture %B, i32 %fil, i32 %col) nounwind readonly optsize {\n" +
            "  br label %1\n" +
            "\n" +
            "; <label>:1                                       ; preds = %17, %0\n" +
            "  %i.0 = phi i32 [ 0, %0 ], [ %18, %17 ]\n" +
            "  %2 = icmp slt i32 %i.0, %fil\n" +
            "  br i1 %2, label %.preheader, label %.loopexit\n" +
            "\n" +
            ".preheader:                                       ; preds = %1\n" +
            "  %3 = getelementptr inbounds double** %A, i32 %i.0\n" +
            "  %4 = getelementptr inbounds double** %B, i32 %i.0\n" +
            "  br label %5\n" +
            "\n" +
            "; <label>:5                                       ; preds = %.preheader, %15\n" +
            "  %j.0 = phi i32 [ %16, %15 ], [ 0, %.preheader ]\n" +
            "  %6 = icmp slt i32 %j.0, %col\n" +
            "  br i1 %6, label %7, label %17\n" +
            "\n" +
            "; <label>:7                                       ; preds = %5\n" +
            "  %8 = load double** %3, align 4, !tbaa !0\n" +
            "  %9 = getelementptr inbounds double* %8, i32 %j.0\n" +
            "  %10 = load double* %9, align 4, !tbaa !4\n" +
            "  %11 = load double** %4, align 4, !tbaa !0\n" +
            "  %12 = getelementptr inbounds double* %11, i32 %j.0\n" +
            "  %13 = load double* %12, align 4, !tbaa !4\n" +
            "  %14 = fcmp olt double %10, %13\n" +
            "  br i1 %14, label %15, label %.loopexit\n" +
            "\n" +
            "; <label>:15                                      ; preds = %7\n" +
            "  %16 = add nsw i32 %j.0, 1\n" +
            "  br label %5\n" +
            "\n" +
            "; <label>:17                                      ; preds = %5\n" +
            "  %18 = add nsw i32 %i.0, 1\n" +
            "  br label %1\n" +
            "\n" +
            ".loopexit:                                        ; preds = %1, %7\n" +
            "  %.0 = phi i32 [ 0, %7 ], [ 1, %1 ]\n" +
            "  ret i32 %.0\n" +
            "}\n";
    public String _mat_rmayor_igual = "define i32 @_mat_rmayor_igual(double** nocapture %A, double** nocapture %B, i32 %fil, i32 %col) nounwind readonly optsize {\n" +
            "  br label %1\n" +
            "\n" +
            "; <label>:1                                       ; preds = %17, %0\n" +
            "  %i.0 = phi i32 [ 0, %0 ], [ %18, %17 ]\n" +
            "  %2 = icmp slt i32 %i.0, %fil\n" +
            "  br i1 %2, label %.preheader, label %.loopexit\n" +
            "\n" +
            ".preheader:                                       ; preds = %1\n" +
            "  %3 = getelementptr inbounds double** %A, i32 %i.0\n" +
            "  %4 = getelementptr inbounds double** %B, i32 %i.0\n" +
            "  br label %5\n" +
            "\n" +
            "; <label>:5                                       ; preds = %.preheader, %15\n" +
            "  %j.0 = phi i32 [ %16, %15 ], [ 0, %.preheader ]\n" +
            "  %6 = icmp slt i32 %j.0, %col\n" +
            "  br i1 %6, label %7, label %17\n" +
            "\n" +
            "; <label>:7                                       ; preds = %5\n" +
            "  %8 = load double** %3, align 4, !tbaa !0\n" +
            "  %9 = getelementptr inbounds double* %8, i32 %j.0\n" +
            "  %10 = load double* %9, align 4, !tbaa !4\n" +
            "  %11 = load double** %4, align 4, !tbaa !0\n" +
            "  %12 = getelementptr inbounds double* %11, i32 %j.0\n" +
            "  %13 = load double* %12, align 4, !tbaa !4\n" +
            "  %14 = fcmp ult double %10, %13\n" +
            "  br i1 %14, label %.loopexit, label %15\n" +
            "\n" +
            "; <label>:15                                      ; preds = %7\n" +
            "  %16 = add nsw i32 %j.0, 1\n" +
            "  br label %5\n" +
            "\n" +
            "; <label>:17                                      ; preds = %5\n" +
            "  %18 = add nsw i32 %i.0, 1\n" +
            "  br label %1\n" +
            "\n" +
            ".loopexit:                                        ; preds = %1, %7\n" +
            "  %.0 = phi i32 [ 0, %7 ], [ 1, %1 ]\n" +
            "  ret i32 %.0\n" +
            "}\n";
    public String _mat_rmenor_igual = "define i32 @_mat_rmenor_igual(double** nocapture %A, double** nocapture %B, i32 %fil, i32 %col) nounwind readonly optsize {\n" +
            "  br label %1\n" +
            "\n" +
            "; <label>:1                                       ; preds = %17, %0\n" +
            "  %i.0 = phi i32 [ 0, %0 ], [ %18, %17 ]\n" +
            "  %2 = icmp slt i32 %i.0, %fil\n" +
            "  br i1 %2, label %.preheader, label %.loopexit\n" +
            "\n" +
            ".preheader:                                       ; preds = %1\n" +
            "  %3 = getelementptr inbounds double** %A, i32 %i.0\n" +
            "  %4 = getelementptr inbounds double** %B, i32 %i.0\n" +
            "  br label %5\n" +
            "\n" +
            "; <label>:5                                       ; preds = %.preheader, %15\n" +
            "  %j.0 = phi i32 [ %16, %15 ], [ 0, %.preheader ]\n" +
            "  %6 = icmp slt i32 %j.0, %col\n" +
            "  br i1 %6, label %7, label %17\n" +
            "\n" +
            "; <label>:7                                       ; preds = %5\n" +
            "  %8 = load double** %3, align 4, !tbaa !0\n" +
            "  %9 = getelementptr inbounds double* %8, i32 %j.0\n" +
            "  %10 = load double* %9, align 4, !tbaa !4\n" +
            "  %11 = load double** %4, align 4, !tbaa !0\n" +
            "  %12 = getelementptr inbounds double* %11, i32 %j.0\n" +
            "  %13 = load double* %12, align 4, !tbaa !4\n" +
            "  %14 = fcmp ugt double %10, %13\n" +
            "  br i1 %14, label %.loopexit, label %15\n" +
            "\n" +
            "; <label>:15                                      ; preds = %7\n" +
            "  %16 = add nsw i32 %j.0, 1\n" +
            "  br label %5\n" +
            "\n" +
            "; <label>:17                                      ; preds = %5\n" +
            "  %18 = add nsw i32 %i.0, 1\n" +
            "  br label %1\n" +
            "\n" +
            ".loopexit:                                        ; preds = %1, %7\n" +
            "  %.0 = phi i32 [ 0, %7 ], [ 1, %1 ]\n" +
            "  ret i32 %.0\n" +
            "}\n";
    public String _mat_rconjuncion = "define i32 @_mat_rconjuncion(double** nocapture %A, double** nocapture %B, i32 %fil, i32 %col) nounwind readonly optsize {\n" +
            "  br label %1\n" +
            "\n" +
            "; <label>:1                                       ; preds = %19, %0\n" +
            "  %i.0 = phi i32 [ 0, %0 ], [ %20, %19 ]\n" +
            "  %2 = icmp slt i32 %i.0, %fil\n" +
            "  br i1 %2, label %.preheader, label %.loopexit\n" +
            "\n" +
            ".preheader:                                       ; preds = %1\n" +
            "  %3 = getelementptr inbounds double** %A, i32 %i.0\n" +
            "  %4 = getelementptr inbounds double** %B, i32 %i.0\n" +
            "  br label %5\n" +
            "\n" +
            "; <label>:5                                       ; preds = %.preheader, %17\n" +
            "  %j.0 = phi i32 [ %18, %17 ], [ 0, %.preheader ]\n" +
            "  %6 = icmp slt i32 %j.0, %col\n" +
            "  br i1 %6, label %7, label %19\n" +
            "\n" +
            "; <label>:7                                       ; preds = %5\n" +
            "  %8 = load double** %3, align 4, !tbaa !0\n" +
            "  %9 = getelementptr inbounds double* %8, i32 %j.0\n" +
            "  %10 = load double* %9, align 4, !tbaa !4\n" +
            "  %11 = fcmp une double %10, 0.000000e+00\n" +
            "  br i1 %11, label %12, label %.loopexit\n" +
            "\n" +
            "; <label>:12                                      ; preds = %7\n" +
            "  %13 = load double** %4, align 4, !tbaa !0\n" +
            "  %14 = getelementptr inbounds double* %13, i32 %j.0\n" +
            "  %15 = load double* %14, align 4, !tbaa !4\n" +
            "  %16 = fcmp une double %15, 0.000000e+00\n" +
            "  br i1 %16, label %17, label %.loopexit\n" +
            "\n" +
            "; <label>:17                                      ; preds = %12\n" +
            "  %18 = add nsw i32 %j.0, 1\n" +
            "  br label %5\n" +
            "\n" +
            "; <label>:19                                      ; preds = %5\n" +
            "  %20 = add nsw i32 %i.0, 1\n" +
            "  br label %1\n" +
            "\n" +
            ".loopexit:                                        ; preds = %1, %7, %12\n" +
            "  %.0 = phi i32 [ 0, %12 ], [ 0, %7 ], [ 1, %1 ]\n" +
            "  ret i32 %.0\n" +
            "}\n";
    public String _mat_rdisyuncion = "define i32 @_mat_rdisyuncion(double** nocapture %A, double** nocapture %B, i32 %fil, i32 %col) nounwind readonly optsize {\n" +
            "  br label %1\n" +
            "\n" +
            "; <label>:1                                       ; preds = %19, %0\n" +
            "  %i.0 = phi i32 [ 0, %0 ], [ %20, %19 ]\n" +
            "  %2 = icmp slt i32 %i.0, %fil\n" +
            "  br i1 %2, label %.preheader, label %.loopexit\n" +
            "\n" +
            ".preheader:                                       ; preds = %1\n" +
            "  %3 = getelementptr inbounds double** %A, i32 %i.0\n" +
            "  %4 = getelementptr inbounds double** %B, i32 %i.0\n" +
            "  br label %5\n" +
            "\n" +
            "; <label>:5                                       ; preds = %.preheader, %17\n" +
            "  %j.0 = phi i32 [ %18, %17 ], [ 0, %.preheader ]\n" +
            "  %6 = icmp slt i32 %j.0, %col\n" +
            "  br i1 %6, label %7, label %19\n" +
            "\n" +
            "; <label>:7                                       ; preds = %5\n" +
            "  %8 = load double** %3, align 4, !tbaa !0\n" +
            "  %9 = getelementptr inbounds double* %8, i32 %j.0\n" +
            "  %10 = load double* %9, align 4, !tbaa !4\n" +
            "  %11 = fcmp une double %10, 0.000000e+00\n" +
            "  br i1 %11, label %17, label %12\n" +
            "\n" +
            "; <label>:12                                      ; preds = %7\n" +
            "  %13 = load double** %4, align 4, !tbaa !0\n" +
            "  %14 = getelementptr inbounds double* %13, i32 %j.0\n" +
            "  %15 = load double* %14, align 4, !tbaa !4\n" +
            "  %16 = fcmp une double %15, 0.000000e+00\n" +
            "  br i1 %16, label %17, label %.loopexit\n" +
            "\n" +
            "; <label>:17                                      ; preds = %7, %12\n" +
            "  %18 = add nsw i32 %j.0, 1\n" +
            "  br label %5\n" +
            "\n" +
            "; <label>:19                                      ; preds = %5\n" +
            "  %20 = add nsw i32 %i.0, 1\n" +
            "  br label %1\n" +
            "\n" +
            ".loopexit:                                        ; preds = %1, %12\n" +
            "  %.0 = phi i32 [ 0, %12 ], [ 1, %1 ]\n" +
            "  ret i32 %.0\n" +
            "}\n";
    public String _mat_ridentico = "define i32 @_mat_ridentico(double** nocapture %A, double** nocapture %B, i32 %fil, i32 %col) nounwind readonly optsize {\n" +
            "  br label %1\n" +
            "\n" +
            "; <label>:1                                       ; preds = %17, %0\n" +
            "  %i.0 = phi i32 [ 0, %0 ], [ %18, %17 ]\n" +
            "  %2 = icmp slt i32 %i.0, %fil\n" +
            "  br i1 %2, label %.preheader, label %.loopexit\n" +
            "\n" +
            ".preheader:                                       ; preds = %1\n" +
            "  %3 = getelementptr inbounds double** %A, i32 %i.0\n" +
            "  %4 = getelementptr inbounds double** %B, i32 %i.0\n" +
            "  br label %5\n" +
            "\n" +
            "; <label>:5                                       ; preds = %.preheader, %15\n" +
            "  %j.0 = phi i32 [ %16, %15 ], [ 0, %.preheader ]\n" +
            "  %6 = icmp slt i32 %j.0, %col\n" +
            "  br i1 %6, label %7, label %17\n" +
            "\n" +
            "; <label>:7                                       ; preds = %5\n" +
            "  %8 = load double** %3, align 4, !tbaa !0\n" +
            "  %9 = getelementptr inbounds double* %8, i32 %j.0\n" +
            "  %10 = load double* %9, align 4, !tbaa !4\n" +
            "  %11 = load double** %4, align 4, !tbaa !0\n" +
            "  %12 = getelementptr inbounds double* %11, i32 %j.0\n" +
            "  %13 = load double* %12, align 4, !tbaa !4\n" +
            "  %14 = fcmp oeq double %10, %13\n" +
            "  br i1 %14, label %15, label %.loopexit\n" +
            "\n" +
            "; <label>:15                                      ; preds = %7\n" +
            "  %16 = add nsw i32 %j.0, 1\n" +
            "  br label %5\n" +
            "\n" +
            "; <label>:17                                      ; preds = %5\n" +
            "  %18 = add nsw i32 %i.0, 1\n" +
            "  br label %1\n" +
            "\n" +
            ".loopexit:                                        ; preds = %1, %7\n" +
            "  %.0 = phi i32 [ 0, %7 ], [ 1, %1 ]\n" +
            "  ret i32 %.0\n" +
            "}\n";
    public String _mat_rdiferente = "define i32 @_mat_rdiferente(double** nocapture %A, double** nocapture %B, i32 %fil, i32 %col) nounwind readonly optsize {\n" +
            "  br label %1\n" +
            "\n" +
            "; <label>:1                                       ; preds = %17, %0\n" +
            "  %i.0 = phi i32 [ 0, %0 ], [ %18, %17 ]\n" +
            "  %2 = icmp slt i32 %i.0, %fil\n" +
            "  br i1 %2, label %.preheader, label %.loopexit\n" +
            "\n" +
            ".preheader:                                       ; preds = %1\n" +
            "  %3 = getelementptr inbounds double** %A, i32 %i.0\n" +
            "  %4 = getelementptr inbounds double** %B, i32 %i.0\n" +
            "  br label %5\n" +
            "\n" +
            "; <label>:5                                       ; preds = %.preheader, %15\n" +
            "  %j.0 = phi i32 [ %16, %15 ], [ 0, %.preheader ]\n" +
            "  %6 = icmp slt i32 %j.0, %col\n" +
            "  br i1 %6, label %7, label %17\n" +
            "\n" +
            "; <label>:7                                       ; preds = %5\n" +
            "  %8 = load double** %3, align 4, !tbaa !0\n" +
            "  %9 = getelementptr inbounds double* %8, i32 %j.0\n" +
            "  %10 = load double* %9, align 4, !tbaa !4\n" +
            "  %11 = load double** %4, align 4, !tbaa !0\n" +
            "  %12 = getelementptr inbounds double* %11, i32 %j.0\n" +
            "  %13 = load double* %12, align 4, !tbaa !4\n" +
            "  %14 = fcmp une double %10, %13\n" +
            "  br i1 %14, label %15, label %.loopexit\n" +
            "\n" +
            "; <label>:15                                      ; preds = %7\n" +
            "  %16 = add nsw i32 %j.0, 1\n" +
            "  br label %5\n" +
            "\n" +
            "; <label>:17                                      ; preds = %5\n" +
            "  %18 = add nsw i32 %i.0, 1\n" +
            "  br label %1\n" +
            "\n" +
            ".loopexit:                                        ; preds = %1, %7\n" +
            "  %.0 = phi i32 [ 0, %7 ], [ 1, %1 ]\n" +
            "  ret i32 %.0\n" +
            "}\n";
    public String _mat_rnegacion = "define i32 @_mat_rnegacion(double** nocapture %A,  i32 %fil, i32 %col) nounwind readonly optsize {\n" +
            "  br label %1\n" +
            "\n" +
            "; <label>:1                                       ; preds = %13, %0\n" +
            "  %i.0 = phi i32 [ 0, %0 ], [ %14, %13 ]\n" +
            "  %2 = icmp slt i32 %i.0, %fil\n" +
            "  br i1 %2, label %.preheader, label %.loopexit\n" +
            "\n" +
            ".preheader:                                       ; preds = %1\n" +
            "  %3 = getelementptr inbounds double** %A, i32 %i.0\n" +
            "  br label %4\n" +
            "\n" +
            "; <label>:4                                       ; preds = %.preheader, %11\n" +
            "  %j.0 = phi i32 [ %12, %11 ], [ 0, %.preheader ]\n" +
            "  %5 = icmp slt i32 %j.0, %col\n" +
            "  br i1 %5, label %6, label %13\n" +
            "\n" +
            "; <label>:6                                       ; preds = %4\n" +
            "  %7 = load double** %3, align 4, !tbaa !0\n" +
            "  %8 = getelementptr inbounds double* %7, i32 %j.0\n" +
            "  %9 = load double* %8, align 4, !tbaa !4\n" +
            "  %10 = fcmp une double %9, 0.000000e+00\n" +
            "  br i1 %10, label %.loopexit, label %11\n" +
            "\n" +
            "; <label>:11                                      ; preds = %6\n" +
            "  %12 = add nsw i32 %j.0, 1\n" +
            "  br label %4\n" +
            "\n" +
            "; <label>:13                                      ; preds = %4\n" +
            "  %14 = add nsw i32 %i.0, 1\n" +
            "  br label %1\n" +
            "\n" +
            ".loopexit:                                        ; preds = %1, %6\n" +
            "  %.0 = phi i32 [ 0, %6 ], [ 1, %1 ]\n" +
            "  ret i32 %.0\n" +
            "}\n";
    public String _mat_rnegatividad = "define noalias double** @_mat_rnegatividad(double** nocapture %A, i32 %fil, i32 %col) nounwind optsize {\n" +
            "  %1 = tail call double** @_mat_rreservar(double** undef, i32 %fil, i32 %col) optsize\n" +
            "  %2 = icmp sgt i32 %fil, 0\n" +
            "  br i1 %2, label %.preheader.lr.ph, label %._crit_edge3\n" +
            "\n" +
            ".preheader.lr.ph:                                 ; preds = %0\n" +
            "  %3 = icmp sgt i32 %col, 0\n" +
            "  br label %.preheader\n" +
            "\n" +
            ".preheader:                                       ; preds = %._crit_edge, %.preheader.lr.ph\n" +
            "  %i.02 = phi i32 [ 0, %.preheader.lr.ph ], [ %14, %._crit_edge ]\n" +
            "  br i1 %3, label %.lr.ph, label %._crit_edge\n" +
            "\n" +
            ".lr.ph:                                           ; preds = %.preheader\n" +
            "  %4 = getelementptr inbounds double** %A, i32 %i.02\n" +
            "  %5 = load double** %4, align 4, !tbaa !0\n" +
            "  %6 = getelementptr inbounds double** %1, i32 %i.02\n" +
            "  %7 = load double** %6, align 4, !tbaa !0\n" +
            "  br label %8\n" +
            "\n" +
            "; <label>:8                                       ; preds = %8, %.lr.ph\n" +
            "  %j.01 = phi i32 [ 0, %.lr.ph ], [ %13, %8 ]\n" +
            "  %9 = getelementptr inbounds double* %5, i32 %j.01\n" +
            "  %10 = load double* %9, align 4, !tbaa !4\n" +
            "  %11 = fsub double -0.000000e+00, %10\n" +
            "  %12 = getelementptr inbounds double* %7, i32 %j.01\n" +
            "  store double %11, double* %12, align 4, !tbaa !4\n" +
            "  %13 = add nsw i32 %j.01, 1\n" +
            "  %exitcond = icmp eq i32 %13, %col\n" +
            "  br i1 %exitcond, label %._crit_edge, label %8\n" +
            "\n" +
            "._crit_edge:                                      ; preds = %8, %.preheader\n" +
            "  %14 = add nsw i32 %i.02, 1\n" +
            "  %exitcond4 = icmp eq i32 %14, %fil\n" +
            "  br i1 %exitcond4, label %._crit_edge3, label %.preheader\n" +
            "\n" +
            "._crit_edge3:                                     ; preds = %._crit_edge, %0\n" +
            "  ret double** %1\n" +
            "}\n";
    public String _mat_enegatividad = "define noalias i32** @_mat_enegatividad(double** nocapture %A, i32 %fil, i32 %col) nounwind optsize {\n" +
            "  %1 = tail call i32** @_mat_ereservar(i32** undef, i32 %fil, i32 %col) optsize\n" +
            "  %2 = icmp sgt i32 %fil, 0\n" +
            "  br i1 %2, label %.preheader.lr.ph, label %._crit_edge3\n" +
            "\n" +
            ".preheader.lr.ph:                                 ; preds = %0\n" +
            "  %3 = icmp sgt i32 %col, 0\n" +
            "  br label %.preheader\n" +
            "\n" +
            ".preheader:                                       ; preds = %._crit_edge, %.preheader.lr.ph\n" +
            "  %i.02 = phi i32 [ 0, %.preheader.lr.ph ], [ %15, %._crit_edge ]\n" +
            "  br i1 %3, label %.lr.ph, label %._crit_edge\n" +
            "\n" +
            ".lr.ph:                                           ; preds = %.preheader\n" +
            "  %4 = getelementptr inbounds double** %A, i32 %i.02\n" +
            "  %5 = load double** %4, align 4, !tbaa !0\n" +
            "  %6 = getelementptr inbounds i32** %1, i32 %i.02\n" +
            "  %7 = load i32** %6, align 4, !tbaa !0\n" +
            "  br label %8\n" +
            "\n" +
            "; <label>:8                                       ; preds = %8, %.lr.ph\n" +
            "  %j.01 = phi i32 [ 0, %.lr.ph ], [ %14, %8 ]\n" +
            "  %9 = getelementptr inbounds double* %5, i32 %j.01\n" +
            "  %10 = load double* %9, align 4, !tbaa !4\n" +
            "  %11 = fptosi double %10 to i32\n" +
            "  %12 = sub nsw i32 0, %11\n" +
            "  %13 = getelementptr inbounds i32* %7, i32 %j.01\n" +
            "  store i32 %12, i32* %13, align 4, !tbaa !3\n" +
            "  %14 = add nsw i32 %j.01, 1\n" +
            "  %exitcond = icmp eq i32 %14, %col\n" +
            "  br i1 %exitcond, label %._crit_edge, label %8\n" +
            "\n" +
            "._crit_edge:                                      ; preds = %8, %.preheader\n" +
            "  %15 = add nsw i32 %i.02, 1\n" +
            "  %exitcond4 = icmp eq i32 %15, %fil\n" +
            "  br i1 %exitcond4, label %._crit_edge3, label %.preheader\n" +
            "\n" +
            "._crit_edge3:                                     ; preds = %._crit_edge, %0\n" +
            "  ret i32** %1\n" +
            "}\n";
    
    public String _mat_transpuesta = "define noalias double** @_mat_transpuesta(double** nocapture %matriz, i32 %tam) nounwind optsize {\n" +
            "  %1 = tail call double** @_mat_rreservar(double** undef, i32 %tam, i32 %tam) optsize\n" +
            "  %2 = icmp sgt i32 %tam, 0\n" +
            "  br i1 %2, label %.lr.ph, label %._crit_edge3\n" +
            "\n" +
            ".lr.ph:                                           ; preds = %._crit_edge, %0\n" +
            "  %i.02 = phi i32 [ %12, %._crit_edge ], [ 0, %0 ]\n" +
            "  %3 = getelementptr inbounds double** %1, i32 %i.02\n" +
            "  %4 = load double** %3, align 4, !tbaa !0\n" +
            "  br label %5\n" +
            "\n" +
            "; <label>:5                                       ; preds = %5, %.lr.ph\n" +
            "  %j.01 = phi i32 [ 0, %.lr.ph ], [ %11, %5 ]\n" +
            "  %6 = getelementptr inbounds double** %matriz, i32 %j.01\n" +
            "  %7 = load double** %6, align 4, !tbaa !0\n" +
            "  %8 = getelementptr inbounds double* %7, i32 %i.02\n" +
            "  %9 = load double* %8, align 4, !tbaa !3\n" +
            "  %10 = getelementptr inbounds double* %4, i32 %j.01\n" +
            "  store double %9, double* %10, align 4, !tbaa !3\n" +
            "  %11 = add nsw i32 %j.01, 1\n" +
            "  %exitcond = icmp eq i32 %11, %tam\n" +
            "  br i1 %exitcond, label %._crit_edge, label %5\n" +
            "\n" +
            "._crit_edge:                                      ; preds = %5\n" +
            "  %12 = add nsw i32 %i.02, 1\n" +
            "  %exitcond4 = icmp eq i32 %12, %tam\n" +
            "  br i1 %exitcond4, label %._crit_edge3, label %.lr.ph\n" +
            "\n" +
            "._crit_edge3:                                     ; preds = %._crit_edge, %0\n" +
            "  ret double** %1\n" +
            "}\n";
    
    public String _mat_inversa = "define i32 @potencia(i32 %a, i32 %b) nounwind readnone optsize {\n" +
            "  %1 = icmp sgt i32 %b, 0\n" +
            "  br i1 %1, label %.lr.ph, label %._crit_edge\n" +
            "\n" +
            ".lr.ph:                                           ; preds = %0, %.lr.ph\n" +
            "  %i.02 = phi i32 [ %3, %.lr.ph ], [ 0, %0 ]\n" +
            "  %tmp.01 = phi i32 [ %2, %.lr.ph ], [ 1, %0 ]\n" +
            "  %2 = mul nsw i32 %tmp.01, %a\n" +
            "  %3 = add nsw i32 %i.02, 1\n" +
            "  %exitcond = icmp eq i32 %3, %b\n" +
            "  br i1 %exitcond, label %._crit_edge, label %.lr.ph\n" +
            "\n" +
            "._crit_edge:                                      ; preds = %.lr.ph, %0\n" +
            "  %tmp.0.lcssa = phi i32 [ 1, %0 ], [ %2, %.lr.ph ]\n" +
            "  ret i32 %tmp.0.lcssa\n" +
            "}\n" +
            "\n" +
            "define i32 @determinante(double** nocapture %matriz, i32 %tam) nounwind optsize {\n" +
            "  %1 = icmp eq i32 %tam, 2\n" +
            "  br i1 %1, label %5, label %.preheader5\n" +
            "\n" +
            ".preheader5:                                      ; preds = %0\n" +
            "  %2 = icmp sgt i32 %tam, 0\n" +
            "  br i1 %2, label %.lr.ph8, label %.loopexit\n" +
            "\n" +
            ".lr.ph8:                                          ; preds = %.preheader5\n" +
            "  %3 = add nsw i32 %tam, -1\n" +
            "  %4 = icmp sgt i32 %tam, 1\n" +
            "  br label %19\n" +
            "\n" +
            "; <label>:5                                       ; preds = %0\n" +
            "  %6 = load double** %matriz, align 4, !tbaa !0\n" +
            "  %7 = load double* %6, align 4, !tbaa !3\n" +
            "  %8 = getelementptr inbounds double** %matriz, i32 1\n" +
            "  %9 = load double** %8, align 4, !tbaa !0\n" +
            "  %10 = getelementptr inbounds double* %9, i32 1\n" +
            "  %11 = load double* %10, align 4, !tbaa !3\n" +
            "  %12 = fmul double %7, %11\n" +
            "  %13 = load double* %9, align 4, !tbaa !3\n" +
            "  %14 = getelementptr inbounds double* %6, i32 1\n" +
            "  %15 = load double* %14, align 4, !tbaa !3\n" +
            "  %16 = fmul double %13, %15\n" +
            "  %17 = fsub double %12, %16\n" +
            "  %18 = fptosi double %17 to i32\n" +
            "  br label %.loopexit\n" +
            "\n" +
            "; <label>:19                                      ; preds = %potencia.exit, %.lr.ph8\n" +
            "  %rpta.07 = phi i32 [ 0, %.lr.ph8 ], [ %48, %potencia.exit ]\n" +
            "  %j.06 = phi i32 [ 0, %.lr.ph8 ], [ %49, %potencia.exit ]\n" +
            "  %20 = tail call double** @_mat_rreservar(double** undef, i32 %3, i32 %3) optsize\n" +
            "  br i1 %4, label %.lr.ph, label %._crit_edge4\n" +
            "\n" +
            ".lr.ph:                                           ; preds = %._crit_edge, %19\n" +
            "  %k.03 = phi i32 [ %35, %._crit_edge ], [ 1, %19 ]\n" +
            "  %21 = getelementptr inbounds double** %matriz, i32 %k.03\n" +
            "  %22 = add nsw i32 %k.03, -1\n" +
            "  %23 = getelementptr inbounds double** %20, i32 %22\n" +
            "  br label %24\n" +
            "\n" +
            "; <label>:24                                      ; preds = %33, %.lr.ph\n" +
            "  %l.02 = phi i32 [ 0, %.lr.ph ], [ %34, %33 ]\n" +
            "  %c.01 = phi i32 [ 0, %.lr.ph ], [ %c.1, %33 ]\n" +
            "  %25 = icmp eq i32 %l.02, %j.06\n" +
            "  br i1 %25, label %33, label %26\n" +
            "\n" +
            "; <label>:26                                      ; preds = %24\n" +
            "  %27 = load double** %21, align 4, !tbaa !0\n" +
            "  %28 = getelementptr inbounds double* %27, i32 %l.02\n" +
            "  %29 = load double* %28, align 4, !tbaa !3\n" +
            "  %30 = load double** %23, align 4, !tbaa !0\n" +
            "  %31 = getelementptr inbounds double* %30, i32 %c.01\n" +
            "  store double %29, double* %31, align 4, !tbaa !3\n" +
            "  %32 = add nsw i32 %c.01, 1\n" +
            "  br label %33\n" +
            "\n" +
            "; <label>:33                                      ; preds = %24, %26\n" +
            "  %c.1 = phi i32 [ %32, %26 ], [ %c.01, %24 ]\n" +
            "  %34 = add nsw i32 %l.02, 1\n" +
            "  %exitcond = icmp eq i32 %34, %tam\n" +
            "  br i1 %exitcond, label %._crit_edge, label %24\n" +
            "\n" +
            "._crit_edge:                                      ; preds = %33\n" +
            "  %35 = add nsw i32 %k.03, 1\n" +
            "  %exitcond9 = icmp eq i32 %35, %tam\n" +
            "  br i1 %exitcond9, label %._crit_edge4, label %.lr.ph\n" +
            "\n" +
            "._crit_edge4:                                     ; preds = %._crit_edge, %19\n" +
            "  %36 = sitofp i32 %rpta.07 to double\n" +
            "  %37 = icmp sgt i32 %j.06, 0\n" +
            "  br i1 %37, label %.lr.ph.i, label %potencia.exit\n" +
            "\n" +
            ".lr.ph.i:                                         ; preds = %._crit_edge4, %.lr.ph.i\n" +
            "  %i.02.i = phi i32 [ %39, %.lr.ph.i ], [ 0, %._crit_edge4 ]\n" +
            "  %tmp.01.i = phi i32 [ %38, %.lr.ph.i ], [ 1, %._crit_edge4 ]\n" +
            "  %38 = sub i32 0, %tmp.01.i\n" +
            "  %39 = add nsw i32 %i.02.i, 1\n" +
            "  %exitcond.i = icmp eq i32 %39, %j.06\n" +
            "  br i1 %exitcond.i, label %potencia.exit.loopexit, label %.lr.ph.i\n" +
            "\n" +
            "potencia.exit.loopexit:                           ; preds = %.lr.ph.i\n" +
            "  %phitmp = sitofp i32 %38 to double\n" +
            "  br label %potencia.exit\n" +
            "\n" +
            "potencia.exit:                                    ; preds = %potencia.exit.loopexit, %._crit_edge4\n" +
            "  %tmp.0.lcssa.i = phi double [ 1.000000e+00, %._crit_edge4 ], [ %phitmp, %potencia.exit.loopexit ]\n" +
            "  %40 = load double** %matriz, align 4, !tbaa !0\n" +
            "  %41 = getelementptr inbounds double* %40, i32 %j.06\n" +
            "  %42 = load double* %41, align 4, !tbaa !3\n" +
            "  %43 = fmul double %tmp.0.lcssa.i, %42\n" +
            "  %44 = tail call i32 @determinante(double** %20, i32 %3) optsize\n" +
            "  %45 = sitofp i32 %44 to double\n" +
            "  %46 = fmul double %43, %45\n" +
            "  %47 = fadd double %36, %46\n" +
            "  %48 = fptosi double %47 to i32\n" +
            "  %49 = add nsw i32 %j.06, 1\n" +
            "  %exitcond11 = icmp eq i32 %49, %tam\n" +
            "  br i1 %exitcond11, label %.loopexit, label %19\n" +
            "\n" +
            ".loopexit:                                        ; preds = %.preheader5, %potencia.exit, %5\n" +
            "  %rpta.1 = phi i32 [ %18, %5 ], [ 0, %.preheader5 ], [ %48, %potencia.exit ]\n" +
            "  ret i32 %rpta.1\n" +
            "}\n" +
            "\n" +
            "define double** @identidad(double** %matriz, i32 %tam) nounwind optsize {\n" +
            "  %1 = icmp sgt i32 %tam, 0\n" +
            "  br i1 %1, label %.lr.ph, label %._crit_edge3\n" +
            "\n" +
            ".lr.ph:                                           ; preds = %._crit_edge, %0\n" +
            "  %i.02 = phi i32 [ %8, %._crit_edge ], [ 0, %0 ]\n" +
            "  %2 = getelementptr inbounds double** %matriz, i32 %i.02\n" +
            "  br label %3\n" +
            "\n" +
            "; <label>:3                                       ; preds = %3, %.lr.ph\n" +
            "  %j.01 = phi i32 [ 0, %.lr.ph ], [ %7, %3 ]\n" +
            "  %4 = icmp eq i32 %i.02, %j.01\n" +
            "  %5 = load double** %2, align 4, !tbaa !0\n" +
            "  %6 = getelementptr inbounds double* %5, i32 %j.01\n" +
            "  %. = select i1 %4, double 1.000000e+00, double 0.000000e+00\n" +
            "  store double %., double* %6, align 4\n" +
            "  %7 = add nsw i32 %j.01, 1\n" +
            "  %exitcond = icmp eq i32 %7, %tam\n" +
            "  br i1 %exitcond, label %._crit_edge, label %3\n" +
            "\n" +
            "._crit_edge:                                      ; preds = %3\n" +
            "  %8 = add nsw i32 %i.02, 1\n" +
            "  %exitcond4 = icmp eq i32 %8, %tam\n" +
            "  br i1 %exitcond4, label %._crit_edge3, label %.lr.ph\n" +
            "\n" +
            "._crit_edge3:                                     ; preds = %._crit_edge, %0\n" +
            "  ret double** %matriz\n" +
            "}\n" +
            "\n" +
            "define noalias double** @_mat_inversa(double** nocapture %matriz, i32 %tam) nounwind optsize {\n" +
            "  %1 = tail call double** @_mat_rreservar(double** undef, i32 %tam, i32 %tam) optsize\n" +
            "  %2 = tail call i32 @determinante(double** %matriz, i32 %tam) optsize\n" +
            "  %3 = icmp eq i32 %2, 0\n" +
            "  br i1 %3, label %.loopexit15, label %4\n" +
            "\n" +
            "; <label>:4                                       ; preds = %0\n" +
            "  %5 = icmp sgt i32 %tam, 0\n" +
            "  br i1 %5, label %.lr.ph.i, label %.loopexit15\n" +
            "\n" +
            ".lr.ph.i:                                         ; preds = %4, %._crit_edge.i\n" +
            "  %i.02.i = phi i32 [ %12, %._crit_edge.i ], [ 0, %4 ]\n" +
            "  %6 = getelementptr inbounds double** %1, i32 %i.02.i\n" +
            "  %7 = load double** %6, align 4, !tbaa !0\n" +
            "  br label %8\n" +
            "\n" +
            "; <label>:8                                       ; preds = %8, %.lr.ph.i\n" +
            "  %j.01.i = phi i32 [ 0, %.lr.ph.i ], [ %11, %8 ]\n" +
            "  %9 = icmp eq i32 %i.02.i, %j.01.i\n" +
            "  %10 = getelementptr inbounds double* %7, i32 %j.01.i\n" +
            "  %..i = select i1 %9, double 1.000000e+00, double 0.000000e+00\n" +
            "  store double %..i, double* %10, align 4\n" +
            "  %11 = add nsw i32 %j.01.i, 1\n" +
            "  %exitcond.i = icmp eq i32 %11, %tam\n" +
            "  br i1 %exitcond.i, label %._crit_edge.i, label %8\n" +
            "\n" +
            "._crit_edge.i:                                    ; preds = %8\n" +
            "  %12 = add nsw i32 %i.02.i, 1\n" +
            "  %exitcond4.i = icmp eq i32 %12, %tam\n" +
            "  br i1 %exitcond4.i, label %identidad.exit.preheader, label %.lr.ph.i\n" +
            "\n" +
            "identidad.exit.preheader:                         ; preds = %._crit_edge.i\n" +
            "  br i1 %5, label %.lr.ph22, label %.loopexit15\n" +
            "\n" +
            "identidad.exit.loopexit:                          ; preds = %._crit_edge27, %._crit_edge23\n" +
            "  %exitcond37 = icmp eq i32 %27, %tam\n" +
            "  br i1 %exitcond37, label %.preheader, label %.lr.ph22\n" +
            "\n" +
            ".preheader:                                       ; preds = %identidad.exit.loopexit\n" +
            "  br i1 %5, label %.lr.ph, label %.loopexit15\n" +
            "\n" +
            ".lr.ph22:                                         ; preds = %identidad.exit.loopexit, %identidad.exit.preheader\n" +
            "  %k.031 = phi i32 [ %27, %identidad.exit.loopexit ], [ 0, %identidad.exit.preheader ]\n" +
            "  %13 = getelementptr inbounds double** %matriz, i32 %k.031\n" +
            "  %14 = load double** %13, align 4, !tbaa !0\n" +
            "  %15 = getelementptr inbounds double* %14, i32 %k.031\n" +
            "  %16 = load double* %15, align 4, !tbaa !3\n" +
            "  %17 = getelementptr inbounds double** %1, i32 %k.031\n" +
            "  %18 = load double** %17, align 4, !tbaa !0\n" +
            "  br label %19\n" +
            "\n" +
            "; <label>:19                                      ; preds = %19, %.lr.ph22\n" +
            "  %z.020 = phi i32 [ 0, %.lr.ph22 ], [ %26, %19 ]\n" +
            "  %20 = getelementptr inbounds double* %14, i32 %z.020\n" +
            "  %21 = load double* %20, align 4, !tbaa !3\n" +
            "  %22 = fdiv double %21, %16\n" +
            "  store double %22, double* %20, align 4, !tbaa !3\n" +
            "  %23 = getelementptr inbounds double* %18, i32 %z.020\n" +
            "  %24 = load double* %23, align 4, !tbaa !3\n" +
            "  %25 = fdiv double %24, %16\n" +
            "  store double %25, double* %23, align 4, !tbaa !3\n" +
            "  %26 = add nsw i32 %z.020, 1\n" +
            "  %exitcond34 = icmp eq i32 %26, %tam\n" +
            "  br i1 %exitcond34, label %._crit_edge23, label %19\n" +
            "\n" +
            "._crit_edge23:                                    ; preds = %19\n" +
            "  %27 = add nsw i32 %k.031, 1\n" +
            "  %28 = icmp slt i32 %27, %tam\n" +
            "  br i1 %28, label %.lr.ph30, label %identidad.exit.loopexit\n" +
            "\n" +
            ".lr.ph30:                                         ; preds = %._crit_edge23\n" +
            "  %29 = getelementptr inbounds double** %1, i32 %k.031\n" +
            "  br label %.lr.ph26\n" +
            "\n" +
            ".lr.ph26:                                         ; preds = %._crit_edge27, %.lr.ph30\n" +
            "  %i.028 = phi i32 [ %27, %.lr.ph30 ], [ %54, %._crit_edge27 ]\n" +
            "  %30 = getelementptr inbounds double** %matriz, i32 %i.028\n" +
            "  %31 = load double** %30, align 4, !tbaa !0\n" +
            "  %32 = getelementptr inbounds double* %31, i32 %k.031\n" +
            "  %33 = load double* %32, align 4, !tbaa !3\n" +
            "  %34 = load double* %15, align 4, !tbaa !3\n" +
            "  %35 = fdiv double %33, %34\n" +
            "  %36 = fsub double -0.000000e+00, %35\n" +
            "  %37 = getelementptr inbounds double** %1, i32 %i.028\n" +
            "  %38 = load double** %37, align 4, !tbaa !0\n" +
            "  %39 = load double** %29, align 4, !tbaa !0\n" +
            "  br label %40\n" +
            "\n" +
            "; <label>:40                                      ; preds = %40, %.lr.ph26\n" +
            "  %j.024 = phi i32 [ 0, %.lr.ph26 ], [ %53, %40 ]\n" +
            "  %41 = getelementptr inbounds double* %31, i32 %j.024\n" +
            "  %42 = load double* %41, align 4, !tbaa !3\n" +
            "  %43 = getelementptr inbounds double* %14, i32 %j.024\n" +
            "  %44 = load double* %43, align 4, !tbaa !3\n" +
            "  %45 = fmul double %44, %36\n" +
            "  %46 = fadd double %42, %45\n" +
            "  store double %46, double* %41, align 4, !tbaa !3\n" +
            "  %47 = getelementptr inbounds double* %38, i32 %j.024\n" +
            "  %48 = load double* %47, align 4, !tbaa !3\n" +
            "  %49 = getelementptr inbounds double* %39, i32 %j.024\n" +
            "  %50 = load double* %49, align 4, !tbaa !3\n" +
            "  %51 = fmul double %50, %36\n" +
            "  %52 = fadd double %48, %51\n" +
            "  store double %52, double* %47, align 4, !tbaa !3\n" +
            "  %53 = add nsw i32 %j.024, 1\n" +
            "  %exitcond35 = icmp eq i32 %53, %tam\n" +
            "  br i1 %exitcond35, label %._crit_edge27, label %40\n" +
            "\n" +
            "._crit_edge27:                                    ; preds = %40\n" +
            "  %54 = add nsw i32 %i.028, 1\n" +
            "  %exitcond36 = icmp eq i32 %54, %tam\n" +
            "  br i1 %exitcond36, label %identidad.exit.loopexit, label %.lr.ph26\n" +
            "\n" +
            ".loopexit:                                        ; preds = %._crit_edge11, %._crit_edge\n" +
            "  %55 = icmp sgt i32 %k1.018, 0\n" +
            "  br i1 %55, label %.lr.ph, label %.loopexit15\n" +
            "\n" +
            ".lr.ph:                                           ; preds = %.loopexit, %.preheader\n" +
            "  %k1.018.in = phi i32 [ %k1.018, %.loopexit ], [ %tam, %.preheader ]\n" +
            "  %k1.018 = add nsw i32 %k1.018.in, -1\n" +
            "  %56 = getelementptr inbounds double** %matriz, i32 %k1.018\n" +
            "  %57 = load double** %56, align 4, !tbaa !0\n" +
            "  %58 = getelementptr inbounds double* %57, i32 %k1.018\n" +
            "  %59 = load double* %58, align 4, !tbaa !3\n" +
            "  %60 = getelementptr inbounds double** %1, i32 %k1.018\n" +
            "  %61 = load double** %60, align 4, !tbaa !0\n" +
            "  br label %62\n" +
            "\n" +
            "; <label>:62                                      ; preds = %62, %.lr.ph\n" +
            "  %z3.07 = phi i32 [ 0, %.lr.ph ], [ %69, %62 ]\n" +
            "  %63 = getelementptr inbounds double* %57, i32 %z3.07\n" +
            "  %64 = load double* %63, align 4, !tbaa !3\n" +
            "  %65 = fdiv double %64, %59\n" +
            "  store double %65, double* %63, align 4, !tbaa !3\n" +
            "  %66 = getelementptr inbounds double* %61, i32 %z3.07\n" +
            "  %67 = load double* %66, align 4, !tbaa !3\n" +
            "  %68 = fdiv double %67, %59\n" +
            "  store double %68, double* %66, align 4, !tbaa !3\n" +
            "  %69 = add nsw i32 %z3.07, 1\n" +
            "  %exitcond = icmp eq i32 %69, %tam\n" +
            "  br i1 %exitcond, label %._crit_edge, label %62\n" +
            "\n" +
            "._crit_edge:                                      ; preds = %62\n" +
            "  %70 = add nsw i32 %k1.018.in, -2\n" +
            "  %71 = icmp sgt i32 %70, -1\n" +
            "  br i1 %71, label %.lr.ph14, label %.loopexit\n" +
            "\n" +
            ".lr.ph14:                                         ; preds = %._crit_edge\n" +
            "  %72 = getelementptr inbounds double** %1, i32 %k1.018\n" +
            "  br label %.lr.ph10\n" +
            "\n" +
            ".lr.ph10:                                         ; preds = %.lr.ph14, %._crit_edge39\n" +
            "  %i4.012 = phi i32 [ %70, %.lr.ph14 ], [ %98, %._crit_edge39 ]\n" +
            "  %73 = getelementptr inbounds double** %matriz, i32 %i4.012\n" +
            "  %74 = load double** %73, align 4, !tbaa !0\n" +
            "  %75 = getelementptr inbounds double* %74, i32 %k1.018\n" +
            "  %76 = load double* %75, align 4, !tbaa !3\n" +
            "  %77 = load double* %58, align 4, !tbaa !3\n" +
            "  %78 = fdiv double %76, %77\n" +
            "  %79 = fsub double -0.000000e+00, %78\n" +
            "  %80 = getelementptr inbounds double** %1, i32 %i4.012\n" +
            "  %81 = load double** %80, align 4, !tbaa !0\n" +
            "  %82 = load double** %72, align 4, !tbaa !0\n" +
            "  br label %83\n" +
            "\n" +
            "; <label>:83                                      ; preds = %83, %.lr.ph10\n" +
            "  %j6.08 = phi i32 [ 0, %.lr.ph10 ], [ %96, %83 ]\n" +
            "  %84 = getelementptr inbounds double* %74, i32 %j6.08\n" +
            "  %85 = load double* %84, align 4, !tbaa !3\n" +
            "  %86 = getelementptr inbounds double* %57, i32 %j6.08\n" +
            "  %87 = load double* %86, align 4, !tbaa !3\n" +
            "  %88 = fmul double %87, %79\n" +
            "  %89 = fadd double %85, %88\n" +
            "  store double %89, double* %84, align 4, !tbaa !3\n" +
            "  %90 = getelementptr inbounds double* %81, i32 %j6.08\n" +
            "  %91 = load double* %90, align 4, !tbaa !3\n" +
            "  %92 = getelementptr inbounds double* %82, i32 %j6.08\n" +
            "  %93 = load double* %92, align 4, !tbaa !3\n" +
            "  %94 = fmul double %93, %79\n" +
            "  %95 = fadd double %91, %94\n" +
            "  store double %95, double* %90, align 4, !tbaa !3\n" +
            "  %96 = add nsw i32 %j6.08, 1\n" +
            "  %exitcond33 = icmp eq i32 %96, %tam\n" +
            "  br i1 %exitcond33, label %._crit_edge11, label %83\n" +
            "\n" +
            "._crit_edge11:                                    ; preds = %83\n" +
            "  %97 = icmp sgt i32 %i4.012, 0\n" +
            "  br i1 %97, label %._crit_edge39, label %.loopexit\n" +
            "\n" +
            "._crit_edge39:                                    ; preds = %._crit_edge11\n" +
            "  %98 = add nsw i32 %i4.012, -1\n" +
            "  br label %.lr.ph10\n" +
            "\n" +
            ".loopexit15:                                      ; preds = %4, %identidad.exit.preheader, %.preheader, %.loopexit, %0\n" +
            "  ret double** %1\n" +
            "}\n";
    public String _mat_rproducto = "define noalias double** @_mat_rproducto(double** nocapture %A, double** nocapture %B, i32 %fil1, i32 %col1, i32 %fil2, i32 %col2) nounwind optsize {\n" +
            "  %1 = tail call double** @_mat_rreservar(double** undef, i32 %fil1, i32 %col2) optsize\n" +
            "  %2 = icmp eq i32 %col1, %fil2\n" +
            "  %3 = icmp sgt i32 %fil1, 0\n" +
            "  %or.cond = and i1 %2, %3\n" +
            "  br i1 %or.cond, label %.preheader.lr.ph, label %.loopexit\n" +
            "\n" +
            ".preheader.lr.ph:                                 ; preds = %0\n" +
            "  %4 = icmp sgt i32 %col2, 0\n" +
            "  %5 = icmp sgt i32 %col1, 0\n" +
            "  br label %.preheader\n" +
            "\n" +
            ".preheader:                                       ; preds = %._crit_edge4, %.preheader.lr.ph\n" +
            "  %i.06 = phi i32 [ 0, %.preheader.lr.ph ], [ %24, %._crit_edge4 ]\n" +
            "  br i1 %4, label %.lr.ph3, label %._crit_edge4\n" +
            "\n" +
            ".lr.ph3:                                          ; preds = %.preheader\n" +
            "  %6 = getelementptr inbounds double** %1, i32 %i.06\n" +
            "  %7 = load double** %6, align 4, !tbaa !0\n" +
            "  %8 = getelementptr inbounds double** %A, i32 %i.06\n" +
            "  br label %9\n" +
            "\n" +
            "; <label>:9                                       ; preds = %._crit_edge, %.lr.ph3\n" +
            "  %j.02 = phi i32 [ 0, %.lr.ph3 ], [ %23, %._crit_edge ]\n" +
            "  %10 = getelementptr inbounds double* %7, i32 %j.02\n" +
            "  store double 0.000000e+00, double* %10, align 4, !tbaa !3\n" +
            "  br i1 %5, label %.lr.ph, label %._crit_edge\n" +
            "\n" +
            ".lr.ph:                                           ; preds = %9\n" +
            "  %11 = load double** %8, align 4, !tbaa !0\n" +
            "  br label %12\n" +
            "\n" +
            "; <label>:12                                      ; preds = %12, %.lr.ph\n" +
            "  %13 = phi double [ 0.000000e+00, %.lr.ph ], [ %21, %12 ]\n" +
            "  %k.01 = phi i32 [ 0, %.lr.ph ], [ %22, %12 ]\n" +
            "  %14 = getelementptr inbounds double* %11, i32 %k.01\n" +
            "  %15 = load double* %14, align 4, !tbaa !3\n" +
            "  %16 = getelementptr inbounds double** %B, i32 %k.01\n" +
            "  %17 = load double** %16, align 4, !tbaa !0\n" +
            "  %18 = getelementptr inbounds double* %17, i32 %j.02\n" +
            "  %19 = load double* %18, align 4, !tbaa !3\n" +
            "  %20 = fmul double %15, %19\n" +
            "  %21 = fadd double %13, %20\n" +
            "  store double %21, double* %10, align 4, !tbaa !3\n" +
            "  %22 = add nsw i32 %k.01, 1\n" +
            "  %exitcond = icmp eq i32 %22, %col1\n" +
            "  br i1 %exitcond, label %._crit_edge, label %12\n" +
            "\n" +
            "._crit_edge:                                      ; preds = %12, %9\n" +
            "  %23 = add nsw i32 %j.02, 1\n" +
            "  %exitcond7 = icmp eq i32 %23, %col2\n" +
            "  br i1 %exitcond7, label %._crit_edge4, label %9\n" +
            "\n" +
            "._crit_edge4:                                     ; preds = %._crit_edge, %.preheader\n" +
            "  %24 = add nsw i32 %i.06, 1\n" +
            "  %exitcond8 = icmp eq i32 %24, %fil1\n" +
            "  br i1 %exitcond8, label %.loopexit, label %.preheader\n" +
            "\n" +
            ".loopexit:                                        ; preds = %._crit_edge4, %0\n" +
            "  ret double** %1\n" +
            "}\n";
    public String _mat_eproducto = "define noalias i32** @_mat_eproducto(double** nocapture %A, double** nocapture %B, i32 %fil1, i32 %col1, i32 %fil2, i32 %col2) nounwind optsize {\n" +
            "  %1 = tail call i32** @_mat_ereservar(i32** undef, i32 %fil1, i32 %col2) optsize\n" +
            "  %2 = icmp eq i32 %col1, %fil2\n" +
            "  %3 = icmp sgt i32 %fil1, 0\n" +
            "  %or.cond = and i1 %2, %3\n" +
            "  br i1 %or.cond, label %.preheader.lr.ph, label %.loopexit\n" +
            "\n" +
            ".preheader.lr.ph:                                 ; preds = %0\n" +
            "  %4 = icmp sgt i32 %col2, 0\n" +
            "  %5 = icmp sgt i32 %col1, 0\n" +
            "  br label %.preheader\n" +
            "\n" +
            ".preheader:                                       ; preds = %._crit_edge4, %.preheader.lr.ph\n" +
            "  %i.06 = phi i32 [ 0, %.preheader.lr.ph ], [ %27, %._crit_edge4 ]\n" +
            "  br i1 %4, label %.lr.ph3, label %._crit_edge4\n" +
            "\n" +
            ".lr.ph3:                                          ; preds = %.preheader\n" +
            "  %6 = getelementptr inbounds i32** %1, i32 %i.06\n" +
            "  %7 = load i32** %6, align 4, !tbaa !0\n" +
            "  %8 = getelementptr inbounds double** %A, i32 %i.06\n" +
            "  br label %9\n" +
            "\n" +
            "; <label>:9                                       ; preds = %25, %.lr.ph3\n" +
            "  %j.02 = phi i32 [ 0, %.lr.ph3 ], [ %26, %25 ]\n" +
            "  %10 = getelementptr inbounds i32* %7, i32 %j.02\n" +
            "  store i32 0, i32* %10, align 4, !tbaa !4\n" +
            "  br i1 %5, label %.lr.ph, label %25\n" +
            "\n" +
            ".lr.ph:                                           ; preds = %9\n" +
            "  %11 = load double** %8, align 4, !tbaa !0\n" +
            "  br label %12\n" +
            "\n" +
            "; <label>:12                                      ; preds = %12, %.lr.ph\n" +
            "  %13 = phi i32 [ 0, %.lr.ph ], [ %23, %12 ]\n" +
            "  %k.01 = phi i32 [ 0, %.lr.ph ], [ %24, %12 ]\n" +
            "  %14 = sitofp i32 %13 to double\n" +
            "  %15 = getelementptr inbounds double* %11, i32 %k.01\n" +
            "  %16 = load double* %15, align 4, !tbaa !3\n" +
            "  %17 = getelementptr inbounds double** %B, i32 %k.01\n" +
            "  %18 = load double** %17, align 4, !tbaa !0\n" +
            "  %19 = getelementptr inbounds double* %18, i32 %j.02\n" +
            "  %20 = load double* %19, align 4, !tbaa !3\n" +
            "  %21 = fmul double %16, %20\n" +
            "  %22 = fadd double %14, %21\n" +
            "  %23 = fptosi double %22 to i32\n" +
            "  %24 = add nsw i32 %k.01, 1\n" +
            "  %exitcond = icmp eq i32 %24, %col1\n" +
            "  br i1 %exitcond, label %._crit_edge, label %12\n" +
            "\n" +
            "._crit_edge:                                      ; preds = %12\n" +
            "  store i32 %23, i32* %10, align 4\n" +
            "  br label %25\n" +
            "\n" +
            "; <label>:25                                      ; preds = %._crit_edge, %9\n" +
            "  %26 = add nsw i32 %j.02, 1\n" +
            "  %exitcond7 = icmp eq i32 %26, %col2\n" +
            "  br i1 %exitcond7, label %._crit_edge4, label %9\n" +
            "\n" +
            "._crit_edge4:                                     ; preds = %25, %.preheader\n" +
            "  %27 = add nsw i32 %i.06, 1\n" +
            "  %exitcond8 = icmp eq i32 %27, %fil1\n" +
            "  br i1 %exitcond8, label %.loopexit, label %.preheader\n" +
            "\n" +
            ".loopexit:                                        ; preds = %._crit_edge4, %0\n" +
            "  ret i32** %1\n" +
            "}\n";
    public String _mat_itemr = "define double @_mat_itemr(double** nocapture %A, i32 %fil, i32 %col) nounwind readonly optsize {\n" +
            "  %1 = getelementptr inbounds double** %A, i32 %fil\n" +
            "  %2 = load double** %1, align 4, !tbaa !0\n" +
            "  %3 = getelementptr inbounds double* %2, i32 %col\n" +
            "  %4 = load double* %3, align 4, !tbaa !3\n" +
            "  ret double %4\n" +
            "}\n";
    public String _mat_iteme = "define i32 @_mat_iteme(i32** nocapture %A, i32 %fil, i32 %col) nounwind readonly optsize {\n" +
            "  %1 = getelementptr inbounds i32** %A, i32 %fil\n" +
            "  %2 = load i32** %1, align 4, !tbaa !0\n" +
            "  %3 = getelementptr inbounds i32* %2, i32 %col\n" +
            "  %4 = load i32* %3, align 4, !tbaa !4\n" +
            "  ret i32 %4\n" +
            "}\n";
    public static boolean[] cabecera = {false,false,false,false,false,false,false,false,false,false,
                                        false,false,false,false,false,false,false,false,false,false,
                                        false,false,false,false,false,false,false,false,false,false,
                                        false,false,false,false,false,false,false,false,false,false,
                                        false,false,false,false,false,false,false,false,false,false,
                                        false,false,false,false,false,false,false,false,false,false,
                                        false,false,false,false, false, false,false,false,false,false,
                                        false,false,false,false,false};

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
            case 1: return _leer_cab; //0
            case 2: return _str_ie ; //1
            case 3: return _str_ir; //2
            case 4: return _str_pe; //3
            case 5: return _str_pr; //4
            case 6: return _ent_a_real; //5
            case 7: return _real_a_ent; //6
            case 8: return _esuma; //7
            case 9: return _eresta; //8
            case 10: return _edivision; //9
            case 11: return _eproducto; //10
            case 12: return _emodulo; //11
            case 13: return _emayor; //12
            case 14: return _emenor; //13
            case 15: return _emayor_igual; //14
            case 16: return _emenor_igual; //15
            case 17: return _econjuncion; //16
            case 18: return _edisyuncion; //17
            case 19: return _eidentico; //18
            case 20: return _ediferente; //19
            case 21: return _enegacion; //20
            case 22: return _enegatividad; //21
            case 23: return _rsuma; //22
            case 24: return _rresta; //23
            case 25: return _rdivision; //24
            case 26: return _rproducto; //25
            case 27: return _rmodulo; //26
            case 28: return _rmayor; //27
            case 29: return _rmenor; //28
            case 30: return _rmayor_igual; //29
            case 31: return _rmenor_igual; //30
            case 32: return _rconjuncion; //31
            case 33: return _rdisyuncion; //32
            case 34: return _ridentico; //33
            case 35: return _rdiferente; //34
            case 36: return _rnegacion; //35
            case 37: return _rnegatividad; //36
            case 38: return _mat_def;
            case 39: return _mat_rreservar;
            case 40: return _mat_ereservar;
            case 41: return _mat_ent_a_real;
            case 42: return _mat_real_a_ent;
            case 43: return _mat_rponer;
            case 44: return _mat_eponer;
            case 45: return _mat_rsuma;
            case 46: return _mat_esuma;
            case 47: return _mat_rresta;
            case 48: return _mat_eresta;
            case 49: return _mat_rimprimir;
            case 50: return _mat_eimprimir;
            case 51: return _mat_imprimir_cabecera_e;
            case 52: return _mat_imprimir_cabecera_r;
            case 53: return _mat_default_pos;
            case 54: return str_error;
            case 55: return _mat_comprobar;
            case 56: return _str_error2;
            case 57: return _mat_comprobar_tam;
            case 58: return asig_e;
            case 59: return asig_r;
            case 60: return _mat_rmayor;
            case 61: return _mat_rmenor;
            case 62: return _mat_rmayor_igual;
            case 63: return _mat_rmenor_igual;
            case 64: return _mat_rconjuncion;
            case 65: return _mat_rdisyuncion;
            case 66: return _mat_ridentico;
            case 67: return _mat_rdiferente;
            case 68: return _mat_rnegacion;
            case 69: return _mat_rnegatividad;
            case 70: return _mat_enegatividad;
            case 71: return _mat_transpuesta;
            case 72: return _mat_inversa;
            case 73: return _mat_rproducto;
            case 74: return _mat_eproducto;
            case 75: return _mat_itemr;
            case 76: return _mat_iteme;
        }
        return tmp;
    }
    
    public String _arquitectura_32 = "target datalayout = \"e-p:32:32:32-i1:8:8-i8:8:8-i16:16:16-i32:32:32-i64:32:64-f32:32:32-f64:32:64-v64:64:64-v128:128:128-a0:0:64-f80:32:32-n8:16:32-S128\"\n" +
                                    "target triple = \"i386-pc-linux-gnu\"\n";
    public String _arquitectura_64 =    "target datalayout = \"e-p:64:64:64-i1:8:8-i8:8:8-i16:16:16-i32:32:32-i64:64:64-f32:32:32-f64:64:64-v64:64:64-v128:128:128-a0:0:64-s0:64:64-f80:128:128-n8:16:32:64-S128\"\n" +
                                        "target triple = \"x86_64-pc-linux-gnu\"\n";
    public boolean arquitectura = true;
    public void setArquitectura(boolean a){
        arquitectura = a;
    }
    public String getArquitectura(){
        if(arquitectura)
            return _arquitectura_32;
        else
            return _arquitectura_64;
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
