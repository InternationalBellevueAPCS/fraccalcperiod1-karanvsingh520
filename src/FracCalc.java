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
    	
    	//setting continuingto true initially to initiate the while loop to accept input multiple times depending on user choice
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
    	
    	//I added secondOpIndex to these as they are seperated from the input String and therefore needed to be converted to 
    	//resemble the input String length again to avoid out of Bound exception errors
    	int seperation= secondOperand.indexOf("_") + secondOpIndex;
    	int divisor = secondOperand.indexOf("/") + secondOpIndex;
    	
    	//converted integers from the strings between certain indexes and key divisors and seperators
    	int whole = Integer.parseInt(input.substring(secondOpIndex,seperation));
    	int numerator = Integer.parseInt(input.substring(seperation+1, divisor));
    	int denominator = Integer.parseInt(input.substring(divisor+1,input.length()));
    	
    	//compiling everything into one string to return
    	String breakdown = "whole: " + whole + "\nnumerator: " + numerator + "\ndenominator: " + denominator;
        return breakdown;
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
