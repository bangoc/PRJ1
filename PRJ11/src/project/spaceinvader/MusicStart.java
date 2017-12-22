package project.spaceinvader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
public class MusicStart extends Thread implements Runnable {
	public void playSound() throws FileNotFoundException, JavaLayerException {
		FileInputStream musicstart = new FileInputStream("musicstart.mp3");
		Player startplay = new Player(musicstart);
		startplay.play();
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