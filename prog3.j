.class public prog3
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
	putstatic	prog3/_runTimer LRunTimer;
	new	SubCTextIn
	dup
	invokenonvirtual	SubCTextIn/<init>()V
	putstatic	prog3/_standardIn LSubCTextIn;


.line 8
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"Enter a value for i: "
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V
.line 9
	getstatic	prog3/_standardIn LSubCTextIn;
	invokevirtual	SubCTextIn.readInteger()I
	putstatic	prog3/i I
.line 11
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"Enter a value for j: "
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V
.line 12
	getstatic	prog3/_standardIn LSubCTextIn;
	invokevirtual	SubCTextIn.readInteger()I
	putstatic	prog3/j I
.line 14
	getstatic	prog3/j I
	iconst_5
	imul
	getstatic	prog3/i I
	i2f
	iconst_2
	i2f
	idiv
	iadd
	iconst_2
	isub
	putstatic	prog3/i I
.line 16
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"New value for i is %d\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	prog3/i I
	invokestatic	java/lang/Integer.valueOf(I)Ljava/lang/Integer;
	aastore
	invokestatic	java/lang/String/format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V
.line 17
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"Old value for j is %d\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	prog3/j I
	invokestatic	java/lang/Integer.valueOf(I)Ljava/lang/Integer;
	aastore
	invokestatic	java/lang/String/format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V

	getstatic	prog3/_runTimer LRunTimer;
	invokevirtual	RunTimer.printElapsedTime()V

	return

.limit locals 1
.limit stack 7
.end method
