package ControlClasses;

import java.awt.Rectangle;
import java.util.*;

import mainGamePackage.Play;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

import Objects.Enemies;
import StaticClasses.Levels;
import StaticClasses.Sounds;

public class EnemyControl
{
	public static ArrayList<Enemies> enemyArray = new ArrayList<Enemies>();
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
	
	public static void render(Graphics g, StateBasedGame sbg)
	{
		// looping through all the enemies and drawing&moving them
		for(int i = 0; i < enemyArray.size(); i++)
		{
			enemyArray.get(i).render(g);
			enemyArray.get(i).move();
			
			// check if enemy hit ship
			if((new Rectangle((int)enemyArray.get(i).getX()+20, (int)enemyArray.get(i).getY()+20, 25, 25)).intersects(new Rectangle((int)Play.xcharachter, (int)Play.ycharachter, 45, 45)))
			{
				enemyArray.remove(i);
				Play.life--;
				
				if(Play.life == 0)
				{
					// entering to game over
					sbg.enterState(3);
					
					// stopping the game song
					Sounds.stopSound(Sounds.playtimeMusic);

					// playing the game over sound
					Sounds.loadSpecificSound(Sounds.gameOverID);
					Sounds.playSound(Sounds.gameOver);
				}
				
				continue;
			}
			
			
			// killing all the enemies that felt down the screen
			if(enemyArray.get(i).getY() > 600)
			{
				enemyArray.remove(i);
				Play.life--;
				
				if(Play.life == 0)
				{
					// entering to game over
					sbg.enterState(3);
					
					// stopping the game song
					Sounds.stopSound(Sounds.playtimeMusic);

					// playing the game over sound
					Sounds.loadSpecificSound(Sounds.gameOverID);
					Sounds.playSound(Sounds.gameOver);
				}
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