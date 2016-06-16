package StaticClasses;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Images
{
	public static Image background, enemy, character;
	
	public static void loadPics()
	{
		try {
			background = new Image("res//spaceBackground.jpg");
			character = new Image("res//spaceShip.png");
			enemy = new Image("res//enemy.jpg");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
