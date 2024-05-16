package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	Clip clip;
	URL soundURL[] = new URL[30];
	public Sound() {
		soundURL[0]= getClass().getResource("/res/sound/nhac.wav");
		soundURL[1]= getClass().getResource("/res/sound/coin.wav");
		soundURL[2]= getClass().getResource("/res/sound/dooropen.wav");
		soundURL[3]= getClass().getResource("/res//sound/fanfare.wav");
		soundURL[4]= getClass().getResource("/res//sound/gameover.wav");
		soundURL[5]= getClass().getResource("/res//sound/powerup.wav");
	}
	
	public void setFile (int i) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void play() {
		clip.start();
	}
	public void loop() {
		clip.loop(clip.LOOP_CONTINUOUSLY);
	}
	public void stop() {
		clip.stop();
	}
}
