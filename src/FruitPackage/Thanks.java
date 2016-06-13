package FruitPackage;

import java.awt.Font;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Thanks extends BasicGameState
{
	private TrueTypeFont font, back;
	public static Color fcolor = Color.blue;
	public static Color pcolor = new Color(34, 0, 255);
	public static Color bcolor = Color.blue;
	
	public Thanks(int state)
	{
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		Images.loadPics();
		
		Font itemsFont = new Font(Font.MONOSPACED, Font.ITALIC + Font.BOLD, 23);
		font = new TrueTypeFont(itemsFont, true);
		
		Font backFont = new Font("Arial", Font.ITALIC + Font.BOLD, 40);
		back = new TrueTypeFont(backFont, true);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		font.drawString(300, 100, "The Fruit Catcher", fcolor);
		font.drawString(190, 140, "This game created by koko the cute", fcolor);
		font.drawString(350, 180, "Thanks To:", fcolor);
		font.drawString(310, 240, "itay - nothing", pcolor);
		font.drawString(280, 280, "internet - the idea", pcolor);
		font.drawString(250, 320, "koko - creating the game", pcolor);
		font.drawString(210, 400, "and all the cutes in the world", pcolor);
		
		back.drawString(370, 470, "Back", bcolor);
		//g.drawRect(370, 470, 105, 45);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		MouseInput.Scan(sbg);
	}
	
	public int getID()
	{
		return 2;
	}
}