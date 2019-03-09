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
	private int year;
	@Lob
	private String body;

	@ManyToOne
	private Category category;
	
	@ManyToOne
	private Author author;
	
	@ManyToMany
	private Collection<Tag> tags;

	public Post() {}

	public Post(String title, Category category, int year, String body, Tag ...tags) {
		this.title = title;
		this.category = category;
		this.year = year;
		this.body = body;
		this.tags = Arrays.asList(tags);
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public String getBody() {
		return body;
	}

	public Category getCategory() {
		return category;
	}

	public Author getAuthors() {
		return author;
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	public void addTagToTags(Tag tag) {
		tags.add(tag);
	}
	
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", year=" + year + ", body=" + body + ", category=" + category
				+ ", author=" + author + ", tags=" + tags + "]";
	}
	
	


	
	

}
