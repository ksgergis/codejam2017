package qualificationround;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Scanner;

public class pancakeflip {

	HashMap<Character, Character> flip = new HashMap<>();

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Scanner inputScanner = new Scanner(
				new File("/Users/m975851/Documents/devOps/codejam/src/codejam/A-large.in"));
		int testCases = inputScanner.nextInt();

		PrintWriter writer = new PrintWriter("/Users/m975851/Documents/devOps/codejam/src/codejam/A-large.out",
				"UTF-8");

		for (int testNum = 1; testNum <= testCases; testNum++) {
			String s = inputScanner.next();
			int k = inputScanner.nextInt();
			int numOfFlips = new pancakeflip().getNumOfFlips(s.toCharArray(), k);
			System.out.println("Case #" + testNum + ": " + (numOfFlips == -1 ? "IMPOSSIBLE" : numOfFlips));
			writer.println("Case #" + testNum + ": " + (numOfFlips == -1 ? "IMPOSSIBLE" : numOfFlips));
		}
		writer.close();
	}

	public pancakeflip() {
		flip.put('+', '-');
		flip.put('-', '+');
	}

	public int getNumOfFlips(char[] pancakesLine, int flipperSize) {

		int numOfFlips = 0;
		for (int i = 0; i < pancakesLine.length; i++) {
			if (pancakesLine[i] == '-') {
				if (i + flipperSize - 1 < pancakesLine.length) {
					for (int tempI = i; tempI < i + flipperSize; tempI++) {
						pancakesLine[tempI] = flip.get(pancakesLine[tempI]);
					}
					numOfFlips++;
				} else {
					return -1;
				}
			}
		}

		return numOfFlips;
	}

}
