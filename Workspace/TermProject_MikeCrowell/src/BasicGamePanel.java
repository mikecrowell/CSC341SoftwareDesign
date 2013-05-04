import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.*;

/**
 * The Class BasicGamePanel.
 * JPanel that builds the game field and is the controller for the main game action.   
 * An observer of both PlayerCharacter and BadGuy
 * 
 * @author Mike Crowell
 */
public class BasicGamePanel extends JPanel implements ActionListener, KeyListener, Observer{


	private static final long serialVersionUID = 1L;
    public static final int RECTANGLE = 2;
    private Font biggerFont = new Font("sansserif", Font.PLAIN, 24);
    private Image playerImg, dog1Img, dog2Img, dog3Img, elephantImg, prizeImg, ob1Img, ob2Img, ob3Img;
    private Obstacle ob1, ob2, ob3;
    private Obstacles obstacles;
    private Timer timer;
    private ArrayList<GameCharacter> characters;
    private BadGuy dog1, dog2, dog3, elephant;
    private PlayerCharacter player;
    private GamePrize prize;
    private PrizeProperties basicPrize, bonusPrize;
    private boolean isGameOn, didGameStart;
    private GameTimer gameTimer;
    private BoardCollision collision;


    public BasicGamePanel(GameTimer gameTimer) {
        //set the JPanel properties
    	this.setBackground(Color.GREEN);
        this.setFont(biggerFont);
        this.setPreferredSize(new Dimension(900, 700));
        this.addKeyListener(this);
        this.setFocusable(true);       
        
        //instantiate the game field objects
        collision = new BoardCollision();
		isGameOn = false;
		didGameStart = false;      
		timer = new Timer(10, this);		        
        this.gameTimer = gameTimer;
        obstacles = new Obstacles();
        basicPrize = new BasicPrizeProperties();
        bonusPrize = new BonusPrizeProperties();      
        prize = new GamePrize(basicPrize);       
        ob1 = new Obstacle();
        ob2 = new Obstacle();
        ob3 = new Obstacle();      
        obstacles.addObstacle(ob1);
        obstacles.addObstacle(ob2);
        obstacles.addObstacle(ob3);       
        
        //select one of four random game field layouts
		Random rand = new Random();
		int randLayout = rand.nextInt(4);
		if(randLayout == 0){
	        ob1.setX(100);
	        ob1.setY(100);
	        ob2.setX(100);
	        ob2.setY(600);	        
	        ob3.setX(500);
	        ob3.setY(300);
	        prize.setX(500);
	        prize.setY(300);
		}else if(randLayout == 1){
	        ob1.setX(10);
	        ob1.setY(400);
	        ob2.setX(300);
	        ob2.setY(400);	        
	        ob3.setX(400);
	        ob3.setY(300);
	        prize.setX(600);
	        prize.setY(300);
		}else if(randLayout == 2){
	        ob1.setX(10);
	        ob1.setY(100);
	        ob2.setX(10);
	        ob2.setY(300);	        
	        ob3.setX(300);
	        ob3.setY(600);	
	        prize.setX(600);
	        prize.setY(100);
		}else{
	        ob1.setX(450);
	        ob1.setY(100);
	        ob2.setX(30);
	        ob2.setY(400);	        
	        ob3.setX(500);
	        ob3.setY(500);
	        prize.setX(450);
	        prize.setY(300);
		}
        
		//define and position game field characters
        player = new PlayerCharacter(prize, obstacles);       
        player.setX(800);
        player.setY(600);
		player.setMaxHeight(this.getHeight());
		player.setMaxWidth(this.getWidth());       
        dog1 = new MeanDog(player, prize, obstacles);
        dog2 = new HungryDog(player, prize, obstacles);
        dog3 = new HoundDog(player, prize, obstacles);
        elephant = new Elephant(player, prize, obstacles);
        player.addObserver(this);
        dog1.addObserver(this);
        dog2.addObserver(this);
        dog3.addObserver(this);
        elephant.addObserver(this);
        characters = new ArrayList<GameCharacter>();
        characters.add(dog1);
        characters.add(dog2);
        characters.add(dog3);
        characters.add(elephant);
        characters.add(player);      
        dog1.setX(0);
        dog1.setY(0);      
        dog2.setX(0);
        dog2.setY(300);      
        dog3.setX(0);
        dog3.setY(600);     
        elephant.setX(2000);
        elephant.setY(2000);     
        playerImg = new ImageIcon(player.getImgLoc()).getImage();
        dog1Img = new ImageIcon(dog1.getImgLoc()).getImage();
        dog2Img = new ImageIcon(dog2.getImgLoc()).getImage();
        dog3Img = new ImageIcon(dog3.getImgLoc()).getImage();
        elephantImg = new ImageIcon(elephant.getImgLoc()).getImage();
        prizeImg = new ImageIcon(prize.getImgLoc()).getImage();    
        ob1Img = new ImageIcon(ob1.getImgLoc()).getImage(); 
        ob2Img = new ImageIcon(ob2.getImgLoc()).getImage(); 
        ob3Img = new ImageIcon(ob3.getImgLoc()).getImage();      
    }

    //draw the game field and its characters
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
		g.drawImage(playerImg, player.getX(), player.getY(), player.getWidth(),player.getHeight(),this);	
		g.drawImage(dog1Img, dog1.getX(), dog1.getY(), dog1.getWidth(),dog1.getHeight(),this);
		g.drawImage(dog2Img, dog2.getX(), dog2.getY(), dog2.getWidth(),dog2.getHeight(),this);
		g.drawImage(dog3Img, dog3.getX(), dog3.getY(), dog3.getWidth(),dog3.getHeight(),this);
		g.drawImage(elephantImg, elephant.getX(), elephant.getY(), elephant.getWidth(),elephant.getHeight(),this);
		g.drawImage(prizeImg, prize.getX(), prize.getY(), prize.getWidth(),prize.getHeight(),this);
		g.drawImage(ob1Img, ob1.getX(), ob1.getY(), ob1.getWidth(),ob1.getHeight(),this);
		g.drawImage(ob2Img, ob2.getX(), ob2.getY(), ob1.getWidth(),ob1.getHeight(),this);
		g.drawImage(ob3Img, ob3.getX(), ob3.getY(), ob1.getWidth(),ob1.getHeight(),this);	 	 
    }

    public void keyTyped(KeyEvent e) {    	

    }

    //set player character property based on key stroke
    public void keyPressed(KeyEvent e) {   		
    	if(!didGameStart){
    		didGameStart = true;
    		isGameOn = true;
    		startGame();
    	}   	
        if(e.getKeyCode() == KeyEvent.VK_LEFT ){
        	player.setLeft(true);
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT ){
        	player.setRight(true);
        }else if(e.getKeyCode() == KeyEvent.VK_UP ){
        	player.setUp(true);
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN ){
        	player.setDown(true);
        }else if(e.getKeyCode() == KeyEvent.VK_SPACE ){
        	player.setTurbo(true);
        }  
    }

  //set player character property based on key stroke
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT ){
        	player.setLeft(false);   
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT ){
        	player.setRight(false);
        }else if(e.getKeyCode() == KeyEvent.VK_UP ){
        	player.setUp(false);
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN ){
        	player.setDown(false);
        }else if(e.getKeyCode() == KeyEvent.VK_SPACE ){
        	player.setTurbo(false); 
        }    	
    }

	public void actionPerformed(ActionEvent e) {
		if(isGameOn){
			player.setMaxHeight(this.getHeight());
			player.setMaxWidth(this.getWidth());
			for(GameCharacter c: characters){
				c.move();  //move all game characters
			}
            repaint(); 	
        }
	}

	public PlayerCharacter getPlayer() {
		return player;
	}

	public void setPlayer(PlayerCharacter player) {
		this.player = player;
	}


	/* 
	 * Implements Observer pattern
	 * Receives updates from subjects
	 */
	@Override
	public void update(Observable observable, Object arg) {
		if (observable instanceof PlayerCharacter) {
			PlayerCharacter p = (PlayerCharacter)observable;
			if(p.isCaughtPrize()){
				resetPrize();
			}
		}else if (observable instanceof BadGuy) {
			BadGuy b = (BadGuy)observable;
			if(b.isCaughtPrize()){
				player.setScore(player.getScore() - (prize.score()/10));
				resetPrize();
			}else if(b.isCaughtPlayer()){
				player.setScore(player.getScore() - b.getScore());
				movePlayer();
			}
		}
	}
	
	public void gameOver(){
		timer.stop();
		isGameOn = false;
	}
	
	public void startGame(){
		timer.start();
		gameTimer.startTimer();
	}
	
	public void resetPrize(){
		boolean safeSpot = false;
		int randX = 0;
		int randY = 0;
		while(!safeSpot){
			Random rand = new Random();
			int randPrize = rand.nextInt(4);;
			if(randPrize == 0){
		        prize.setProperties(bonusPrize);
			}else{
				prize.setProperties(basicPrize);
			}
			prizeImg = new ImageIcon(prize.getImgLoc()).getImage();
			randX = rand.nextInt(700)+100;
			randY = rand.nextInt(400)+100;
	        for(GameCharacter c: characters){
                prize.setX(randX);
                prize.setY(randY);
        		safeSpot = !(collision.execute(prize, c));
	        }
	        if(safeSpot){
	        	safeSpot = !(obstacles.checkForCrash(prize));
	        }
		}
		prizeImg = new ImageIcon(prize.getImgLoc()).getImage();
		prize.setPosition(randX, randY);
	}
	
	public void movePlayer(){
		boolean safeSpot = false;
		int randX = 0;
		int randY = 0;
		while(!safeSpot){
			Random rand = new Random();
			randX = rand.nextInt(700)+100;
			randY = rand.nextInt(400)+100;
	        for(GameCharacter c: characters){
	        	if(c instanceof BadGuy){
	                player.setX(randX);
	                player.setY(randY);
	        		safeSpot = !(collision.execute(player, c));
	        	}
	        }
	        if(safeSpot){
	        	safeSpot = !(obstacles.checkForCrash(player));
	        }
		}
        player.positionChanged();
	}
	
}
