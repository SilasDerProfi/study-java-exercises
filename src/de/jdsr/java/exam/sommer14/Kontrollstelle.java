package de.jdsr.java.exam.sommer14;

public class Kontrollstelle {
	@SuppressWarnings("unused")
	private int kontrAbt = 0;
	
	public Kontrollstelle(int abt){
		
	}
	
	@SuppressWarnings("static-access")
	public void kontrollieren(Fenster myWin){
		while(true)
		{
			switch (myWin.pruefen()) {
			case 1:
				myWin.setZustand("inOrdnung");
				return;
			case 2:
				myWin.setZustand("Nachbessern");
				nachbessern();
				break;
			case 3:
				myWin.setZustand("Ausschuss");
				myWin.ausschuss++;
				return;
			}
		}
	}
	
	public void nachbessern(){
		
	}
}
