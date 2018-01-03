package music;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
public class MusicFire extends Thread implements Runnable {
        public void playSound() throws FileNotFoundException, JavaLayerException {
                FileInputStream musicFire = new FileInputStream("shoot.mp3");
                Player firePlay = new Player(musicFire);
                firePlay.play();
        }
        @Override
        public void run() {
                try {
                        playSound();
                } catch (FileNotFoundException | JavaLayerException e) {
                        e.printStackTrace();
                }
        }
}