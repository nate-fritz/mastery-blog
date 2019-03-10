package org.wecancodeit.masteryblog.models;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private LocalDateTime dateTime;
	
	@Lob
	private String body;

	@ManyToMany
	private Collection<Author> authors;

	@ManyToOne
	private Category category;

	@ManyToMany
	private Collection<Tag> tags;

	
			
	public Post() {
	}

	public Post(String title, String body, Category category, Author author, Tag ...tags) {
        this.title = title;
        this.body = body;
        this.category= category;
        this.dateTime= LocalDateTime.now();
        this.authors = Arrays.asList(author);
        this.tags = Arrays.asList(tags);
	}

	public String getTitle() {
		return title;
	}

	



	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public String getBody() {
		return body;
	}

	public Collection<Author> getAuthors() {
		return authors;
	}

	public Category getCategory() {
		return category;
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	public void addTagToTags(Tag tag) {
		tag.add(tag);
		
	}

	public Long getId() {
	
		return id;
	}

}