
/**
 * The Class BoardCollision.
 * Implements the BoardCommand interface.  
 * Provides a command that classes can execute to 
 * determine when objects collide on the play field.
 * 
 * @author Mike Crowell
 */
public class BoardCollision implements BoardCommand{
	
 	/* 
 	 * Implements Commandpattern
 	 * Provides implementation of a command to be executed
 	 * by other objects.
 	*/
	public boolean execute(GameCharacter a, GameCharacter b){
		boolean isCrash = false;		
		if ((a.getX() + a.getHeight()-5) >= (b.getX()+5)){
			if ((a.getX()+5) <= (b.getX() + b.getHeight()-5)){
				if ((a.getY() + a.getWidth()-5) >= (b.getY()+5)){
					if  ((a.getY()+5) <= (b.getY() + b.getWidth()-5)){
						isCrash = true;
					}
				}				
			}
		}		
		return isCrash;
	}
}
