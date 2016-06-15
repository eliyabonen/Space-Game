package StaticClasses;

import java.io.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Sounds
{
	public static AudioStream audioStream;
	public static boolean musicOn = false;
	
	public static void playSound(String sound)
	{
		try
        {
			audioStream = new AudioStream(new FileInputStream(sound));
            AudioPlayer.player.start(audioStream);
        }
        catch(FileNotFoundException e) {
        	e.printStackTrace();
        }
        catch(IOException e) {
        	e.printStackTrace();
        }
	}
}
