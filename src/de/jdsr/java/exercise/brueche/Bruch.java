package de.jdsr.java.exercise.brueche;

public class Bruch {
	private int zaehler;
	private int nenner;

	public static boolean GEMISCHTER_BRUCH = true;

	public String toString() {

		if (GEMISCHTER_BRUCH) {
			String gemischterBruch = Integer.toString(zaehler / nenner) + " ";
			gemischterBruch += Integer.toString(zaehler % nenner) + "/" + nenner;
			return gemischterBruch;
		} else
			return this.zaehler + "/" + this.nenner;
	}

	public void setZaehlerUndNenner(int zaehler, int nenner) {
		this.setNenner(nenner);
		this.setZaehler(zaehler);
	}

	public void setZaehler(int zaehler) {
		this.zaehler = zaehler;
	}

	public int getZaehler() {
		return this.zaehler;
	}

	public void setNenner(int nenner) {
		if (nenner != 0) {
			this.nenner = nenner;
		} else {
			System.out.println("Nenner darf nicht 0 sein!!");
		}
	}

	public int getNenner() {
		return this.nenner;
	}

	public int ggT(Bruch b)
	{
		return ggT(b.nenner, b.zaehler);
	}

	public int ggT(int nenner, int zaehler) {
		int r = zaehler % nenner;
		while (r != 0) {
			r = zaehler % nenner;
			if (r != 0) {
				zaehler = nenner;
				nenner = r;
			}
		}

		return nenner;

	}

	public void addition(Bruch bruch) {
		if (bruch.getNenner() == this.nenner) {
			this.zaehler = this.zaehler + bruch.getZaehler();
		} else {
			this.zaehler = (this.zaehler * bruch.getNenner()) + (bruch.getZaehler() * this.getNenner());
			this.nenner = this.nenner * bruch.getNenner();
		}
	}

	public void subtraktion(Bruch bruch) {
		if (bruch.getNenner() == this.nenner) {
			this.zaehler = this.zaehler - bruch.getZaehler();
		} else {
			System.out.println(
					this.zaehler + "*" + bruch.getZaehler() + "-" + bruch.getZaehler() + "*" + this.getNenner());
			this.zaehler = (this.zaehler * bruch.getNenner()) - (bruch.getZaehler() * this.getNenner());
			this.nenner = this.nenner * bruch.getNenner();
		}
	}

	public void multiplikation(Bruch bruch) {
		this.zaehler = this.zaehler * bruch.getZaehler();
		this.nenner = this.nenner * bruch.getNenner();
	}

	public static Bruch multiplikation(Bruch bruchEins, Bruch bruchZwei) {
		Bruch result = new Bruch();
		result.nenner = bruchEins.nenner * bruchZwei.nenner;
		result.zaehler = bruchEins.zaehler * bruchZwei.zaehler;
		return result;
	}

	public void addition(int zahl) {
		Bruch bruch = new Bruch();
		bruch.setZaehler(zahl);
		bruch.setNenner(1);
		if (bruch.getNenner() == this.nenner) {
			this.zaehler = this.zaehler + bruch.getZaehler();
		} else {
			this.zaehler = (this.zaehler * bruch.getNenner()) + (bruch.getZaehler() * this.getNenner());
			this.nenner = this.nenner * bruch.getNenner();
		}
	}

	public void subtraktion(int zahl) {
		Bruch bruch = new Bruch();
		bruch.setZaehler(zahl);
		bruch.setNenner(1);

		if (bruch.getNenner() == this.nenner) {
			this.zaehler = this.zaehler - bruch.getZaehler();
		} else {
			System.out.println(
					this.zaehler + "*" + bruch.getZaehler() + "-" + bruch.getZaehler() + "*" + this.getNenner());
			this.zaehler = (this.zaehler * bruch.getNenner()) - (bruch.getZaehler() * this.getNenner());
			this.nenner = this.nenner * bruch.getNenner();
		}
	}

	public void multiplikation(int zahl) {
		Bruch bruch = new Bruch();
		bruch.setZaehler(zahl);
		bruch.setNenner(1);

		this.zaehler = this.zaehler * bruch.getZaehler();
		this.nenner = this.nenner * bruch.getNenner();
	}

}
