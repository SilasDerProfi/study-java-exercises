package de.dhbwka.database.objectrelational;

import javax.persistence.*;


@Entity
@Table(name="flaechen")
public class Face {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long id;

    public Face(){
		// default constructor for Mapping
    }

    @Override
    public String toString() {
        return String.format("F(%d)", id);
    }
}
