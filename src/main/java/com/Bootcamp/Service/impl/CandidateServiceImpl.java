package com.Bootcamp.Service.impl;

import java.util.List; 



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bootcamp.Repository.CandidateRepository;
import com.Bootcamp.Repository.FeedbackRepository;
import com.Bootcamp.Service.CandidateService;
import com.Bootcamp.model.Candidate;

@Service
public class CandidateServiceImpl implements CandidateService
{

    @Autowired
    CandidateRepository candidateRepository;
    @Autowired
	FeedbackRepository feedbackRepository;

    public CandidateRepository getCandidateRepository() {
        return candidateRepository;
    }
    public void setCandidateRepositroy(CandidateRepository candidateRepositroy) {
        this.candidateRepository = candidateRepositroy;
    }

    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

 

    @Override
    public void add(Candidate candidate) 
    {
        this.candidateRepository.add(candidate);
    }


    @Override
    public Candidate findById(int c_ID) {
    	Candidate candidate = this.candidateRepository.findById(c_ID);
//		candidateRepository.edit(candidate);
		
		return candidate;
    }
    @Override
    public void delete(Long c_ID) {
    	this.candidateRepository.delete(c_ID);
    }
    @Override
    public void update(Candidate candidate) {
    	this.candidateRepository.update(candidate);
    }
    
    
    
    
    @Override
    public List<Candidate> findSeleted() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public List<Candidate> findNotSeleted() {
        // TODO Auto-generated method stub
        return null;
    }
	@Override
	public List<Candidate> findByName(String c_Name) {
		
		return this.candidateRepository.findByName(c_Name);
//		return this.findByName(c_Name);
	}
	
	

 

}
