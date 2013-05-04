import java.util.ArrayList;


/**
 * The Class Obstacles.
 * Obstacles is a collection of Obstacle objects.
 * 
 * @author Mike Crowell
 */
public class Obstacles {

	private ArrayList<Obstacle> obstacles;
	private BoardCollision collision;
	

	public Obstacles(){
		obstacles = new ArrayList<Obstacle>();
		collision = new BoardCollision();
	}
	
	public void addObstacle(Obstacle o){
		obstacles.add(o);
	}

	public void removeObstacle(Obstacle o){
		obstacles.remove(o);
	}

	public ArrayList getObstacles(){
		return obstacles;
	}

	public boolean checkForCrash(GameCharacter c){
		boolean isCrash = false;
		
		for(Obstacle o: obstacles){
			isCrash = collision.execute(o, c);
			if (isCrash) break;
		}
		
		return isCrash;
	}
	
}
