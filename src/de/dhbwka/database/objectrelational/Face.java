package de.dhbwka.database.objectrelational;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="flaechen")
public class Face {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

    public Face(){
        // default constructor for mapping
    }
        
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
    }
    
    @ManyToOne
    @JoinColumn(name="poly")
    public Polyeder polyeder;

    @ManyToMany
    @JoinTable(
        name="flaechen_kanten",
        joinColumns = {
            @JoinColumn(name = "flaeche", referencedColumnName = "id") },
        inverseJoinColumns = {
            @JoinColumn(name = "kante", referencedColumnName = "id") }
    )
    public List<Edge> edges = new ArrayList<>();

    @Override
    public String toString() {
        return String.format("F(%d)", id);
    }
}
