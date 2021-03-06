package com.skilldistillery.xtreme.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Category cat; 
	
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
		cat = em.find(Category.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		cat = null;
	}

	@Test
	void test() {
		assertNotNull(cat);
		assertEquals("skydiving", cat.getName());
	}
	
	@Test
	void testCategroyMappingOneToManyRelationship() {
		assertNotNull(cat);
		assertEquals("skydiving", cat.getName());
		assertTrue(cat.getPosts().size() > 0);
	}

}
