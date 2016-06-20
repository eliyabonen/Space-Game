package InputPackages;

import mainGamePackage.GameOver;
import mainGamePackage.Menu;
import mainGamePackage.Pause;
import mainGamePackage.Play;
import mainGamePackage.Credits;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import StaticClasses.Levels;
import StaticClasses.Sounds;

public class MouseInput
{
	public static int xpos, ypos;
	
	public static void Scan(StateBasedGame sbg, GameContainer gc)
	{
		xpos = Mouse.getX();
		ypos = 600-Mouse.getY();
		
		// Mouse Clicking
		if(gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON))
		{
			if(sbg.getCurrentStateID() == 0) // start menu
			{
				if(xpos >= 375 && xpos <= 445 && ypos >= 180 && ypos <= 210) // play
				{
					// cleaning the key pressed record
					gc.getInput().clearKeyPressedRecord();
					
					// reseting the game and starting a new level
					Play.resetAll();
					Levels.beginLevels();
					
					// entering to the play state
					sbg.enterState(1);
				}
				else if(xpos >= 290 && xpos <= 545 && ypos >= 250 && ypos <= 280) // music
					Sounds.musicOn = !(Sounds.musicOn);
				else if(xpos >= 340 && xpos <= 480 && ypos >= 320 && ypos <= 350) // credits
					sbg.enterState(2);
				else if(xpos >= 375 && xpos <= 445 && ypos >= 520 && ypos <= 550) // quit
					System.exit(0);
			}
			
			else if(sbg.getCurrentStateID() == 2) // credits
			{
				if(xpos >= 370 && xpos <= 475 && ypos >= 470 && ypos <= 575) // back
					sbg.enterState(0);
			}
			
			else if(sbg.getCurrentStateID() == 3) // game over
			{
				if(xpos >= 340 && xpos <= 500 && ypos >= 310 && ypos <= 345) // main menu
					sbg.enterState(0);
			}
			
			else if(sbg.getCurrentStateID() == 4) // pause
			{
				if(xpos >= 380 && xpos <= 490 && ypos >= 200 && ypos <= 230) // resume
				{
					if(Sounds.inTheMiddleOfLevelUp == false && Play.winner == false)
						Sounds.playSound(Sounds.playtimeMusic);
					sbg.enterState(1); // enter to the game state
				}
				
				else if(xpos >= 350 && xpos <= 520 && ypos >= 260 && ypos <= 290) // main menu
					sbg.enterState(0);
				
				else if(xpos >= 385 && xpos <= 465 && ypos >= 520 && ypos <= 550) // quit
					System.exit(0);
				
			}
		}
		
			// Mouse Moving
		// main menu
		if(sbg.getCurrentStateID() == 0)
		{
			if(xpos >= 375 && xpos <= 445 && ypos >= 180 && ypos <= 210) // play
				Menu.pColor = Color.gray;
			else if(xpos >= 290 && xpos <= 545 && ypos >= 250 && ypos <= 280) // music
				Menu.mColor = Color.gray;
			else if(xpos >= 340 && xpos <= 480 && ypos >= 320 && ypos <= 350) // credits
				Menu.tColor = Color.gray;
			else if(xpos >= 375 && xpos <= 445 && ypos >= 520 && ypos <= 550) // quit
				Menu.qColor = Color.gray;
			else
			{
				//Menu.mColor = Color.yellow;
				Menu.pColor = Color.yellow;
				Menu.qColor = Color.yellow;
				Menu.tColor = Color.yellow;
				Menu.mColor = Color.yellow;
			}
				
		}
		
		// credits
		else if(sbg.getCurrentStateID() == 2)
		{
			if(xpos >= 370 && xpos <= 475 && ypos >= 470 && ypos <= 515) // back
				Credits.bcolor = Color.gray;
			else
				Credits.bcolor = Color.yellow;
		}
		
		// game over
		else if(sbg.getCurrentStateID() == 3)
		{
			if(xpos >= 340 && xpos <= 500 && ypos >= 310 && ypos <= 345) // main menu
				GameOver.mainMenuColor = Color.gray;
			else
				GameOver.mainMenuColor = Color.yellow;
		}
		
		// pause
		else if(sbg.getCurrentStateID() == 4)
		{
			if(xpos >= 380 && xpos <= 490 && ypos >= 200 && ypos <= 230) // resume
				Pause.resumeColor = Color.gray;
			
			else if(xpos >= 350 && xpos <= 520 && ypos >= 260 && ypos <= 290) // main menu
				Pause.mainmenuColor = Color.gray;
			
			else if(xpos >= 385 && xpos <= 465 && ypos >= 520 && ypos <= 550) // quit
				Pause.quitColor = Color.gray;
			else
			{
				Pause.mainmenuColor = Color.yellow;
				Pause.quitColor = Color.yellow;
				Pause.resumeColor = Color.yellow;
			}
		}
	}
}