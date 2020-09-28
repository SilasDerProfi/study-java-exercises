package de.dhbwka.java.exam.quartets;

/**
 * QuartetsClient
 */
public interface QuartetsClient {

    /**
     * Liefert den Spieler, den dieser Client repräsentiert
     */
    public Player getPlayer();

    /**
     * Zeigt die oberste Karte des Spielers an (vgl. Teilaufgabe d)).
     * Das Argument bestimmt, ob der aktuelle Spieler an der Reihe, d.h. aktiv, ist (true) oder nicht (false).
     * Sollte keine Karte vorhanden sein, sind statt der Informationen Minus-Zeichen anzuzeigen.
     */
    public void showTopCard(boolean active);

    /**
     * Setzt die Anzahl der gespielten Sekunden (bspw. im Fenstertitel, vgl. Teilaufgabe g))
     */
    public void setPlayedSeconds(int secs);
}