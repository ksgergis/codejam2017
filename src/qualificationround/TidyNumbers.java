package qualificationround;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
//Soultion is big o of n. google hire me :D
public class TidyNumbers {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Scanner inputScanner = new Scanner(
				new File("/Users/m975851/Downloads/B-large.in"));
		int testCases = inputScanner.nextInt();

		PrintWriter writer = new PrintWriter("/Users/m975851/Documents/devOps/codejam/src/codejam/B-large.out",
				"UTF-8");

		for (int testNum = 1; testNum <= testCases; testNum++) {
			String s = inputScanner.next();
			char[] number = getClosestTidy(s);
			//System.out.println("Case #" + testNum + ": " + Long.parseLong(new String(number)));
			writer.println("Case #" + testNum + ": " + Long.parseLong(new String(number)));
		}
		writer.close();
	}

	public static char[] getClosestTidy(String numberString) {
		// get the length of the number
		int numLength = numberString.length();
		// the array we will return
		char[] numberArray = numberString.toCharArray();
		// parse the string to long
		long number = Long.parseLong(numberString);
		// loop through the number from the most right digit to the most left
		// digit
		for (int i = numLength - 1; i > 0; i--) {

			long currentDigit = number % 10;
			// delete the current digit from the remaining number
			number = number / 10;
			// if this was the last digit. return the array
			if (number == 0) {
				return numberArray;
			}
			// get the previous digit without deleting from the remaining digits

			long previousDigit = i == 1 ? number : number % 10;
			// no problemoo, keep going
			if (previousDigit <= currentDigit) {
				continue;
			}
			// if the previous number was bigger, decrement 1
			numberArray[i - 1] = Character.forDigit((int) (previousDigit - 1), 10);
			number = (number / 10) *10 ;
			number += previousDigit - 1;
	
		
			// make all digits from current to up 9
			for (int tempI = i; tempI < numLength; tempI++) {
				//here the magical o(n) happens :) see I am good
				if (numberArray[tempI] == '9') {
					break;
				}
				numberArray[tempI] = '9';
			}
		}
		return numberArray;
	}
}
