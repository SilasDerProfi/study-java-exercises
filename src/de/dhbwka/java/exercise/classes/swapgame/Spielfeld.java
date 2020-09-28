package de.dhbwka.java.exercise.classes.swapgame;

import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Spielfeld
 */
public class Spielfeld {
    // #region private members
    private final int SIZE = 9;
    private final int COLOR_COUNT = 7;
    @SuppressWarnings("unused")
    private Color[] colors = generateColors(COLOR_COUNT);
    private Integer[][] matchfield = new Integer[SIZE][SIZE]; // [Spalte][Zeile]
    private int points;
    private PropertyChangeSupport pointsChange = new PropertyChangeSupport(points);
    private PropertyChangeSupport matchfieldChanged = new PropertyChangeSupport(matchfield);
    // #endregion private members

    // #region constructors
    public Spielfeld() {
        Random r = new Random();
        for (Integer[] col : matchfield)
            for (int i = 0; i < SIZE; i++)
                col[i] = r.nextInt(COLOR_COUNT);

        calcPoints();
    }
    // #endregion constructors

    // #region private methods
    /**
     * Generiert {@code i} unterschiedliche Farben
     * 
     * @param i Anzahl der zu generierenden Farben
     * @return Liste an Farben
     */
    private Color[] generateColors(int i) {
        Color[] colors = new Color[i];
        int offSet = Integer.parseInt("FFFFFF", 16) / i;

        for (int c = 0; c < i; c++)
            colors[c] = new Color(offSet * (c + 1));

        return colors;
    }

    /**
     * Berechnet, fuer die aktuelle Spielsituation erzielbare Punkte. Wenn ja,
     * werden die Felder aufgeloest. Felder rutschen nach / werden neu generiert und
     * es werden dadurch neue moegliche Punkte berechnet.
     * 
     * @return insgesamt erzielte Punkte
     */
    private int calcPoints() {
        Position[] pos = getPointFields();
        if (pos.length > 0) {
            // Zerstörte Felder auf null setzen
            for (Position p : pos)
                setFieldValue(p, null);

                Integer[][] oldMatchfield = this.matchfield;
            // null Felder nach vorne sortieren
            for (Integer[] col : matchfield) {
                java.util.Arrays.sort(col, (a, b) -> (a == null ? -1 : 1) - (b == null ? -1 : 1));

                // null Felder neu befüllen
                Random r = new Random();
                for (int i = 0; i < SIZE; i++) {
                    if (col[i] != null)
                        break;
                    col[i] = r.nextInt(COLOR_COUNT);
                }
            }

            matchfieldChanged.firePropertyChange("matchfield", oldMatchfield, this.matchfield);
            return (10 * pos.length) + calcPoints();
        }

        return 0;
    }

    /**
     * Liste von Feldern, durch welche Punkte erzielt werden. mehrfache Aufführugen
     * sind möglich, wenn das Feld sowohl Senkrecht als auch Wagerecht Punkte erzielt.
     * 
     * @return Liste mit Felder, fuer die Punkte vergeben werden
     */
    private Position[] getPointFields() {

        List<Position> positions = new ArrayList<Position>();

        for (int c = 0; c < SIZE; c++) {
            for (int r = 0; r < SIZE; r++) {
                positions = searchBlocks(c, r, positions);
            }
            // letzter Block, incl. beginnendem [null] entfernen, wenn kein vollständiger
            // Block
            int lastBlockSize = positions.size() - positions.lastIndexOf(null);
            lastBlockSize = lastBlockSize < 0 || lastBlockSize > positions.size() ? positions.size() : lastBlockSize;
            if (lastBlockSize < 4)
                positions = positions.subList(0, positions.size() - lastBlockSize);
            positions.add(null);
        }

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                positions = searchBlocks(c, r, positions);
            }
            // letzter Block, incl. beginnendem [null] entfernen, wenn kein vollständiger
            // Block
            int lastBlockSize = positions.size() - positions.lastIndexOf(null);
            lastBlockSize = lastBlockSize < 0 || lastBlockSize > positions.size() ? positions.size() : lastBlockSize;
            if (lastBlockSize < 4)
                positions = positions.subList(0, positions.size() - lastBlockSize);
            positions.add(null);
        }

        positions.removeAll(Collections.singleton(null));
        return positions.toArray(new Position[positions.size()]);
    }

    /**
     * Vergleicht eine Position auf dem Spielfeld mit den vorherigen. Speichert den
     * Block ggfs. als Wertbar ab, wenn es min. 3 gleiche Felder in Folge sind. Die
     * Felder muessen in der Liste mit {@code null} separiert werden.
     * 
     * @param c         aktuelle Spalte
     * @param r         aktuelle Zeile
     * @param positions Positionsliste, mit bereits erkannten Blöcken
     * @return neue Positionsliste, da es Probleme mit der Referenz-Liste bei
     *         neuinitialisierung in der Methode gibt.
     */
    private List<Position> searchBlocks(int c, int r, List<Position> positions) {
        // Wenn dieses Feld das erste ist, oder das vorherige gleich / null ist, kann es
        // hinzugefügt werden
        if (positions.size() == 0 || positions.get(positions.size() - 1) == null
                || getFieldValue(positions.get(positions.size() - 1)) == getFieldValue(c, r)) {
            positions.add(new Position(c, r));
        } else {
            // wenn min. 3 vorgänger gleich sind, kann null eingefügt werden, um den Block
            // abzuschließen und mit diesem Feld einen neuen zu beginnen.
            // ansonsten werden die Vorgänger bis zum Ende des letzten Blocks (null)
            // gelöscht.
            if (positions.size() < 3) {
                positions = new ArrayList<Position>();
                positions.add(null);
            } else {
                // min 3 gleiche: null einfügen;
                Integer curVal = getFieldValue(positions.get(positions.size() - 1));
                if (curVal == getFieldValue(positions.get(positions.size() - 2))
                        && curVal == getFieldValue(positions.get(positions.size() - 3)))
                    positions.add(null);
                else
                    positions = positions.subList(0, positions.lastIndexOf(null) + 1);
            }

            // dieses Feld hinzufügen
            positions.add(new Position(c, r));
        }

        return positions;
    }

    private Integer getFieldValue(Position p) {
        return p == null ? null : getFieldValue(p.getColArrayIndex(), p.getRowArrayIndex());
    }

    private Integer getFieldValue(int col, int row) {
        return matchfield[col][row];
    }

    private void setFieldValue(Position p, Integer value) {
        if(p == null)
            return;
        setFieldValue(p.getColArrayIndex(), p.getRowArrayIndex(), value);
    }

    private void setFieldValue(int col, int row, Integer value) {
        matchfield[col][row] = value;
    }

    private void increasePoints(int points) {
        if (points != 0)
            pointsChange.firePropertyChange("points", this.points, this.points += points);
    }
    // #endregion private methods

    // #region public methods
    /**
     * Tauscht zwei Felder auf dem Spielfeld, falls dadurch Punkte erzielt werden
     * koennen.
     * 
     * @param pos1 Zeilennummer & Spalte des ersten Feldes
     * @param pos2 Zeilennummer & Spalte des zweiten Feldes
     * @return durch diesen Spielzug verdiente Punkte. 0 für einen ungueltigen
     *         Spielzug.
     */
    public int swap(Position pos1, Position pos2) {
        // Nur tauschen, wenn die Felder nebeneinander liegen
        if (Math.abs(pos1.getColArrayIndex() - pos2.getColArrayIndex())
                + Math.abs(pos1.getRowArrayIndex() - pos2.getRowArrayIndex()) != 1)
            return 0;

        Integer cell1 = getFieldValue(pos1);
        Integer cell2 = getFieldValue(pos2);

        setFieldValue(pos1, cell2);
        setFieldValue(pos2, cell1);

        int points = calcPoints();

        if (points == 0) {
            setFieldValue(pos1, cell1);
            setFieldValue(pos2, cell2);
        } else {
            increasePoints(points);
        }

        return points;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("   ");

        for (int i = 0; i < SIZE; i++)
            sb.append(new Position(i, i).getCol() + " ");
        sb.append("\r\n");
        sb.append("  __________________\r\n");
        for (int i = 0; i < SIZE; i++) {
            sb.append((i + 1) + "| ");
            for (int j = 0; j < SIZE; j++) {
                sb.append(matchfield[j][i] + " ");
            }
            sb.append("\r\n");
        }
        sb.append("Punkte: [" + points + "]");
        return sb.toString();

    }

    public void addPointsChangeListener(PropertyChangeListener listener) {
        pointsChange.addPropertyChangeListener(listener);
    }

    public void removePointsChangeListener(PropertyChangeListener listener) {
        pointsChange.removePropertyChangeListener(listener);
    }

    public void addMatchfieldChangeListener(PropertyChangeListener listener) {
        matchfieldChanged.addPropertyChangeListener(listener);
    }

    public void removeMatchfieldChangeListener(PropertyChangeListener listener) {
        matchfieldChanged.removePropertyChangeListener(listener);
    }

    // #endregion public methods
}