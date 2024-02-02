package com.Bootcamp.Service;

import java.util.List;

import com.Bootcamp.model.Feedback;

public interface FeedbackService {
	void add(Feedback feedback);
	List<Feedback> findAll();
	Feedback findById(int id);
	List<Feedback> findByEvaluator(int c_ID);
	List<Feedback> findByCandidate(int c_ID);
	;
}
