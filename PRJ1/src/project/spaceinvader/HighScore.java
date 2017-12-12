package project.spaceinvader;

import java.io.*;

public class HighScore {
        static double count = 0;

        public static void Write(double theScore) {
                Read();
                if (theScore >= count) {
                        count = theScore;
                        try {
                                FileOutputStream fos = new FileOutputStream("./PRJ1/High_Score.txt");
                                DataOutputStream dos = new DataOutputStream(fos);
                                dos.writeDouble(count);
                                fos.close();
                                dos.close();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
        }

        public static double Read() {
                try {
                        FileInputStream fis = new FileInputStream("./PRJ1/High_Score.txt");
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
