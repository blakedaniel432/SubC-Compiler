.class public prog6
.super java/lang/Object

.field private static _runTimer LRunTimer;
.field private static _standardIn LSubCTextIn;


.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method private static foo()V



.line 6
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"This is function foo\n"
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V

	return

.limit locals 1
.limit stack 2
.end method

.method private static bar()V



.line 11
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"This is function bar\n"
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V

	return

.limit locals 1
.limit stack 2
.end method

.method public static main([Ljava/lang/String;)V

	new	RunTimer
	dup
	invokenonvirtual	RunTimer/<init>()V
	putstatic	prog6/_runTimer LRunTimer;
	new	SubCTextIn
	dup
	invokenonvirtual	SubCTextIn/<init>()V
	putstatic	prog6/_standardIn LSubCTextIn;


.line 16
	invokestatic	prog6/foo()V
.line 17
	invokestatic	prog6/bar()V
.line 18
	invokestatic	prog6/foo()V

	getstatic	prog6/_runTimer LRunTimer;
	invokevirtual	RunTimer.printElapsedTime()V

	return

.limit locals 1
.limit stack 3
.end method
