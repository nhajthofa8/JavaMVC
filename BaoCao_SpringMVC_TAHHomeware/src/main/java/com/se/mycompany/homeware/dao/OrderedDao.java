package com.se.mycompany.homeware.dao;

import com.se.mycompany.homeware.model.Ordered;
import java.util.List;

public interface OrderedDao {
	void insert(Ordered ordered); 
	 
	void edit(Ordered ordered); 
	
	void delete(String id); 
 
	Ordered get(int id); 
	 
	Ordered get(String name); 
 
	List<Ordered> getAll();
}
