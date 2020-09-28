package de.dhbwka.java.exercise.classes;

/**
 * Radio
 */
public class Radio {

    // #region private members
    private boolean on;
    private int volume;
    private double frequency;
    // #endregion private members

    // #region constructors
    Radio() {
        setFrequency(85);
    }

    Radio(boolean on, int volume, double frequency) {
        setOn(on);
        setVolume(volume);
        setFrequency(frequency);
    }
    // #endregion constructors

    // #region GetSet
    public boolean getOn() {
        return on;
    }

    public void setOn(boolean value) {
        on = value;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int value) {
        if (value < 0)
            volume = 0;
        else if (value > 10)
            volume = 10;
        else
            volume = value;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double value) {
        if (value < 85 || value > 110)
            frequency = 99.9;
        else
            frequency = value;
    }
    // #endregion GetSet

    // #region public methods
    public void incVolume() {
        if (on)
            setVolume(getVolume() + 1);
    }

    public void decVolume() {
        if (on)
            setVolume(getVolume() - 1);
    }

    public void turnOn() {
        setOn(true);
    }

    public void turnOff() {
        setOn(false);
    }

    public String toString() {
        return String.format("Radio " + (getOn() ? "an" : "aus") + " Lautstaerke " + getVolume() + " Frequenz "
                + getFrequency() + " MHz");
    }
    // #endregion public methods
}