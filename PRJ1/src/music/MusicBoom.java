package music;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicBoom extends Thread {

	public void playSound() throws FileNotFoundException, JavaLayerException {
		FileInputStream music = new FileInputStream("killUFO.mp3");
		Player boomPlay = new Player(music);
		boomPlay.play();
	}

	public void run() {
		try {
			playSound();
		} catch (FileNotFoundException | JavaLayerException e) {
			e.printStackTrace();
		}
	}
}