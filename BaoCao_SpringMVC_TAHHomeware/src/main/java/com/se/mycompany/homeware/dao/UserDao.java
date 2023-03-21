package com.se.mycompany.homeware.dao;

import com.se.mycompany.homeware.model.User;
import java.util.List;


public interface UserDao {
	
	void insert(User user);

	void edit(User user);
	
	void delete(int id);

	User get(String name);

	User get(int id);
	
	List<User> getAll();
}
