package de.dhbwka.java.exam.dartscounter;

import java.util.Arrays;

/**
 * Board
 */
public class Board {

    private Field[] field;

    Board() {
        field = new Field[63];
        for (int i = 1; i <= 20; i++) {
            field[i - 1] = new Field(String.valueOf(i), i, false);
            field[i + 19] = new Field("D" + i, i * 2, true);
            field[i + 39] = new Field("T" + i, i * 3, false);
        }

        field[60] = new Field("25", 25, true);
        field[61] = new Field("BULL", 50);
        field[62] = new Field("x", 0);
    }

    public Field parseField(String label) {
        return Arrays.stream(field).filter(f -> label.equalsIgnoreCase(f.getLabel())).findFirst().orElseGet(() -> null);
    }

}