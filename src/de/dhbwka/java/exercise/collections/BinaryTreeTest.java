package de.dhbwka.java.exercise.collections;

import java.util.Random;

/**
 * BinaryTreeTest
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        Random r = new Random();
        BinaryTree<Integer> bt = new BinaryTree<Integer>();
        for (int i = 0; i < 10; i++)
            bt.add(r.nextInt(101));

        System.out.println(bt.toString());
        System.out.println();

        for (Integer i : bt.traverse())
            System.out.print(i + " ");
            System.out.println();
    }
}