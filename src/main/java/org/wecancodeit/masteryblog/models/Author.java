package org.wecancodeit.masteryblog.models;


import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Author {

	@Id
	@GeneratedValue
	private Long id;
	private String author;
	
	@ManyToMany
	private Collection<Post> posts;
		
	public Author() {}

	public Author(String author) {
		this.author = author;
	}

	public Author(String author, Collection<Post> post) {
		this.author = author;
		this.posts = post;
	}
	
	public Long getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public Collection<Post> getPosts() {
		return posts;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", author=" + author + ", posts=" + posts + "]";
	}



	
	
}
	