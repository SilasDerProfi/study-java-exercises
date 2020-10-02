package de.dhbwka.evolution.knapsack;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;


/**
 * knapsack
 */
public class Knapsack {

    private final Item[] items;
    private final int maximumWeight;
    private BitSet currentResult;
    private ExecutionMode executionMode;
    private Random randomNumber;

    public Knapsack(int maximumWeight, final Item[] items){
        this.items = items;
        this.maximumWeight = maximumWeight;
        randomNumber = new Random();
    }

    private BitSet getBetter(BitSet a, BitSet b){
        List<Item> aItems = getAffectedItems(a);
        int aWeight = aItems.stream().mapToInt(Item::getWeight).sum();
        int aValue = aItems.stream().mapToInt(Item::getValue).sum();

        List<Item> bItems = getAffectedItems(b);
        int bWeight = bItems.stream().mapToInt(Item::getWeight).sum();
        int bValue = bItems.stream().mapToInt(Item::getValue).sum();

        if(bWeight > maximumWeight)
            return a;

        if(aWeight > maximumWeight)
            return b;

        if(aValue >= bValue)
            return a;

        return b;
    }

    private List<Item> getAffectedItems(BitSet selection){
        List<Item> affectedItems = new ArrayList<>();
        
        for(int i = 0; i < items.length; i++)
            if(selection.get(i))
                affectedItems.add(items[i]);

        return affectedItems;
    }

    /**
     * Mutates a BitSet (parent) by randomly changing a Bit.
     * @return the mutated Child
     */
    private BitSet mutate(BitSet parent){
        // TODO: Implement Recombination / Crossover
        int flipIndex = randomNumber.nextInt(items.length);
        BitSet child = (BitSet)parent.clone();
        child.flip(flipIndex);
        return child;
    }

    /**
     * Solves the Knapsack problem with Hill climbing 
     */
    public void solveHillClimbing(int maxGenerations){
        currentResult = new BitSet(items.length);
        executionMode = ExecutionMode.HILL_CLIMBING;
        
        for(int generation = 0; executionMode == ExecutionMode.HILL_CLIMBING && generation != maxGenerations; generation++){
            BitSet child = mutate(currentResult);
            currentResult = getBetter(currentResult, child);
        }
    }
    
    public void solveGradientDescent(){
        currentResult = new BitSet(items.length);
        executionMode = ExecutionMode.GRADIENT_DESCENT;

        new Thread(() -> {
            while(executionMode == ExecutionMode.GRADIENT_DESCENT){
                // TODO: Implement
                executionMode = ExecutionMode.NONE;
            }
        }).start();
    }

    public void stopSolving(){
        executionMode = ExecutionMode.NONE;
    }

    public List<Item> getCurrentResult(){
        return getAffectedItems(currentResult);
    }
}