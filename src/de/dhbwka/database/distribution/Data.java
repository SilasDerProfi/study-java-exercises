package de.dhbwka.database.distribution;

import java.util.Objects;

public abstract class Data
	implements Comparable<Data>
{
	protected int c;

	protected Data() {
		c = randVal();
	}

	protected int randVal() {
		return (int)Math.round(DistributedJoin.MAXVALUE * Math.random());
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		
		if (!(o instanceof Data))
			return false;
	
		return compareTo((Data)o) == 0;
	}


	@Override
	public int hashCode() {
		return Objects.hashCode(c);
	}
}
