
/*
 * Program Purpose: SIMON: Memory Game
 * 					The main menu, the first landing page where
 * 					the user chooses what to do
 * Name: Berk Tanyeri
 * Date: 6/1/17
 * Revision Number: 1.0
 */
//Imported classes
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Tanyeri_FinalMenu extends JFrame {
	// Variables
	private JPanel panelNew;
	private JButton start;
	private JButton inst;

	File Note = new File("sounds/Note.wav");
	File ready = new File("sounds/ready.wav");

	// Class Constructor, creates the panel and buttons
	// to be added, with action listeners
	public Tanyeri_FinalMenu() {
		// Set window name
		super("MENU");

		// Create panel
		setResizable(false);
		setSize(1000, 500);
		setLocationRelativeTo(null);

		panelNew = new JPanel();
		panelNew.setLayout(null);

		// Create buttons
		inst = new JButton("INSTRUCTIONS");
		start = new JButton("START");

		inst.setBounds(510, 250, 260, 100);
		inst.setBackground(Color.GRAY);
		inst.setBorderPainted(true);
		inst.setFont(new Font("Arial", Font.BOLD, 25));
		inst.setVisible(true);
		inst.setForeground(Color.WHITE);

		start.setBounds(220, 250, 250, 100);
		start.setBackground(Color.GRAY);
		start.setBorderPainted(true);
		start.setFont(new Font("Arial", Font.BOLD, 25));
		start.setVisible(true);
		start.setForeground(Color.WHITE);

		// Add buttons to panel
		add(panelNew);
		panelNew.add(start);
		panelNew.add(inst);
	}

	// The paint method, automatically called to set the
	// background design with the visuals defined
	public void paint(Graphics g) {
		// Background
		g.setColor(Color.GRAY);
		g.fillRect(-100, -100, 1100, 700);

		// Design text
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", 1, 103));
		g.drawString("SIM    N", 317, 147);
		g.setColor(Color.BLACK);
		g.fillRect(500, 50, 119, 120);
		g.setColor(Color.RED);
		g.fillRect(505, 55, 52, 52);
		g.setColor(Color.GREEN);
		g.fillRect(562, 55, 52, 52);
		g.setColor(Color.BLUE);
		g.fillRect(505, 112, 52, 52);
		g.setColor(Color.YELLOW);
		g.fillRect(562, 112, 52, 52);
		g.setColor(Color.BLACK);
		g.fillOval(523, 73, 75, 75);
		g.setColor(Color.WHITE);

		// Fixes JButton not spawning
		g.setFont(new Font("Arial", Font.BOLD, 25));
		g.drawString("INSTRUCTIONS", 550, 335);

		// Stripes
		g.setColor(Color.RED);
		g.fillRect(-0, -0, 50, 600);
		g.setColor(Color.GREEN);
		g.fillRect(50, -0, 50, 600);
		g.setColor(Color.BLUE);
		g.fillRect(100, -0, 50, 600);
		g.setColor(Color.YELLOW);
		g.fillRect(150, -0, 50, 600);
		g.setColor(Color.RED);
		g.fillRect(950, -0, 50, 600);
		g.setColor(Color.GREEN);
		g.fillRect(900, -0, 50, 600);
		g.setColor(Color.BLUE);
		g.fillRect(850, -0, 50, 600);
		g.setColor(Color.YELLOW);
		g.fillRect(800, -0, 50, 600);

		// Signature
		g.setColor(Color.WHITE);
		g.setFont(new Font("Blackadder ITC", Font.BOLD, 30));
		g.drawString("By Berk Tanyeri", 400, 470);
	}

	// Listen for button clicks
	public void action() {
		// Execute sound file on launch
		playSound(Note);
		// perform actions
		start.addActionListener(new ActionListener() {
			// Listen for button press
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				setVisible(false);
				Tanyeri_FinalSimon go1 = new Tanyeri_FinalSimon();
				go1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				playSound(ready);
				try {
					Thread.sleep(7000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				go1.setVisible(true);
				go1.start();
			}
		});
		inst.addActionListener(new ActionListener() {
			// Listen for button press
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				setVisible(false);
				Tanyeri_FinalInstruction go1 = new Tanyeri_FinalInstruction();
				go1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				go1.setVisible(true);
				go1.action();
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
