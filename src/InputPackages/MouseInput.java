package InputPackages;

import mainGamePackage.Menu;
import mainGamePackage.Play;
import mainGamePackage.Credits;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.state.StateBasedGame;

public class MouseInput
{
	public static int xpos, ypos;
	
	public static void Scan(StateBasedGame sbg)
	{
		xpos = Mouse.getX();
		ypos = 600-Mouse.getY();
		
			// Mouse Clicking
		if(Mouse.getEventButtonState())
		{
			if(Mouse.getEventButton() == 0)
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
			}
		}
		
			// Mouse Moving
		if(xpos >= 375 && xpos <= 445 && ypos >= 180 && ypos <= 210) // play in menu
			Menu.pColor = Color.gray;
		else if(xpos >= 340 && xpos <= 480 && ypos >= 320 && ypos <= 350) // thanks in menu
			Menu.tColor = Color.gray;
		else if(xpos >= 375 && xpos <= 445 && ypos >= 520 && ypos <= 550) // quit in menu
			Menu.qColor = Color.gray;
		else if(xpos >= 370 && xpos <= 475 && ypos >= 470 && ypos <= 515) // back in thanks
			Credits.bcolor = Color.gray;
		else
		{
			Credits.bcolor = Color.blue;
			Menu.mColor = Color.yellow;
			Menu.pColor = Color.yellow;
			Menu.qColor = Color.yellow;
			Menu.tColor = Color.yellow;
		}
	}
}