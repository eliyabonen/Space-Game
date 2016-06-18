package Objects;

import java.util.Timer;
import java.util.TimerTask;

import StaticClasses.Levels;

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
