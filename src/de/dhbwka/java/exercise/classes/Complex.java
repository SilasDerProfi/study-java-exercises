package de.dhbwka.java.exercise.classes;

/**
 * Complex
 */
public class Complex implements Comparable<Complex>{
    private double a;
    private double b;

    Complex(double real, double imag)
    {
        a = real;
        b = imag;
    }

    public double getReal(){
        return a;
    }

    public double getImag(){
        return b;
    }

    public Complex add(Complex comp){
        return new Complex(a + comp.getReal(), b + comp.getImag());
    }

    public Complex sub(Complex comp){
        return new Complex(a - comp.getReal(), b - comp.getImag());
    }
    
    public Complex mult(Complex comp){
        return new Complex(a * comp.getReal() - b * comp.getImag(), a * comp.getImag() + b * comp.getReal());
    }

    public Complex div(Complex comp){
        return new Complex((a * comp.getReal() + b * comp.getImag()) / (Math.pow(comp.getReal(), 2) + (Math.pow(comp.getImag(), 2))),
        (b * comp.getReal() - a * comp.getImag()) / (Math.pow(comp.getReal(), 2) + (Math.pow(comp.getImag(), 2))));
    }

    public double getMagnitude()
    {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public Boolean isLess(Complex comp)
    {
        return getMagnitude() < comp.getMagnitude();
    }

    public String toString(){
        return String.format("%10s", a + "+" + b + "i");
    }

    @Override
    public int compareTo(Complex o) {
        return o.isLess(this) ? 1 : -1;
    }
}