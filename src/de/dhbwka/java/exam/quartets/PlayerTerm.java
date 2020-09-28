package de.dhbwka.java.exam.quartets;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;

public class PlayerTerm extends JFrame implements QuartetsClient {

	/**
     *
     */
    private static final long serialVersionUID = 1L;
    private Player player;
    private Game game;
    private JLabel country;
    private JLabel cardCount;
    private JLabel[] categories;
    private JLabel[] values;
    private JButton[] buttons;
    private boolean active;

    public PlayerTerm(Player player, Game game) {
        this.player = player;
        this.game = game;

        InitilizeComponents();
	}

    private void InitilizeComponents() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
        setTitle(player.getName());
        
        country = new JLabel(player.getTopCard().toString());
        country.setHorizontalAlignment(JLabel.CENTER);

        cardCount = new JLabel(player.getCardCount() + " Karten");
        cardCount.setHorizontalAlignment(JLabel.CENTER);

        categories = new JLabel[game.getCategorys().size()];
        values = new JLabel[game.getCategorys().size()];
        buttons = new JButton[game.getCategorys().size()];

        JPanel gameField = new JPanel(new GridLayout(game.getCategorys().size(),3));
        for(int i = 0; i < game.getCategorys().size(); i++)
        {
            Category curCat = game.getCategorys().get(i);
            categories[i] = new JLabel(curCat.getTitle());
            values[i] = new JLabel(player.getTopCard().getValue(curCat) + " " + curCat.getTitle());
            buttons[i] = new JButton("Go!");

            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    game.categorySelected(curCat);
                }});
                
            gameField.add(categories[i]);
            gameField.add(values[i]);
            gameField.add(buttons[i]);
        }


        add(country, BorderLayout.NORTH);
        add(gameField, BorderLayout.CENTER);
        add(cardCount, BorderLayout.SOUTH);

        setSize(400, 300);
		setVisible(true);
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public void showTopCard(boolean active) {
        
        this.active = active;
        for(int i = 0; i < game.getCategorys().size(); i++)
        {
            categories[i].setText(game.getCategorys().get(i).getTitle());
            categories[i].setForeground(active ? Color.BLACK : Color.GRAY);
            
            values[i].setText(player.getTopCard().getValue(game.getCategorys().get(i)) + " " + game.getCategorys().get(i).getTitle());
            values[i].setForeground(active ? Color.BLACK : Color.GRAY);
            
            buttons[i].setEnabled(active);
        }


        cardCount.setText(player.getCardCount() + " Karten");
        cardCount.setEnabled(active);

        country.setText(player.getTopCard().toString());
        cardCount.setEnabled(active);
    }

    @Override
    public void setPlayedSeconds(int secs) {
        setTitle(player.getName() + " " + secs);
    }

    public Boolean getActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
    }

	public void finish() {
        for(int i = 0; i < game.getCategorys().size(); i++)
        {
            categories[i].setText(game.getCategorys().get(i).getTitle());
            categories[i].setForeground(Color.GRAY);
            
            values[i].setText("-");
            values[i].setForeground(Color.GRAY);
            
            buttons[i].setEnabled(false);
        }


        cardCount.setText(player.getCardCount() + " Karten");
        cardCount.setEnabled(false);

        country.setText("");
        cardCount.setEnabled(false);

    }
    
    public String getPlayerName(){
        return player.toString();
    }
}
