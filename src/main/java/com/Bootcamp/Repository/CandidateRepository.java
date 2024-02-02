package com.Bootcamp.Repository;

import java.util.List;

import com.Bootcamp.model.Candidate;

public interface CandidateRepository 
{
    void add(Candidate candidate);
    List<Candidate> findAll();
    Candidate findById(int id);
    List<Candidate> findByName(String c_Name);
    void delete(Long c_ID);
   
	void update(Candidate candidate);
	
	
    
}



