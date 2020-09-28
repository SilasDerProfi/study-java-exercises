package de.dhbwka.java.exercise.classes;
/**
 * Horner
 */
public class Horner {

    private double[] parameter;

    Horner(double... parameter)
    {
        this.parameter = parameter;
    }

    public double getValue(double x)
    {
        if(parameter.length == 0)
            return 0;

        double retVal = parameter[0];
        for(int i = 1; i < parameter.length; i++)
            retVal = x * retVal + parameter[i];

        return retVal;
    }

    public String toString(){
        String retVal = "";
        for(int i = 0; i < parameter.length; i++)
            retVal += (parameter[i] >= 0 ? " +" : " ") + parameter[i]  + "*x^" + (parameter.length - i - 1);

        return retVal;
    }
}