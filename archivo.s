	.file	"/media/yuli/Yuli/CO/Software/LeMa 2.0/LeMa/archivo.bc"
	.text
	.globl	main
	.type	main,@function
main:                                   # @main
# BB#0:
	xorl	%eax, %eax
	ret
.Ltmp0:
	.size	main, .Ltmp0-main

	.type	c,@object               # @c
	.section	.rodata,"a",@progbits
	.globl	c
	.align	4
c:
	.long	0                       # 0x0
	.size	c, 4

	.type	b,@object               # @b
	.globl	b
	.align	8
b:
	.quad	0                       # double 0
	.size	b, 8

	.type	a,@object               # @a
	.globl	a
	.align	4
a:
	.long	0                       # 0x0
	.size	a, 4


	.section	".note.GNU-stack","",@progbits
