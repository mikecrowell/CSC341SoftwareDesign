

/**
 * The Class Elephant.
 * Extends the BadGuy abstract class.  
 * Elephant is one of the types of computer controlled characters.
 * 
 * @author Mike Crowell
 */
public class Elephant extends BadGuy{
	public Elephant(PlayerCharacter player, GamePrize prize, Obstacles obstacles){	
		super(player, prize, obstacles);
		speed = 1;
		score = 5;
		
		// Assign a move behavior
		// implements the Strategy pattern
		moveBehavior = new MoveStampede(this, player, prize, obstacles, speed);
		
		super.setImgLoc("src/elephant.gif");
		super.setHeight(100);
		super.setWidth(100);
	}
}
