package Objects;

import java.util.Timer;
import java.util.TimerTask;

import mainGamePackage.Play;
import StaticClasses.Levels;
import StaticClasses.Sounds;

public class MyTimer
{
	private int seconds;
	private Timer timer;
	
	public MyTimer(int seconds)
	{
		this.seconds = seconds;
		timer = new Timer();
	}
	
	public void startTimer()
	{
		if(Play.level == 4)
			Play.winner = true;
		else
			Play.newLevel = true;
		
		Sounds.inTheMiddleOfLevelUp = true;
		
		timer.scheduleAtFixedRate(
		new TimerTask()
		{
			  @Override
			  public void run()
			  {
				  seconds--;
				  
				  // if finished the levelup song, then begin the new level
				  if(seconds == 0)
				  {
					  Play.newLevel = false;
					  Sounds.inTheMiddleOfLevelUp = false;
					  Levels.beginLevels();
					  timer.cancel();
				  }
			  }
			  
		}, 0, 1000);
	}
	
	public int getSeconds()
	{
		return seconds;
	}
}
