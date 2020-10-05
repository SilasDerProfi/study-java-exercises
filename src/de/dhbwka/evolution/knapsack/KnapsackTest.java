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
            new Item(60,60),
            new Item(35,175),
            new Item(50,200),
            new Item(50,150),
            new Item(15,30),
            new Item(60,60),
            new Item(35,175),
            new Item(50,200),
            new Item(50,150),
            new Item(15,30),
            new Item(60,60)
        );

        Knapsack myBackpack = new Knapsack(200, items.toArray(new Item[0]));
        myBackpack.solveHillClimbing(10000);
        
        int weight = 0;
        int value = 0;
        for(Item item : myBackpack.getCurrentResult()){
            System.out.println(item);
            weight += item.getWeight();
            value += item.getValue();
        }
        System.out.println("-----------------");
        System.out.println(weight + " kg, " + value + " €");
    }
}
