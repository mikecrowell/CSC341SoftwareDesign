
/**
 * The Class HoundDog.
 * Extends the BadGuy abstract class.  
 * HoundDog is one of the types of computer controlled characters.
 * 
 * @author Mike Crowell
 */
public class HoundDog extends BadGuy{

	public HoundDog(PlayerCharacter player, GamePrize prize, Obstacles obstacles){	
		super(player, prize, obstacles);
		speed = 1;
		score = 1;
		
		// Assign a move behavior
		// implements the Strategy pattern
		moveBehavior = new MoveChasePlayerAndPrize(this, player, prize, obstacles, speed);
		
		super.setImgLoc("src/dog3.gif");
		super.setHeight(75);
		super.setWidth(75);
	}
	
}
