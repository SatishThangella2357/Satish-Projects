package com.Bootcamp.rowmappers;

import java.sql.ResultSet; 
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Service;

import com.Bootcamp.Repository.CandidateRepository;
import com.Bootcamp.Repository.EvaluatorRepository;
import com.Bootcamp.model.Candidate;
import com.Bootcamp.model.Evaluator;
import com.Bootcamp.model.Feedback;



@Service
public class FeedbackRowMapper1 implements RowMapper<Feedback> 
{
	@Autowired
	CandidateRepository candidateRepository;
	@Autowired
	EvaluatorRepository evaluatorRepository;
	

	@Override
	public Feedback mapRow(ResultSet rs, int cnt) throws SQLException 
	{
		Feedback feedback = new Feedback();
		//feedback.setF_ID(rs.getInt(1));
		
		Evaluator evaluator = evaluatorRepository.findById(rs.getInt(3));
		//feedback.setE_ID(2);
		
		Candidate candidate = candidateRepository.findById(rs.getInt(2));
		//feedback.setC_ID(2);
		
		//feedback.setF_ScreeningLevel(rs.getString(5));
		
		//feedback.setFeedbackStatus(rs.getString("Feedback"));
		
		//feedback.setF_Comments(rs.getString("f_Comments"));
		System.out.println(feedback);
		return feedback;
	}
	
}
