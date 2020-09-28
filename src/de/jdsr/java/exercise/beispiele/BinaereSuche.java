package de.jdsr.java.exercise.beispiele;

public class BinaereSuche {

	public static void main(String[] args) {
		int[] feld = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987};
		
		int unten = 0;
		int oben = feld.length - 1;
		int element = 144;
		int mitte = 0;
		boolean gefunden = false;
		
		while(!gefunden  && unten <= oben){
			mitte = Math.abs((unten + oben) / 2);
			if(feld[mitte] == element){
				gefunden = true;
			}
			else{
				if(feld[mitte] > element){
					oben = mitte -1;
				}
				else{
					unten = mitte + 1;
				}
			}
		}
		
		if(!gefunden){
			mitte = -1;
		}
		
		System.out.println(mitte);
	}

}
