package com.skilldistillery.xtreme.data;

import java.util.List;

import com.skilldistillery.xtreme.entities.Post;

public interface PostDAO {

	public List<Post> findAll();
	public Post findById(int postId);
	public Post create(Post post);
	public Post update(int postId, Post post);
	public boolean delete(int postId);



}
