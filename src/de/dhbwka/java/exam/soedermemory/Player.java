package de.dhbwka.java.exam.soedermemory;

import javax.swing.JLabel;

/**
 * Player
 */
public class Player extends JLabel {
	private static final long serialVersionUID = 1L;
    private String name;
    private int points;
    private PlayerStatus status;

    public Player(String name) {
        setName(name);
        setStatus(PlayerStatus.WAITING);
    }
    

    public void addPoint(){
        setPoints(getPoints() + 1);
        setText(name + "(" + points +")");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
        setText(name + "(" + points +")");
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public PlayerStatus getStatus() {
        return this.status;
    }

    public void setStatus(PlayerStatus status) {
        this.status = status;

        setForeground(status.getColor());
    }

}