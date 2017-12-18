.class public prog4
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
	putstatic	prog4/_runTimer LRunTimer;
	new	SubCTextIn
	dup
	invokenonvirtual	SubCTextIn/<init>()V
	putstatic	prog4/_standardIn LSubCTextIn;


.line 8
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"Enter a value for i: "
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V
.line 9
	getstatic	prog4/_standardIn LSubCTextIn;
	invokevirtual	SubCTextIn.readInteger()I
	putstatic	prog4/i I
.line 11
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"Enter a value for j: "
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V
.line 12
	getstatic	prog4/_standardIn LSubCTextIn;
	invokevirtual	SubCTextIn.readInteger()I
	putstatic	prog4/j I
.line 14
	getstatic	prog4/i I
	getstatic	prog4/j I
	if_icmpgt	L002
	iconst_0
	goto	L003
L002:
	iconst_1
L003:
	ifeq	L004
.line 15
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"i is greater than j\n"
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V
	goto	L001
L004:
.line 18
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"i is less than or equal to j\n"
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V
L001:

	getstatic	prog4/_runTimer LRunTimer;
	invokevirtual	RunTimer.printElapsedTime()V

	return

.limit locals 1
.limit stack 3
.end method
