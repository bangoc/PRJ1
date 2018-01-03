package music;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicShoot extends Thread {
	
	public void playSound() throws FileNotFoundException, JavaLayerException {
                FileInputStream music = new FileInputStream("shoot.mp3");
                Player firePlay = new Player(music);
                firePlay.play();
        }

	public void run() {
		try {
			playSound();
		} catch (FileNotFoundException | JavaLayerException e) {
			e.printStackTrace();
		}
	}
}
