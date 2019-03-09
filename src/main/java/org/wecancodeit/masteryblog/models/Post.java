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
	private String imgUrl;

	@ManyToOne
	private Category category;

	@ManyToMany
	private Collection<Tag> tags;

	@ManyToOne
	private Author author;

	public Post() {
	}

	public Post(String title, int year, String body, String imgUrl) {

		this.title = title;
		this.year = year;
		this.body = body;
//		this.imgUrl = imgUrl;
//		this.category = category;
//		this.tags = Arrays.asList(tags);
//		this.author = author;
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

	public String getImgUrl() {
		return imgUrl;
	}

	public Category getCategory() {
		return category;
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	public Author getAuthor() {
		return author;
	}

	public void addTagToTags(Tag tag) {
		tags.add(tag);
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", year=" + year + ", body=" + body + ", imgUrl=" + imgUrl
				+ ", category=" + category + ", tags=" + tags + ", author=" + author + "]";
	}

}
