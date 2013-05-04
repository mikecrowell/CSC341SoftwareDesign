
/**
 * The Class BonusPrizeProperties.
 * Implements the PrizeProperties interface.  
 * Is a decorator to GamePrize objects.
 * 
 * @author Mike Crowell
 */
public class BonusPrizeProperties implements PrizeProperties{

	@Override
	public String getImgLoc() {
		return "src/watermelon.gif";
	}

	@Override
	public int getScore() {
		return 50;
	}

	@Override
	public int getHeight() {
		return 25;
	}

	@Override
	public int getWidth() {
		return 60;
	}
}
