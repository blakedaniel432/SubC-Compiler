//FrankenC by Blake and Daniel

program testprog;

procedure programStart;
{
	writeln("***Program Started!***");
}

procedure programEnd;
{
	writeln("***Program Ended!***");
}

int six;
int ratio;
int number;
{
	int root;
	char character;
	
	programStart;
	
    { //Sample program
        const int TWO = 2;
        const int THREE = 3;
		
        six = -1 + TWO - THREE + 3 + 5;       
        ratio = six/2;
        
        writeln("Six: ", six);
        writeln("Ratio: ", ratio);
        
        while (ratio != 6) {
        	ratio = ratio + 1;
        }
        
        writeln("Ratio after While loop: ", ratio);
        
        if (ratio == 6) { 
        	ratio = 5;
        	
        	writeln("Ratio after If statement: ", ratio);
        	
        	if (ratio == 5) { 
        		ratio = 3;
        	}
        	
        	writeln("Ratio after nested If statement: ", ratio);
        }
        
        number = six + ratio;
        writeln("Number = six + ratio = ", number);
        
        number = number / ratio;
        writeln("Number = number / ratio = ", number);
        
        number = number * ratio;
        writeln("Number = number * ratio = ", number);
        
        
    }

    character = "a";
    writeln("Character: ", character);
    
    programEnd;
}