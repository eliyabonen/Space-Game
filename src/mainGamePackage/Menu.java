package mainGamePackage;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import StaticClasses.Images;
import StaticClasses.Sound;

import java.awt.Font;

public class Menu extends BasicGameState
{
	private TrueTypeFont title, item;
	
	public static Color pColor = Color.yellow, mColor = Color.yellow, tColor = Color.yellow, qColor = Color.yellow;
	
	public Menu(int state)
	{
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		// initializing all the fonts
		
		Font titleFont = new Font(Font.SERIF, Font.ITALIC, 30);
		title = new TrueTypeFont(titleFont, true);
		
		Font itemsFont = new Font(Font.MONOSPACED, Font.ITALIC + Font.BOLD, 25);
		item = new TrueTypeFont(itemsFont, true);
		
		// initialize the images
		Images.loadPics();
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		g.setBackground(Color.black);
		
		title.drawString(330, 50, "Space Game", Color.pink);
		
		item.drawString(375, 180, "PLAY", pColor); // width 70, height 30
		//g.drawRect(375, 180, 70, 30);
		
		item.drawString(290, 250, "MUSIC STATUS: " + (Sound.musicOn ? "ON" : "OFF"), mColor);
		
		
		item.drawString(350, 320, "Credits", tColor);
		//g.drawRect(340, 320, 140, 30);
		
		item.drawString(375, 520, "QUIT", qColor);
		//g.drawRect(375, 520, 70, 30);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		MouseInput.Scan(sbg);
	}
	
	public int getID()
	{
		return 0;
	}
}