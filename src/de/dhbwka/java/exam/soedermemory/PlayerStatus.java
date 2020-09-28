package de.dhbwka.java.exam.soedermemory;

import java.awt.Color;

/**
 * Months
 */
public enum PlayerStatus {

    ACTIVE(Color.ORANGE),
    WAITING(Color.BLACK),
    FINISHED(Color.GRAY);

    private Color color;

    PlayerStatus(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}