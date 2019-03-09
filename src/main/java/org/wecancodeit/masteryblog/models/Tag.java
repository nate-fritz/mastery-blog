package org.wecancodeit.masteryblog.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long id;
	private String tagLabel;

	@ManyToMany(mappedBy="tags")
	private Collection<Post> posts;

	public Tag() {}

	public Tag(String postTags) {
		this.tagLabel = postTags;
	}
	
	public Collection<Post> getPosts() {
		return posts;
	}

	public Long getId() {
		return id;
	}

	public String getTagLabel() {
		return tagLabel;
	}

	public String getPostTags() {
		return tagLabel;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", postTags=" + tagLabel + "]";
	}
	
	

}
