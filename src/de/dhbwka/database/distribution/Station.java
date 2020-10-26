package de.dhbwka.database.distribution;
import java.util.ArrayList;
import java.util.Arrays;
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
			// Transfer r (3) and key (1)
			mValuesTransferred += 4;
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
	 */
	public void computeJoinTransferOne(Station stationR, Station stationS) {
		var datas = Arrays.asList(stationR.mData, stationS.mData);
		datas.sort((a, b) -> b.size() - a.size());

		// transferred values from the smaller station to the larger station
		mValuesTransferred += 3 * datas.get(1).size();
		
		// store the join result in local table
		hashJoin(mData, datas.get(0).getIterator(), datas.get(1).getIterator());

		// transfer the values to the target Station
		mValuesTransferred += 5 * mData.size();
	}

	/**
	 * Join filtering one relation
	 */
	public void computeJoinFilterOne(Station stationR, Station stationS) {
		var datas = Arrays.asList(stationR.mData.data(), stationS.mData.data());
		datas.sort((a, b) -> b.size() - a.size());

        var keys = datas.get(0).stream().mapToInt(d -> d.c).boxed().collect(Collectors.toList());
		mValuesTransferred += keys.size();
		
		var semiJoin = datas.get(1).stream().filter(data -> keys.contains(data.c)).collect(Collectors.toList());
        mValuesTransferred += 3 * semiJoin.size();

        hashJoin(mData, datas.get(0).iterator(), semiJoin.iterator());
		mValuesTransferred += 5 * mData.size();
	}

	/**
	 * Join using hash
	 * @param stationR
	 * @param stationS
	 */
	public void computeJoinHash(Station stR, Station stS)
	{
		long hashMap = 0;
        for (Data data : stR.mData.data())
            hashMap |= 1 << (data.c & 63);
		
		mValuesTransferred += 2;

		final long finalHashMap = hashMap;
		List<Data> semiJoin = stS.mData.data().stream().filter(data -> (finalHashMap & (1 << (data.c & 63))) != 0).collect(Collectors.toList());
		mValuesTransferred += 3 * semiJoin.size();
        
        hashJoin(mData, semiJoin.iterator(), stR.mData.getIterator());
        mValuesTransferred += 5 * mData.size();
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

		// second step: combine all values from iterator2 with the values from the map
		iterator2.forEachRemaining(d1 -> map.getOrDefault(d1.c, new ArrayList<>()).forEach(d2 -> result.addData(new DataResult(d1, d2))));
	}
}

