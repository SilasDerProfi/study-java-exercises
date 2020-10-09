package de.dhbwka.database.objectrelational;

import java.util.ArrayList;
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

	public double getPerimeter() {
		for(Face f : faces)
			System.out.println(f);
		return -0.0;
	}
	 
	@OneToMany(mappedBy = "polyeder")
	public List<Face> faces = new ArrayList<>();
   
      
	@Override
	public String toString() {
		return String.format("POL(%d,%s)", id, name);
	}
}
