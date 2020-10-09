package de.dhbwka.database.objectrelational;

import javax.persistence.*;

@Entity
@Table(name="punkte")
public class Point {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private double x;
    private double y;
    private double z;
    
    public Point(){
        // default constructor for Mapping
    }

    public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getX() {
		return this.x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return this.y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return this.z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	/**
	 * Moves the Point in the 3-dimensional space
	 * @param dx delta x
	 * @param dy delta y
	 * @param dz delta z
	 */
	public void move(double dx, double dy, double dz){
		setX(getX() + dx);
		setY(getY() + dy);
		setZ(getZ() + dz);
	}

    @Override
    public String toString() {
        return String.format("P(%f, %f, %f)", getX(), getY(), getZ());
    }
}
