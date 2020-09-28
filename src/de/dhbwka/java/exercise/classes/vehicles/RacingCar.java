package de.dhbwka.java.exercise.classes.vehicles;

/**
 * RacingCar
 */
public class RacingCar extends Car {

    public RacingCar(double speed)
    {
        this(speed, 220);
    }

    public RacingCar(double speed, double speedLimit)
    {
        super(speed, speedLimit);
    }
    
}