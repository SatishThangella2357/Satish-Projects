package com.Bootcamp.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bootcamp.Repository.EvaluatorRepository;
import com.Bootcamp.Service.EvaluatorService;
import com.Bootcamp.model.Evaluator;


@Service
public class EvaluatorServiceImpl implements EvaluatorService{
	@Autowired
	EvaluatorRepository evaluatorRepository;
	
	public EvaluatorServiceImpl() {
		System.out.println("Constructor of User Service");
	}
	
	
	
	@Override
	public Evaluator doLogin(String DasID, String Password) {
		return this.evaluatorRepository.doLogin(DasID, Password);
	}

	@Override
	public List<Evaluator> findAll() {
		return evaluatorRepository.findAll();
	}

	@Override
	public Evaluator findById(int id) {
		return this.evaluatorRepository.findById(id);
	}

	
	

	

}
