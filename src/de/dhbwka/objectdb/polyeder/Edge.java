package de.dhbwka.objectdb.polyeder;

import javax.persistence.Entity;

@Entity
public class Edge {
    private Point p0;
    private Point p1;

    Edge(){

    }

    Edge(Point point0, Point point1){
        this.p0 = point0;
        this.p1 = point1;
    }

    public Point getP0() {
    	return p0;
    }

    public Point getP1() {
    	return p1;
    }

    @Override
    public String toString() {
        return String.format("{ %f, %f }", this.p0, this.p1);
    }
}
