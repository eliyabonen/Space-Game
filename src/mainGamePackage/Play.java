package mainGamePackage;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import StaticClasses.Images;
import StaticClasses.Sounds;
import ControlClasses.EnemyControl;
import ControlClasses.ShootingControl;
import InputPackages.KeyboardInput;

public class Play extends BasicGameState
{
	public static float xcharachter = 430, ycharachter = 500;
	public static int level = 1, score = 0, life = 3;
	
	public Play()
	{
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		// drawing the background
		g.drawImage(Images.background, 0, 0, null);
		g.setColor(Color.white);
		
		// drawing the character
		//g.drawRect(xcharachter, ycharachter, 45, 45);
		g.drawImage(Images.character, xcharachter, ycharachter, null);
		
		// drawing the enemies
		EnemyControl.beginLevel(g);
		EnemyControl.render(g, sbg);
		
		// drawing the bullets
		if(ShootingControl.getBulletNum() > 0)
			ShootingControl.render(g);
		
		// draw the score
		g.setColor(Color.white);
		g.drawString("Score: " + score, Game.width-100, 20);
		g.drawString("Life: " + life, Game.width-100, 40);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		KeyboardInput.KeyboardScan(gc, delta);
	}
	
	public static void resetAll()
	{
		// playtime utilities
		score = 0;
		life = 3;
		level = 1;
		xcharachter = 430;
		ycharachter = 500;
		
		// clear the enemies and bullets off the screen
		EnemyControl.sratedLevel = false;
		EnemyControl.enemyArray.clear();
		ShootingControl.bulletArray.clear();
		
		// starting the sound all over again
		Sounds.loadSpecificSound(Sounds.playtimeMusicID);
		Sounds.playSound(Sounds.playtimeMusic);
	}
	
	public int getID()
	{
		return 1;
	}
}