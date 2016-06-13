package FruitPackage;

import org.newdawn.slick.*;

public class Enemies
{
	Image image;
	private float enemyX, enemyY;
	private double speed = 0.1;
	
	public Enemies(int x, int y)
	{
		this.enemyX = x;
		this.enemyY = y;
	}
	
	public void render(Graphics g)
	{
		g.drawImage(Images.enemy, enemyX, enemyY, null);
	}
	
	public void move()
	{
		enemyY += (float)speed;
	}
	
	// can be for more advanced version of the game
	/*
	public void move(int moveType)
	{
		switch(moveType)
		{
			case 1: // Front
				enemyy += (float)speed;
				break;
			case 2: // Back
				enemyy -= (float)speed;
				break;
			case 3: // Left
				enemyx -= (float)speed;
				break;
			case 4: // Right
				enemyx += (float)speed;
				break;
		}
	}*/
	
	public float getY()
	{
		return enemyY;
	}
	
	public float getX()
	{
		return enemyX;
	}
}