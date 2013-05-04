import java.util.Random;


/**
 * The Class MoveStampede.
 * Implements the MoveBehavior interface.  
 * Implements a type of movement where the computer character 
 * randomly shoots across the play field.
 * 
 * @author Mike Crowell
 */
public class MoveStampede implements MoveBehavior{

	private PlayerCharacter player;
	private GamePrize prize;
	private BadGuy badGuy;
	private Obstacles obstacles;
	private int speed, direction;
	private BoardCollision collision;
	private boolean isMoving;
    public static final int MOVING_DOWN = 0;
    public static final int MOVING_UP = 1;
    public static final int MOVING_LEFT = 2;
    public static final int MOVING_RIGHT = 3;
	

	public MoveStampede(BadGuy badGuy, PlayerCharacter player, GamePrize prize, Obstacles obstacles, int speed){
		this.player = player;
		this.prize = prize;
		this.badGuy = badGuy;
		this.obstacles = obstacles;
		this.speed = speed;
		collision = new BoardCollision();
		isMoving = false;
	}
	
	@Override
	public void move() {
		if(isMoving){
			if(direction == MOVING_DOWN){
				badGuy.setY(badGuy.getY() + speed);
				if(badGuy.getY() >= player.getMaxHeight()){
					isMoving = false;
				}
			}else if(direction == MOVING_UP){
				badGuy.setY(badGuy.getY() - speed);
				if((badGuy.getY() + badGuy.getHeight()) <= 0){
					isMoving = false;
				}
			}else if(direction == MOVING_LEFT){
				badGuy.setX(badGuy.getX() - speed);
				if((badGuy.getX() + badGuy.getWidth()) <= 0){
					isMoving = false;
				}
			}else if(direction == MOVING_RIGHT){
				badGuy.setX(badGuy.getX() + speed);
				if(badGuy.getX() >= player.getMaxWidth()){
					isMoving = false;
				}
			}
			caughtPrize();
			caughtPlayer();
			badGuy.statusChanged();
		}else{
			Random rand = new Random();
			int randNum = rand.nextInt(100);
			if(randNum == 0){
				direction = rand.nextInt(4);
				if(direction == MOVING_DOWN){
					badGuy.setX(player.getX());
					badGuy.setY(0);
				}else if(direction == MOVING_UP){
					badGuy.setX(player.getX());
					badGuy.setY(player.getMaxHeight());
				}else if(direction == MOVING_LEFT){
					badGuy.setX(player.getMaxWidth());
					badGuy.setY(player.getY());
				}else if(direction == MOVING_RIGHT){
					badGuy.setX(0);
					badGuy.setY(player.getY());
				}
				isMoving = true;
			}			
		}
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
