import static org.junit.Assert.*;

import org.junit.Test;


public class BoardCollisionTest {

	@Test
	public void test() {
		BoardCollision collision = new BoardCollision();
		
		Obstacle ob1, ob2, ob3;
	    Obstacles obstacles;
	    BadGuy dog1;
	    PlayerCharacter player;
	    GamePrize prize;
	    PrizeProperties basicPrize, bonusPrize;

		
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
	    
	    player.setX(10);
	    player.setY(10);
	    player.setHeight(50);
	    player.setWidth(50);
	    
	    dog1.setX(10);
	    dog1.setY(10);
	    dog1.setHeight(50);
	    dog1.setWidth(50);
	    
	    assertTrue(collision.execute(player, dog1));
	    
	    
	    player.setX(10);
	    player.setY(10);
	    player.setHeight(50);
	    player.setWidth(50);
	    
	    dog1.setX(40);
	    dog1.setY(40);
	    dog1.setHeight(50);
	    dog1.setWidth(50);
	    
	    assertTrue(collision.execute(player, dog1));	    
	    
	    
	    player.setX(10);
	    player.setY(10);
	    player.setHeight(10);
	    player.setWidth(10);
	    
	    dog1.setX(100);
	    dog1.setY(100);
	    dog1.setHeight(50);
	    dog1.setWidth(50);
	    
	    assertFalse(collision.execute(player, dog1));
	    
	    
	}

}
