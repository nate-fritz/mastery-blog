package org.wecancodeit.masteryblog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int price;
	private int year;
	private String publisher;
	@Lob
	private String content;

	@ManyToOne
	private Tag tag;
	
	public Post() {
	}

	public Post(String name, int price, int year, String publisher, String content) {
		this.name = name;
		this.price = price;
		this.year = year;
		this.publisher = publisher;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getYear() {
		return year;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", year=" + year + ", publisher="
				+ publisher + ", content=" + content + "]";
	}

}
