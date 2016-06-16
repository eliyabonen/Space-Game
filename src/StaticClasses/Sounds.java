package StaticClasses;

import java.io.*;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Sounds
{
	public static boolean musicOn = false;
	public static AudioStream playtimeMusic, gameOver, shotEffect;
	public static int playtimeMusicID = 1, gameOverID = 2, shotEffectID = 3;
	
	public static void loadSounds()
	{
		try {
			playtimeMusic = new AudioStream(new FileInputStream("sounds//playtimeMusic.wav"));
			gameOver = new AudioStream(new FileInputStream("sounds//gameOver.wav"));
			shotEffect = new AudioStream(new FileInputStream("sounds//shotEffect.wav"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void loadSpecificSound(int soundID)
	{
		try {
			
			if(soundID == playtimeMusicID)
				playtimeMusic = new AudioStream(new FileInputStream("sounds//playtimeMusic.wav"));
			
			else if(soundID == gameOverID)
				gameOver = new AudioStream(new FileInputStream("sounds//gameOver.wav"));
			
			else if(soundID == shotEffectID)
				shotEffect = new AudioStream(new FileInputStream("sounds//shotEffect.wav"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void playSound(AudioStream audioStream)
	{
		AudioPlayer.player.start(audioStream);
	}
	
	public static void stopSound(AudioStream audioStream)
	{
		AudioPlayer.player.stop(audioStream);
	}
}
