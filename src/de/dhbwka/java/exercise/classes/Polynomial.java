package de.dhbwka.java.exercise.classes;

/**
 * Polynomial
 */
public class Polynomial {

    private double a;
    private double b;
    private double c;

    Polynomial(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getValue(double x) {
        return a * Math.pow(x, 2) + b * x + b;
    }

    public Polynomial add(Polynomial pol2) {
        return new Polynomial(a + pol2.getA(), b + pol2.getB(), c + pol2.getC());
    }

    public Polynomial subtract(Polynomial pol2) {
        return new Polynomial(a - pol2.getA(), b - pol2.getB(), c - pol2.getC());
    }

    public Polynomial multiply(double scalar) {
        return new Polynomial(a * scalar, b * scalar, c * scalar);
    }

    public double[] calculateZero() {
        double b = this.b / this.a;
        double c = this.c / this.a;

        double radicand = (Math.pow((b / 2), 2) - c);

        if (radicand > 0) {
            double x1 = (b / (-2)) + Math.sqrt(radicand);
            double x2 = (b / (-2)) - Math.sqrt(radicand);
            return x1 == x2 ? new double[] { x1 } : new double[] { x1, x2 };
        } else
            return new double[0];
    }

    private double getA() {
        return a;
    }

    private double getB() {
        return b;
    }

    private double getC() {
        return c;
    }

    public String toString() {
        return a + "x^2 " + (b >= 0 ? "+" + b : b) + "x " + (c >= 0 ? "+" + c : c);
    }
}