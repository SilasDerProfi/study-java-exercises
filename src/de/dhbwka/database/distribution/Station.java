package de.dhbwka.database.distribution;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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
	 * Join with Nested Loops
	 */
	public void computeJoinNestedLoops(Station stationR, Station stationS) {
		stationR.mData.getIterator().forEachRemaining(r -> {
			mValuesTransferred += 3;
			
			// get matching rows from S
			stationS.getByKey(r.c).forEachRemaining(s -> mData.addData(new DataResult(r, s)));
		});
	}

	/**
	 * Join transferring two relations
	 */
	public void computeJoinTransferTwo(Station stationR, Station stationS) {
		hashJoin(mData, stationR.mData.getIterator(), stationS.mData.getIterator());
		mValuesTransferred += 3 * (stationR.mData.size() + stationS.mData.size());
	}

	/**
	 * Join transferring one relation
	 * @param stationR
	 * @param stationS
	 */
	public void computeJoinTransferOne(Station stationR, Station stationS) {
		// TODO: implement
	}

	/**
	 * Join filtering one relation
	 * @param stationR
	 * @param stationS
	 */
	public void computeJoinFilterOne(Station stationR, Station stationS) {
		// TODO: implement
	}

	/**
	 * Join using hash
	 * @param stationR
	 * @param stationS
	 */
	public void computeJoinHash(Station stationR, Station stationS) {
		// TODO: implement
	}

	
	private Iterator<Data> getByKey(int key) {
		var result = mData.data().stream().filter(s -> s.c == key).collect(Collectors.toList());
		mValuesTransferred += 3 * result.size();
		return result.iterator();
	}
	
	/**
	 * Hash-Join
	 */
	private void hashJoin(DataTable result, Iterator<Data> iterator1, Iterator<Data> iterator2) {
		var map = new HashMap<Integer, List<Data>>();
		
		// first step: add all tuples from iterator1 to a map
		iterator1.forEachRemaining(d -> map.computeIfAbsent(d.c, key -> new ArrayList<>()).add(d));

		//second step: combine all values from iterator2 with the values from the map
		iterator2.forEachRemaining(d1 -> map.getOrDefault(d1.c, new ArrayList<>()).forEach(d2 -> result.addData(new DataResult(d1, d2))));
	}
}

