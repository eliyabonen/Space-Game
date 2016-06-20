package ControlClasses;

import java.util.ArrayList;
import java.awt.Rectangle;

import mainGamePackage.Play;

import org.newdawn.slick.*;

import Objects.Bullet;

public class ShootingControl
{
	public static ArrayList<Bullet> bulletArray = new ArrayList<Bullet>();
	private static int index = -1;
	
	public static void render(Graphics g)
	{
		// looping through all the bullets
		for(int i = 0; i < bulletArray.size(); i++)
		{
			bulletArray.get(i).render(g);
			bulletArray.get(i).move();
			
			// checking if the bullet hit an enemy(return the index of the enemy if hitted, return -1 if not hit)
			index = bulletHitEnemy(i);
			
			// check if actually hitted
			if(index != -1)
			{
				// deleting the bullet and the enemy
				bulletArray.remove(i);
				EnemyControl.removeEnemy(index);
				
				// increasing the score
				Play.score++;
				
				// there must be a continue here because of the bullets check right after(maybe i deleted this element already)
				continue;
			}
			
			// kill the bullets that left the screen
			if(bulletArray.get(i).getY() == -100)
				bulletArray.remove(i);
		}
	}
	
	// checking if a bullet hit an enemy, if so, return the enemy index, if not, return -1
	private static int bulletHitEnemy(int i)
	{
		for(int j = 0; j < EnemyControl.enemyArray.size(); j++)
		{
			if(new Rectangle((int)bulletArray.get(i).getX(), (int)bulletArray.get(i).getY(), 20, 10).intersects(new Rectangle((int)EnemyControl.enemyArray.get(j).getX()+20, (int)EnemyControl.enemyArray.get(j).getY()+20, 25, 25)))
			{
				return j;
			}
		}
		
		return -1;
	}
	
	public static void addBullet(Bullet b)
	{
		bulletArray.add(b);
	}
	
	public static int getBulletNum()
	{
		return bulletArray.size();
	}
}
