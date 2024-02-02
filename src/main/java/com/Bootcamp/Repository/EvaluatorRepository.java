package com.Bootcamp.Repository;

import java.util.List;  

import com.Bootcamp.model.Evaluator;


public interface EvaluatorRepository {

	List<Evaluator> findAll();
	Evaluator findById(int i);
	
	Evaluator doLogin(String DasID,String Password);

	
}
