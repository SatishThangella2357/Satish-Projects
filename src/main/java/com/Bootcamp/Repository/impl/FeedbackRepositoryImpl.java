package com.Bootcamp.Repository.impl;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.Bootcamp.Repository.CandidateRepository;
import com.Bootcamp.Repository.EvaluatorRepository;
import com.Bootcamp.Repository.FeedbackRepository;
import com.Bootcamp.model.Candidate;
import com.Bootcamp.model.Evaluator;
import com.Bootcamp.model.Feedback;
import com.Bootcamp.rowmappers.FeedbackRowMapper1;

@Repository
public class FeedbackRepositoryImpl implements FeedbackRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	CandidateRepository candidateRepository;
	@Autowired
	EvaluatorRepository evaluatorRepository;
	
	@Autowired
	FeedbackRowMapper1 feedbackRowMapper;
	
	String sqlQuery;
	
	@Override
	public void add(Feedback feedback) {
		sqlQuery = "insert into feedback (c_ID, e_ID,f_ScreeningLevel,Feedback,f_Comments) values (?,?,?,?,?)";
		this.jdbcTemplate.update(sqlQuery,feedback.getC_ID(),feedback.getE_ID(),feedback.getF_ScreeningLevel(),feedback.getFeedbackStatus(),feedback.getF_Comments());
	}

	@Override
	public Feedback findById(int f_ID) {
	    sqlQuery = "SELECT * FROM feedback WHERE f_ID = ?";
	    RowMapper<Feedback> rowMapper = (rs, cnt) -> {
	        Feedback feedback = new Feedback();
	        feedback.setF_ID(rs.getInt("f_ID"));
	        feedback.setE_ID(rs.getInt("e_ID"));
	        feedback.setC_ID(rs.getInt("c_ID"));
	        feedback.setF_Date(rs.getDate("f_Date"));
	        feedback.setFeedbackStatus(rs.getString("FeedbackStatus"));
	        feedback.setF_Comments(rs.getString("f_Comments"));
	        feedback.setF_ScreeningLevel(rs.getString("f_ScreeningLevel"));
	        feedback.setFe_ID(evaluatorRepository.findById(rs.getInt("e_ID")));
	        feedback.setFc_ID(candidateRepository.findById(rs.getInt("c_ID")));
	        return feedback;
	    };
	    return this.jdbcTemplate.queryForObject(sqlQuery, rowMapper, f_ID);
	}

	@Override
	public List<Feedback> findAll() {
	    sqlQuery = "SELECT * FROM feedback";
	    RowMapper<Feedback> rowMapper = (rs, cnt) -> {
	        Feedback feedback = new Feedback();
	        feedback.setF_ID(rs.getInt("f_ID"));
	        feedback.setE_ID(rs.getInt("e_ID"));
	        feedback.setC_ID(rs.getInt("c_ID"));
	        feedback.setF_Date(rs.getDate("f_Date"));
	        feedback.setFeedbackStatus(rs.getString("FeedbackStatus"));
	        feedback.setF_Comments(rs.getString("f_Comments"));
	        feedback.setF_ScreeningLevel(rs.getString("f_ScreeningLevel"));
	        feedback.setFe_ID(evaluatorRepository.findById(rs.getInt("e_ID")));
	        feedback.setFc_ID(candidateRepository.findById(rs.getInt("c_ID")));
	        return feedback;
	    };
	    return this.jdbcTemplate.query(sqlQuery, rowMapper);
	}


	@Override

    public List<Feedback> findByCandidate(int c_ID) {

         sqlQuery="select * from feedback where c_ID=?";

         RowMapper<Feedback> rowMapper =(rs,cnt)->{       	 
             Feedback feedback = new Feedback();
             
             feedback.setE_ID(rs.getInt(3));
             feedback.setC_ID(rs.getInt(2));
             feedback.setF_ID(rs.getInt(1));
             feedback.setF_Date(rs.getDate(4));
             feedback.setF_ScreeningLevel(rs.getString(5));
             feedback.setFeedbackStatus(rs.getString(6));
             feedback.setF_Comments(rs.getString(7));
           feedback.setFe_ID(evaluatorRepository.findById(rs.getInt(3)));
             ;
            

             

             return feedback;

         };

        return this.jdbcTemplate.query(sqlQuery,rowMapper,c_ID);

    }
	@Override
	public List<Feedback> findByEvaluator(int e_ID) {
		sqlQuery="select * from feedback where e_ID=?";
		return this.jdbcTemplate.query(sqlQuery, feedbackRowMapper,e_ID);
	
	}
	
	



}
