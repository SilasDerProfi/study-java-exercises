package de.dhbwka.database.inmemory;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class RadixPartition {
	// #region Config
	public static final int N_MASK_BITS = 1;
	public static final int N_WORKER = (1 << N_MASK_BITS);
	public static final int N_DATA = 6 * N_WORKER; // must be multiple of N_WORKER
	public static final int N_BITS_VALUE = 6; // number of bits for our test data
	public static final int MAX_VALUE = (1 << N_BITS_VALUE);
	// #endregion

	// #region IO
	private int[] mInputData = new int[N_DATA];
	private int[][] mOutputData = new int[N_WORKER][N_DATA];
	private int[] mOutputDataSize = new int[N_WORKER];

	private Worker[] mWorkers = new Worker[N_WORKER];
	// #endregion

	private CyclicBarrier mBarrier = new CyclicBarrier(N_WORKER, new BarrierAction(this));

	public static void main(String[] args) {
		RadixPartition rp = new RadixPartition();
		rp.partition();
		System.out.println("done.");
	}

	private void partition() {
		// createInputData
		for (int i = 0; i < N_DATA; i++)
			mInputData[i] = ThreadLocalRandom.current().nextInt(0, MAX_VALUE);

		dumpArray("input", mInputData, mInputData.length);

		for (int i = 0; i < N_WORKER; i++) {
			mWorkers[i] = new Worker(i, this);
			mWorkers[i].start();
		}

		try {
			for (int i = 0; i < N_WORKER; i++) {
				mWorkers[i].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < N_WORKER; i++)
			dumpArray("output " + i, mOutputData[i], mOutputDataSize[i]);
	}

	private void dumpArray(String name, int[] array, int size) {
		System.out.print(name + ": ");
		for (int i = 0; i < size; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}

	public Worker getWorker(int i) {
		return mWorkers[i];
	}

	public void setOutputDataSize(int index, int size) {
		mOutputDataSize[index] = size;
	}

	public void awaitBarrier() {
		try {
			mBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

	public int getInputData(int index) {
		return mInputData[index];
	}

	public void setOutputData(int indexA, int indexB, int value) {
		mOutputData[indexA][indexB] = value;
	}
}
