package project.spaceinvader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Music extends Thread implements Runnable {
	
	public void playSound(String nameMusic) throws FileNotFoundException, JavaLayerException {
                FileInputStream music = new FileInputStream(nameMusic);
                Player firePlay = new Player(music);
                firePlay.play();
        }

	public void run(String name ) {
		
		try {
			playSound(name);
		} catch (FileNotFoundException | JavaLayerException e) {
			e.printStackTrace();
		}
	}
}
