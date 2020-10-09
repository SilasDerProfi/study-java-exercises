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
 
	@OneToMany(mappedBy = "polyeder")
	public List<Face> faces = new ArrayList<>();
   
	public double getPerimeter() {
		for(Face f : faces)
			System.out.println(f);
		return -0.0;
	}
      
	@Override
	public String toString() {
		return String.format("POL(%d,%s)", id, name);
	}
}
