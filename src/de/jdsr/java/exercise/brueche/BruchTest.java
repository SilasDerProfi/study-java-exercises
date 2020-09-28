package de.jdsr.java.exercise.brueche;

import java.io.*;

public class BruchTest {

	public static void main(String[] args) throws IOException {

		int zaehler;
		int nenner;
		String str;
		int ggT;

		Bruch bruchEins = new Bruch();
		Bruch bruchZwei = new Bruch();

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Bitte geben Sie den Zaehler ein: ");
		str = input.readLine();
		zaehler = Integer.parseInt(str);
		System.out.println("Bitte geben Sie den Nenner ein: ");
		str = input.readLine();
		nenner = Integer.parseInt(str);

		ggT = bruchEins.ggT(nenner, zaehler);
		zaehler = zaehler / ggT;
		nenner = nenner / ggT;
		bruchEins.setZaehlerUndNenner(zaehler, nenner);

		System.out.println("Bitte geben Sie den 2. Zaehler ein: ");
		str = input.readLine();
		zaehler = Integer.parseInt(str);
		System.out.println("Bitte geben Sie den 2. Nenner ein: ");
		str = input.readLine();
		nenner = Integer.parseInt(str);

		ggT = bruchZwei.ggT(nenner, zaehler);
		zaehler = zaehler / ggT;
		nenner = nenner / ggT;
		bruchZwei.setZaehlerUndNenner(zaehler, nenner);

		bruchEins.addition(bruchZwei);
		System.out.println(bruchEins);

		Bruch.GEMISCHTER_BRUCH = true;
		System.out.println("Der erste Bruch lautet " + bruchEins);

		Bruch.GEMISCHTER_BRUCH = false;
		System.out.println("Der zweite Bruch lautet " + bruchZwei);
	}

}
