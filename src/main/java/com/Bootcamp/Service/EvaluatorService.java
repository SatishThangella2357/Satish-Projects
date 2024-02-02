package com.Bootcamp.Service;

import java.util.List; 

import com.Bootcamp.model.Evaluator;

public interface EvaluatorService {
	
	List<Evaluator> findAll();
	Evaluator findById(int id);
	Evaluator doLogin(String DasID, String Password);
	
	 
}
