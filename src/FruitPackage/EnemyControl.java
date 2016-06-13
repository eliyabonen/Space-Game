package FruitPackage;

import java.util.*;
import org.newdawn.slick.*;

public class EnemyControl
{
	private static ArrayList<Enemies> enemyArray = new ArrayList<Enemies>();
	private static Random random = new Random();
	private static boolean added = false;
	
	public static void beginLevel(Graphics g)
	{
		// creating the enemies for level 1
		if(Play.level == 1)
		{
			// check for not making these enemies for infinite times
			if(added == false)
			{
				for(int i = 0; i < 5; i++)
					EnemyControl.addEnemy(new Enemies(random.nextInt(900), -100));
			}
			added = true;
		}
	}
	
	public static void render(Graphics g)
	{
		// looping through all the enemies and drawing&moving them
		for(int i = 0; i < enemyArray.size(); i++)
		{
			enemyArray.get(i).render(g);
			enemyArray.get(i).move();
			
			// killing all the enemies that felt down the screen
			if(enemyArray.get(i).getY() > 600)
			{
				enemyArray.remove(i);
			}
		}
	}
	
	public static void addEnemy(Enemies e)
	{
		enemyArray.add(e);
	}
}