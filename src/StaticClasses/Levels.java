package StaticClasses;

import mainGamePackage.Play;
import ControlClasses.EnemyControl;

public class Levels
{
	public static void Level1()
	{
		if(Play.score == 0)
		{
			EnemyControl.createPackOfEnemies(3, 3, 200);
			EnemyControl.createPackOfEnemies(3, 3, 650);
		}

		if(Play.score == 9)
		{
			EnemyControl.createPackOfEnemies(3, 4, 400);
		}
		
		if(Play.score == 18)
		{
			EnemyControl.createPackOfEnemies(5, 5, 200);
		}
	}
}
