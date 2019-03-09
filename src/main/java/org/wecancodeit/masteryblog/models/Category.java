package org.wecancodeit.masteryblog.models;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;
	private String categoryName;

	@OneToMany
	private Collection<Post> posts;
	
	public Category() {
	}

	public Category(String name) {
		this.categoryName = name;
	}
	
	public Collection<Post> getPosts(){
		return posts;
		
	}

	public Long getId() {
		return id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + ", posts=" + posts + "]";
	}

	
	
	
	
	
}
