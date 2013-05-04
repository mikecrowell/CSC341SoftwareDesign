import java.util.Observable;


/**
 * The Class GamePrize.
 * Implements both the Prize and GameCharacter interfaces.  
 * GamePrize is the object to be caught in game play.  
 * GamePrize is a subject in the Observer pattern.
 * GamePrize is a lso a component in the Decorator pattern 
 * and provides an example of delegation.
 * 
 * @author Mike Crowell
 */
public class GamePrize extends Observable implements Prize, GameCharacter {

	private int x, y;
	private PrizeProperties properties;
	

	public GamePrize(PrizeProperties properties){
		this.properties = properties;
	}
	
	@Override
	public int score() {
		// delegate responsibility to the decorator class
		return properties.getScore();
	}

	@Override
	public void setPosition(int x, int y) {
		setX(x);
		setY(y);
		positionChanged();
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
		// delegate responsibility to the decorator class
		return properties.getImgLoc();
	}
	
 	/**
 	 * Implements Observer pattern
 	 * this method notifies the observers
	 */
	public void positionChanged() {
		setChanged();
		notifyObservers();
	}

	/* 
	 * Game Prizes don't move
	 */
	@Override
	public void move() { }

	@Override
	public int getWidth() {
		// delegate responsibility to the decorator class
		return properties.getWidth();
	}

	@Override
	public int getHeight() {
		// delegate responsibility to the decorator class
		return properties.getHeight();
	}

	public PrizeProperties getProperties() {
		return properties;
	}

	public void setProperties(PrizeProperties properties) {
		this.properties = properties;
	}
	
}
