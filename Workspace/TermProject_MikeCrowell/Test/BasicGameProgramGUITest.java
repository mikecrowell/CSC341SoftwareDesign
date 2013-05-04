import static org.junit.Assert.*;

import org.junit.Test;


public class BasicGameProgramGUITest {

	@Test
	public void test() {
		BasicGameProgramGUI gui = new BasicGameProgramGUI();
		
		Obstacle ob1, ob2, ob3;
	    Obstacles obstacles;
	    BadGuy dog1;
	    PlayerCharacter player;
	    GamePrize prize;
	    PrizeProperties basicPrize, bonusPrize;
	    GameTimer timer = new GameTimer();
		
		obstacles = new Obstacles();
	    ob1 = new Obstacle();
	    ob2 = new Obstacle();
	    ob3 = new Obstacle();
	    obstacles.addObstacle(ob1);
	    obstacles.addObstacle(ob2);
	    obstacles.addObstacle(ob3);
		basicPrize = new BasicPrizeProperties();
	    bonusPrize = new BonusPrizeProperties();
	    prize = new GamePrize(basicPrize);
		player = new PlayerCharacter(prize, obstacles);
	    dog1 = new MeanDog(player, prize, obstacles);
	    
	    player.setScore(50);
	    gui.update(player, player);
	    assertEquals("Result", "50", gui.getScore());
	    
	   timer.setSecCounter(100);
	   gui.update(timer, timer);
	   assertEquals("Result", "0", gui.getTime()); 
	    
	   gui.update(dog1, dog1);
	   assertEquals("Result", "50", gui.getScore());  
	    
	}

}
