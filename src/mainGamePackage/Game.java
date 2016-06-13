package mainGamePackage;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame
{
	public static final String gameName = "Space Game";
	public static final int menu = 0, play = 1, thanks = 2;
	
	public Game(String gamename)
	{
		// adding all the states for the game
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new Thanks(thanks));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException
	{
		// initializing all the states
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(thanks).init(gc, this);
		
		this.enterState(menu);
	}
	
	public static void main(String[] args)
	{
		AppGameContainer appgc;
		
		try {
			appgc = new AppGameContainer(new Game(gameName));
			appgc.setDisplayMode(900, 600, false);
			//appgc.setShowFPS(false);
			appgc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}