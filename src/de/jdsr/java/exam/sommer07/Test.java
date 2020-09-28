package de.jdsr.java.exam.sommer07;

/**
 * 
 * @author Silas Schnurr
 *
 */

public class Test 
{
	public static void main(String[] args) 
	{
		Club clubDerTotenFilme = new Club();
		clubDerTotenFilme.derFilm.add(new Film("Club der toten Dichter", "Peter Weir"));
		clubDerTotenFilme.derFilm.add(new Film("Fight Club", "David Fincher"));
		clubDerTotenFilme.derGast.add(new Gast("Marco", clubDerTotenFilme));
		clubDerTotenFilme.derGast.add(new Gast("Tobias", clubDerTotenFilme));
		clubDerTotenFilme.derGast.add(new Gast("Silas", clubDerTotenFilme));
		clubDerTotenFilme.dieGruppe.add(new Gruppe("Klubbb 3", "Schlager"));
		clubDerTotenFilme.dieGruppe.add(new Gruppe("Klub 27", "Rock- und Bluesmusiker"));
		clubDerTotenFilme.derGast.get(0).wunschFilm.add(clubDerTotenFilme.gibFilm("Fight Club"));
		clubDerTotenFilme.derGast.get(1).wunschGruppe.add(clubDerTotenFilme.dieGruppe.get(0));
		clubDerTotenFilme.derGast.get(2).wunschFilm.add(clubDerTotenFilme.gibFilm("Fight Club"));
		clubDerTotenFilme.derGast.get(2).wunschGruppe.add(clubDerTotenFilme.dieGruppe.get(1));
		clubDerTotenFilme.derGast.get(2).wunschFilm.add(clubDerTotenFilme.gibFilm("Club der toten Dichter"));
		clubDerTotenFilme.derGast.get(2).wunschGruppe.add(clubDerTotenFilme.dieGruppe.get(0));
		
		ausgebenAlleFilme(clubDerTotenFilme);
		
		String filmName = "Clubhouse";
		System.out.println("Suche nach Film: " + filmName + "...");
		Film clubhouseFilm = clubDerTotenFilme.gibFilm(filmName);
		System.out.println("Film: " + clubhouseFilm.getTitel());
		System.out.println("-------------------------------------");
		System.out.println();
		
		ausgebenAlleFilme(clubDerTotenFilme);
		
		System.out.println("Alle G�ste und deren wunschFilme:");
		for(Gast g : clubDerTotenFilme.derGast)
		{
			System.out.print(g.getName() + " (");
			
			StringBuilder filme = new StringBuilder();
			
			for(Film f : g.wunschFilm)
				filme.append(f.getName() + ", ");
			
			if(filme.length() > 2)
				filme = filme.replace(filme.length() - 2, filme.length(), "");
			
			System.out.println(filme.toString() + ")");
		}
		System.out.println("-------------------------------------");
		System.out.println();
		
		System.out.println("Alle G�ste und deren wunschGruppe:");
		for(Gast g : clubDerTotenFilme.derGast)
		{
			System.out.print(g.getName() + " (");
			
			StringBuilder gruppen = new StringBuilder();
			
			for(Gruppe gr : g.wunschGruppe)
				gruppen.append(gr.getName() + ", ");
			
			if(gruppen.length() > 2)
				gruppen = gruppen.replace(gruppen.length() - 2, gruppen.length(), "");
			
			System.out.println(gruppen.toString() + ")");
		}
	}
	
	private static void ausgebenAlleFilme(Club c)
	{
		System.out.println("Alle Filme:");
		for(Film f : c.derFilm)
			System.out.println(f.getTitel());
		System.out.println("-------------------------------------");
		System.out.println();
	}

}
