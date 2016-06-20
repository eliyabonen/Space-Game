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
		if(Play.level == 3)
			Level3();
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
		// continue the song on the start of the level
		Sounds.playSound(Sounds.playtimeMusic);
		
		EnemyControl.createPackOfEnemies(4, 4, 100, -200);
		EnemyControl.createPackOfEnemies(4, 3, 600, -200);
		EnemyControl.createPackOfEnemies(3, 3, 400, -300);
		EnemyControl.createPackOfEnemies(5, 5, 100, -450);
		EnemyControl.createPackOfEnemies(5, 5, 500, -600);
		EnemyControl.createPackOfEnemies(7, 7, 100, -980);
		EnemyControl.createPackOfEnemies(4, 4, 650, -1250);
		EnemyControl.createPackOfEnemies(8, 8, 400, -1550);
		EnemyControl.createPackOfEnemies(4, 13, 220, -2100);
	}
	
	public static void Level3()
	{
		// continue the song on the start of the level
		Sounds.playSound(Sounds.playtimeMusic);
		
		EnemyControl.createPackOfEnemies(5, 5, 200, -200);
		EnemyControl.createPackOfEnemies(5, 5, 500, -200);
		EnemyControl.createPackOfEnemies(6, 6, 100, -450);
		EnemyControl.createPackOfEnemies(2, 2, 700, -500);
		EnemyControl.createPackOfEnemies(7, 7, 100, -760);
		EnemyControl.createPackOfEnemies(5, 5, 300, -900);
		EnemyControl.createPackOfEnemies(3, 3, 600, -900);
		EnemyControl.createPackOfEnemies(8, 8, 200, -1250);
		EnemyControl.createPackOfEnemies(5, 5, 200, -1550);
		EnemyControl.createPackOfEnemies(5, 5, 600, -1550);
		EnemyControl.createPackOfEnemies(4, 4, 200, -1750);
		EnemyControl.createPackOfEnemies(4, 13, 200, -2100);
	}
}
