package com.se.mycompany.homeware.dao;

import com.se.mycompany.homeware.model.Catalog;
import java.util.List;

public interface CategoryDao {
	void insert(Catalog category);

	void edit(Catalog category);

	void delete(String id);

	Catalog get(int id);
	
	Catalog get(String name);

	List<Catalog> getAll();
	
	List<Catalog> getCateByProduct(int id);

}
