package de.dhbwka.evolution.magicsquare;

public class MagicSquareResult {
    private int sum;
    private int fitness;
	private int desired_line_sum;

    public MagicSquareResult(int desired_line_sum, int sum){
		this.desired_line_sum = desired_line_sum;
		increaseSum(sum);
    }

	public int getSum() {
		return this.sum;
	}

	public void increaseSum(int incrementValue) {
		if(incrementValue == 0)
			return;
			
		this.sum += incrementValue;
		this.fitness = (int)Math.pow(this.sum - this.desired_line_sum, 2);
	}

	public int getFitness() {
		return this.fitness;
	}
}
