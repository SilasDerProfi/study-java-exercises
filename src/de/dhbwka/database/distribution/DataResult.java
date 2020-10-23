package de.dhbwka.database.distribution;


public class DataResult extends Data
{
	private int a;
	private int b;
	// c is inherited from Data
	private int d;
	private int e;

	public DataResult(Data d1, Data d2) {
		// one must be DataR, the other DataS
		DataR r;
		DataS s;
		if (d1 instanceof DataR) {
			r = (DataR)d1;
			s = (DataS)d2;
		} else {
			r = (DataR)d2;
			s = (DataS)d1;			
		}
		a = r.a; b = r.b; c = r.c;
		d = s.d; e = s.e;
	}
	
	public void genRandom() {
		throw new UnsupportedOperationException();
	}

	// compare DataResult by order C, A, B, D, E
	@Override
    public int compareTo(Data rhs) {
		if (c < rhs.c) return -1;
		if (c > rhs.c) return  1;
		if (rhs instanceof DataResult) {
			DataResult r = (DataResult)rhs;
			if (a < r.a) return -1;
			if (a > r.a) return  1;
			if (b < r.b) return -1;
			if (b > r.b) return  1;
			if (d < r.d) return -1;
			if (d > r.d) return  1;
			if (e < r.e) return -1;
			if (e > r.e) return  1;
		}
		return 0;
	}
	
	@Override
	public boolean equals(Object rhs) {
		if(!(rhs instanceof Data))
			return false;

		return this.compareTo((Data)rhs) == 0;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
    public String toString() {
		return String.format("A:%2d B:%2d C:%2d D:%2d E:%2d", a, b, c, d, e);
	}
}

