package de.dhbwka.evolution.knapsack;

public class Item {
    private int weight;
    private int value;

    public Item(int weight, int value){
        this.weight = weight;
        this.value = value;
    }

    public int getWeight(){
        return weight;
    }

    public int getValue(){
        return value;
    }

    @Override
    public String toString() {
        return weight + " kg, " + value + " €";
    }
}
