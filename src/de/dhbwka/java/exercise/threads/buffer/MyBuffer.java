package de.dhbwka.java.exercise.threads.buffer;

import java.util.LinkedList;

/**
 * MyBuffer
 */
public class MyBuffer {
    private final int MAXSIZE = 3;
    private LinkedList<Integer> value = new LinkedList<Integer>();

    public synchronized void put(int v) {
        if (value.size() >= MAXSIZE) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }

        this.value.add(0, v);
        this.notify();
        System.out.println("Put: " + v);
        System.out.println("Filling level after put: " + value.size());
        sleep();
    }

    private void sleep() {
        try {
            Thread.sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
        }
    }

    public synchronized int get() {
        int v;
        if (value.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        v = this.value.pop();
        
        this.notify();
        System.out.println("Get:" + v);
        System.out.println("Filling level after get: " + value.size());
        sleep();
        return v;
    }
}