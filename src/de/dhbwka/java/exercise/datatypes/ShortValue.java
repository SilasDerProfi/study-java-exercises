package de.dhbwka.java.exercise.datatypes;

public class ShortValue {
    public static void main(String[] args) {
        // 32767 entspricht Short.MAX_VALUE
        short a = Short.MAX_VALUE;
        
        System.out.printf("%d + 1 = %d", a, ++a);
        
        // a entspricht nun Short.MIN_VALUE
    }
}