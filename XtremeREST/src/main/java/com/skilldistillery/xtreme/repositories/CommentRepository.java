package com.skilldistillery.xtreme.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.xtreme.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	//	Gets all comments for a post
	List<Comment> findByPost_Id(int id);
	
	//	Creates a new comment on a post is done in a controller method

	
	
}
