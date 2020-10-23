package de.dhbwka.database.distribution;
import java.util.Iterator;

public class Station
{
	private DataTable mData = new DataTable();
	private int mValuesTransferred = 0;

	
	public DataTable getMData() {
		return this.mData;
	}
	
	public void resetDataTable() {
		mData = new DataTable();
	}

	public void resetValuesTransferred() {
		mValuesTransferred = 0;
	}
	
	public int getValuesTransferred() {
		return mValuesTransferred;
	}


	/**
	 * Merge-Join
	 * @param result
	 * @param jIt1
	 * @param jIt2
	 */
	public void mergeJoin(DataTable result, Iterator<Data> jIt1, Iterator<Data> jIt2) {
		// TODO: implement
	}
	

	/**
	 * Join with Nested Loops
	 * @param stR
	 * @param stS
	 */
	public void computeJoinNestedLoops(Station stR, Station stS) {
		// TODO: implement
	}
	

	/**
	 * Join transferring two relations
	 * @param stR
	 * @param stS
	 */
	public void computeJoinTransferTwo(Station stR, Station stS) {
		// TODO: implement
	}

	/**
	 * Join transferring one relation
	 * @param stR
	 * @param stS
	 */
	public void computeJoinTransferOne(Station stR, Station stS) {
		// TODO: implement
	}

	/**
	 * Join filtering one relation
	 * @param stR
	 * @param stS
	 */
	public void computeJoinFilterOne(Station stR, Station stS) {
		// TODO: implement
	}

	/**
	 * Join using hash
	 * @param stR
	 * @param stS
	 */
	public void computeJoinHash(Station stR, Station stS) {
		// TODO: implement
	}
}

