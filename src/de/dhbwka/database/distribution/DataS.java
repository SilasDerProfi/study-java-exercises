package de.dhbwka.database.distribution;

public class DataS extends Data
{
	// C is inherited from Data
	protected int d;
	protected int e;

	public DataS() {
		d = randVal();
		e = randVal();
	}

	// compare DataS by order C, D, E
	@Override
    public int compareTo(Data rhs) {
		if (c < rhs.c) return -1;
		if (c > rhs.c) return  1;
		if (rhs instanceof DataS) {
			DataS r = (DataS)rhs;
			if (d < r.d) return -1;
			if (d > r.d) return  1;
			if (e < r.e) return -1;
			if (e > r.e) return  1;
		}
		return 0;
    }

	@Override
    public String toString() {
		return String.format("C:%2d D:%2d E:%2d", c, d, e);
	}
}
