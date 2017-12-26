package project.spaceinvader;

import java.util.StringTokenizer;

public class Test {
	public static void main(String[] args) {
		String[] name = new String[5];
		String s = "pre:fix-di:r1-di:r2-di:r3-di:r4-";
		StringTokenizer tokenizer = new StringTokenizer(s, "-");
		for (int i = 0; i < 5; i++) {
			String a = tokenizer.nextToken();
			int index = a.indexOf(":");
			name[i] = a.substring(index + 1);
		}
		for (int i = 0; i < 5; i ++) {
			System.out.println(name[i]);
		}
//		System.out.println("Dir 1  : " + dirA);
//		System.out.println("Dir 2 : " + dirB);
	}
}