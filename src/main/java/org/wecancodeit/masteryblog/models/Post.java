package org.wecancodeit.masteryblog.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
	private LocalDateTime time;
	@Lob
	private String body;

	@ManyToMany
	private Collection<Author> author;

	@ManyToOne
	private Category category;

	@ManyToMany
	private List<Tag> tags;

	public Post() {
	}

	public Post(String title, String body, String time, Category category, Author author) {
        this.title = title;
        this.body = body;
        this.category = category;
        this.time = LocalDateTime.now();
        this.author = new ArrayList<>();

	}

	public String getTitle() {
		return title;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public String getBody() {
		return body;
	}

	public Collection<Author> getAuthor() {
		return author;
	}

	public Category getCategory() {
		return category;
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	public void addTagToTags(Tag tag) {
		ArrayList<Tag> tags = new ArrayList<Tag>(this.getTags());
		tags.add(tag);
		this.tags = tags;
		
	}

	public Long getId() {
		return id;
	}
	

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", time=" + time + ", body=" + body + ", author=" + author
				+ ", category=" + category + ", tags=" + tags + "]";
	}

}