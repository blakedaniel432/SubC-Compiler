.class public testprog
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LSubCTextIn;

.field private static character C
.field private static number I
.field private static ratio I
.field private static root I
.field private static six I

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method private static programstart()V


.line 7

	return

.limit locals 1
.limit stack 0
.end method

.method private static programend()V


.line 12

	return

.limit locals 1
.limit stack 0
.end method

.method public static main([Ljava/lang/String;)V

	new	RunTimer
	dup
	invokenonvirtual	RunTimer/<init>()V
	putstatic	testprog/_runTimer LRunTimer;
	new	SubCTextIn
	dup
	invokenonvirtual	SubCTextIn/<init>()V
	putstatic	testprog/_standardIn LSubCTextIn;

.line 22
.line 28
	iconst_1
	ineg
	iconst_2
	iadd
	iconst_3
	isub
	iconst_3
	iadd
	iconst_5
	iadd
	putstatic	testprog/six I
.line 29
	getstatic	testprog/six I
	i2f
	iconst_2
	i2f
	idiv
	putstatic	testprog/ratio I
.line 31
.line 32
.line 34
.line 38
.line 40
.line 52
	getstatic	testprog/six I
	getstatic	testprog/ratio I
	iadd
	putstatic	testprog/number I
.line 53
.line 55
	getstatic	testprog/number I
	i2f
	getstatic	testprog/ratio I
	i2f
	idiv
	putstatic	testprog/number I
.line 56
.line 58
	getstatic	testprog/number I
	getstatic	testprog/ratio I
	imul
	putstatic	testprog/number I
.line 59
.line 64
	bipush	97
	putstatic	testprog/character C
.line 65
.line 67

	getstatic	testprog/_runTimer LRunTimer;
	invokevirtual	RunTimer.printElapsedTime()V

	return

.limit locals 1
.limit stack 3
.end method
