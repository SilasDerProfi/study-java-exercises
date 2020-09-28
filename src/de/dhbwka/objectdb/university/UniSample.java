package de.dhbwka.objectdb.university;

import javax.persistence.*;
import java.util.*;
public class UniSample {
    
    public static void main(String[] args)
    {
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("unibeispiel.odb");
        EntityManager em = emf.createEntityManager();

        if (true) {  // set to false, once the DB exists
        	System.out.println("Creating some employees...");
            em.getTransaction().begin();
        	em.persist(new Professor("Peter"));
        	em.persist(new Professor("Paul"));
        	em.persist(new Professor("Mary"));
        	em.persist(new Employee("Alice"));
        	em.persist(new Employee("Bob"));
            em.getTransaction().commit();
        }

        // List all Employees from the database:
        System.out.println("Employees:");
        TypedQuery<Employee> queryEmployees =
            em.createQuery("SELECT e FROM Employee e", Employee.class);
        List<Employee> resultsEmployees = queryEmployees.getResultList();
        for (Employee e : resultsEmployees) {
            System.out.println("  " + e);
        }

        // List all Professors from the database:
        System.out.println("Professors:");
        TypedQuery<Professor> queryProfessors =
            em.createQuery("SELECT p FROM Professor p", Professor.class);
        List<Professor> resultsProfessors = queryProfessors.getResultList();
        for (Professor p : resultsProfessors) {
            System.out.println("  " + p);
        }

        // Close the database connection:
        em.close();
        emf.close();
    }
}