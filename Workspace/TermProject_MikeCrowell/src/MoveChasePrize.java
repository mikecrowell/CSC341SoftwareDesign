
/**
 * The Class MoveChasePrize.
 * Implements the MoveBehavior interface.  
 * Implements a type of movement where the computer 
 * character chases the prize.
 * 
 * @author Mike Crowell
 */
public class MoveChasePrize implements MoveBehavior{

	private PlayerCharacter player;
	private GamePrize prize;
	private BadGuy badGuy;
	private Obstacles obstacles;
	private int speed;
	private BoardCollision collision;
	

	public MoveChasePrize(BadGuy badGuy, PlayerCharacter player, GamePrize prize, Obstacles obstacles, int speed){
		this.player = player;
		this.prize = prize;
		this.badGuy = badGuy;
		this.obstacles = obstacles;
		this.speed = speed;
		collision = new BoardCollision();
	}
	
	@Override
	public void move() {
		int prevX = badGuy.getX();
		int prevY = badGuy.getY();
		boolean isMoveUp = false;
		boolean isMoveLeft = false;
		boolean isMoveDown = false;
		boolean isMoveRight = false;
		
		if((badGuy.getX() - prize.getX()) > 0){
			isMoveLeft = true;
		}else if((badGuy.getX() - prize.getX()) < 0){
			isMoveRight = true;
		}

		if((badGuy.getY() - prize.getY()) > 0){
			isMoveUp = true;
		} else if((badGuy.getY() - prize.getY()) < 0){
			isMoveDown = true;
		}
		
		if(isMoveLeft){
			badGuy.setX(badGuy.getX() - speed);
		}else if(isMoveRight){
			badGuy.setX(badGuy.getX() + speed);
		}
		
		if (obstacles.checkForCrash(badGuy)){
			if(isMoveLeft){
				if((prevX + speed) < player.getMaxWidth()){
					badGuy.setX(prevX + speed);
				}
			}else{
				if((prevX - speed) > 0){
					badGuy.setX(prevX - speed);
				}
			}
		}
		
		if(isMoveUp){
			badGuy.setY(badGuy.getY() - speed);
		}else if(isMoveDown){
			badGuy.setY(badGuy.getY() + speed);
		}
		
		if (obstacles.checkForCrash(badGuy)){
			if(isMoveUp){
				if((prevY + speed) < player.getMaxHeight()){
					badGuy.setY(prevY + speed);
				}
			}else{
				if((prevY - speed) > 0){
					badGuy.setY(prevY + speed);
				}
			}
		}
		caughtPrize();
		caughtPlayer();
		badGuy.statusChanged();
	}

	private void caughtPrize(){
        if(collision.execute(badGuy, prize)){
    		badGuy.setCaughtPrize(true);    	
        }else{
        	badGuy.setCaughtPrize(false); 
        }
	}
	
	private void caughtPlayer(){
        if(collision.execute(badGuy, player)){
    		badGuy.setCaughtPlayer(true);    	
        }else{
        	badGuy.setCaughtPlayer(false); 
        }
	}
	
}
