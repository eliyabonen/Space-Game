package mainGamePackage;

import java.awt.Toolkit;

import javax.swing.JOptionPane;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame
{
	public static final String gameName = "Space Game";
	public static final int menu = 0, play = 1, credits = 2, gameOver = 3, pause = 4;
	public static int width = 850, height = 600;
	
	public Game(String gamename)
	{
		// adding all the states for the game
		super(gamename);
		this.addState(new Menu());
		this.addState(new Play());
		this.addState(new Credits());
		this.addState(new GameOver());
		this.addState(new Pause());
	}
	
	public void initStatesList(GameContainer gc) throws SlickException
	{
		// initializing all the states
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(credits).init(gc, this);
		this.getState(gameOver).init(gc, this);
		this.getState(pause).init(gc, this);
		
		this.enterState(menu);
	}
	
	public static void main(String[] args)
	{
		AppGameContainer appgc;
		
		
		try {
			appgc = new AppGameContainer(new Game(gameName));
			appgc.setShowFPS(true);
			appgc.setDisplayMode(width, height, false);
			appgc.setAlwaysRender(true);
			appgc.setUpdateOnlyWhenVisible(false);
			String[] Icons = { "res//spaceShipIcon16.png", "res//spaceShipIcon32.png" };
			appgc.setIcons(Icons);
			appgc.start();
		} catch (SlickException e) {
			JOptionPane.showMessageDialog(null, "There are some images missing", "ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			e.printStackTrace();
		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(null, "There are some images missing", "ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			e.printStackTrace();
		}
	}
}