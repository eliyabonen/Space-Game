package InputPackages;

import mainGamePackage.Game;
import mainGamePackage.Play;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

import ControlClasses.ShootingControl;
import Objects.Bullet;
import StaticClasses.Sounds;

public class KeyboardInput
{
	public static int side = 1;
	public static int plusSpot = 10;
	public static double speed = 0.5;
	
	public static void KeyboardScan(GameContainer gc, StateBasedGame sbg, int delta)
	{
		Input input = gc.getInput();
		
		// going right
		if(input.isKeyDown(Input.KEY_RIGHT))
		{
			if(Play.xcharachter < Game.width-50)
				Play.xcharachter += delta * .1f + speed;
		}
		// going left
		if(input.isKeyDown(Input.KEY_LEFT))
		{
			if(Play.xcharachter > 0)
				Play.xcharachter -= delta * .1f + speed;
		}
		if(input.isKeyDown(Input.KEY_UP))
		{
			 // maybe add these choice later(in later versions)
		}
		if(input.isKeyDown(Input.KEY_DOWN))
		{
			 // maybe add these choice later(in later versions)
		}
		
		// shoot
		if(input.isKeyPressed(Input.KEY_SPACE))
		{
			// play the shooting sound
			Sounds.loadSpecificSound(Sounds.shotEffectID);
			Sounds.playSound(Sounds.shotEffect);
			
			// every time the space key is pressed, we create a new bullet and shooting it
			ShootingControl.addBullet(new Bullet(Play.xcharachter+plusSpot, Play.ycharachter));
		}
		// pause
		if(input.isKeyPressed(Input.KEY_ESCAPE))
		{
			// if it's in the game state
			if(sbg.getCurrentStateID() == 1)
			{
				Sounds.stopSound(Sounds.playtimeMusic);
				sbg.enterState(4); // entering to pause
			}
			
			// if it's in the pause state
			if(sbg.getCurrentStateID() == 4)
			{
				Sounds.playSound(Sounds.playtimeMusic);
				sbg.enterState(1); // enter to the game state
			}
		}
	}
}
