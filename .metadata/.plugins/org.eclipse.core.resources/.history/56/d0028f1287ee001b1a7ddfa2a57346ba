package com.skilldistillery.xtreme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	
	private String title;
	
	private String name;
	
	private String email;
	
	private String description;
	
	
	private double price;
	
	private String url;
	
	private String brand;
	

	@Column(name = "category_id")
	private int categoryId;
	
	
	
}
