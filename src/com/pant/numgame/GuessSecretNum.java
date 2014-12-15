package com.pant.numgame;
import java.util.Scanner;
import java.io.PrintWriter;


/**
 * @author malaya pant
 * 
 * This is the driver class used to guess the correct number as selected by user.Currently number selected between
 * 1 - 100 range.But it may be extended by putting values for max range in a property file and modify the max range on demand.
 * The application uses Binary Search Algorithm to find the correct answer  
 * 
 */
public class GuessSecretNum implements GuessNumberInterface {

	private static int totalAttempts = 0;
	private static double possibelGuess = 0.0;
	private static String s = null;
	private static String gotit = null;
	private static double minValue = 1.0;
	private static double maxValue = 100.0;
	private static boolean isGameOver = false;
	private static boolean isFirstIter = true;
	private static boolean isGameTerminated = false;
	private static double maxAttempts = 0.0;
	private static double totalGuesses = 0.0;

	/* (non-Javadoc)
	 * @see GuessNumberInterface#GuessCorrectNumber(java.util.Scanner, java.io.PrintWriter)
	 */
	 
	public String GuessCorrectNumber(Scanner mscanner, PrintWriter output) {

		maxValue = 100.0;
		minValue = 1.0;
		String notest = mscanner.nextLine();
		int junitCounter = Integer.parseInt(notest);    // For junit testing we will have randomly generated number between 1 -100 passed via a parameterized test class
		totalGuesses = maxValue + minValue - 1;
		maxAttempts = Math.log(totalGuesses) / (Math.log(2)) + 1;
		possibelGuess = Math.ceil(totalGuesses / 2.0);
		totalGuesses = maxValue + minValue - 1;
		maxAttempts = Math.log(totalGuesses) / (Math.log(2)) + 1;
		possibelGuess = Math.ceil(totalGuesses / 2.0);
		 
		if (isFirstIter) {
			
			System.out.println("\n Hello User - Chosse Any Number Between 1 - 100 and hit enter!\n");
			System.out.println("I will try to guess your number in maximum "
					+ Math.floor(maxAttempts) + "  attempts using Binary Search Algorithm");
			isFirstIter = false;
		}
		
		
		if (junitCounter > 0)    // junit test here.We use parameterized junit class to pass randomaly generated numbers to test
		{
			int a = 0;
			System.out.println("\n This is jUnit test . Randomly generated number passed via parameterized jUnit Class ===== > "+ junitCounter); 
			while (!isGameOver) {

				totalGuesses = maxValue + minValue - 1;
				possibelGuess = Math.ceil(totalGuesses / 2.0);

				totalAttempts++;

				if (junitCounter > possibelGuess) {
					s = "lower";
					minValue = possibelGuess + 1;

				}

				if (junitCounter < possibelGuess) {

					s = "higher";
					maxValue = possibelGuess - 1;

				}

				if (junitCounter == possibelGuess) {
					s = "yes";
					isGameOver = true;
				}

			}
			mscanner.close();
			System.out.println("\n Correct Number is   =====>  "
					+ possibelGuess + " Answered in ===== " + totalAttempts
					+ "  attempts !");
		}

		 
		if (junitCounter < 1)     // Regular application runs here  
		{
			int num = 0; 
    		Scanner out = new Scanner(System.in);
			s = out.nextLine();
			while (!isGameOver) 
			{
				totalGuesses = maxValue+ minValue- 1;
				possibelGuess = Math.ceil(totalGuesses  / 2.0);
				System.out.println("Is this the number you selected " + possibelGuess);
				System.out.println("Enter yes if number is Correct ,higher  if Number is High, lower if number is Low or enter end to terminate this game \n" );
				Scanner in = new Scanner(System.in);
				s = in.nextLine();
				totalAttempts++; 
				if ((s.equals("higher")) || (s.equals("HIGHER"))) {
				    num=1; 
				}
				
				if ((s.equals("lower")) || (s.equals("LOWER"))) {
				    num=2; 
				}
				
				if ((s.equals("yes")) || (s.equals("YES"))) {
				    num=3; 
				}
				
				if ((s.equals("end")) || (s.equals("END"))) {
				    num=4; 
				}
				
				switch (num) 
				{
				case 1 :
					maxValue = possibelGuess - 1;
					break;

				case 2 : 	
					minValue = possibelGuess  + 1;
					break; 

				case 3 :	 
					isGameOver=true;
					break;

				case 4 :	 
					isGameOver=true;
					isGameTerminated=true; 
					break;

				default:
					System.out.println("Enter yes if number is correct ,higher if Number is high, lower if number is low ,end to terminate this game \n" );
					System.out.println("Enter in lower cases[case sensitive entries]\n" );
					break;   
				}
			} 
			if (isGameTerminated)
			{

				System.out.println("\n Game Aborted . Good Bye !");
				System.out.println("\n To run jUnit Test type ant junit and open file testreport/TEST-CorrectNumberCheckerTest to see test report");
			}	
			else
			{
				System.out.println("\n Correct Number is   =====>  " + possibelGuess + " Answered in ===== " + totalAttempts + "  attempts !");
				System.out.println("\n To run jUnit Test type ant junit and open file testreport/TEST-CorrectNumberCheckerTest to see Test report");
			}

		}
	 

		return s;
	}

}