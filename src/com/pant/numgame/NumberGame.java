package com.pant.numgame;
import java.util.Scanner;
import java.io.*;

public class NumberGame {
	/**
	 * @author malaya pant
	 * 
	 * This is the main class used to invoke driver class.For normal run we pass a dummy value to scanner[noJunitTest="0\n".Do not change this
	 * During junit test this will be randomly populated via a junit parameterized test class.
	 * 
	 * 
	 */
	public NumberGame() {
		// TODO Auto-generated constructor stub
	}  
 
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		StringWriter output = new StringWriter();
		String noJunitTest="0\n";       
		GuessSecretNum  findnum = new GuessSecretNum();
		String s = findnum.GuessCorrectNumber(new Scanner(noJunitTest), new PrintWriter(output));
		 

	}

}
