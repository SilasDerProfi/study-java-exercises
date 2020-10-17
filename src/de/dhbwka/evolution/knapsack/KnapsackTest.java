package de.dhbwka.evolution.knapsack;

import java.util.HashMap;

public class KnapsackTest {
    
    static final int EXECUTION_TIMES = 10;
    static final int MAX_GENERATIONS = 1000;
    static final int MAX_NO_CHANGE_GENERATIONS = 100;
    
    public static void main(String[] args) {
        Item[] items = {
            new Item(20,120), new Item(35,175), new Item(50,200),
            new Item(50,150), new Item(15,30), new Item(60,60)
        };

        Knapsack myBackpack = new Knapsack(100, items);

        int totalValue = 0;
        var distributionTable = new HashMap<Integer, Integer>();

        // execute the algorithm multiple times, to compare the results
        for(int i = 0; i < EXECUTION_TIMES; i++) {
            myBackpack.solveHillClimbing(MAX_GENERATIONS, MAX_NO_CHANGE_GENERATIONS);
            int currentTotalValue = myBackpack.getCurrentTotalValue();
            totalValue += currentTotalValue;
            
            distributionTable.compute(currentTotalValue, (k, v) -> v == null ? 1 : ++v);
        }

        System.out.println(String.format("Distribution of all results: %s", distributionTable.toString()));
        System.out.println(String.format("Average: %d", totalValue / EXECUTION_TIMES));
    }
}
