package org.wecancodeit.masteryblog.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long categoryId;
	private String categoryName;
	
	@OneToMany (mappedBy= "category")
	private Collection<Post> post = new ArrayList<Post>();

	public Category() {
	}

	public Category(String categoryName) {
		this.categoryName = categoryName;
	}

	public Collection<Post> getPost() {
		return post;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

//	@Override
//	public String toString() {
//		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", post=" + post + "]";
//	}



}
