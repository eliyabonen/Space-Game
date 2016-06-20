package mainGamePackage;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import InputPackages.KeyboardInput;
import InputPackages.MouseInput;
import StaticClasses.Images;

public class Pause extends BasicGameState
{
	private TrueTypeFont item;
	public static Color resumeColor = Color.yellow, mainmenuColor = Color.yellow, quitColor = Color.yellow;
	
	public Pause()
	{
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		// initializing all the fonts
		
		Font itemsFont = new Font(Font.MONOSPACED, Font.ITALIC + Font.BOLD, 30);
		item = new TrueTypeFont(itemsFont, true);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		g.drawImage(Images.background, 0, 0, null);
		
		item.drawString(380, 200, "Resume", resumeColor);
		//g.drawRect(380, 200, 110, 30);
		item.drawString(350, 260, "Main Menu", mainmenuColor);
		//g.drawRect(350, 260, 170, 30);
		item.drawString(385, 520, "Quit", quitColor);
		//g.drawRect(385, 520, 80, 30);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		MouseInput.Scan(sbg, gc);
		KeyboardInput.KeyboardScan(gc, sbg, delta);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 4;
	}
}
