program test;

procedure testFunction;
{
	writeln("Hi, Dr. Wang!");
}

int centigrade;
int five;
int ratio;
int fahrenheit;
int number;
{
	int root;
	char character;
	
	testFunction;
	
    { //Temperature conversions
        const int TWO = 2;
        const int THREE = 3;
		
        five = -1 + TWO - THREE + 4 + 3;       
        ratio = five/9.0;
        
        write("Five: ", five);
        
        while (five != 3) {
        	five = five - 1;
        }
        
        write("Five: ", five);
        
        if (ratio == 5/9.0) { 
        	ratio = 1;
        	
        	write("Ratio: ", ratio);
        	
        	if (ratio == 1) { 
        		ratio = five/9.0;
        	}
        }
        
        write("Ratio: ", ratio);
        
        fahrenheit = 72;
        centigrade = (fahrenheit - 32)*ratio;

        centigrade = 25;
        fahrenheit = centigrade/ratio + 32;

        centigrade = 25;
        fahrenheit = 32 + centigrade/ratio;
    }
    

    { //Calculate a square root using Newton's method
        number = 2;
        root = number;
        root = (number/root + root)/2;
    }

    character = 'a';
    
    write("Character: ", ratio);
}