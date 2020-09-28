package de.jdsr.java.exercise.beispiele;

public class foreachSuche {

	public static void main(String[] args) {

		int feld[] = {1, 2, 3, 4, 8, 13, 21, 34, 55, 89, 144, 233, 377, 670, 987};
		int element = 144;
		for(int zahl : feld){
			if(zahl == element){
				System.out.println("gefunden");
				break;
			}
			System.out.println("nicht gefunden.");
		}
		int aktuellerFeldIndex = 0;
		for(int zahl : feld){
			feld[aktuellerFeldIndex] = zahl++;
			aktuellerFeldIndex++;
		}
	}

}