
/**
 * The Class BasicPrizeProperties.
 * Implements the PrizeProperties interface.  
 * Is a decorator to GamePrize objects.
 * 
 * @author Mike Crowell
 */
public class BasicPrizeProperties implements PrizeProperties{

	@Override
	public String getImgLoc() {
		return "src/carrot.gif";
	}

	@Override
	public int getScore() {
		return 10;
	}

	@Override
	public int getHeight() {
		return 55;
	}

	@Override
	public int getWidth() {
		return 30;
	}
}
