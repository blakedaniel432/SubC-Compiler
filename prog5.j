.class public prog5
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
	putstatic	prog5/_runTimer LRunTimer;
	new	SubCTextIn
	dup
	invokenonvirtual	SubCTextIn/<init>()V
	putstatic	prog5/_standardIn LSubCTextIn;


.line 8
	iconst_0
	putstatic	prog5/i I
.line 9
	iconst_5
	putstatic	prog5/j I
.line 12
L001:
	getstatic	prog5/i I
	getstatic	prog5/j I
	if_icmplt	L003
	iconst_0
	goto	L004
L003:
	iconst_1
L004:
	iconst_1
	ixor
	ifne	L002
.line 13
	getstatic	prog5/i I
	iconst_1
	iadd
	putstatic	prog5/i I
.line 14
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"Current value for i: %d\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	prog5/i I
	invokestatic	java/lang/Integer.valueOf(I)Ljava/lang/Integer;
	aastore
	invokestatic	java/lang/String/format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V
	goto	L001
L002:

	getstatic	prog5/_runTimer LRunTimer;
	invokevirtual	RunTimer.printElapsedTime()V

	return

.limit locals 1
.limit stack 7
.end method
