
package de.dhbwka.database.objectrelational.publication;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


public class Author
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;

	@OneToMany(mappedBy="author")
	private List<Publication> publications = new ArrayList<>(); 

	public Author() {
		// default constructor for Mapping
	}
	
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Publication> getPublications() {
		return this.publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	@Override
	public String toString() {
		return String.format("Author(%s)", getName());
	}
}
