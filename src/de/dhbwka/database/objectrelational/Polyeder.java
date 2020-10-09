package de.dhbwka.database.objectrelational;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="polyeder")
public class Polyeder
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	@OneToMany(mappedBy = "polyeder")
	private List<Face> faces = new ArrayList<>();
 
	public Polyeder() {
        // default constructor for Mapping
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Face> getFaces() {
		return this.faces;
	}

	public void setFaces(List<Face> faces) {
		this.faces = faces;
	}

	public double getPerimeter() {
		return faces.stream()
			.flatMap(f -> f.getEdges().stream())
			.distinct()
			.mapToDouble(Edge::getLength)
			.sum();
	}

	/**
	 * Moves the Polyeder in the 3-dimensional space
	 * @param dx delta x
	 * @param dy delta y
	 * @param dz delta z
	 */
	public void move(double dx, double dy, double dz){
		faces.stream()
			.flatMap(f -> f.getEdges().stream()
				.flatMap(e -> Arrays.asList(e.getP1(), e.getP2()).stream()))
			.distinct()
			.forEach(p -> p.move(dx,dy,dz));
	}
	
	@Override
	public String toString() {
		return String.format("POL(%d,%s)", getId(), getName());
	}
}
