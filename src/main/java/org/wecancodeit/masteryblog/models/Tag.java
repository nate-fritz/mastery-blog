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

	@ManyToMany
	private Collection<Post> posts;

	public Tag() {
	}

	public Tag(String tagLabel) {
		this.tagLabel = tagLabel;
	}

	public Long getId() {
		return id;
	}

	public String getTagLabel() {
		return tagLabel;
	}

	public Collection<Post> getProducts() {
		return posts;
	}
	
	public void addTagToPosts(Tag tag) {
		tag.add(tag);
	}

	private void add(Tag tag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", tagLabel=" + tagLabel + ", products=" + posts + "]";
	}

}
