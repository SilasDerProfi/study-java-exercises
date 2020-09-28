package de.jdsr.java.exercise.einkaufen;

import java.util.ArrayList;

public class Einkaufskorb
{

	public static void  main(String[] args)
	{
		ArrayList<Goods> waren = new ArrayList<Goods>();
		
		int preiseGesamt = 0;
		for (Goods goods : waren) {
			preiseGesamt += goods.getPreis();
		}
		
		System.out.println(Integer.toString(preiseGesamt));
		
	}
}
