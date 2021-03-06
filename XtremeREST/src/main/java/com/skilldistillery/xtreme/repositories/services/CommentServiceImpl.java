package com.skilldistillery.xtreme.repositories.services;

import java.util.List;
import java.util.Optional;

import com.skilldistillery.xtreme.entities.Comment;
import com.skilldistillery.xtreme.entities.Post;
import com.skilldistillery.xtreme.repositories.CommentRepository;
import com.skilldistillery.xtreme.repositories.PostRepository;

public class CommentServiceImpl implements CommentService {
	
	CommentRepository commentRepo;
	PostRepository postRepo;
	
	@Override
	public List<Comment> commentsForPostId(int postId) {
		List<Comment> comments = null;
		if (postRepo.existsById(postId)) {
			comments = commentRepo.findByPost_Id(postId);
		}
		return null;
	}
	
	@Override
	public Comment createForPostId(int postId, Comment comment) {
		Optional<Post> postOpt = postRepo.findById(null);
		if (postOpt.isPresent()) {
			Post post = postOpt.get();
			comment.setPost(post);
			return commentRepo.saveAndFlush(comment);
		}
		return null;
	}

}
