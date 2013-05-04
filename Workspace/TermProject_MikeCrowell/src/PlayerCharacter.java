import java.util.Observable;
import java.util.Observer;


/**
 * The Class PlayerCharacter.
 * Implements the GameCharacter interface.  
 * PlayerCharacter is the object that is controlled by the user.  
 * PlayerCharacter is both a subject and observer in the Observer pattern.
 * 
 * @author Mike Crowell
 */
public class PlayerCharacter extends Observable implements GameCharacter, Observer{


	private int x, y, width, height, maxWidth, maxHeight;
	private String imgLoc;
	private boolean isUp, isDown, isRight, isLeft, isTurbo;
	private int speed;
	GamePrize prize;
	private int score;
	private boolean caughtPrize;
	private BoardCollision collision;
	private Obstacles obstacles;
	

	public PlayerCharacter(GamePrize prize, Obstacles obstacles){
		prize.addObserver(this);
		score = 0;
		collision = new BoardCollision();
		this.prize = prize;
		this.obstacles = obstacles;
		imgLoc = "src/bunny.gif";
		height = 75;
		width = 75;
	}
	
	@Override
	public void move() {
		setCaughtPrize(false);
		if(isTurbo()) {
            speed = 7;
        } else {
            speed = 3;
        }        
        
        if(isLeft()){
        	setX(getX() - speed);
        	if(obstacles.checkForCrash(this)){
        		setX(getX() + speed);;
        	}
        	if(getX() < 0){
        		setX(maxWidth);
        	}  
        	if(isUp){
            	setY(getY() - speed);
            	if(obstacles.checkForCrash(this)){
            		setY(getY() + speed);;
            	}
            	if(getY() < 0){
            		setY(maxHeight);
            	} 
            }else if(isDown){
            	setY(getY() + speed);
            	if(obstacles.checkForCrash(this)){
            		setY(getY() - speed);;
            	}
            	if(getY() > maxHeight){
            		setY(0);
            	} 
            }        	
        }else if(isRight()){
        	setX(getX() + speed);
        	if(obstacles.checkForCrash(this)){
        		setX(getX() - speed);;
        	}
        	if(getX() > maxWidth){
        		x = 0;
        		setX(0);
        	}
        	if(isUp()){
            	setY(getY() - speed);
            	if(obstacles.checkForCrash(this)){
            		setY(getY() + speed);;
            	}
            	if(getY() < 0){
            		setY(maxHeight);
            	} 
            }else if(isDown()){
            	setY(getY() + speed);
            	if(obstacles.checkForCrash(this)){
            		setY(getY() - speed);;
            	}
            	if(getY() > maxHeight){
            		setY(0);
            	} 
            }        	
        }else if(isUp()){
        	setY(getY() - speed);
        	if(obstacles.checkForCrash(this)){
        		setY(getY() + speed);;
        	}        	
        	if(getY() < 0){
        		setY(maxHeight);
        	} 
        }else if(isDown()){
        	setY(getY() + speed);
        	if(obstacles.checkForCrash(this)){
        		setY(getY() - speed);;
        	}
        	if(getY() > maxHeight){
        		setY(0);
        	} 
        }
        
        if(collision.execute(this, prize)){
    		score+= prize.score();
    		setCaughtPrize(true);
    		scoreChanged();        	
        }
               
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getImgLoc() {
		return imgLoc;
	}

	public void setImgLoc(String imgLoc) {
		this.imgLoc = imgLoc;
	}

	public boolean isUp() {
		return isUp;
	}

	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}

	public boolean isDown() {
		return isDown;
	}

	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}

	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public boolean isTurbo() {
		return isTurbo;
	}

	public void setTurbo(boolean isTurbo) {
		this.isTurbo = isTurbo;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

 	/* 
 	 * Implements Observer pattern
 	 * Receives updates from subjects
 	*/
	@Override
	public void update(Observable observable, Object arg) {
		if (observable instanceof GamePrize) {
			this.prize = (GamePrize)observable;
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
		setCaughtPrize(true);
		scoreChanged();		
	}

 	/**
 	 * Implements Observer pattern
 	 * this method notifies the observers
	 */
	public void scoreChanged() {
		setChanged();
		notifyObservers();
	}

	public boolean isCaughtPrize() {
		return caughtPrize;
	}

	public void setCaughtPrize(boolean caughtPrize) {
		this.caughtPrize = caughtPrize;
	}	
	
 	/**
 	 * Implements Observer pattern
 	 * this method notifies the observers
	 */
	public void positionChanged() {
		setChanged();
		notifyObservers();
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getMaxWidth() {
		return maxWidth;
	}

	public void setMaxWidth(int maxWidth) {
		this.maxWidth = maxWidth;
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}
	
}
