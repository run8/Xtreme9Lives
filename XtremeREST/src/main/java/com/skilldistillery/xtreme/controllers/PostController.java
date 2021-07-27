package com.skilldistillery.xtreme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.xtreme.data.PostDAO;

@RequestMapping("api")
@RestController
public class PostController {
	
	@Autowired
	private PostDAO postDao;
	
	@GetMapping("ping")
	public String ping() {
		
		return "pong";
	}
}
