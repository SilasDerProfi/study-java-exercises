package de.dhbwka.java.exercise.datatypes;

public class Round {
    public static void main(String[] args) {
        // Kaufmännisches Runden
        System.out.println("Pi ganzzahlig: " + Math.round((float) Math.PI));
        System.out.println("e ganzzahlig: " + Math.round((float) Math.E));
        // Kaufmännisches Runden (2)
        System.out.println("Pi ganzzahlig: " + Math.round(-(float) Math.PI));
        System.out.println("e ganzzahlig: " + Math.round(-(float) Math.E));

        double h = 1.3;
        int v = (int)(h+(h >= 0 ? 0.5 : -0.5));
        System.out.println("v: " + v);
    }

}