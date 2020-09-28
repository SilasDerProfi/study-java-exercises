package de.jdsr.java.exam.sommer15;

public class KuenstlerAuftritt {
	private String datum;
	private String uhrzeit;
	private String dauerInStunden;
	private Kuenstlergruppe aufgetreteneGruppe;
	
	public KuenstlerAuftritt(String datum, String uhrzeit, String dauerInStunden, Kuenstlergruppe aufgetreteneGruppe){
		this.datum = datum;
		this.uhrzeit = uhrzeit;
		this.dauerInStunden = dauerInStunden;
		this.aufgetreteneGruppe = aufgetreteneGruppe;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getUhrzeit() {
		return uhrzeit;
	}

	public void setUhrzeit(String uhrzeit) {
		this.uhrzeit = uhrzeit;
	}

	public String getDauerInStunden() {
		return dauerInStunden;
	}

	public void setDauerInStunden(String dauerInStunden) {
		this.dauerInStunden = dauerInStunden;
	}

	public Kuenstlergruppe getAufgetreteneGruppe() {
		return aufgetreteneGruppe;
	}

	public void setAufgetreteneGruppe(Kuenstlergruppe aufgetreteneGruppe) {
		this.aufgetreteneGruppe = aufgetreteneGruppe;
	}
	
	
}
