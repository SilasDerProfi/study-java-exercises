package de.dhbwka.java.exam.dartscounter;

/**
 * Field
 */
public class Field {

    private String label;
    private int value;
    private Boolean doubleField;

    Field(String label, int value, Boolean doubleField) {
        this.label = label;
        this.value = value;
        this.doubleField = doubleField;
    }

    Field(String label, int value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return this.label;
    }

    public int getValue() {
        return this.value;
    }

    public Boolean isDoubleField() {
        return this.doubleField;
    }
}