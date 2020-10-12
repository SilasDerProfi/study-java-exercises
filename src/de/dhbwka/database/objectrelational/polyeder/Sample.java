package de.dhbwka.database.objectrelational.polyeder;

import java.util.List;

import javax.persistence.*;


public class Sample
{
	private static EntityManager entityManager;

	public static void main(String[] args)
	{
		// Open a database connection
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("polyeder");
		entityManager = emf.createEntityManager();

		listPolyeders();
		System.out.println();
		getPerimeter("poly#88322");
		movePolyeder("poly#88322", 1, 2, 3);
	}

	private static void listPolyeders() {
		try {
			entityManager.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Polyeder> polyeders = entityManager.createQuery("SELECT p FROM Polyeder p").getResultList();
			for (Polyeder p : polyeders) {
				System.out.println(p);
			}
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR(listPolyeders): " + e.getMessage());
			entityManager.getTransaction().rollback();
		}
	}

	private static void getPerimeter(String polyName) {
		try {
			entityManager.getTransaction().begin();
			TypedQuery<Polyeder> query = entityManager.createQuery(
					"SELECT p FROM Polyeder p WHERE p.name=:name", Polyeder.class);
			Polyeder p = query.setParameter("name", polyName).getSingleResult();

			System.out.println(String.format("Perimeter for %s is %f", polyName, p.getPerimeter()));

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR(getPerimeter): " + e.getMessage());
			entityManager.getTransaction().rollback();
		}
	}

	private static void movePolyeder(String polyName, double dx, double dy, double dz) {
		try {
			entityManager.getTransaction().begin();
			TypedQuery<Polyeder> query = entityManager.createQuery(
					"SELECT p FROM Polyeder p WHERE p.name=:name", Polyeder.class);
			Polyeder p = query.setParameter("name", polyName).getSingleResult();

			System.out.println(p.getFaces().get(0).getEdges().get(0).getP1());
			p.move(dx, dy, dz);
			System.out.println(p.getFaces().get(0).getEdges().get(0).getP1());

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR(getPerimeter): " + e.getMessage());
			entityManager.getTransaction().rollback();
		}
	}
}
