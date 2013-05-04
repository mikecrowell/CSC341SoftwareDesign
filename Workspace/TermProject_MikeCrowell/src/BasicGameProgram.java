import javax.swing.*;


/**
 * The Class BasicGameProgram.
 * Launches the application
 * 
 * @author Mike Crowell
 */
public class BasicGameProgram extends JFrame {
	public static void main(String[] args) {	
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	    		BasicGameProgramGUI window = new BasicGameProgramGUI();
	    		window.getGameFrame().setDefaultCloseOperation(EXIT_ON_CLOSE);
	    		window.getGameFrame().setVisible(true);
	        }
	      });
	}
}
