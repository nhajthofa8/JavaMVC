package com.se.mycompany.homeware.service;

import com.se.mycompany.homeware.model.Boardnew;
import java.util.List;


public interface BoardnewService {
	void insert(Boardnew boardnew);

	void edit(Boardnew boardnew);

	void delete(int id);

	Boardnew get(int id);
	
	Boardnew get(String name);

	List<Boardnew> getAll();

}
