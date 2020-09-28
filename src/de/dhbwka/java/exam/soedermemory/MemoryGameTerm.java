package de.dhbwka.java.exam.soedermemory;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

/**
 * MemoryGameTerm
 */
public class MemoryGameTerm extends JFrame{

    private static final long serialVersionUID = 1L;
    private MemoryGame game;
    private JToggleButton[] memoryFields;
    private int shownCards;
    private int level;
    private int gameSeconds;
    private Timer timer = new Timer();

	public MemoryGameTerm(MemoryGame game) {
        setGame(game);

        setLayout(new BorderLayout());

        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new GridLayout(game.getPlayers().size(), 1));
        game.getPlayers().forEach(p -> playerPanel.add(p));

        JPanel memoryPanel = new JPanel();
        memoryPanel.setLayout(new GridLayout(game.getRows(), game.getCols()));

        ActionListener buttonClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (((JToggleButton)e.getSource()).isSelected())
                {
                    if(game.getCurrentPlayer().getStatus() != PlayerStatus.ACTIVE)
                        return;

                    setShownCards(getShownCards() + 1);
                    if(getShownCards() == 2)
                    {
                        if(Arrays.stream(getMemoryFields()).filter(m -> m.isSelected() && m.isEnabled() ).map(c -> c.getName()).distinct().count() == 1)
                        {
                            game.getCurrentPlayer().addPoint();
                            Arrays.stream(getMemoryFields()).filter(m -> m.isSelected()).forEach(t -> t.setEnabled(false));
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Sorry, those don't match", "Wrong", JOptionPane.ERROR_MESSAGE);
                            Arrays.stream(getMemoryFields()).filter(p -> p.isEnabled()).forEach(b -> b.setSelected(false));
                            game.nextPlayer();
                        }

                        if( Arrays.stream(getMemoryFields()).allMatch(j -> j.isSelected() || j.getName() == "blank"))
                            game.getPlayers().forEach(p -> p.setStatus(PlayerStatus.FINISHED));

                        setShownCards(0);

                        MemoryGameTerm.this.repaint();
                        level++;
                    }
                }
                else
                    setShownCards(getShownCards() - 1);

                if(game.getCurrentPlayer().getStatus() == PlayerStatus.FINISHED)
                {
                    Arrays.stream(getMemoryFields()).forEach(t -> t.setEnabled(false));
                    String message = "Game ends after " + level + " rounds, scores:";
                    game.getPlayers().sort((a,b) -> b.getPoints()-a.getPoints() );
                    
                    for(Player p : game.getPlayers())
                        message += " " + p.getName() + "(" + p.getPoints() + ")" + ",";

                    message = message.substring(0, message.length() - 1);
                    String old ="";
                        try (FileWriter fw = new FileWriter("io/memory.txt", true)) {
                            old = new String(java.nio.file.Files.readAllBytes(Paths.get("io/memory.txt")));

                            fw.append(message + "\n");
                        }
                        catch(IOException ex){}

                    
                    JOptionPane.showMessageDialog(null, message + "\n\nLast games:\n" + old, "Score", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        };

        memoryFields = game.getFullShuffledImages().stream().map(memoryImage -> {
            JToggleButton btn = new JToggleButton();

            btn.setName( memoryImage.getId() ); // Could be used to check if two buttons have the same image
            btn.setSelectedIcon( memoryImage.getImage() ); // Set the icon for SELECTED JToggleButton
            btn.setDisabledSelectedIcon( memoryImage.getImage() ); // Set the icon for SELECTED and DISABLED JToggleButton (keeps color)
            btn.setIcon( MemoryImages.getBackside() ); // Bavarian flag for UNSELECTED JToggleButton
            btn.addActionListener(buttonClick);
            memoryPanel.add(btn);
            return btn;
        }).toArray(JToggleButton[]::new);

        add(playerPanel, BorderLayout.NORTH);
        add(memoryPanel, BorderLayout.CENTER);


        setSize(400, 400);
        setTitle("Soeder Memory");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
        
        startGame();
	}

    private void startGame() {
        game.nextPlayer();
        this.repaint();
    
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                
                if(game.getCurrentPlayer().getStatus() == PlayerStatus.FINISHED)
                    this.cancel();
                    
                    gameSeconds++;
                    setTitle("Soeder Memory (" + gameSeconds + ")");
                
            }
        }, 0, 1000);
    }

    public MemoryGame getGame() {
        return this.game;
    }

    public void setGame(MemoryGame game) {
        this.game = game;
    }

    public JToggleButton[] getMemoryFields() {
        return this.memoryFields;
    }

    public void setMemoryFields(JToggleButton[] memoryFields) {
        this.memoryFields = memoryFields;
    }

    public int getShownCards() {
        return this.shownCards;
    }

    public void setShownCards(int shownCards) {
        this.shownCards = shownCards;
    }

    
}