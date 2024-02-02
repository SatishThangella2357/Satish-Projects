package com.Bootcamp.Service;

import java.util.List;

import com.Bootcamp.model.Candidate;


 

public interface CandidateService 
{
    void add(Candidate candidate);
    List<Candidate> findAll();
    Candidate findById(int c_ID);
    List<Candidate> findByName(String c_Name);

    void delete(Long c_ID);
    
    List<Candidate> findSeleted();
    List<Candidate> findNotSeleted();
	
	void update(Candidate candidate);
	
	
}


