target datalayout = "e-p:64:64:64-i1:8:8-i8:8:8-i16:16:16-i32:32:32-i64:64:64-f32:32:32-f64:64:64-v64:64:64-v128:128:128-a0:0:64-s0:64:64-f80:128:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"
define i32 @main() nounwind readnone optsize {
%b = tail call double @_ent_a_real(i32 0)
%_var4 = tail call double @_ent_a_real(i32 4)
%_var1 = tail call double @_rproducto(double %_var4, double %b)
%_var2 = tail call double @_rsuma(double 3.0, double %_var1)
%_var5 = tail call double @_ent_a_real(i32 4)
%_var3 = tail call double @_rresta(double %_var2, double %_var5)
%a = tail call i32 @_real_a_ent(double %_var3)
ret i32 0
}
define double @_ent_a_real(i32 %a) nounwind readnone optsize {
  %1 = sitofp i32 %a to double
  ret double %1
}
define i32 @_real_a_ent(double %a) nounwind readnone optsize {
  %1 = fptosi double %a to i32
  ret i32 %1
}
define double @_rsuma(double %a, double %b) nounwind readnone optsize {
  %1 = fadd double %a, %b
  ret double %1
}
define double @_rresta(double %a, double %b) nounwind readnone optsize {
  %1 = fsub double %a, %b
  ret double %1
}
define double @_rproducto(double %a, double %b) nounwind readnone optsize {
  %1 = fmul double %a, %b
  ret double %1
}
