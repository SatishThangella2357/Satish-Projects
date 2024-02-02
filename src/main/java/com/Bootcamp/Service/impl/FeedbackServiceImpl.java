package com.Bootcamp.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bootcamp.Repository.FeedbackRepository;
import com.Bootcamp.Service.FeedbackService;
import com.Bootcamp.model.Feedback;
@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	FeedbackRepository feedbackRepository;

	@Override
	public void add(Feedback feedback) {
		this.feedbackRepository.add(feedback);
	}

	@Override
	public List<Feedback> findAll() {
		return this.feedbackRepository.findAll();
	}

	@Override
	public Feedback findById(int c_ID) {
		
		return this.feedbackRepository.findById(c_ID);
	}

	@Override
	public List<Feedback> findByEvaluator(int c_ID) {
		
		return this.feedbackRepository.findByEvaluator(c_ID);
	}

	@Override
	public List<Feedback> findByCandidate(int c_ID) {
		
		return this.feedbackRepository.findByCandidate(c_ID);
	}

}
