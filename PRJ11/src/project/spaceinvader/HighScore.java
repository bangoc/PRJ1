package project.spaceinvader;

import java.io.*;

// create file high score
public class HighScore {
	static double count = 0;

	// write high score of player to file
	public static void Write(double theScore) {
		Read();
		if (theScore >= count) {
			count = theScore;
			try {
				FileOutputStream fos = new FileOutputStream("High_Score.txt");
				DataOutputStream dos = new DataOutputStream(fos);
				dos.writeDouble(count);
				fos.close();
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// read high score from file
	public static double Read() {
		try {
			FileInputStream fis = new FileInputStream("High_Score.txt");
			DataInputStream dis = new DataInputStream(fis);
			count = dis.readDouble();
			fis.close();
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return count;
	}
}
