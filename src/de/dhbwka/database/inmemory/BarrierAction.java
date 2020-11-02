package de.dhbwka.database.inmemory;

public class BarrierAction implements Runnable {
    private RadixPartition mRadixPartition;

    public BarrierAction(RadixPartition radixPartition) {
        mRadixPartition = radixPartition;
    }

    @Override
    public void run() {
        //
        // compute write indexes
        //
        // Worker 0 starts at index 0
        for (int j = 0; j < RadixPartition.N_WORKER; j++)
            mRadixPartition.getWorker(0).write(j, 0);

        // worker i (i > 0) starts where worker i - 1 ends
        for (int i = 1; i < RadixPartition.N_WORKER; i++) {
            for (int j = 0; j < RadixPartition.N_WORKER; j++) {
                Worker w = mRadixPartition.getWorker(i - 1);
                int startIndex = w.read(j) + w.readHistogram(j);
                mRadixPartition.getWorker(i).write(j, startIndex);
            }
        }
        // for i = N_WORKER we can compute the number
        // of coputers for each output area
        for (int j = 0; j < RadixPartition.N_WORKER; j++) {
            Worker w = mRadixPartition.getWorker(RadixPartition.N_WORKER - 1);
            int startIndex = w.read(j) + w.readHistogram(j);
            mRadixPartition.setOutputDataSize(j, startIndex);
        }
    }

}
