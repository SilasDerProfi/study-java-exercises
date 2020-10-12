
package de.dhbwka.database.objectrelational.publication;

import java.util.Date;

import javax.persistence.*;


public class Sample
{
	private static EntityManager entityManager;
	
	private static Author author;

	public static void main(String[] args)
	{
		// Open a database connection
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("publication");
		entityManager = emf.createEntityManager();

		deleteAll();
		createAuthor();
		createBooks();
		createBlogPosts();
		
		System.out.println("done.");
	}
	
	private static void deleteAll() {
		try {
			entityManager.getTransaction().begin();
			entityManager.createQuery("DELETE FROM Book b").executeUpdate();
			entityManager.createQuery("DELETE FROM BlogPost b").executeUpdate();
			entityManager.createQuery("DELETE FROM Publication p").executeUpdate();
			entityManager.createQuery("DELETE FROM Author a").executeUpdate();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR(createAuthor): " + e.getMessage());
			entityManager.getTransaction().rollback();
		}
	}

	private static void createAuthor() {
		try {
			entityManager.getTransaction().begin();
			author = new Author();
			author.setName("Yoda");
			entityManager.persist(author);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR(createAuthor): " + e.getMessage());
			entityManager.getTransaction().rollback();
		}
	}

	private static void createBooks() {
		try {
			entityManager.getTransaction().begin();
			// Book 1
			Book b = new Book();
			b.author = author;
			b.setTitle("The Force Compendium, Part 1");
			b.setPublishingDate(new Date());
			b.setNumPages(739);
			b.setIsHardcover(true);
			entityManager.persist(b);
			author.getPublications().add(b);
			// Book 2
			b = new Book();
			b.author = author;
			b.setTitle("The Force Compendium, Part 2");
			b.setPublishingDate(new Date());
			b.setNumPages(834);
			b.setIsHardcover(true);
			entityManager.persist(b);
			author.getPublications().add(b);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR(createAuthor): " + e.getMessage());
			entityManager.getTransaction().rollback();
		}
	}

	private static void createBlogPosts() {
		try {
			entityManager.getTransaction().begin();
			// BlogPost 1
			BlogPost b = new BlogPost();
			b.author = author;
			b.setTitle("How to recognize a Sith Lord");
			b.setPublishingDate(new Date());
			b.setUrl("http://jedi.org/blog/1");
			entityManager.persist(b);
			author.getPublications().add(b);
			// BlogPost 2
			b = new BlogPost();
			b.author = author;
			b.setTitle("May the Force be with you");
			b.setPublishingDate(new Date());
			b.setUrl("http://jedi.org/blog/2");
			entityManager.persist(b);
			author.getPublications().add(b);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR(createAuthor): " + e.getMessage());
			entityManager.getTransaction().rollback();
		}
	}
}

