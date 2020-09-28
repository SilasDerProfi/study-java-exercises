package de.dhbwka.java.exam.quartets;

import java.util.HashMap;
import java.util.Map;

public class Card {

    private Map<Category, Integer> values;
    private String title;

    public Card(String title){
        this.title = title;
        values = new HashMap<Category, Integer>();
    }

    public void setValue(Category cat, Integer val){
        values.put(cat, val);
    }

    public Integer getValue(Category cat){
        return values.get(cat);
    }
    
    @Override
    public String toString() {
        return title;
    }
}
