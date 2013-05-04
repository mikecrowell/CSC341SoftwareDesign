
/**
 * The Class Obstacle.
 * Implements the GameCharacter interface.  
 * An Obstacle is a game character that does not move 
 * and provides an obstruction to other game characters.
 * 
 * @author Mike Crowell
 */
public class Obstacle implements GameCharacter{

	private int x, y, width, height;
	private String imgLoc;
	

	public Obstacle(){
		imgLoc = "src/tree.gif";
		width = 200;
		height = 200;
	}

	@Override
	public int getX() {
		return y;
	}

	@Override
	public int getY() {
		return x;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void move() {
		//Obstacles don't move		
	}

	public String getImgLoc() {
		return imgLoc;
	}

	public void setImgLoc(String imgLoc) {
		this.imgLoc = imgLoc;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
