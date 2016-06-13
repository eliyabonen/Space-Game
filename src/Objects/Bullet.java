package Objects;

import org.newdawn.slick.*;

public class Bullet
{
	private float bulletX, bulletY;
	private double speed = 2.0;
	
	public Bullet(float x, float y)
	{
		this.bulletX = x;
		this.bulletY = y;
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.red);
		g.fillRect(bulletX, bulletY, 20, 10);
	}
	
	public void move()
	{
		bulletY -= (float)speed;
	}
	
	public float getY()
	{
		return bulletY;
	}
	
	public float getX()
	{
		return bulletX;
	}
}
