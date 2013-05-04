import static org.junit.Assert.*;

import org.junit.Test;


public class MoveChasePlayerAndPrizeTest {

	@Test
	public void test() {

		Obstacle ob1;
	    Obstacles obstacles;
	    BadGuy dog1;
	    PlayerCharacter player;
	    GamePrize prize;
	    PrizeProperties basicPrize, bonusPrize;
		
		obstacles = new Obstacles();
	    ob1 = new Obstacle();
	    obstacles.addObstacle(ob1);
		basicPrize = new BasicPrizeProperties();
	    bonusPrize = new BonusPrizeProperties();
	    prize = new GamePrize(basicPrize);
		player = new PlayerCharacter(prize, obstacles);
	    dog1 = new MeanDog(player, prize, obstacles);
	    
	    
	    
	    player.setX(10);
	    player.setY(10);
	    player.setHeight(50);
	    player.setWidth(50);
	    player.setMaxHeight(1000);
	    player.setMaxWidth(1000);
	    
	    dog1.setX(100);
	    dog1.setY(100);
	    dog1.setHeight(50);
	    dog1.setWidth(50);
	    
	    ob1.setX(200);
	    ob1.setY(200);
	    ob1.setHeight(50);
	    ob1.setWidth(50);
	    
	    prize.setPosition(500, 500);

	    MoveChasePlayerAndPrize move = new MoveChasePlayerAndPrize(dog1, player, prize, obstacles, 10);
	    move.move();
	    
	    assertEquals("Result", 90, dog1.getX());
	    assertEquals("Result", 90, dog1.getY());
	    
	    
	    ob1.setX(20);
	    ob1.setY(20);
	    
	    player.setX(0);
	    player.setY(0);
	    
	    prize.setPosition(500, 500);
	    
	    dog1.setX(10);
	    dog1.setY(10);
	    
	    move = new MoveChasePlayerAndPrize(dog1, player, prize, obstacles, 10);
	    move.move();
	    
	    assertEquals("Result", 20, dog1.getX());
	    assertEquals("Result", 20, dog1.getY());
	    
	    
	    ob1.setX(0);
	    ob1.setY(0);
	    
	    player.setX(0);
	    player.setY(0);
	    
	    prize.setPosition(500, 500);
	    
	    dog1.setX(400);
	    dog1.setY(400);
	    
	    move.move();
	    
	    assertEquals("Result", 410, dog1.getX());
	    assertEquals("Result", 410, dog1.getY());
	    assertFalse(dog1.caughtPrize);
	    
	    dog1.setX(450);
	    dog1.setY(450);
	    
	    move.move();
	    assertTrue(dog1.caughtPrize);
	    
	    

	}

}
