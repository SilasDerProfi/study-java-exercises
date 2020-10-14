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
    private int currentGeneration;
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
        // inverse
        int flipIndex = randomNumber.nextInt(items.length);
        BitSet child = (BitSet)parent.clone();
        child.flip(flipIndex);

        // swap
        int swapIndex1 = randomNumber.nextInt(items.length);
        int swapIndex2 = randomNumber.nextInt(items.length);

        if(child.get(swapIndex1) != child.get(swapIndex2))
        {
            child.flip(swapIndex1);
            child.flip(swapIndex2);
        }

        return child;
    }

    /**
     * Solves the Knapsack problem with Hill climbing 
     * @param maxGenerations Maximum number of generations
     * @param maxNoChangeGenerations Maximum number of generations without improvement
     */
    public void solveHillClimbing(int maxGenerations, int maxNoChangeGenerations){
        currentResult = new BitSet(items.length);

        executionMode = ExecutionMode.HILL_CLIMBING;
        int noChangeCounter = 0;

        for(currentGeneration = 0;
            executionMode == ExecutionMode.HILL_CLIMBING &&
            currentGeneration != maxGenerations &&
            noChangeCounter < maxNoChangeGenerations; currentGeneration++)
        {
            BitSet child = mutate(currentResult);
            BitSet newResult = getBetter(currentResult, child);
            if(currentResult == newResult)
                noChangeCounter++;
            else
                noChangeCounter = 0;

            currentResult = newResult;
        }

        executionMode = ExecutionMode.NONE;
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

    public int getCurrentTotalValue(){
        return getAffectedItems(currentResult).stream().mapToInt(Item::getValue).sum();
    }

	public void printCurrentResult() {
        System.out.println("-----Knapsack-----");
        System.out.println(String.format("Generation:%7d", currentGeneration));
        int totalWeight = 0;
        int totalValue = 0;
        for(Item item : getCurrentResult()){
            System.out.println(item);
            totalWeight += item.getWeight();
            totalValue += item.getValue();
        }
        System.out.println("------Total-------");
        System.out.println(totalWeight + " kg, " + totalValue + " €");
        System.out.println("------------------");
	}
}