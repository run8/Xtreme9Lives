package com.skilldistillery.xtreme.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class PostDAOImpl implements PostDAO {

	@PersistenceContext
	private EntityManager em;
}
