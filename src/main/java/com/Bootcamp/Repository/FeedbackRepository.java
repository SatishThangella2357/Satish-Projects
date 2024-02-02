package com.Bootcamp.Repository;

import java.util.List;

import com.Bootcamp.model.Feedback;

public interface FeedbackRepository 
{
	void add(Feedback feedback);
	List<Feedback> findAll();
	Feedback findById(int c_ID);
	List<Feedback> findByEvaluator(int e_ID);
	List<Feedback> findByCandidate(int c_ID);
}
