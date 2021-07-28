package com.skilldistillery.xtreme.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.xtreme.entities.Category;
import com.skilldistillery.xtreme.entities.Post;
import com.skilldistillery.xtreme.repositories.PostRepository;

@SpringBootTest
public class CategoriesTest {

	@Autowired
	private PostRepository repo;

	@Test
	void test() {
		List<Category> categories = repo.findAll();
	}
}
