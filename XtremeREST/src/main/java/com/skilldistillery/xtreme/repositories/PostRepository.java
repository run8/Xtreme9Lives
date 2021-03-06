package com.skilldistillery.xtreme.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.xtreme.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	// Gets all posts of a specific category
	List<Post> findByCategory_Id(int id);
	
	//	Gets all posts by a name or title
	List<Post> findByNameLikeOrTitleLike(String name, String Title);
	
	//	Gets all posts within price range
	List<Post> findByPriceGreaterThanEqualAndPriceLessThanEqual(double low, double high);
}

//List<Film> findByReplacementCostGreaterThanEqualAndReplacementCostLessThanEqual(double low, double high);
