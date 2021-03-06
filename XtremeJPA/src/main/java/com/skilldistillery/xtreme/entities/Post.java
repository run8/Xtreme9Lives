package com.skilldistillery.xtreme.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String name;
	
	private String email;
	
	private String description;
	
	private double price;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	private String brand;

	@JsonIgnore
	@OneToMany(mappedBy = "post")
	private List<Comment> comments;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Column(name = "created_at")
	private LocalDateTime creatDate;
	
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	/////////////////////////////////////////// Methods
	public Post() {	}

	public Post(int id, String title, String name, String email, String description, double price, String imageUrl,
			String brand, List<Comment> comments, Category category, LocalDateTime creatDate, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.title = title;
		this.name = name;
		this.email = email;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
		this.brand = brand;
		this.comments = comments;
		this.category = category;
		this.creatDate = creatDate;
		this.updatedAt = updatedAt;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public LocalDateTime getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(LocalDateTime creatDate) {
		this.creatDate = creatDate;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}



	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", name=" + name + ", email=" + email + ", description="
				+ description + ", price=" + price + ", imageUrl=" + imageUrl + ", brand=" + brand + ", comments="
				+ comments + ", category=" + category + ", creatDate=" + creatDate + ", updatedAt=" + updatedAt + "]";
	}

	
	

	
	
}
