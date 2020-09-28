package de.dhbwka.java.exam.dartscounter;

import java.util.Arrays;

/**
 * Visit
 */
public class Visit {

    private Field[] fields;
    private int value;

    /**
     * @param fields Liste von genau 3 getroffenen Feldern (nicht getroffenes feld
     *               entspricht 'x'), ansonsten tritt eine
     *               {@code IllegalArgumentException} auf
     */
    Visit(Field[] fields) {
        if (fields.length != 3 || Arrays.stream(fields).anyMatch(f -> f == null))
            throw new IllegalArgumentException();

        this.fields = fields;
        value = Arrays.stream(fields).mapToInt(f -> f.getValue()).sum();
    }

    public Field[] getFields() {
        return fields;
    }

    public int getValue() {
        return value;
    }

    public Field getLastField() {
        return fields[fields.length - 1];
    }
}