package de.dhbwka.java.exercise.classes.vehicles;

/**
 * Vehicle
 */
public abstract class Vehicle {

    private int wheelCount;
    private double speedLimit;
    private double kmPosition;
    private double speed;


    public Vehicle(int wheelCount, double speedLimit)
    {
        this.wheelCount = wheelCount;
        this.speedLimit = speedLimit;   
    }

    protected void setSpeed(double speed)
    {
        this.speed = speed > speedLimit ? speedLimit : speed;
    }

    protected void drive(double minutes)
    {
        kmPosition += (speed / 60) * minutes;
    }

    public int getWheelCount()
    {
        return wheelCount;
    }
    
    public String Info()
    {
        return toString();
    }

    public String toString(){
        return this.getClass().getSimpleName() + " at position " + kmPosition + " km with " + wheelCount + " wheels at speed " + speed + " km/h of max. " + speedLimit + " km/h.";
    }


}