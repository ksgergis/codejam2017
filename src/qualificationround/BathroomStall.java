package qualificationround;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BathroomStall {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Scanner inputScanner = new Scanner(new File("/Users/m975851/Downloads/C-large.in"));
		PrintWriter writer = new PrintWriter("/Users/m975851/Documents/devOps/codejam/src/codejam/c-large.out",
				"UTF-8");
		int testCases = inputScanner.nextInt();

		for (int testNum = 1; testNum <= testCases; testNum++) {
			long numOfStalls = inputScanner.nextLong();
			long numOfPersons = inputScanner.nextLong();
			getMinMax(numOfStalls, numOfPersons, writer, testNum);
		}
		writer.close();

	}

	public static void getMinMax(long numOfStalls, long numOfPersons, PrintWriter writer, int testNum) {
		PriorityQueue<Long> queue = new PriorityQueue<Long>(99999999, Collections.reverseOrder());
		queue.add(numOfStalls);
		for (int i = 0; i < numOfPersons - 1; i++) {
			long biggestEmptyStall = queue.poll();
			long mid = biggestEmptyStall / 2;
			boolean noDecNeeded = biggestEmptyStall % 2 == 0 ? false : true;
			if (mid != 0) {
				long right = biggestEmptyStall - mid;
				long left = mid;
				if (right > left) {
					right--;
				} else {
					left--;
				}
				queue.add(right);

				queue.add(left);

				long low = noDecNeeded ? mid : mid - 1;
			}
		}
		long lastBiggest = queue.poll();
		if (lastBiggest == 1) {
			writer.println("Case #" + testNum + ": 0 0");
			System.out.println("Case #" + testNum + ": 0 0");
			return;
		}
		long mid = lastBiggest / 2;

		long left = mid;
		long right = lastBiggest - mid;
		if (right > left) {
			right--;
		} else {
			left--;
		}

		if (right > left) {
			long temp = left;
			left = right;
			right = temp;
		}
		writer.println("Case #" + testNum + ": " + left + " " + right);
		System.out.println("Case #" + testNum + ": " + left + " " + right);

	}
}
