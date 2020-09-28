package de.jdsr.java.exercise.geodaten;
import java.util.Scanner;


public class SatelitenschuesselAusrichtung {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Eigene Position: ");
		System.out.print("  Breitengrad: ");
		double a  = in.nextDouble()  * (Math.PI/180);
		System.out.print("  Laengengrad: ");
		double l = in.nextDouble();
		
		double sl = 19.2;
		double s = 7;
		
		double b = (sl - l) * (Math.PI/180);
		double x = Math.sin(b) * 42164;
		
		double y = (Math.cos(b) * Math.cos(a) * 42164) - 6378;
		double z = Math.cos(b) * Math.sin(a) * (-42164);
		
		double elevation = (180/Math.PI) * Math.atan(y / (Math.sqrt(Math.pow(x, 2) + Math.pow(z, 2))));
		double azimut = getAzimut(x, z);
		double lnbSkew = s -(180/Math.PI) * (Math.sin(b) * Math.cos(a)) / Math.sin(a);
		
		System.out.println("Elevation: " + elevation);
		System.out.println("Azimut: " + azimut);
		System.out.println("LNB-Skew: " + lnbSkew);
		in.close();
	}
	
	private static double getAzimut(double x, double z)
	{
		double azimut = 0;
		
		if(z <= 0){
			if(x == 0){
				return 0;
			}
			else if(x > 0){
				return 90 + (180/Math.PI) * Math.atan(Math.abs(z)/Math.abs(x));
			}
			else if(x < 0){
				return 90 - (180/Math.PI) * Math.atan(Math.abs(z)/Math.abs(x));
			}
		}
		else if(z > 0){
			if(x == 0){
				return 180;
			}
			else if(x > 0){
				return 270 - (180/Math.PI) * Math.atan(Math.abs(z)/Math.abs(x));
			}
			else if(x < 0){
				return 270 + (180/Math.PI) * Math.atan(Math.abs(z)/Math.abs(x));
			}
		}
		
		return azimut;
	}

}
