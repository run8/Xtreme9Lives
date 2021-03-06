package com.skilldistillery.xtreme.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.xtreme.entities.Comment;
import com.skilldistillery.xtreme.repositories.services.CommentService;

@RequestMapping("api")
@RestController
public class CommentController {

	@Autowired
	private CommentService commentSvc;
	
	@GetMapping("posts/{id}/comments")
	public List<Comment> commentsForPostId(
		@PathVariable("id") Integer postId,
		HttpServletResponse res
		){
		List<Comment> comments = commentSvc.commentsForPostId(postId);
		if (comments == null) {
			res.setStatus(404);
		}
		return comments;
	}
	
	@PostMapping("posts/{id}/comments")
	public Comment addCommentForPost(
			@PathVariable Integer postId,
			@RequestBody Comment comment,
			HttpServletRequest req,
			HttpServletResponse res
			
			)
}
