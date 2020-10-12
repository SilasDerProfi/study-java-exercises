package de.dhbwka.database.objectrelational.publication;

import java.util.Date;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Publication_Type")
public abstract class Publication
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String title;
	private Date publishingDate;

	
	@ManyToOne
	Author author;
	
	public Publication() {
		// default constructor for Mapping
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublishingDate() {
		return this.publishingDate;
	}

	public void setPublishingDate(Date publishingDate) {
		this.publishingDate = publishingDate;
	}
	
	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return String.format("Publication(%s)", getTitle());
	}
}
