package com.skilldistillery.xtreme.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.xtreme.entities.Post;
import com.skilldistillery.xtreme.repositories.PostRepository;

@SpringBootTest
class PostRepositoryTest {

	@Autowired
	private PostRepository repo;

	@Test
	void test() {
		Post post = repo.getById(1);
		
		List<Post> posts = repo.findByCategory_Id(1);
		assertTrue(posts.size() > 0);
		
	}
	@Test
	void test1() {
//		select count(*) from post where post.title like '%single%' OR post.name like '%single%';
		List<Post> posts = repo.findByNameLikeOrTitleLike("%single%", "%single%");
		assertTrue(1 == posts.size());

	}

}
