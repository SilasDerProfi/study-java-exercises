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
    
    @ManyToOne
    @JoinColumn(name="poly")
    private Polyeder polyeder;

    @ManyToMany
    @JoinTable(
        name="flaechen_kanten",
        joinColumns = { @JoinColumn(name = "flaeche", referencedColumnName = "id") },
        inverseJoinColumns = { @JoinColumn(name = "kante", referencedColumnName = "id") }
        )
    private List<Edge> edges = new ArrayList<>();

    public Face(){
        // default constructor for mapping
    }
        
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
    }

    public Polyeder getPolyeder() {
        return this.polyeder;
    }

    public void setPolyeder(Polyeder polyeder) {
        this.polyeder = polyeder;
    }

    public List<Edge> getEdges() {
        return this.edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    @Override
    public String toString() {
        return String.format("F(%d)", getId());
    }
}
