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
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"***Program Started!***\n"
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V

	return

.limit locals 1
.limit stack 2
.end method

.method private static programend()V



.line 12
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"***Program Ended!***\n"
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V

	return

.limit locals 1
.limit stack 2
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
	invokestatic	testprog/programstart()V
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
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"Six: %d\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	testprog/six I
	invokestatic	java/lang/Integer.valueOf(I)Ljava/lang/Integer;
	aastore
	invokestatic	java/lang/String/format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V
.line 32
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"Ratio: %d\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	testprog/ratio I
	invokestatic	java/lang/Integer.valueOf(I)Ljava/lang/Integer;
	aastore
	invokestatic	java/lang/String/format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V
.line 34
.line 38
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"Ratio after while loop: %d\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	testprog/ratio I
	invokestatic	java/lang/Integer.valueOf(I)Ljava/lang/Integer;
	aastore
	invokestatic	java/lang/String/format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V
.line 40
.line 52
	getstatic	testprog/six I
	getstatic	testprog/ratio I
	iadd
	putstatic	testprog/number I
.line 53
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"Number = six + ratio = %d\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	testprog/number I
	invokestatic	java/lang/Integer.valueOf(I)Ljava/lang/Integer;
	aastore
	invokestatic	java/lang/String/format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V
.line 55
	getstatic	testprog/number I
	i2f
	getstatic	testprog/ratio I
	i2f
	idiv
	putstatic	testprog/number I
.line 56
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"Number = number / ratio = %d\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	testprog/number I
	invokestatic	java/lang/Integer.valueOf(I)Ljava/lang/Integer;
	aastore
	invokestatic	java/lang/String/format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V
.line 58
	getstatic	testprog/number I
	getstatic	testprog/ratio I
	imul
	putstatic	testprog/number I
.line 59
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"Number = number * ratio = %d\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	testprog/number I
	invokestatic	java/lang/Integer.valueOf(I)Ljava/lang/Integer;
	aastore
	invokestatic	java/lang/String/format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V
.line 64
	bipush	97
	putstatic	testprog/character C
.line 65
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"Character: %c\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	testprog/character C
	invokestatic	java/lang/Character.valueOf(C)Ljava/lang/Character;
	aastore
	invokestatic	java/lang/String/format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V
.line 67
	invokestatic	testprog/programend()V

	getstatic	testprog/_runTimer LRunTimer;
	invokevirtual	RunTimer.printElapsedTime()V

	return

.limit locals 1
.limit stack 7
.end method
