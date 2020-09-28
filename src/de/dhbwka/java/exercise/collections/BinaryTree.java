package de.dhbwka.java.exercise.collections;

import java.util.*;

/**
 * BinaryTree
 */
public class BinaryTree<T extends Comparable<T>> {
    private BinaryTree<T> left;
    private BinaryTree<T> right;
    private T k;

    public boolean add(T newValue) {
        if (newValue == null) {
            return false;
        } else if (k != null) {
            switch (newValue.compareTo(k)) {
            case -1:
                return left.add(newValue);
            case 1:
                return right.add(newValue);
            default:
                return false;
            }
        } else {
            k = newValue;
            left = new BinaryTree<T>();
            right = new BinaryTree<T>();
            return true;
        }
    }

    public T getValue() {
        return k;
    }

    public List<T> traverse() {
        List<T> sorted = new ArrayList<T>();

        if (getValue() != null) {
            sorted.addAll(left.traverse());
            sorted.add(getValue());
            sorted.addAll(right.traverse());
        }
        return sorted;
    }
    
    @Override
    public String toString(){
        return getValue() == null ? "" : getValue() + "(" +  left + right + ")";
    }
}