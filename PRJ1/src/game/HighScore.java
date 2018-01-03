package game;

import java.io.*;
import java.util.StringTokenizer;

// create file high score
public class HighScore {

	// write high score of player to file
	public static void write(String[] name, int[] theScore) {
		String valueAll = toString(name, theScore);
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("High_Score.txt"));
			out.write(valueAll);
			out.close();
		} catch (IOException e) {
			System.out.println("Exception");
		}

	}

	public static String toString(String[] name, int[] theScore) {
		String valueAll = "";
		for (int i = 0; i < 5; i++) {
			valueAll = valueAll + theScore[i] + ":" + name[i] + "-";
		}
		return valueAll;
	}

	public static int[] getValue() {
		int[] count = new int[5];
		String valueAll = read();
		StringTokenizer tokenizer = new StringTokenizer(valueAll, "-");
		for (int i = 0; i < 5; i++) {
			String a = tokenizer.nextToken();
			StringTokenizer tokenizerScore = new StringTokenizer(a, ":");
			count[i] = Integer.parseInt(tokenizerScore.nextToken());
		}
		return count;
	}

	public static String[] getName() {
		String[] name = new String[5];
		String valueAll = read();
		StringTokenizer tokenizer = new StringTokenizer(valueAll, "-");
		for (int i = 0; i < 5; i++) {
			String a = tokenizer.nextToken();
			int index = a.indexOf(":");
			name[i] = a.substring(index + 1);
		}
		return name;
	}

	// read high score from file
	@SuppressWarnings("deprecation")
	public static String read() {
		String valueAll = null;
		try {
			File file = new File("High_Score.txt");
			BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
			byte[] buffer = new byte[(int) file.length()];
			fis.read(buffer);
			valueAll = new String(buffer);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return valueAll;
	}
}