package de.dhbwka.evolution.knapsack;

import java.util.Arrays;
import java.util.List;

public class KnapsackTest {
    
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
            new Item(20,120),
            new Item(35,175),
            new Item(50,200),
            new Item(50,150),
            new Item(15,30),
            new Item(60,60)
        );

        Knapsack myBackpack = new Knapsack(100, items.toArray(new Item[0]));
        myBackpack.solveHillClimbing(10000);
        
        for(Item item : myBackpack.getCurrentResult()){
            System.out.println(item);
        }
    }
}
