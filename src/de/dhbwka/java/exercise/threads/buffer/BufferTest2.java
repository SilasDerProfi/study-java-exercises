package de.dhbwka.java.exercise.threads.buffer;

/**
 * BufferTest2
 */
public class BufferTest2 {

    public static void main(String args[]) {
        MyBuffer buf = new MyBuffer();
        ProducerThread thread1 = new ProducerThread(buf);
        thread1.start();
        ConsumerThread thread2 = new ConsumerThread(buf);
        thread2.start();
    }
}