package de.dhbwka.database.bigdata.pagerank;

public class SquareMatrix {
	private final double[] values;
	private final int size;
	private final int totalSize;

	/**
	 * @param n The size (width and length) of the Matrix
	 */
	public SquareMatrix(int n) {
		this.size = n;
		this.totalSize = n * n;
		this.values = new double[this.totalSize];
	}

	public int size() {
		return size;
	}

	public int totalSize() {
		return totalSize;
	}

	/**
	 * Get value at row i and column j
	 */
	public double get(int i, int j) {
		return values[i * size + j];
	}

	/**
	 * Set value at row i and column j
	 */
	public void set(int i, int j, double value) {
		values[i * size + j] = value;
	}

	/**
	 * Sum up values from given column
	 */
	public double sumColumn(int j) {
		double sum = 0;
		for (int i = 0; i < size; i++)
			sum += get(i, j);
		return sum;
	}

	/**
	 * Multiply this with scalar value
	 */
	public void multiply(double v) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				set(i, j, v * get(i, j));
		}
	}

	/**
	 * Multiply with vector (r = this*v)
	 */
	public Vector multiply(Vector v) {
		if (v.size() != size)
			throw new IllegalArgumentException("Matrix/Vector size mismatch");

		Vector v2 = new Vector(size, 0);
		for (int i = 0; i < size; i++) {
			double sum = 0;
			for (int j = 0; j < size; j++)
				sum += get(i, j) * v.get(j);
			v2.set(i, sum);
		}
		return v2;
	}

	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.print("MATRIX:");
			for (int j = 0; j < size; j++) {
				System.out.format(" %.3f", get(i, j));
			}
			System.out.println();
		}
	}
}
