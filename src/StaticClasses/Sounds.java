package StaticClasses;

import java.io.*;

import javax.swing.JOptionPane;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Sounds
{
	public static boolean musicOn = true, inTheMiddleOfLevelUp = false;
	public static AudioStream playtimeMusic, gameOver, shotEffect, levelUPEffect;
	public static int playtimeMusicID = 1, gameOverID = 2, shotEffectID = 3, levelup = 4;
	
	public static void loadSounds()
	{
		try {
			playtimeMusic = new AudioStream(new FileInputStream("sounds//playtimeMusic.wav"));
			gameOver = new AudioStream(new FileInputStream("sounds//gameOver.wav"));
			shotEffect = new AudioStream(new FileInputStream("sounds//shotEffect.wav"));
			levelUPEffect = new AudioStream(new FileInputStream("sounds//levelup.wav"));
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "There are some sound files missing", "ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "There are a problem with the sound", "ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
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
			
			else if(soundID == levelup)
				levelUPEffect = new AudioStream(new FileInputStream("sounds//levelup.wav"));
			
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
		if(musicOn == true || audioStream == shotEffect)
			AudioPlayer.player.start(audioStream);
	}
	
	public static void stopSound(AudioStream audioStream)
	{
		if(musicOn == true || audioStream == shotEffect)
			AudioPlayer.player.stop(audioStream);
	}
}
