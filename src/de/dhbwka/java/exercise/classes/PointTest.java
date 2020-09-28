package de.dhbwka.java.exercise.classes;
/**
 * PointTest
 */
public class PointTest {

    public static void main(String[] args) {
        Point pointA= new Point(4.0, 2.0);
        System.out.println("A"+ pointA);
        System.out.println("Betrag: "+ pointA.getMagnitude());
        Point pointB= new Point(-1.0, -1.0);
        System.out.println("B"+ pointB);
        System.out.println("A - B: "+ pointA.getDistance(pointB));
        pointA= pointA.mirrorOrigin();
        System.out.println("A'"+ pointA);
        System.out.println("A'- B: "+ pointA.getDistance(pointB));
    }
}