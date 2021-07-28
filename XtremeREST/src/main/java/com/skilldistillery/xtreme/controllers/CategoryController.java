package com.skilldistillery.xtreme.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.xtreme.entities.Category;
import com.skilldistillery.xtreme.repositories.services.CategoryService;

@RequestMapping("api")
@RestController
public class CategoryController {
	@Autowired
	private CategoryService catSvc;
	
	@GetMapping("categories")
	public List<Category> index() {
		return catSvc.allCategories();
	}
}
