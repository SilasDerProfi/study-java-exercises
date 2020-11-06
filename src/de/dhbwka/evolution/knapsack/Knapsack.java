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

    private BitSet getBetter(List<BitSet> sets){
        if(sets == null || sets.isEmpty())
            return null;

        var best = sets.get(0);
        for(int setIndex = 1; setIndex < sets.size(); setIndex++)
            best = getBetter(best, sets.get(setIndex));

        return best;
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
        if(parent == null)
            return parent;

        // inverse
        BitSet child = (BitSet)parent.clone();
        int flipIndex = randomNumber.nextInt(items.length);
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
     * @param numberOfChildren The generated number of Children for each generation
     * @param maxGenerations Maximum number of generations
     * @param maxNoChangeGenerations Maximum number of generations without improvement
     * @return total execution time in miliseconds
     */
    public int solveHillClimbing(int numberOfChildren, int maxGenerations, int maxNoChangeGenerations){
        currentResult = new BitSet(items.length);

        executionMode = ExecutionMode.HILL_CLIMBING;
        var startTime = System.currentTimeMillis();
        int noChangeCounter = 0;

        // TODO: Consider using a destruction algorithm (e.g. bomb algorithm) to escape local maxima

        for(currentGeneration = 0;
            executionMode == ExecutionMode.HILL_CLIMBING &&
            currentGeneration != maxGenerations &&
            noChangeCounter < maxNoChangeGenerations; currentGeneration++)
        {
            var allExponats = new ArrayList<BitSet>();
            allExponats.add(currentResult);

            // TODO: Consider avoiding twins
            for(int childIndex = 0; childIndex < numberOfChildren; childIndex++)
                allExponats.add(mutate(currentResult));
        
            BitSet newResult = getBetter(allExponats); 
            if(currentResult == newResult)
                noChangeCounter++;
            else
                noChangeCounter = 0;

            currentResult = newResult;
        }

        executionMode = ExecutionMode.NONE;
        return (int)(System.currentTimeMillis() - startTime);
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