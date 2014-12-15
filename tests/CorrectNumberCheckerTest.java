import com.pant.numgame.GuessSecretNum;
import java.util.Arrays;
import java.util.Collection;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner; 

import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import java.util.Random;
@RunWith(Parameterized.class)
public class CorrectNumberCheckerTest  {
   private Integer inputNumber;
   private String expectedResult;
   
   private int testval = 0;
   private static int min = 1;
   private static int max = 100;
   private String input = null;
   StringWriter output = new StringWriter();
   @Before
   public void initialize() {
	   
   }

   // Each parameter should be placed as an argument here
   // Every time runner triggers, it will pass the arguments
   // from parameters we defined in randomTestNumbers() method
   
   GuessSecretNum  messageUtil = new GuessSecretNum ();
   public CorrectNumberCheckerTest(Integer inputNumber, 
		      String expectedResult) {
		      this.inputNumber = inputNumber;
		      int testval = inputNumber.intValue();
		      input = Integer.toString(testval);
		      this.expectedResult = expectedResult;
		   } 
 
   @Parameterized.Parameters
   public static Collection randomTestNumbers() {  
	   Random rand = new Random();
       int randomNum = rand.nextInt((max - min) + 1) + min;
       Integer intObj = new Integer(randomNum );
       return Arrays.asList(new Object[][] {
         { intObj, "yes" } 
      });
   }
    
   @Test
   public void testCorrectNumberChecker() {
      System.out.println("Parameterized Number is : " + inputNumber);
      System.out.println("input is : " + input);
      assertEquals(expectedResult,messageUtil.GuessCorrectNumber(new Scanner(input), new PrintWriter(output)));
      messageUtil=null;
   }
}
