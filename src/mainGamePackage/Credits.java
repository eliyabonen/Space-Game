package mainGamePackage;

import java.awt.Font;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import InputPackages.MouseInput;
import StaticClasses.Images;

public class Credits extends BasicGameState
{
	private TrueTypeFont font, back;
	public static Color fcolor = Color.pink;
	public static Color pcolor = new Color(34, 0, 255);
	public static Color bcolor = Color.yellow;
	
	public Credits()
	{
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		Font itemsFont = new Font(Font.MONOSPACED, Font.ITALIC + Font.BOLD, 30);
		font = new TrueTypeFont(itemsFont, true);
		
		Font backFont = new Font("Arial", Font.ITALIC + Font.BOLD, 40);
		back = new TrueTypeFont(backFont, true);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		// drawing the background
		g.drawImage(Images.background, 0, 0, null);
		
		font.drawString(330, 220, "Space Game", fcolor);
		font.drawString(170, 260, "Created by Eliya Bonen [2016]", fcolor);
		
		back.drawString(370, 470, "Back", bcolor);
		//g.drawRect(370, 470, 105, 45);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		MouseInput.Scan(sbg, gc);
	}
	
	public int getID()
	{
		return 2;
	}
}