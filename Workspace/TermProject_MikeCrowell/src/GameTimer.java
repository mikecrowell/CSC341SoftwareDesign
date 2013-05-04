
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;


/**
 * The Class GameTimer.
 * GameTimer controls the game clock.  
 * It is a subject in the Observer pattern.
 * 
 * @author Mike Crowell
 */
public class GameTimer extends Observable{

	private Timer timer;
	private int secCounter;
	private int delay = 1000;   // delay for 1 sec.
	private int period = 1000;  // repeat every sec.
	

	public GameTimer(){
		timer = new Timer();
		secCounter = 0;
	}

 	/**
 	 * Implements Observer pattern
 	 * this method notifies the observers
	 */
	public void secondsChanged() {
		setChanged();
		notifyObservers();
	}

	public int getSecCounter() {
		return secCounter;
	}

	public void setSecCounter(int secCounter) {
		this.secCounter = secCounter;
	}
	
	public void stopTimer(){
		timer.cancel();
	}
	
	public void startTimer(){
		timer.scheduleAtFixedRate(new TimerTask() {
	        public void run() {
				secCounter++;
				secondsChanged();
	        }
	    }, delay, period);	
	}
	
}
