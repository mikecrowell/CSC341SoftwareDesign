import static org.junit.Assert.*;

import org.junit.Test;


public class PlayerCharacterTest {

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
	    player.setDown(true);
	    player.setTurbo(true);
	    
	    dog1.setX(100);
	    dog1.setY(100);
	    dog1.setHeight(50);
	    dog1.setWidth(50);
	    
	    ob1.setX(200);
	    ob1.setY(200);
	    ob1.setHeight(50);
	    ob1.setWidth(50);
	    
	    prize.setPosition(500, 500);

	    player.move();
	    
	    assertEquals("Result", 17, player.getY());
	    
	    

	}

}
