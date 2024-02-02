package com.Bootcamp.Repository.impl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.Bootcamp.Repository.EvaluatorRepository;
import com.Bootcamp.model.Evaluator;

@Repository
public class EvaluatorRepositoryImpl implements EvaluatorRepository{
	
	
	
String sqlQuery;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
				
	@Override
	public Evaluator doLogin(String DasID, String Password) {
		
		sqlQuery = "select * from Evaluator where e_DasID=? and e_password=?";
		
		RowMapper<Evaluator> rowMapperforEvaluator = (rs,rowcnt)->{
			Evaluator e = new Evaluator();
			e.setE_DASID(rs.getString("e_DASID"));
			e.setE_Name(rs.getString("e_Name"));
			e.setE_Email(rs.getString("e_Email"));
			e.setE_ID(rs.getInt(1));
//			........
			return e;
		};
		Evaluator evaluator = this.jdbcTemplate.queryForObject(sqlQuery, rowMapperforEvaluator,DasID,Password);
		return evaluator;
	}


//	@Override
//	public Evaluator findById(Long id) {
//		sqlQuery="select * from evaluator where e_ID=?";
//		RowMapper<Evaluator> evaluatorRowMapper = (rs,rowcnt)->new Evaluator(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getString(4), rs.getInt(5),rs.getString(6));
//		return this.jdbcTemplate.queryForObject(sqlQuery, evaluatorRowMapper,id);
//	}

	@Override
	public Evaluator findById(int id) {
	    sqlQuery = "SELECT * FROM evaluator WHERE e_ID = ?";
	    RowMapper<Evaluator> evaluatorRowMapper = (rs, rowcnt) -> {
	        Evaluator e = new Evaluator();
	        e.setE_ID(rs.getInt("e_ID"));
	        e.setE_DASID(rs.getString("e_DasID"));
	        e.setE_Name(rs.getString("e_Name"));
	        e.setE_Email(rs.getString("e_Email"));
	        // Set other properties as needed
	        return e;
	    };
	    return this.jdbcTemplate.queryForObject(sqlQuery, evaluatorRowMapper, id);
	}





	@Override
	public List<Evaluator> findAll() {
	    sqlQuery = "SELECT * FROM evaluator";
	    RowMapper<Evaluator> evaluatorRowMapper = (rs, rowcnt) -> {
	        Evaluator e = new Evaluator();
	        e.setE_ID(rs.getInt("e_ID"));
	        e.setE_Name(rs.getString("e_Name"));
	        e.setE_DASID(rs.getString("e_DASID"));
	        e.setE_Password(rs.getString("e_Password"));
	        e.setE_Email(rs.getString("e_Email"));
	        e.setE_GCMLevel(rs.getInt("e_GCMLevel"));
	        e.setE_ManagerName(rs.getString("e_ManagerName"));
	        e.setE_Phone(rs.getInt("e_Phone"));
	        return e;
	    };
	    return this.jdbcTemplate.query(sqlQuery, evaluatorRowMapper);
	}

	

}
