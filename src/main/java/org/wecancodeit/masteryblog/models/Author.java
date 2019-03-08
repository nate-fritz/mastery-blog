package org.wecancodeit.masteryblog.models;

import java.util.Arrays;
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
	private String name;
	
	@ManyToMany
	private Collection<Post> posts;
	
	public Author() {}
	
	public Author(String name, Post ...posts) {
		this.name = name;
		this.posts = Arrays.asList(posts);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<Post> getPosts() {
		return posts;
	}
	
	public void addPostToPosts(Post post) {
		posts.add(post);
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", posts=" + posts + "]";
	}
	
	
}
