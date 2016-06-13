package ControlClasses;

import java.util.ArrayList;

import org.newdawn.slick.*;

import Objects.Bullet;

public class ShootingControl
{
	private static ArrayList<Bullet> bulletArray = new ArrayList<Bullet>();
	
	public static void render(Graphics g)
	{
		// looping through all the bullets
		for(int i = 0; i < bulletArray.size(); i++)
		{
			bulletArray.get(i).render(g);
			bulletArray.get(i).move();
			
			// kill the bullets that left the screen
			if(bulletArray.get(i).getY() == -100)
				bulletArray.remove(i);
		}
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
