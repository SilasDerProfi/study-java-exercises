package de.dhbwka.java.exam.quartets;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class Game {

    private List<Category> categorys;
    private PlayerTerm player1;
    private PlayerTerm player2;
    private int level;
    private int time;
    private Timer timer = new Timer();;

	public Game(List<Category> categoryPool, int cnt) throws QuartetsException {
        if(categoryPool.size() <= cnt)
            throw new QuartetsException("Too few categories available");

        Collections.shuffle(categoryPool);
        categorys = categoryPool.subList((0), cnt);
	}

	public void start() throws QuartetsException{
        if(player1 == null ||player2 == null)
            throw new QuartetsException("Both players are required!");

            player1.showTopCard(true);
            player2.showTopCard(false);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    time++;
                    player1.setPlayedSeconds(time);
                    player2.setPlayedSeconds(time);
                  
                }
            }, 0, 1000);	
    }
    
    public void categorySelected(Category cat){
        level++;
        Card playerOneCard = player1.getPlayer().drawTopCard();
        Card playerTwoCard = player2.getPlayer().drawTopCard();

        if(playerOneCard.getValue(cat) == playerTwoCard.getValue(cat))
        {
            if(player1.getActive())
            {
                player1.getPlayer().addCard(playerOneCard);
                player1.getPlayer().addCard(playerTwoCard);
            }
            else
            {
                player2.getPlayer().addCard(playerOneCard);
                player2.getPlayer().addCard(playerTwoCard);
            }
        }
        else if(playerOneCard.getValue(cat) > playerTwoCard.getValue(cat))
        {
            player1.getPlayer().addCard(playerOneCard);
            player1.getPlayer().addCard(playerTwoCard);
            player1.setActive(true);
            player2.setActive(false);
        }
        else
        {
            player2.getPlayer().addCard(playerOneCard);
            player2.getPlayer().addCard(playerTwoCard);
            player2.setActive(true);
            player1.setActive(false);
        }


        Boolean finsihed = !player1.getPlayer().hasCards() || !player2.getPlayer().hasCards();

        // neue Runde
        if(!finsihed)
        {
            player1.showTopCard(player1.getActive() && !finsihed);
            player2.showTopCard(player2.getActive() && !finsihed);
        }

        if(finsihed){
            timer.cancel();
            String winner = player1.getPlayer().hasCards() ? player2.getPlayerName() : player1.getPlayerName();

        
            player1.finish();
            player2.finish();
            
            try {
                try (FileWriter fw = new FileWriter("io/highscore.txt", true)) {
                    fw.append(winner + " won in " + level + " rounds\r\n");
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Highscore konnte nicht gespeichert werden.", "Fehler", JOptionPane.ERROR_MESSAGE);
            }

            JOptionPane.showMessageDialog(null, winner + " won in " + level + " rounds", "Meldung", JOptionPane.INFORMATION_MESSAGE);
        }
    }

	public void registerClient1(QuartetsClient playerTerm) {
        player1 = (PlayerTerm)playerTerm;
	}

	public void registerClient2(QuartetsClient playerTerm) {
        player2 = (PlayerTerm)playerTerm;
    }
    

    public List<Category> getCategorys() {
        return this.categorys;
    }


}
