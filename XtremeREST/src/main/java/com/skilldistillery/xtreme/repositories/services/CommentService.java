package com.skilldistillery.xtreme.repositories.services;

import java.util.List;

import com.skilldistillery.xtreme.entities.Comment;

public interface CommentService {
	
	List<Comment> commentsForPostId(int postId);
	Comment createForPostId(int postId, Comment comment);
}
