package de.dhbwka.java.exam.stadtlandfluss;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Sheet extends JFrame {
	private static final long serialVersionUID = 1L;

	private Player player;
	private Game game;
	private JLabel points;
	private JLabel seconds;
	private JLabel character;
	private JPanel gamePnl;
	private JButton startBtn;
	private JButton stopBtn;
	private List<JTextField> inputFields; 
	private List<JLabel> pointLables; 
	private JLabel noGame;

	public Sheet(Player player, Game game) {
		this.player = player;
		this.game = game;

		InitilizeComponents();
	}

	private void InitilizeComponents() {
		this.setTitle(player.toString());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel upperArea = new JPanel(new GridLayout(3, 2));
		points = new JLabel("0");
		seconds = new JLabel();
		character = new JLabel();

		upperArea.add(new JLabel("Punkte"));
		upperArea.add(points);
		upperArea.add(new JLabel("Verbleibende Sekunden"));
		upperArea.add(seconds);
		upperArea.add(new JLabel("Anfangsbuchstabe"));
		upperArea.add(character);

		gamePnl = new JPanel(new GridLayout(1, 1));
		noGame = new JLabel("Kein Spiel aktiv.");
		noGame.setHorizontalAlignment(SwingConstants.CENTER);
		noGame.setVerticalAlignment(SwingConstants.NORTH);
		gamePnl.add(noGame);
		JPanel footerArea = new JPanel(new GridLayout(1, 2));
		startBtn = new JButton("Start");
		startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.startGame();
			}
		});

		stopBtn = new JButton("Stop");
		stopBtn.setEnabled(false);
		stopBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.stopGame();
			}
		});

		footerArea.add(startBtn);
		footerArea.add(stopBtn);

		add(upperArea, BorderLayout.NORTH);
		add(gamePnl, BorderLayout.CENTER);
		add(footerArea, BorderLayout.SOUTH);
		setSize(400, 300);
		setVisible(true);
	}

	public void stop(){
		startBtn.setEnabled(true);
		stopBtn.setEnabled(false);
		
		/**
		 * Erweitern Sie die Klasse Sheet so, dass bei der Benachrichtigung durch stopGame() 
		 * die erreichten Punkte, s. Teilaufgabe d), neben jeder Spiel-Spalte angezeigt werden! 
		 * 
		 * Zusätzlich soll auch die Gesamtpunktzahl des Spielers („Punkte“) entsprechend aktualisiert
		 * und angezeigt werden. (Sobald ein neues Spiel gestartet wird sollen die Punktezahlen neben
		 * den Textfeldern jeweils wieder auf 0 stehen.)
		 * 
		 */
	}

	public void start(){
		startBtn.setEnabled(false);
		stopBtn.setEnabled(true);

		inputFields = new ArrayList<JTextField>();
		pointLables = new ArrayList<JLabel>();
		gamePnl.setLayout(new GridLayout(game.getColumns().size(),3));

		game.getColumns().forEach(c -> {
			
			JTextField input = new JTextField();
			inputFields.add(input);
			
			JLabel point = new JLabel("0");
			point.setHorizontalAlignment(SwingConstants.CENTER);
			pointLables.add(point);

			if(inputFields.size() == 1)
		{
			noGame.setText(c.getTitle());		
			noGame.setVerticalAlignment(SwingConstants.CENTER);
		}
			else
			{
				JLabel name = new JLabel(c.getTitle());
				name.setHorizontalAlignment(SwingConstants.CENTER);
				gamePnl.add(name);
			}

				gamePnl.add(input);
			gamePnl.add(point);

		});

		/**
		 * Pass by Value -> Wie Layout änndern / alte komponente entfernen
		 * 
		 */
		seconds.setText(game.getRemainingSeconds()+"");
		character.setText(game.getFirstLetter()+"");
		repaint();
	}

}
