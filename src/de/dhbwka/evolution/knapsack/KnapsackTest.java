package de.dhbwka.evolution.knapsack;

import java.util.TreeMap;

public class KnapsackTest {
    
    static final int EXECUTION_TIMES = 100;
    static final int MAX_GENERATIONS = 10;
    static final int NUMBER_OF_CHILDREN = 5;
    static final int MAX_NO_CHANGE_GENERATIONS = 10;
    
    public static void main(String[] args) {
        Item[] items = {
            new Item(20,120), new Item(35,175), new Item(50,200),
            new Item(50,150), new Item(15,30), new Item(60,60)
        };

        Knapsack myBackpack = new Knapsack(100, items);

        int totalValue = 0;
        var distributionTable = new TreeMap<Integer, Integer>();

        // execute the algorithm multiple times, to compare the results
        for(int i = 0; i < EXECUTION_TIMES; i++) {
            int time = myBackpack.solveHillClimbing(NUMBER_OF_CHILDREN, MAX_GENERATIONS, MAX_NO_CHANGE_GENERATIONS);
            int currentTotalValue = myBackpack.getCurrentTotalValue();
            // use this line for logging:
            // System.out.printf("%3d miliseconds for the result %d\r\n", time, currentTotalValue);
            totalValue += currentTotalValue;
            
            distributionTable.compute(currentTotalValue, (k, v) -> v == null ? 1 : ++v);
        }

        System.out.println(String.format("Distribution of all results: %s", distributionTable.toString()));
        System.out.println(String.format("Average: %d", totalValue / EXECUTION_TIMES));
    }
}
