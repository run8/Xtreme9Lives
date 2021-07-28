package com.skilldistillery.xtreme.controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.skilldistillery.xtreme.data.PostDAO;
import com.skilldistillery.xtreme.entities.Post;

@RequestMapping("api")
@RestController
public class PostController {
	@Autowired
	private PostDAO postDao;

	@GetMapping("ping")
	public String ping() {
		return "pong";
	}

	@GetMapping("posts")
	public List<Post> index() {
		return postDao.findAll();
	}

	@GetMapping("posts/{postId}")
	public Post show(@PathVariable Integer postId, HttpServletResponse res) {
		Post post = postDao.findById(postId);
		if (post == null) {
			res.setStatus(404);
		}
		return post;
	}

	@PostMapping("posts")
	public Post createPost(@RequestBody Post post, HttpServletRequest req, HttpServletResponse res) {
		try {
			postDao.create(post);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(post.getId());
			res.setHeader("Location", url.toString());
		} catch (Exception e) {
			res.setStatus(400);
			post = null;
		}
		return post;
	}

	@PutMapping("posts/{postId}")
	public Post updatePost(@RequestBody Post post, @PathVariable Integer postId, HttpServletResponse res) {
		try {
			post = postDao.update(postId, post);
			if (post == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			res.setStatus(400);
			post = null;
		}
		return post;
	}

	@DeleteMapping("posts/{postId}")
	public void deletePost(@PathVariable Integer postId, HttpServletResponse res) {
		try {
			boolean deleted = postDao.delete(postId);
			if (deleted) {
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			res.setStatus(400);
		}
	}
}
