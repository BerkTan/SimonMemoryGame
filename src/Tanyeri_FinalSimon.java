
/*
 * Program Purpose: SIMON: Memory Game
 * 					Copy the order of the pattern given to you by the computer.
 * 					Get the pattern wrong, and you lose!
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

import java.util.ArrayList;

public class Tanyeri_FinalSimon extends JFrame {
	// Variables
	private JPanel panelNew;
	private JButton menu;
	private JButton rest;
	private JButton r;
	private JButton g;
	private JButton b;
	private JButton y;

	private int currentEl = 0;
	private ArrayList<Integer> List = new ArrayList<Integer>();

	File Note = new File("sounds/Note.wav");
	File gameover = new File("sounds/gameover.wav");
	File red = new File("sounds/red.wav");
	File green = new File("sounds/green.wav");
	File blue = new File("sounds/blue.wav");
	File yellow = new File("sounds/yellow.wav");

	// Class Constructor, creates the panel and buttons
	// to be added, with action listeners
	public Tanyeri_FinalSimon() {
		// Set window name
		super("SIMON");

		// Create panel
		setResizable(false);
		setSize(1200, 800);
		setLocationRelativeTo(null);

		panelNew = new JPanel();
		panelNew.setLayout(null);
		add(panelNew);

		// Create buttons
		menu = new JButton("MENU");
		rest = new JButton("RESTART");
		r = new JButton("");
		g = new JButton("");
		b = new JButton("");
		y = new JButton("");

		menu.setBounds(850, 600, 220, 100);
		menu.setBackground(Color.GRAY);
		menu.setBorderPainted(true);
		menu.setFont(new Font("Arial", Font.BOLD, 25));
		menu.setForeground(Color.WHITE);

		rest.setBounds(850, 490, 220, 100);
		rest.setBackground(Color.GRAY);
		rest.setBorderPainted(true);
		rest.setFont(new Font("Arial", Font.BOLD, 25));
		rest.setForeground(Color.WHITE);

		r.setBounds(59, 60, 320, 320);
		r.setBackground(Color.RED);
		r.setBorderPainted(false);
		r.setFont(new Font("Arial", Font.BOLD, 25));

		g.setBounds(395, 60, 320, 320);
		g.setBackground(Color.GREEN);
		g.setBorderPainted(false);
		g.setFont(new Font("Arial", Font.BOLD, 25));

		b.setBounds(59, 396, 320, 320);
		b.setBackground(Color.BLUE);
		b.setBorderPainted(false);
		b.setFont(new Font("Arial", Font.BOLD, 25));

		y.setBounds(395, 396, 320, 320);
		y.setBackground(Color.YELLOW);
		y.setBorderPainted(false);
		y.setFont(new Font("Arial", Font.BOLD, 25));

		// Listen and perform actions
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
		rest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				setVisible(false);
				Tanyeri_FinalSimon go2 = new Tanyeri_FinalSimon();
				go2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				go2.setVisible(true);
				go2.start();
			}
		});
		r.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				repaint();
				checkPressed(0);
			}

		});
		g.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				repaint();
				checkPressed(1);
			}
		});
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				repaint();
				checkPressed(2);
			}
		});
		y.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				repaint();
				checkPressed(3);
			}
		});

		// Add buttons to panel
		panelNew.add(menu);
		panelNew.add(rest);
		panelNew.add(r);
		panelNew.add(g);
		panelNew.add(b);
		panelNew.add(y);
	}

	// The paint method, automatically called to set the
	// background design with the visuals defined
	public void paint(Graphics g) {
		// Background
		g.setColor(Color.GRAY);
		g.fillRect(-100, -100, 1300, 900);

		// Design text
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", 1, 103));
		g.drawString("SIM    N", 787, 147);
		g.setColor(Color.BLACK);
		g.fillRect(970, 50, 119, 120);
		g.setColor(Color.RED);
		g.fillRect(975, 55, 52, 52);
		g.setColor(Color.GREEN);
		g.fillRect(1032, 55, 52, 52);
		g.setColor(Color.BLUE);
		g.fillRect(975, 112, 52, 52);
		g.setColor(Color.YELLOW);
		g.fillRect(1032, 112, 52, 52);
		g.setColor(Color.BLACK);
		g.fillOval(993, 73, 75, 75);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 25));

		// Fixes JButton not spawning
		g.drawString("RESTART", 906, 575);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 25));
		g.drawString("MENU", 926, 685);

		// Game simon
		g.setColor(Color.BLACK);
		g.fillRect(50, 70, 680, 680);
		g.setColor(Color.RED);
		g.fillRect(62, 82, 320, 320);
		g.setColor(Color.GREEN);
		g.fillRect(398, 82, 320, 320);
		g.setColor(Color.BLUE);
		g.fillRect(62, 418, 320, 320);
		g.setColor(Color.YELLOW);
		g.fillRect(398, 418, 320, 320);

		// Retroactive stats
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", 1, 30));
		g.drawString("Number of Elements: " + List.size(), 813, 250);
		g.drawString("Number Correct: " + currentEl, 833, 320);
	}

	// The first method to start the game, adds random
	// colors to the arraylist (the pattern)
	public void start() {
		// 0=r 1=g 2=b 3=y
		repaint();
		int rand = ((int) (Math.random() * 4));
		List.add(rand);
		currentEl = 0;
		showColors();
	}

	// The method which tells the user the pattern after
	// every new element added
	public void showColors() {
		for (int i = 0; i < List.size(); i++) {
			if (List.get(i) == 0) {
				playSound(red);
			} else if (List.get(i) == 1) {
				playSound(green);
			} else if (List.get(i) == 2) {
				playSound(blue);
			} else if (List.get(i) == 3) {
				playSound(yellow);
			}
		}
	}

	// The method which checks to see if the correct color
	// was chosen by the user. If not, the game is over
	public void checkPressed(int color) {
		if (color == List.get(currentEl)) {
			currentEl++;
			if (currentEl == List.size()) {
				start();
			}
		} else {
			// JOption Pane to display gameover
			playSound(gameover);
			String text = "          INCORRECT ELEMENT\n" + (List.size() - 1) + " ELEMENT PATTERN COMPLETED"
					+ "\n       CLICK TO RESTART GAME";
			JOptionPane.showMessageDialog(null, text);
			setVisible(false);
			Tanyeri_FinalSimon go2 = new Tanyeri_FinalSimon();
			go2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			go2.setVisible(true);
			go2.start();
		}
	}

	// The method to play audio files
	public void playSound(File Sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
			if (List.size() > 1)
				Thread.sleep(clip.getMicrosecondLength() / 1000);
		} catch (Exception e) {

		}
	}
}