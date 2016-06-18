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
		item.drawString(340, 200, "Resume", resumeColor);
		item.drawString(280, 270, "Main Menu", mainmenuColor);
		item.drawString(300, 520, "Quit", quitColor);
		
		//g.drawRect(340, 310, 160, 35);
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
