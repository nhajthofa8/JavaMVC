package com.se.mycompany.homeware.service;

import com.se.mycompany.homeware.model.Transactions;
import java.util.List;


public interface TransactionService {
	void insert(Transactions transaction);
	 
	void edit(Transactions transaction); 

	void delete(String id); 
 
	Transactions get(int id); 
	 
	Transactions get(String name); 
 
	List<Transactions> getAll(); 

}
