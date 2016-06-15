package mainGamePackage;

import java.awt.Font;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOver  extends BasicGameState
{
	private TrueTypeFont title, item;
	
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException
	{
		// initializing all the fonts
		
		Font titleFont = new Font(Font.SERIF, Font.ITALIC, 30);
		title = new TrueTypeFont(titleFont, true);
		
		Font itemsFont = new Font(Font.MONOSPACED, Font.ITALIC + Font.BOLD, 25);
		item = new TrueTypeFont(itemsFont, true);
	}

	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException
	{
		
	}

	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException
	{
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}

}
