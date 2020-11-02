package de.dhbwka.database.inmemory;

public class Worker extends Thread {
    private int mIndex;
    private int[] mHistogram = new int[RadixPartition.N_WORKER];
    private int[] mWriteIndex = new int[RadixPartition.N_WORKER];
    private RadixPartition mRadixPartition;

    Worker(int index, RadixPartition radixPartition) {
        mIndex = index;
        mRadixPartition = radixPartition;
    }

    @Override
    public void run() {
        // 1. split data int N_WORKER Chunks
        int size = RadixPartition.N_DATA / RadixPartition.N_WORKER;
        int start = mIndex * size;
        int end = start + size;
        if (mIndex == 0)
            end += RadixPartition.N_DATA % RadixPartition.N_WORKER;

        // 2. Histogram
        for (int i = start; i < end; i++) {
            int bucket = getBucket(mRadixPartition.getInputData(i));
            mHistogram[bucket]++;
        }

        // 3. Synchronisation
        // wait for all threads to call mBarrier,await()
        mRadixPartition.awaitBarrier();

        // all write indexes have been computed in the barrier action

        // copy data to output areas
        for (int i = start; i < end; i++) {
            int value = mRadixPartition.getInputData(i);
            int bucket = getBucket(value);
            int j = mWriteIndex[bucket]++;
            mRadixPartition.setOutputData(bucket, j, value);
        }
    }

    private int getBucket(int value) {
        int lowBits = RadixPartition.N_BITS_VALUE - RadixPartition.N_MASK_BITS;
        value >>= lowBits;
        int bitMask = (1 << RadixPartition.N_MASK_BITS) - 1;
        return value & bitMask;
    }

    public void write(int index, int value) {
        mWriteIndex[index] = value;
    }

    public int read(int index) {
        return mWriteIndex[index];
    }

    public int readHistogram(int index) {
        return mHistogram[index];
    }
}