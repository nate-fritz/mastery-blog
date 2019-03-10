package org.wecancodeit.masteryblog.models;

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
	private String time;
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

	public Post(String title, String body, String formatDateTime, Category category, Author author, Tag ...tags) {
        this.title = title;
        this.body = body;
        this.category= category;
        this.time = formatDateTime;
        this.authors = Arrays.asList(author);
        this.tags = Arrays.asList(tags);
	}

	public String getTitle() {
		return title;
	}

	public String getTime() {
		return time;
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