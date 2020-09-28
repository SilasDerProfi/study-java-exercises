package de.dhbwka.java.exercise.classes.vehicles;

/**
 * Ambulance
 */
public class Ambulance extends Car {
    private boolean signalIsOn;

    public Ambulance(double speed, boolean signalState) {
        super(speed);
        setSignal(signalState);
    }

    public void setSignal(boolean signalState) {
        signalIsOn = signalState;
    }

    public boolean getSignalState() {
        return signalIsOn;
    }

    public String toString()
    {
        return super.toString() + " Signal " + (signalIsOn ? "on." : "off.");
    }
}