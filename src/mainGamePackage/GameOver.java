package mainGamePackage;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import InputPackages.MouseInput;
import StaticClasses.Images;

public class GameOver  extends BasicGameState
{
	private TrueTypeFont title, item, scoreDisplay;
	public static Color mainMenuColor = Color.yellow;
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		// initializing all the fonts
		
		Font titleFont = new Font(Font.SERIF, Font.BOLD, 65);
		title = new TrueTypeFont(titleFont, true);
		
		Font itemsFont = new Font(Font.MONOSPACED, Font.ITALIC + Font.BOLD, 30);
		item = new TrueTypeFont(itemsFont, true);
		
		Font scoreFont = new Font(Font.MONOSPACED, Font.ITALIC + Font.BOLD, 35);
		scoreDisplay = new TrueTypeFont(scoreFont, true);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		g.drawImage(Images.background, 0, 0, null);
		
		title.drawString(220, 200, "GAME OVER", Color.red);
		item.drawString(340, 300, "Main Menu", mainMenuColor);
		scoreDisplay.drawString(340, 500, "SCORE: " + Play.score);
		
		//g.drawRect(340, 310, 160, 35);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		MouseInput.Scan(sbg, gc);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}

}
