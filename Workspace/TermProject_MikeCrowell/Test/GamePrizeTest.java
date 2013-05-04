import static org.junit.Assert.*;

import org.junit.Test;


public class GamePrizeTest {

	@Test
	public void test() {
		
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
	    
	    player.setScore(0);
	    
	    player.setX(10);
	    player.setY(10);
	    player.setHeight(50);
	    player.setWidth(50);
	    
	    prize.setPosition(20, 20);
	    
	    player.setRight(true);
	    player.move();

	    assertEquals("Result", 10, player.getScore());
	    
	    prize.setProperties(bonusPrize);
	    prize.setPosition(20, 20);

	    player.move();
	    assertEquals("Result", 60, player.getScore());
	    
	    

	}

}
