package de.dhbwka.java.exam.speedyquiz;

import java.awt.Color;

/**
 * Months
 */
public enum Status {

    ACTIVE(Color.ORANGE, 0, "aktuell gestellte Frage"),
    CORRECT(Color.GREEN, 1, "richtig beantwortete Frage"),
    WRONG(Color.RED, -1, "falsch beantwortete Frage"),
    PENDING(Color.WHITE, 0, "noch nicht gespielte/ausstehende Frage"),
    NO_ANSWER(Color.GRAY, 0, "Frage auf die ein anderer Spieler geantwortet hat");

    private Color color;
    private int points;
    private String comment;

    Status(Color color, int points, String comment) {
        this.color = color;
        this.points = points;
        this.comment = comment;
    }

    public int getPoints() {
        return points;
    }

    public Color getColor() {
        return color;
    }

    public String getComment() {
        return comment;
    }

}