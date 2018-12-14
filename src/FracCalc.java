import java.util.*;
public class FracCalc {

    /**
     * Prompts user for input, passes that input to produceAnswer, then outputs the result.
     * @param args - unused
     */
    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
        // Checkpoint 1: Create a Scanner, read one line of input, pass that input to produceAnswer, print the result.
        // Checkpoint 2: Accept user input multiple times.
    	
    	//setting continuing to true initially to initiate the while loop to accept input multiple times depending on user choice
    	boolean continuing = true;
    	while(continuing)
    	{
	    	Scanner console = new Scanner(System.in);
	    	System.out.println("Enter a calculation: (Ex. 1_1/4 + 3)");
	    	String calculation = console.nextLine();
	    	String output = produceAnswer(calculation);
	    	System.out.println(output);
	    	
	    	//checks user input to see whether the program should continue
	    	//created another scanner to test
	    	Scanner test = new Scanner(System.in);
	    	System.out.println("Do you want to continue using the calculator?(Enter y or n)");
	    	String response = test.nextLine();
	    	if (response.equals("n"))
	    	{
	    		System.out.println("Good day to you!");
	    		continuing = false;
	    	}
    	}
    }
    
    /**
     * produceAnswer - This function takes a String 'input' and produces the result.
     * @param input - A fraction string that needs to be evaluated.  For your program, this will be the user input.
     *      Example: input ==> "1/2 + 3/4"
     * @return the result of the fraction after it has been calculated.
     *      Example: return ==> "1_1/4"
     */
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
        // Checkpoint 1: Return the second operand.  Example "4/5 * 1_2/4" returns "1_2/4".
        // Checkpoint 2: Return the second operand as a string representing each part.
        //               Example "4/5 * 1_2/4" returns "whole:1 numerator:2 denominator:4".
        // Checkpoint 3: Evaluate the formula and return the result as a fraction.
        //               Example "4/5 * 1_2/4" returns "6/5".
        //               Note: Answer does not need to be reduced, but it must be correct.
        // Final project: All answers must be reduced.
        //               Example "4/5 * 1_2/4" returns "1_1/5".
    	
    	//I found where there was a space in the input to know when the first operand ended and added 3 to skip over the operands 
    	//and reach the starting index of the second operand
    	int secondOpIndex = input.indexOf(" ") + 3;
    	String secondOperand = input.substring(secondOpIndex, input.length());
    	//finding whether the _ is to separate the whole number from the fraction
    	int seperation= secondOperand.indexOf("_");
    	//finding whether there is a fraction in second operand
    	int divisor = secondOperand.indexOf("/");
    	//initialize all parts of the second operand
    	int whole;
    	int numerator;
    	int denominator;
    	//if the input's second operand is just a whole number, with no fraction
    	if (seperation == -1 && divisor == -1)
    	{
    		whole = Integer.parseInt(input.substring(secondOpIndex,input.length()));
    		numerator = 0;
    		denominator = 1;
    	}
    	//if the input's second operand is just a fraction, with no whole number
    	else if(seperation == -1 && divisor != -1)
    	{
    		//I added secondOpIndex to the divisor as divisor is a substring of the second operand 
    		//but needs to be in the context of the full input string
    		divisor += secondOpIndex;
    		whole = 0;
    		numerator = Integer.parseInt(input.substring(secondOpIndex, divisor));
    		//I added 1 to divisor since I want the substring to start on the number right after the fraction sign
    		denominator = Integer.parseInt(input.substring(divisor+1, input.length()));
    	}
    	//if the input is normal and has both a whole number and fraction
    	else 
    	{
    		//I added secondOpIndex to the divisor and separator as they are a substring of the second operand 
    		//but needs to be in the context of the full input string
    		seperation += secondOpIndex;
    		divisor += secondOpIndex;
    		whole = Integer.parseInt(input.substring(secondOpIndex,seperation));
    		//I added 1 to divisor and separator since I want the substring to start on the number right after the fraction sign and _ symbol
        	numerator = Integer.parseInt(input.substring(seperation+1, divisor));
        	denominator = Integer.parseInt(input.substring(divisor+1,input.length()));
    	}
    	//getting the first operand
    	int firstOpFinalIndex = input.indexOf(" ");
    	String firstOperand = input.substring(0, firstOpFinalIndex);
    	int seperation1= firstOperand.indexOf("_");
    	//finding whether there is a fraction in second operand
    	int divisor1 = firstOperand.indexOf("/");
    	//initialize all parts of the second operand
    	int whole1;
    	int numerator1;
    	int denominator1;
    	//if the input's first operand is just a whole number, with no fraction
    	if (seperation1 == -1 && divisor1 == -1)
    	{
    		whole1 = Integer.parseInt(input.substring(0,firstOpFinalIndex));
    		numerator1 = 0;
    		denominator1 = 1;
    	}
    	//if the input's second operand is just a fraction, with no whole number
    	else if(seperation1 == -1 && divisor1 != -1)
    	{
    		whole1 = 0;
    		numerator1 = Integer.parseInt(input.substring(0, divisor1));
    		//I added 1 to divisor since I want the substring to start on the number right after the fraction sign
    		denominator1 = Integer.parseInt(input.substring(divisor1+1,firstOpFinalIndex));
    	}
    	//if the input is normal and has both a whole number and fraction
    	else 
    	{
    		whole1 = Integer.parseInt(input.substring(0,seperation1));
    		//I added 1 to divisor and separator since I want the substring to start on the number right after the fraction sign and _ symbol
        	numerator1 = Integer.parseInt(input.substring(seperation1+1, divisor1));
        	denominator1 = Integer.parseInt(input.substring(divisor1+1,firstOpFinalIndex));
    	}
    	
    	//Converting complex fraction to a single number
    	//I am converting the first operand whole number to a fraction to add to its fraction if there is one
    	int firstOpWholeNumberNumerator = (whole1 * denominator1);
    	int firstOpWholeNumberDenominator = denominator1;
    	int firstEntireNumberNumerator;
    	//if the first operand is negative, we need to subtract rather than add the fraction to the whole number
    	if(whole1<0)
    	{
    		firstEntireNumberNumerator = firstOpWholeNumberNumerator - numerator1;
    	}
    	
    	else
    	{
    		firstEntireNumberNumerator = firstOpWholeNumberNumerator + numerator1;
    	}
    			
    	//I am converting the second operand whole number to a fraction to add to the other fraction if there is one
    	int secondOpWholeNumberNumerator = (whole * denominator);
    	int secondOpWholeNumberDenominator = denominator;
    	int secondEntireNumberNumerator;
    	//if the first operand is negative, we need to subtract rather than add the fraction to the whole number
    	if(whole < 0)
    	{
    		secondEntireNumberNumerator = secondOpWholeNumberNumerator - numerator;
    	}
    	
    	else
    	{
    		secondEntireNumberNumerator = secondOpWholeNumberNumerator + numerator;
    	}
    	
    	//only for add/subtract, math behind the addition/subtraction of fractions
    	
    	//finding the overall denominator of the product for addition and subtraction by taking least common multiple
    	int finalDenominator = leastCommonMultiple(firstOpWholeNumberDenominator,secondOpWholeNumberDenominator);
    	
    	//converting both operands fractions to be compatible with each other when performing addition and subtraction
    	int firstMultiplier = finalDenominator/firstOpWholeNumberDenominator;
    	int secondMultiplier = finalDenominator/secondOpWholeNumberDenominator;
    	//multiplying both operand fraction numerators to convert them so they have equal denominators
    	int finalFirstEntireNumberNumerator = firstEntireNumberNumerator * firstMultiplier;
    	int finalSecondEntireNumberNumerator = secondEntireNumberNumerator * secondMultiplier;
    	
    	//initializing return variable
    	String computation;
    	//if the operation is addition
    	if(input.indexOf("+") != -1)
    	{
    		//getting numerator of both fractions combined
    		int totalNumerator = (finalFirstEntireNumberNumerator + finalSecondEntireNumberNumerator);
    		//simplifying the fraction
    		int simplify = greatestCommonDivisor(totalNumerator, finalDenominator);
    		int simplifiedTotalNumerator = totalNumerator/simplify;
    		int simplifiedFinalDenominator = finalDenominator/simplify;

    		//checks if the denominator is 1 or -1 so it can make simplification
    		if (simplifiedFinalDenominator == 1)
    		{
    			computation = simplifiedTotalNumerator + "";
    		}
    		else if (simplifiedFinalDenominator == -1)
    		{
    			simplifiedTotalNumerator *= -1;
    			computation = simplifiedTotalNumerator + "";
    		}
    		else
    		{
    			//checks to see if the numerator is greater than the denominator to simplify back into complex number
        		//I have to absolute value just in case the numerator is negative
        		if (Math.abs(simplifiedTotalNumerator) > simplifiedFinalDenominator)
        		{
        			//gets the whole number through integer division than converts it back 
        			//to the fraction to subtract it from the total numerator to get the fraction as well
        			int simplifiedWholeNumber = simplifiedTotalNumerator/simplifiedFinalDenominator;
        			int tempFractionNumerator = simplifiedWholeNumber * simplifiedFinalDenominator;
        			int simplifiedFractionNumerator = simplifiedTotalNumerator - tempFractionNumerator;
        			computation = simplifiedWholeNumber + "_" + Math.abs(simplifiedFractionNumerator) + "/" + simplifiedFinalDenominator;
        		}
        		else
        		{
        			computation = simplifiedTotalNumerator + "/" + simplifiedFinalDenominator;
        		}
    		}
    		
    		return computation;
    	}
    	//if the operation is subtraction
    	//added spaces before and after since it is the same symbol as a negative sign and needs to be distinguished as an operation
    	else if(input.indexOf(" - ") != -1)
    	{
    		//getting numerator of second fraction subtracted from first
    		int totalNumerator = (finalFirstEntireNumberNumerator - finalSecondEntireNumberNumerator);
    		int simplify = greatestCommonDivisor(totalNumerator, finalDenominator);
    		int simplifiedTotalNumerator = totalNumerator/simplify;
    		int simplifiedFinalDenominator = finalDenominator/simplify;
    		
    		//checks if the denominator is 1 or -1 so it can make simplification
    		if (simplifiedFinalDenominator == 1)
    		{
    			computation = simplifiedTotalNumerator + "";
    		}
    		else if (simplifiedFinalDenominator == -1)
    		{
    			simplifiedTotalNumerator *= -1;
    			computation = simplifiedTotalNumerator + "";
    		}
    		else 
    		{
    			//checks to see if the numerator is greater than the denominator to simplify back into complex number
        		//I have to absolute value just in case the numerator is negative
        		if (Math.abs(simplifiedTotalNumerator) > simplifiedFinalDenominator)
        		{
        			//gets the whole number through integer division than converts it back 
        			//to the fraction to subtract it from the total numerator to get the fraction as well
        			int simplifiedWholeNumber = simplifiedTotalNumerator/simplifiedFinalDenominator;
        			int tempFractionNumerator = simplifiedWholeNumber * simplifiedFinalDenominator;
        			int simplifiedFractionNumerator = simplifiedTotalNumerator - tempFractionNumerator;
        			//if there is no whole number, there is no need to absolute value the numerator and denominator
        			if (simplifiedWholeNumber == 0)
        			{
        				//switches negative sign from denominator to numerator if the return value is only a fraction
        				if(simplifiedFinalDenominator < 0)
        				{
        					simplifiedFractionNumerator *= -1;
        					simplifiedFinalDenominator *= -1;
        				}
        				computation = simplifiedFractionNumerator + "/" + simplifiedFinalDenominator;
        			}
        			else
        			{
        			computation = simplifiedWholeNumber + "_" + Math.abs(simplifiedFractionNumerator) + "/" + Math.abs(simplifiedFinalDenominator);
        			}
        		}
        		else
        		{
        			computation = simplifiedTotalNumerator + "/" + simplifiedFinalDenominator;
        		}
    		}
    		return computation;
    	}
    		
    	//if the operation is multiplication
    	else if(input.indexOf("*") != -1)
    	{
    		//don't have to use any of the addition/subtraction operation variables
    		int totalNumerator = firstEntireNumberNumerator * secondEntireNumberNumerator;
    		int totalDenominator = denominator1 * denominator;
    		int simplify = greatestCommonDivisor(totalNumerator, totalDenominator);
    		int simplifiedTotalNumerator = totalNumerator/simplify;
    		int simplifiedFinalDenominator = totalDenominator/simplify;
    		
    		//checks to see if the numerator is greater than the denominator to simplify back into complex number
    		//I have to absolute value just in case the numerator is negative
    		if (Math.abs(simplifiedTotalNumerator) > simplifiedFinalDenominator)
    		{
    			//gets the whole number through integer division than converts it back 
    			//to the fraction to subtract it from the total numerator to get the fraction as well
    			int simplifiedWholeNumber = simplifiedTotalNumerator/simplifiedFinalDenominator;
    			int tempFractionNumerator = simplifiedWholeNumber * simplifiedFinalDenominator;
    			int simplifiedFractionNumerator = simplifiedTotalNumerator - tempFractionNumerator;
    			//if there is no whole number, there is no need to absolute value the numerator and denominator
    			if (simplifiedWholeNumber == 0)
    			{
    				//switches negative sign from denominator to numerator if the return value is only a fraction
    				if(simplifiedFinalDenominator < 0)
    				{
    					simplifiedFractionNumerator *= -1;
    					simplifiedFinalDenominator *= -1;
    				}
    				computation = simplifiedFractionNumerator + "/" + simplifiedFinalDenominator;
    			}
    			else
    			{
    			computation = simplifiedWholeNumber + "_" + Math.abs(simplifiedFractionNumerator) + "/" + Math.abs(simplifiedFinalDenominator);
    			}
    		}
    		
    		//checks if the denominator is 1 or -1 so it can make simplification
    		if (simplifiedFinalDenominator == 1)
    		{
    			computation = simplifiedTotalNumerator + "";
    		}
    		
    		else if (simplifiedFinalDenominator == -1)
    		{
    			simplifiedTotalNumerator *= -1;
    			computation = simplifiedTotalNumerator + "";
    		}
    		else
    		{
    			//checks to see if the numerator is greater than the denominator to simplify back into complex number
        		//I have to absolute value just in case the numerator is negative
        		if (Math.abs(simplifiedTotalNumerator) > simplifiedFinalDenominator)
        		{
        			//gets the whole number through integer division than converts it back 
        			//to the fraction to subtract it from the total numerator to get the fraction as well
        			int simplifiedWholeNumber = simplifiedTotalNumerator/simplifiedFinalDenominator;
        			int tempFractionNumerator = simplifiedWholeNumber * simplifiedFinalDenominator;
        			int simplifiedFractionNumerator = simplifiedTotalNumerator - tempFractionNumerator;
        			//if there is no whole number, there is no need to absolute value the numerator and denominator
        			if (simplifiedWholeNumber == 0)
        			{
        				//switches negative sign from denominator to numerator if the return value is only a fraction
        				if(simplifiedFinalDenominator < 0)
        				{
        					simplifiedFractionNumerator *= -1;
        					simplifiedFinalDenominator *= -1;
        				}
        				computation = simplifiedFractionNumerator + "/" + simplifiedFinalDenominator;
        			}
        			else
        			{
        			computation = simplifiedWholeNumber + "_" + Math.abs(simplifiedFractionNumerator) + "/" + Math.abs(simplifiedFinalDenominator);
        			}
        		}
        		else
        		{
        			computation = simplifiedTotalNumerator + "/" + simplifiedFinalDenominator;
        		}
    		}

    		return computation;
    	}
    	//if the operation is division
    	else
    	{
    		//don't have to use any of the addition/subtraction operation variables
    		
    		//need to flip the second operand's numerator and denominator to perform operation that is why denominator
    		//of second operand is in operation of totalNumerator and visa versa for the totalDenominator
    		
    		int totalNumerator = firstEntireNumberNumerator * denominator;
    		int totalDenominator = denominator1 * secondEntireNumberNumerator;
    		int simplify = greatestCommonDivisor(totalNumerator, totalDenominator);
    		int simplifiedTotalNumerator = totalNumerator/simplify;
    		int simplifiedFinalDenominator = totalDenominator/simplify;
    		
    		//checks if the denominator is 1 or -1 so it can make simplification
    		if (simplifiedFinalDenominator == 1)
    		{
    			computation = simplifiedTotalNumerator + "";
    		}
    		else if (simplifiedFinalDenominator == -1)
    		{
    			simplifiedTotalNumerator *= -1;
    			computation = simplifiedTotalNumerator + "";
    		}
    		else
    		{
    			//checks to see if the numerator is greater than the denominator to simplify back into complex number
        		//I have to absolute value just in case the numerator is negative
        		if (Math.abs(simplifiedTotalNumerator) > simplifiedFinalDenominator)
        		{
        			//gets the whole number through integer division than converts it back 
        			//to the fraction to subtract it from the total numerator to get the fraction as well
        			int simplifiedWholeNumber = simplifiedTotalNumerator/simplifiedFinalDenominator;
        			int tempFractionNumerator = simplifiedWholeNumber * simplifiedFinalDenominator;
        			int simplifiedFractionNumerator = simplifiedTotalNumerator - tempFractionNumerator;
        			//if there is no whole number, there is no need to absolute value the numerator and denominator
        			if (simplifiedWholeNumber == 0)
        			{
        				//switches negative sign from denominator to numerator if the return value is only a fraction
        				if(simplifiedFinalDenominator < 0)
        				{
        					simplifiedFractionNumerator *= -1;
        					simplifiedFinalDenominator *= -1;
        				}
        				computation = simplifiedFractionNumerator + "/" + simplifiedFinalDenominator;
        			}
        			else
        			{
        			computation = simplifiedWholeNumber + "_" + Math.abs(simplifiedFractionNumerator) + "/" + Math.abs(simplifiedFinalDenominator);
        			}
        		}
        		else
        		{
        			computation = simplifiedTotalNumerator + "/" + simplifiedFinalDenominator;
        		}
    		}
    		return computation;
    	}
    }

    // TODO: Fill in the space below with helper methods
    
    /**
     * greatestCommonDivisor - Find the largest integer that evenly divides two integers.
     *      Use this helper method in the Final Checkpoint to reduce fractions.
     *      Note: There is a different (recursive) implementation in BJP Chapter 12.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The GCD.
     */
    public static int greatestCommonDivisor(int a, int b)
    {
        a = Math.abs(a);
        b = Math.abs(b);
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        while (min != 0) {
            int tmp = min;
            min = max % min;
            max = tmp;
        }
        return max;
    }
    
    /**
     * leastCommonMultiple - Find the smallest integer that can be evenly divided by two integers.
     *      Use this helper method in Checkpoint 3 to evaluate expressions.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The LCM.
     */
    public static int leastCommonMultiple(int a, int b)
    {
        int gcd = greatestCommonDivisor(a, b);
        return (a*b)/gcd;
    }
}
