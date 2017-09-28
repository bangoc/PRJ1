package project.spaceinvader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicStart extends Thread implements Runnable {
        public void playSound() throws FileNotFoundException, JavaLayerException {
                FileInputStream musicStart = new FileInputStream("musicstart.mp3");
                Player startPlay = new Player(musicStart);
                startPlay.play();
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
