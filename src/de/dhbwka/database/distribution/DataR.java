package de.dhbwka.database.distribution;


public class DataR extends Data
{
	protected int a;
	protected int b;
	// c is inherited from Data

	public DataR() {
		a = randVal();
		b = randVal();
	}

	// compare DataR by order C, A, B
	@Override
    public int compareTo(Data rhs) {
		if (c < rhs.c) return -1;
		if (c > rhs.c) return  1;
		if (rhs instanceof DataR) {
			DataR r = (DataR)rhs;
			if (a < r.a) return -1;
			if (a > r.a) return  1;
			if (b < r.b) return -1;
			if (b > r.b) return  1;
		}
		return 0;
    }

	@Override
    public String toString() {
		return String.format("A:%2d B:%2d C:%2d", a, b, c);
	}

}
