package org.wecancodeit.masteryblog.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {

	@Id
	@GeneratedValue
	private Long id;
	private String name;

	@OneToMany(mappedBy = "author")
	private Collection<Post> posts;

	public Author() {
	}

	public Author(String name, Collection<Post> posts) {
		super();
		this.name = name;
		this.posts = posts;
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

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", posts=" + posts + "]";
	}

	public void addPostToPosts(Post post) {
		posts.add(post);
		
	}

}
