//Test Program 3
program prog3;

{
	int i;
	int j;

	write("Enter a value for i: ");
	read(i);

	write("Enter a value for j: ");
	read(j);

	i = j*5 + i/2 - 2;

	writeln("New value for i is ", i);
	writeln("Old value for j is ", j);

}