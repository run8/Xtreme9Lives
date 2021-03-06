package com.skilldistillery.xtreme.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PostTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Post post; 
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("XtremeJPA");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		post = em.find(Post.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		post = null;
	}

	@Test
	void test() {
		assertNotNull(post);
		assertEquals("Xtreme Single Engine", post.getTitle());
//		assertEquals("2018-02-28 23:00:00", post.getCreatDate());  CA time is 
		assertEquals("https://i2.wp.com/www.thelostgirlsguide.com/wp-content/uploads/DSC_3138_-1.jpg", post.getImageUrl());
	}
	
	@Test
	void testEntityMappingOneToMany() {
		assertTrue(post.getComments().size() > 0); 

	}

}
