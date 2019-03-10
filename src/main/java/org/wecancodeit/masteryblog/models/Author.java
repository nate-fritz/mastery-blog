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
	
	@ManyToMany(mappedBy="authors")
	private Collection<Post> posts;
		
	public Author() {}

	public Author(String author) {
		this.author = author;
	}

	public Collection<Post> getPosts() {
		return posts;
	}
	
	
	public Long getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}
	
	
	public void addPostsToAuthor(Collection<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", author=" + author + ", posts=" + posts + "]";
	}




	
	
}
	