
/*
 * Program Purpose: SIMON: Memory Game
 * 					The instruction window, which will give the
 * 					user instructions on how to play
 * Name: Berk Tanyeri
 * Date: 6/1/17
 * Revision Number: 1.0
 */
//Imported classes
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class Tanyeri_FinalInstruction extends JFrame {
	// Variables
	private JPanel panelNew;
	private JButton menu;

	File Note = new File("sounds/Note.wav");

	// Class Constructor, creates the panel and buttons
	// to be added, with action listeners
	public Tanyeri_FinalInstruction() {
		// Set window name
		super("INSTRUCTIONS");

		// Create panel
		setResizable(false);
		setSize(1000, 500);
		setLocationRelativeTo(null);

		panelNew = new JPanel();
		panelNew.setLayout(null);

		// Create button
		menu = new JButton("MENU");

		menu.setBounds(380, 350, 220, 100);
		menu.setBackground(Color.GRAY);
		menu.setBorderPainted(true);
		menu.setFont(new Font("Arial", Font.BOLD, 25));
		menu.setForeground(Color.WHITE);

		// Add buttons to panel
		add(panelNew);
		panelNew.add(menu);
	}

	// The paint method, automatically called to set the
	// background design with the visuals defined
	public void paint(Graphics g) {
		// Background
		g.setColor(Color.GRAY);
		g.fillRect(-100, -100, 1100, 600);

		// Text
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", 1, 50));
		g.drawString("Instructions", 350, 100);
		g.setFont(new Font("Arial", 1, 25));
		g.drawString("� The computer will show you a color pattern", 225, 150);
		g.drawString("� Copy the given pattern", 225, 185);
		g.drawString("� After each sequence, another element will be", 225, 220);
		g.drawString("added to the pattern", 240, 255);
		g.drawString("� Play until you lose", 225, 290);
		g.drawString("� This is a SPORT for the MIND", 225, 325);

		// Stripes
		g.setColor(Color.RED);
		g.fillRect(-0, -0, 50, 600);
		g.setColor(Color.YELLOW);
		g.fillRect(50, -0, 50, 600);
		g.setColor(Color.BLUE);
		g.fillRect(100, -0, 50, 600);
		g.setColor(Color.GREEN);
		g.fillRect(150, -0, 50, 600);
		g.setColor(Color.RED);
		g.fillRect(950, -0, 50, 600);
		g.setColor(Color.YELLOW);
		g.fillRect(900, -0, 50, 600);
		g.setColor(Color.BLUE);
		g.fillRect(850, -0, 50, 600);
		g.setColor(Color.GREEN);
		g.fillRect(800, -0, 50, 600);
	}

	// Listen and perform actions
	public void action() {
		// Execute sound file on launch
		playSound(Note);
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				setVisible(false);
				Tanyeri_FinalMenu go2 = new Tanyeri_FinalMenu();
				go2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				go2.setVisible(true);
				go2.action();
			}
		});
	}

	// The method to play audio files
	public static void playSound(File Sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
		} catch (Exception e) {

		}
	}
}