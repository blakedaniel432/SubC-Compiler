int centigrade;
int five;
int ratio;
int fahrenheit;
int number;
{
	int root;
	int dze;
	char character;
	
    { //Temperature conversions
        const int TWO = 2;
        const int THREE = 3;
		
        five = -1 + TWO - THREE + 4 + 3;
        ratio = five/9.0;
        
        while (five != 3) {
        	five = five - 1;
        }
        
        if (ratio == 5/9.0) { 
        	ratio = 1;
        	
        	if (ratio == 1) { 
        		ratio = five/9.0;
        	}
        }
        
        
        fahrenheit = 72;
        centigrade = (fahrenheit - 32)*ratio;

        centigrade = 25;
        fahrenheit = centigrade/ratio + 32;

        centigrade = 25;
        fahrenheit = 32 + centigrade/ratio;
    }
    
    //Runtime division by zero error.
    dze = fahrenheit/(ratio - ratio);

    { //Calculate a square root using Newton's method
        number = 2;
        root = number;
        root = (number/root + root)/2;
    }

    character = 'a';
}