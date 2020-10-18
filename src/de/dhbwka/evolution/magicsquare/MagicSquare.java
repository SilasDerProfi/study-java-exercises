package de.dhbwka.evolution.magicsquare;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MagicSquare {

    private int[][] square;
    private MagicSquareResult[] rowResults;
    private MagicSquareResult[] colResults;
    private int totalFitness;
    private int n;
    /**
     * Initilizes a new MagicSquare. The initial values are sorted ascending
     * @param n the edgeLength of the Square
     */
    public MagicSquare(int n){
        // initilize the square
        square = new int[n][n];
        this.n = n;
        // set the values in ascending order
        for(int i = 0; i < n * n; square[i / n][i % n] = ++i);
        recalculateFitness();
    }
    
    public int getTotalFitness(){
        return totalFitness;
    }

    public int getRowFitness(int rowIndex){
        return rowResults[rowIndex].getFitness();
    }
    
    public int getColFitness(int colIndex){
        return colResults[colIndex].getFitness();
    }

    /**
     * Resets the square values to a shuffled order
     */
    public void Shuffle(){
        // get possible values and shuffle them
        List<Integer> values = IntStream.rangeClosed(1, n * n).boxed().collect(Collectors.toList());
        Collections.shuffle(values);

        // set shuffled values
        for(int i = 0; values.size() > 0; i++)
            square[i / n][i % n] = values.remove(0);
        recalculateFitness();
    }
    
    private void recalculateFitness(){
        // init
        int desired_line_sum = IntStream.rangeClosed(1, n * n).sum() / n;
        this.rowResults = new MagicSquareResult[n];
        this.colResults = new MagicSquareResult[n];
        this.totalFitness = 0;
       
        // Calculate sum and fitness for the rows and cols
        for(int i = 0; i < n; i++){
            // calculate row results
            final int row_index = i;
            rowResults[row_index] = new MagicSquareResult(desired_line_sum, Arrays.stream(this.square[row_index]).sum());
        
            // calculate col results
            final int col_index = i;
            colResults[col_index] = new MagicSquareResult(desired_line_sum, Arrays.stream(this.square).mapToInt(row -> row[col_index]).sum());
        }

        // calculate total Fitness
        Arrays.stream(rowResults).forEach(row -> this.totalFitness += row.getFitness());
        Arrays.stream(colResults).forEach(col -> this.totalFitness += col.getFitness());
    }

    /**
     * Swaps the two Cells and forces a fitness recalculation
     */
    public void Swap(int row1, int col1, int row2, int col2){
        // Swap
        int value1 = this.square[row1][col1];
        int value2 = this.square[row2][col2];
        this.square[row1][col1] = value2;
        this.square[row2][col2] = value1;

        // Update Row and Column Results
        int swapDifference = value1 - value2;

        int row1fitness = this.rowResults[row1].getFitness();
        this.rowResults[row1].increaseSum(swapDifference);

        int col1fitness = this.rowResults[col1].getFitness();
        this.colResults[col1].increaseSum(swapDifference);

        int row2fitness = this.rowResults[row2].getFitness();
        this.rowResults[row2].increaseSum(-swapDifference);

        int col2fitness = this.rowResults[col2].getFitness();
        this.colResults[col2].increaseSum(-swapDifference);

        // Update total fitness
        this.totalFitness -= row1fitness - this.rowResults[row1].getFitness();
        this.totalFitness -= col1fitness - this.rowResults[col1].getFitness();
        this.totalFitness -= row2fitness - this.rowResults[row2].getFitness();
        this.totalFitness -= col2fitness - this.rowResults[col2].getFitness();
    }

    /**
     * Returns a clone of the current MagicSquare instance
     */
    public MagicSquare clone(){
        var clone = new MagicSquare(n);

        clone.square = Arrays.stream(this.square).map(int[]::clone).toArray(int[][]::new);
        clone.rowResults = this.rowResults.clone();
        clone.colResults = this.colResults.clone();
        clone.totalFitness = this.totalFitness;

        return clone;
    }

    @Override
    public String toString() {
        String stringRepresentation = "";
        String colSumRepresentation = "";
        String colFitnessRepresentation = "";

        int colWidth = String.valueOf(n * n).length() + 1;
        String colPattern = "%" + colWidth * 2 + "d";

        for(int i = 0; i < n; i++){
            int rowIndex = i;
            for (int colIndex = 0; colIndex < n; colIndex++)
                stringRepresentation += String.format(colPattern, square[rowIndex][colIndex]);

            var rowResult = rowResults[rowIndex];
            stringRepresentation += "  ";
            stringRepresentation += String.format(colPattern, rowResult.getSum());
            stringRepresentation += String.format(colPattern, rowResult.getFitness());
            stringRepresentation += "\r\n";

            var colIndex = i;
            var colResult = colResults[colIndex];
            colSumRepresentation += String.format(colPattern, colResult.getSum());
            colFitnessRepresentation += String.format(colPattern, colResult.getFitness());
        }
        
        stringRepresentation += "\r\n" + colSumRepresentation + "\r\n";
        stringRepresentation += colFitnessRepresentation;
        stringRepresentation += String.format("  %" + colWidth * 4 + "d", this.totalFitness);

        return stringRepresentation;
    }
}