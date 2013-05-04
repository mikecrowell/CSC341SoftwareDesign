
/**
 * The Class HungryDog.
 * Extends the BadGuy abstract class.  
 * HungryDog is one of the types of computer controlled characters.
 * 
 * @author Mike Crowell
 */
public class HungryDog extends BadGuy{
	
	
	/**
	 * Instantiates a new hungry dog.
	 * 
	 * @param player
	 *            the player
	 * @param prize
	 *            the prize
	 * @param obstacles
	 *            the obstacles
	 */
	public HungryDog(PlayerCharacter player, GamePrize prize, Obstacles obstacles){	
		super(player, prize, obstacles);
		speed = 1;
		score = 1;
		
		// Assign a move behavior
		// implements the Strategy pattern
		moveBehavior = new MoveChasePrize(this, player, prize, obstacles, speed);
		
		super.setImgLoc("src/dog2.gif");
		super.setHeight(75);
		super.setWidth(75);
	}

}
