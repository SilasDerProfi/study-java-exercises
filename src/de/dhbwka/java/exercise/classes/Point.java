package de.dhbwka.java.exercise.classes;

/**
 * Point
 */
public class Point {
    
    // #region private members
    private double x;
    private double y;
    // #endregion private members

    // #region constructors
    Point(double x, double y) {
        setX(x);
        setY(y);
    }
    // #endregion constructors

    // #region GetSet
    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    // #endregion GetSet

    // #region public methods
    public String toString() {
        return "(" + getX() + " | " + getY() + ")";
    }

    public double getMagnitude(){
        return Math.sqrt(Math.pow(getX(), 2) + Math.pow(getY(), 2));
    }

    public Point mirrorX(){
        return new Point(getX() * -1, getY());
    }

    public Point mirrorY(){
        return new Point(getX(), getY() * -1);
    }

    public Point mirrorOrigin(){
        return new Point(getX() * -1, getY() * -1);
    }

    public double getDistance(Point p)
    {
        return Math.sqrt(Math.pow(getX() - p.getX(), 2) + Math.pow(getY() - p.getY(), 2));
    }
    // #endregion public methods
}