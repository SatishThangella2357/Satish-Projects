package com.Bootcamp.Repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.Bootcamp.Repository.CandidateRepository;
import com.Bootcamp.model.Candidate;

@Repository
public class CandidateRepositoryImpl implements CandidateRepository
{
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    String sqlQuery;
    
       
    @Override
    public void add(Candidate candidate) {
    	sqlQuery="insert into candidate (c_Name,c_Phone,c_Email,c_Resume,c_Comments,c_RegDate) values(?,?,?,?,?,?)";
		this.jdbcTemplate.update(sqlQuery,candidate.getC_Name(),candidate.getC_Phone(),candidate.getC_Email(),candidate.getC_Resume(),candidate.getC_Comments(), candidate.getC_RegDate());
	

    }

 

    @Override
    public List<Candidate> findAll() {
        sqlQuery = "select * from Candidate where isActive=1";

        RowMapper<Candidate> rowMapperforCandidate = (rs,rowcnt)->{
            Candidate  c = new Candidate();
            
           c.setC_ID(rs.getInt(1));
           c.setC_Name(rs.getString(2));
           c.setC_Phone(rs.getInt(3));
           c.setC_Email(rs.getString(4));
           c.setC_Resume(rs.getString(5));
           c.setC_Comments(rs.getNString(6));
           c.setC_RegDate(rs.getString(7));
            return c;
        };
        List<Candidate> clist = this.jdbcTemplate.query(sqlQuery, rowMapperforCandidate);
        System.out.println(clist);
        return clist;
    }

 

    @Override
    public Candidate findById(int c_ID) {
    	sqlQuery="select * from candidate where c_ID=?";
		RowMapper<Candidate> rowMapperforCandidate = (rs,rowcnt)->{
			Candidate s=new Candidate();
			s.setC_ID(rs.getInt(1));
	           s.setC_Name(rs.getString(2));
	           s.setC_Phone(rs.getInt(3));
	           s.setC_Email(rs.getString(4));
	           s.setC_Resume(rs.getString(5));
	          s.setC_Comments(rs.getNString(6));
	           s.setC_RegDate(rs.getString(7));
		return s;
		};
		return this.jdbcTemplate.queryForObject(sqlQuery, rowMapperforCandidate,c_ID);
    	
    }

 

    @Override
    public void delete(Long c_ID) {
    	sqlQuery="update candidate set isActive=0 where c_ID=?";
		this.jdbcTemplate.update(sqlQuery,c_ID);

    }

 

    @Override
    public void update(Candidate candidate) {
    	sqlQuery="update candidate set  c_Name=?,c_Phone=?,c_Email=?,c_Resume=?,c_Comments=? where c_ID=?";
		this.jdbcTemplate.update(sqlQuery,candidate.getC_Name(),candidate.getC_Phone(),candidate.getC_Email(),candidate.getC_Resume(),candidate.getC_Comments(),candidate.getC_ID());
	

    }
    
    
    @Override
    public List<Candidate> findByName(String c_Name) {
        String sqlQuery = "SELECT * FROM candidate WHERE c_Name = ?";
        
        RowMapper<Candidate> rowMapperforCandidate = (rs, rowcnt) -> {
            Candidate s = new Candidate();
            s.setC_ID(rs.getInt(1));
            s.setC_Name(rs.getString(2));
            s.setC_Phone(rs.getInt(3));
            s.setC_Email(rs.getString(4));
            s.setC_Resume(rs.getString(5));
            s.setC_Comments(rs.getNString(6));
            s.setC_RegDate(rs.getString(7));
            return s;
        };
        
        return jdbcTemplate.query(sqlQuery, new Object[]{c_Name}, rowMapperforCandidate);
    }



	

 

  

 

}
