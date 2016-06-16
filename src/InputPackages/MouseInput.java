package InputPackages;

import mainGamePackage.GameOver;
import mainGamePackage.Menu;
import mainGamePackage.Play;
import mainGamePackage.Credits;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class MouseInput
{
	public static int xpos, ypos;
	
	public static void Scan(StateBasedGame sbg, GameContainer gc)
	{
		xpos = Mouse.getX();
		ypos = 600-Mouse.getY();
		
		// Mouse Clicking
		if(gc.getInput().isMousePressed(gc.getInput().MOUSE_LEFT_BUTTON))
		{
			if(sbg.getCurrentStateID() == 0) // start menu
			{
				if(xpos >= 375 && xpos <= 445 && ypos >= 180 && ypos <= 210) // play
				{
					Play.resetAll();
					sbg.enterState(1);
				}
				if(xpos >= 340 && xpos <= 480 && ypos >= 320 && ypos <= 350) // credits
					sbg.enterState(2);
				if(xpos >= 375 && xpos <= 445 && ypos >= 520 && ypos <= 550) // quit
					System.exit(0);
			}
			
			if(sbg.getCurrentStateID() == 2) // credits
			{
				if(xpos >= 370 && xpos <= 475 && ypos >= 470 && ypos <= 575) // back
					sbg.enterState(0);
			}
			
			if(sbg.getCurrentStateID() == 3) // game over
			{
				if(xpos >= 340 && xpos <= 500 && ypos >= 310 && ypos <= 345) // main menu
					sbg.enterState(0);
			}
		}
		
			// Mouse Moving
		// main menu
		if(xpos >= 375 && xpos <= 445 && ypos >= 180 && ypos <= 210) // play in menu
			Menu.pColor = Color.gray;
		else if(xpos >= 340 && xpos <= 480 && ypos >= 320 && ypos <= 350) // credits in menu
			Menu.tColor = Color.gray;
		else if(xpos >= 375 && xpos <= 445 && ypos >= 520 && ypos <= 550) // quit in menu
			Menu.qColor = Color.gray;
		
		// credits
		else if(xpos >= 370 && xpos <= 475 && ypos >= 470 && ypos <= 515) // back in credits
			Credits.bcolor = Color.gray;
		
		// game over
		else if(xpos >= 340 && xpos <= 500 && ypos >= 310 && ypos <= 345) // main menu
			GameOver.mainMenuColor = Color.gray;
		
		else
		{
			Credits.bcolor = Color.yellow;
			Menu.mColor = Color.yellow;
			Menu.pColor = Color.yellow;
			Menu.qColor = Color.yellow;
			Menu.tColor = Color.yellow;
			GameOver.mainMenuColor = Color.yellow;
		}
	}
}