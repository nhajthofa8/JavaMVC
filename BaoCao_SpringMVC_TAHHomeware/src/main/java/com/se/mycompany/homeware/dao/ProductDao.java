package com.se.mycompany.homeware.dao;

import com.se.mycompany.homeware.model.Product;
import java.util.List;

public interface ProductDao {
	void insert(Product product);

	void edit(Product product);

	void delete(String id);

	Product get(int id);
	
	Product get(String name);

	List<Product> getAll();
	
	List<Product> getProductById(int id);

	List<Product> searchByName(String productName);


}
