package main;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {
	
	private File soundPath2;
	
	private AudioInputStream ais2;
	private Clip clip2;
       
	public Music() {
		loadSE();
	}
	
	public void play(String type) {
		if(type.equals("Incorrect")) {
			clip2.start();
		}
	}
	
	public void loadSE() {
		try {
		soundPath2 = new File("C://Users//Shamen//Desktop//SE//Incorrect.wav");	
		ais2 = AudioSystem.getAudioInputStream(soundPath2);
		clip2 = AudioSystem.getClip();
		clip2.open(ais2);		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
