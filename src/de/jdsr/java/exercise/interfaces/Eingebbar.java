package de.jdsr.java.exercise.interfaces;

import java.io.IOException;

public interface Eingebbar 
{
	static final int MAX = 25;
	public abstract Object eingeben() throws IOException;
}
