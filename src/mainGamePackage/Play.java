package mainGamePackage;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import StaticClasses.Images;
import ControlClasses.EnemyControl;
import ControlClasses.ShootingControl;

public class Play extends BasicGameState
{
	public static float xcharachter = 430, ycharachter = 500;
	public static int level = 1;
	
	public Play(int state)
	{
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		Images.loadPics();
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		// drawing the background
		g.drawImage(Images.background, 0, 0, null);
		g.setColor(Color.white);
		
		// drawing the character
		g.drawImage(Images.character, xcharachter, ycharachter, null);
		
		// drawing the enemies
		EnemyControl.beginLevel(g);
		EnemyControl.render(g);
		
		// drawing the bullets
		if(ShootingControl.getBulletNum() > 0)
			ShootingControl.render(g);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		KeyboardInput.KeyboardScan(gc, delta);
	}
	
	public int getID()
	{
		return 1;
	}
}