package self.learning.search_pattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SerialSearch {

	public static void main(String[] args) {
		String pattern = "public";
		File dir = new File("./src/self/learning/sample");
		File[] files = dir.listFiles();

		PatternFinder finder = new PatternFinder();

		long startTime = System.currentTimeMillis();

		// for each file in the list of files
		for (File file : files) {

			List<Integer> lineNumbers = finder.find(file, pattern);

			if (!lineNumbers.isEmpty()) {
				System.out.println(pattern + "; found at " + lineNumbers + " in the file - " + file.getName());
			}

		}

		System.out.println(" Time taken for search - " + (System.currentTimeMillis() - startTime));

	}

}

class PatternFinder {

	/*
	 * Looks for the given pattern in the file, and returns the list of line numbers
	 * in which the pattern is found.
	 */
	public List<Integer> find(File file, String pattern) {

		List<Integer> lineNumbers = new ArrayList<Integer>();

		// Open the file for reading.
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			int lineNo = 1;
			String line;

			// for each line in the file.
			while ((line = br.readLine()) != null) {

				if (line.contains(pattern)) {
					// capture the lineNo where the pattern is found.
					lineNumbers.add(lineNo);
				}

				lineNo++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Just introduced the delay for demo.
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}

		return lineNumbers;
	}

}