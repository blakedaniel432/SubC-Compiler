.class public prog2
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LSubCTextIn;

.field private static i I
.field private static j I

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public static main([Ljava/lang/String;)V

	new	RunTimer
	dup
	invokenonvirtual	RunTimer/<init>()V
	putstatic	prog2/_runTimer LRunTimer;
	new	SubCTextIn
	dup
	invokenonvirtual	SubCTextIn/<init>()V
	putstatic	prog2/_standardIn LSubCTextIn;


.line 7
	iconst_0
	putstatic	prog2/i I
.line 8
	iconst_1
	putstatic	prog2/j I
.line 10
	getstatic	prog2/i I
	getstatic	prog2/j I
	if_icmpgt	L002
	iconst_0
	goto	L003
L002:
	iconst_1
L003:
	ifeq	L004
.line 11
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"i is greater than j\n"
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V
	goto	L001
L004:
.line 14
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"i is less than or equal to j\n"
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V
L001:

	getstatic	prog2/_runTimer LRunTimer;
	invokevirtual	RunTimer.printElapsedTime()V

	return

.limit locals 1
.limit stack 3
.end method
