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


.line 23
	invokestatic	testprog/programstart()V
.line 29
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
.line 30
	getstatic	testprog/six I
	i2f
	iconst_2
	i2f
	idiv
	putstatic	testprog/ratio I
.line 33
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
.line 34
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
.line 36
L001:
	getstatic	testprog/ratio I
	bipush	6
	if_icmpne	L003
	iconst_0
	goto	L004
L003:
	iconst_1
L004:
	iconst_1
	ixor
	ifne	L002
.line 37
	getstatic	testprog/ratio I
	iconst_1
	iadd
	putstatic	testprog/ratio I
	goto	L001
L002:
.line 40
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
.line 42
	getstatic	testprog/ratio I
	bipush	6
	if_icmpeq	L006
	iconst_0
	goto	L007
L006:
	iconst_1
L007:
	ifeq	L005
.line 43
	iconst_5
	putstatic	testprog/ratio I
.line 45
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"Ratio after if statement: %d\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	testprog/ratio I
	invokestatic	java/lang/Integer.valueOf(I)Ljava/lang/Integer;
	aastore
	invokestatic	java/lang/String/format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V
.line 47
	getstatic	testprog/ratio I
	iconst_5
	if_icmpeq	L009
	iconst_0
	goto	L010
L009:
	iconst_1
L010:
	ifeq	L008
.line 48
	iconst_3
	putstatic	testprog/ratio I
L008:
.line 51
	getstatic	java/lang/System/out Ljava/io/PrintStream;
	ldc	"Ratio after nested if statement: %d\n"
	iconst_1
	anewarray	java/lang/Object
	dup
	iconst_0
	getstatic	testprog/ratio I
	invokestatic	java/lang/Integer.valueOf(I)Ljava/lang/Integer;
	aastore
	invokestatic	java/lang/String/format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
	invokevirtual	java/io/PrintStream.print(Ljava/lang/String;)V
L005:
.line 54
	getstatic	testprog/six I
	getstatic	testprog/ratio I
	iadd
	putstatic	testprog/number I
.line 55
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
.line 57
	getstatic	testprog/number I
	i2f
	getstatic	testprog/ratio I
	i2f
	idiv
	putstatic	testprog/number I
.line 58
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
.line 60
	getstatic	testprog/number I
	getstatic	testprog/ratio I
	imul
	putstatic	testprog/number I
.line 61
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
.line 66
	bipush	97
	putstatic	testprog/character C
.line 67
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
.line 69
	invokestatic	testprog/programend()V

	getstatic	testprog/_runTimer LRunTimer;
	invokevirtual	RunTimer.printElapsedTime()V

	return

.limit locals 1
.limit stack 7
.end method
