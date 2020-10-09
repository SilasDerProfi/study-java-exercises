package de.dhbwka.database.objectrelational;

import javax.persistence.*;


@Entity
@Table(name="kanten")
public class Edge {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    public Edge(){
        // default constructor for Mapping
    }

    public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
    }

    @ManyToOne
    @JoinColumn(name="f1")
    public Face f1;

    @ManyToOne
    @JoinColumn(name="f2")
    public Face f2;

    @Override
    public String toString() {
        return String.format("K(%s,%s)", f1, f2);
    }
}
