package com.skilldistillery.xtreme.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.xtreme.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

//		List<Category> findByCategory(Category category);
	List<Category> findAll();

}
