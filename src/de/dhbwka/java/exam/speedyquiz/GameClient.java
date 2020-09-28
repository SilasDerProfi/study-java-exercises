package de.dhbwka.java.exam.speedyquiz;

/**
 * GameClient
 */
public interface GameClient {

    /**
     * liefert den Namen des Spielers
     */
    public String getPlayerName();
    /**
     * liefert die Anzahl der Punkte
     * (jede richtige Antwort zählt 1 Punkt, für jede falsche Antwort wird ein Punkt abgezogen.
     * Wäre die Gesamtpunktzahl negativ ist 0 zurückzugeben)
     */
    public int getPoints();
    /**
     * übergibt dem Client den 0-basierten Index der Frage
     * (in der Liste der für das Spiel ausgewählten Fragen),
     * sowie die Fragen-Instanz.
     * Beim Aufruf soll jeder Client implizit für die Frage in den Zustand ACTIVE
     * (siehe Tabelle unten) übergehen.
     */
    public void setQuestion(int questionIndex, Question q);

    public void setRemainingSeconds(int seconds);
    public void gameIsOver();
    public void setAnswerState(int questionIndex, Status status);
}