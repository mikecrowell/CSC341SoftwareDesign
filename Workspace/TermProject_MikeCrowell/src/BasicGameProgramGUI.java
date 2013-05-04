import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

/**
 * The Class BasicGameProgramGUI.
 * Called by BasicGameProgram.  
 * Starts the game timer thread and the game play thread.
 * 
 * @author Mike Crowell
 */
public class BasicGameProgramGUI implements Observer, Runnable{

	private PlayerCharacter player;
	private JFrame gameFrame = new JFrame();
	BasicGamePanel gameField;
	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel();
	private JPanel upperPanel = new JPanel();	
	private JLabel score = new JLabel();
	private static JLabel time = new JLabel();
	private Font biggerFont = new Font("sansserif", Font.BOLD, 24);
	private GameTimer gameTimer;
	int gameCounter;
	private static final int MAX_TIME = 30;
	

	public BasicGameProgramGUI(){
		gameCounter = MAX_TIME;		
		gameFrame.getContentPane().setLayout(new BorderLayout());       
		gameFrame.getContentPane().add(upperPanel,BorderLayout.NORTH);
        upperPanel.setLayout(new BorderLayout());
        upperPanel.add(leftPanel,BorderLayout.EAST);
        leftPanel.setBackground(Color.black);
        leftPanel.setFont(biggerFont);
        leftPanel.add(score);
		score.setOpaque(true);
		score.setBackground(Color.black);
		score.setForeground(Color.red);
		score.setFont(biggerFont);
		score.setText("0");        
        upperPanel.add(rightPanel,BorderLayout.CENTER);
        rightPanel.setBackground(Color.black);
        rightPanel.setFont(biggerFont);
        rightPanel.add(time);
		time.setOpaque(true);
		time.setBackground(Color.black);
		time.setForeground(Color.red);
		time.setFont(biggerFont); 
		time.setText(String.valueOf(gameCounter));
		run();					
	}

  	public void run() {			
		gameTimer = new GameTimer();
		gameTimer.addObserver(this);		
		gameField = new BasicGamePanel(gameTimer);		
		player = gameField.getPlayer();
		player.addObserver(this);		
		gameFrame.getContentPane().add(gameField, BorderLayout.CENTER);		
		gameFrame.setTitle("The Game With No Name");
		gameFrame.pack();	    
	    gameField.requestFocus(); 
	  }	
	
	public JFrame getGameFrame() {
		return gameFrame;
	}

	public void setGameFrame(JFrame gameFrame) {
		this.gameFrame = gameFrame;
	}
	
	public void gameOver(){
		gameTimer.stopTimer();
		gameField.gameOver();
	}

 	/* 
 	 * Implements Observer pattern
 	 * Receives updates from subjects
 	*/
	@Override
	public void update(Observable observable, Object arg) {
		if (observable instanceof PlayerCharacter) {
			PlayerCharacter p = (PlayerCharacter)observable;
			score.setText(String.valueOf(p.getScore()));
		}else if (observable instanceof GameTimer) {
			GameTimer t = (GameTimer)observable;
			gameCounter = MAX_TIME - t.getSecCounter();
			time.setText(String.valueOf(gameCounter));
			if(gameCounter <= 0){
				time.setText("0");
				gameOver();
			}
		}
	}

	public String getScore(){
		return score.getText();
	}
	
	public String getTime(){
		return time.getText();
	}
	
}
