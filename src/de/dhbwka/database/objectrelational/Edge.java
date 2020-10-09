package de.dhbwka.database.objectrelational;

import javax.persistence.*;


@Entity
@Table(name="kanten")
public class Edge {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    @ManyToOne
    @JoinColumn(name="f1")
    private Face f1;

    @ManyToOne
    @JoinColumn(name="f2")
    private Face f2;
    
    public Edge(){
        // default constructor for Mapping
    }

    public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
    }

	public Face getF1() {
		return this.f1;
	}

	public void setF1(Face f1) {
		this.f1 = f1;
    }
    
	public Face getF2() {
		return this.f2;
	}

	public void setF2(Face f2) {
		this.f2 = f2;
	}

    @Override
    public String toString() {
        return String.format("E(%d, %s, %s)", getId(), getF1(), getF2());
    }
}
