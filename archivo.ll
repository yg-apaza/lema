target datalayout = "e-p:32:32:32-i1:8:8-i8:8:8-i16:16:16-i32:32:32-i64:32:64-f32:32:32-f64:32:64-v64:64:64-v128:128:128-a0:0:64-f80:32:32-n8:16:32-S128"
target triple = "i386-pc-linux-gnu"
@c = constant i32 zeroinitializer
define i32 @main() nounwind readnone optsize {
%_var4 = tail call double @_ent_a_real(i32 7)
%_var5 = tail call double @_ent_a_real(i32 4)
%_var1 = tail call double @_rsuma(double %_var4, double %_var5)
%_var6 = load i32* @c, align 4
%_var7 = tail call double @_ent_a_real(i32 %_var6)
%_var2 = tail call double @_rsuma(double %_var1, double %_var7)
%b = tail call double @asig_r(double %_var2)
%_var8 = tail call double @_ent_a_real(i32 4)
%_var3 = tail call double @_rsuma(double %b, double %_var8)
%_var9 = tail call i32 @_real_a_ent(double %_var3)
%a = tail call i32 @asig_e(i32 %_var9)
ret i32 0
}
define void @c.act_e(i32 %nuevo) nounwind optsize {
  store i32 %nuevo, i32* @c, align 4, !tbaa !0
  ret void
}
define void @c.act_r(double %nuevo) nounwind optsize {
  %1 = fptosi double %nuevo to i32
  store i32 %1, i32* @c, align 4, !tbaa !0
  ret void
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
declare void @exit(i32) noreturn nounwind optsize
declare i32 @puts(i8* nocapture) nounwind
declare i32 @putchar(i32)

!0 = metadata !{metadata !"any pointer", metadata !1}
!1 = metadata !{metadata !"omnipotent char", metadata !2}
!2 = metadata !{metadata !"Simple C/C++ TBAA", null}
!3 = metadata !{metadata !"int", metadata !1}
!4 = metadata !{metadata !"double", metadata !1}
define i32 @asig_e(i32 %nuevo) nounwind readnone optsize {
  ret i32 %nuevo
}
define double @asig_r(double %nuevo) nounwind readnone optsize {
  ret double %nuevo
}
