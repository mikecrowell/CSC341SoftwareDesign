
/**
 * The Class MeanDog.
 * Extends the BadGuy abstract class.  
 * MeanDog is one of the types of computer controlled characters.
 * 
 * @author Mike Crowell
 */
public class MeanDog extends BadGuy{

	/**
	 * Instantiates a new mean dog.
	 * 
	 * @param player
	 *            the player
	 * @param prize
	 *            the prize
	 * @param obstacles
	 *            the obstacles
	 */
	public MeanDog(PlayerCharacter player, GamePrize prize, Obstacles obstacles){	
		super(player, prize, obstacles);
		speed = 1;
		score = 3;
		
		// Assign a move behavior
		// implements the Strategy pattern
		moveBehavior = new MoveChasePlayer(this, player, prize, obstacles, speed);
		
		super.setImgLoc("src/dog1.gif");
		super.setHeight(75);
		super.setWidth(75);
	}
	
}
