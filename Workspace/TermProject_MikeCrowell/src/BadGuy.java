import java.util.Observable;
import java.util.Observer;


/**
 * The Class BadGuy.
 * Abstract class, implements GameCharacter interface, 
 * provides the outline and implementation for the computer controlled characters.  
 * BadGuy is a subject in the Observer pattern.
 * 
 * @author Mike Crowell
 */
public abstract class BadGuy extends Observable implements GameCharacter{

	private int x, y, width, height;
	private String imgLoc;
	int speed, score;
	boolean caughtPrize, caughtPlayer;
	MoveBehavior moveBehavior;
	PlayerCharacter player;
	GamePrize prize;
	Obstacles obstacles;
	

	public BadGuy(PlayerCharacter player, GamePrize prize, Obstacles obstacles){
		this.player = player;
		this.prize = prize;
		this.obstacles = obstacles;
	}
	

	public void setMoveBehavior(MoveBehavior mb){
		this.moveBehavior = mb;
	}
	
	public void move(){
		moveBehavior.move();
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isCaughtPrize() {
		return caughtPrize;
	}

	public void setCaughtPrize(boolean caughtPrize) {
		this.caughtPrize = caughtPrize;
	}

	public boolean isCaughtPlayer() {
		return caughtPlayer;
	}

	public void setCaughtPlayer(boolean caughtPlayer) {
		this.caughtPlayer = caughtPlayer;
	}

	/**
	 * Implements Observer pattern
	 * this method notifies the observers
	 */
	public void statusChanged() {
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
