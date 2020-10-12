
package de.dhbwka.database.objectrelational.publication;

import javax.persistence.*;

@Entity(name="Book")
public class Book extends Publication
{
	private boolean isHardcover;
	private int numPages;

	public Book() {
		// default constructor for Mapping
	}

	public boolean isIsHardcover() {
		return this.isHardcover;
	}

	public void setIsHardcover(boolean isHardcover) {
		this.isHardcover = isHardcover;
	}

	public int getNumPages() {
		return this.numPages;
	}

	public void setNumPages(int numPages) {
		this.numPages = numPages;
	}
	
	@Override
	public String toString() {
		return String.format("Book(%s)", getTitle());
	}
}