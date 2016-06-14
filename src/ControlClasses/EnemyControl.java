package ControlClasses;

import java.util.*;

import mainGamePackage.Play;

import org.newdawn.slick.*;

import Objects.Enemies;
import StaticClasses.Levels;

public class EnemyControl
{
	public static ArrayList<Enemies> enemyArray = new ArrayList<Enemies>();
	private static ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
	private static Random random = new Random();
	public static boolean sratedLevel = false;
	private static int spaceBetweenEnemies = 35;
	
	public static void beginLevel(Graphics g)
	{
		// creating the enemies for level 1
		if(Play.level == 1 && sratedLevel == false)
		{
			Levels.Level1();
			sratedLevel = true;
		}
	}
	
	public static void createPackOfEnemies(int rows, int cols, int startXPos)
	{
		int startYPos = -200;
		int tempStartXPos = startXPos;
		
		// creating a matrix of enemies
		for(int r = 0; r < rows; r++)
		{
			// creating the cols
			for(int c = 0; c < cols; c++)
			{
				EnemyControl.addEnemy(new Enemies(tempStartXPos, startYPos));
				tempStartXPos += spaceBetweenEnemies;
			}
			
			// creating the rows
			tempStartXPos = startXPos;
			startYPos += spaceBetweenEnemies;
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
	
	public static void removeEnemy(int index)
	{
		enemyArray.remove(index);
	}
}