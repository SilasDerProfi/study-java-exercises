
package de.dhbwka.database.objectrelational.publication;

import javax.persistence.Entity;

@Entity(name="BlogPost")
public class BlogPost extends Publication
{
	private String url;


	public BlogPost() {
		// default constructor for Mapping
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return String.format("BlogPost(%s)", getTitle());
	}

}