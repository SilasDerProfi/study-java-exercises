package de.dhbwka.evolution.magicsquare;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MagicSquare {

    private int[][] square;
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
    }

    /**
     * Resets the square values to a shuffled order
     */
    public void Shuffle(){
        // get possible values and shuffle them
        List<Integer> values = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        Collections.shuffle(values);

        // set shuffled values
        for(int i = 0; values.size() > 0; i++)
            square[i / n][i % n] = values.remove(0);
    }


    public void SolveStupidSwap(){
        // TODO: implement
    }

    public void SolveIntelligentSwap(){
        // TODO: implement
    }
}
