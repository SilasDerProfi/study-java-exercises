package de.dhbwka.java.exercise.classes.vehicles;

/**
 * Car
 */
public class Car extends Vehicle {

    public Car(double speed) {
        this(speed, 140);
    }

    protected Car(double speed, double speedLimit) {
        super(4, speedLimit);
        this.setSpeed(speed);
    }
}