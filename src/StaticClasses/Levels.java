package StaticClasses;

import mainGamePackage.Play;
import ControlClasses.EnemyControl;
import Objects.MyTimer;

public class Levels
{
	public static void checkLevelUp()
	{
		// if the player killed all the enemies for his current level
		if(EnemyControl.enemyArray.size() == 0)
		{
			Sounds.stopSound(Sounds.playtimeMusic);
			Sounds.loadSpecificSound(Sounds.levelup);
			Sounds.playSound(Sounds.levelUPEffect);
			Play.level++;
			
			// initialize and start the timer for starting the next level
			MyTimer timer = new MyTimer(7);
			timer.startTimer();
		}
	}
	
	public static void beginLevels()
	{
		if(Play.level == 1)
			Level1();
		if(Play.level == 2)
			Level2();
	}
	
	public static void Level1()
	{
		EnemyControl.createPackOfEnemies(3, 3, 200, -200);
		EnemyControl.createPackOfEnemies(3, 3, 650, -200);
		EnemyControl.createPackOfEnemies(3, 4, 400, -300);
		EnemyControl.createPackOfEnemies(5, 5, 200, -500);
		EnemyControl.createPackOfEnemies(5, 5, 500, -800);
		EnemyControl.createPackOfEnemies(5, 6, 100, -1100);
		EnemyControl.createPackOfEnemies(2, 2, 600, -1200);
		EnemyControl.createPackOfEnemies(6, 6, 200, -1500);
		EnemyControl.createPackOfEnemies(7, 7, 400, -1800);
	}
	
	public static void Level2()
	{
		// continue the song on the start of level 2
		Sounds.playSound(Sounds.playtimeMusic);
		
		EnemyControl.createPackOfEnemies(3, 3, 500, -200);
	}
}
