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
	private Long tagId;
	private String tagLabel;

	@ManyToMany(mappedBy="tags")
	private Collection<Post> posts;

	public Tag() {}

	public Tag(String tagLabel) {
		this.tagLabel = tagLabel;
	}
	
	public Collection<Post> getPosts() {
		return posts;
	}

	public Long getTagId() {
		return tagId;
	}

	public String getTagLabel() {
		return tagLabel;
	}

	@Override
	public String toString() {
		return "Tag [id=" + tagId + ", postTags=" + tagLabel + "]";
	}


	
	

}
