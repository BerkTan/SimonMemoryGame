
/*
 * Program Purpose: SIMON: Memory Game
 * 					Driver program, starts of a chain reaction
 * 					of calls to other classes
 * Name: Berk Tanyeri
 * Date: 6/1/1
 * Revision Number: 1.0
 */
//Imported classes
import javax.swing.JFrame;

public class Tanyeri_FinalDriver {
	// The Main Method, create the Main Menu and call the action method
	public static void main(String[] args) {
		Tanyeri_FinalMenu m1 = new Tanyeri_FinalMenu();
		m1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m1.setVisible(true);
		m1.action();
	}
}