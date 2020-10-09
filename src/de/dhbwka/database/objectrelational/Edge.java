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

    @ManyToOne
    @JoinColumn(name="p1")
    private Point p1;

    @ManyToOne
    @JoinColumn(name="p2")
    private Point p2;
    
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
    
	public Point getP1() {
		return this.p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return this.p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
    }
    
    public double getLength(){
        return Math.sqrt(
            Math.pow(getP1().getX() - getP2().getX(), 2) +
            Math.pow(getP1().getY() - getP2().getY(), 2) +
            Math.pow(getP1().getZ() - getP2().getZ(), 2)
        );
    }
    
    @Override
    public String toString() {
        return String.format("E(%d, %s, %s)", getId(), getF1(), getF2());
    }
}
