package com.se.mycompany.homeware.dao;

import com.se.mycompany.homeware.model.Review;
import java.util.List;

public interface ReviewDao {
	void insert(Review review);

	void edit(Review review);

	void delete(int id);

	Review get(int id);
	
	Review get(String name);

	List<Review> getAll();
	
	List<Review> getReviewById(int id);
}
