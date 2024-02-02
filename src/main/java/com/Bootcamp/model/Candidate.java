package com.Bootcamp.model;

import java.sql.Date;
import java.util.List;

public class Candidate {
		private int c_ID;	    
	    private String c_Name;	    
	    private Integer c_Phone;	    
	    private String c_Email;	    
	    private String c_Resume;	    
	    private String c_Comments;	    
	    private String c_RegDate;
	    private List<Feedback> candidateFeedback;
	    
	    
		public Candidate() {
			super();
		}
		public Candidate(int c_ID, String c_Name, Integer c_Phone, String c_Email, String c_Resume, String c_Comments,
				String c_RegDate, List<Feedback> candidateFeedback) {
			super();
			this.c_ID = c_ID;
			this.c_Name = c_Name;
			this.c_Phone = c_Phone;
			this.c_Email = c_Email;
			this.c_Resume = c_Resume;
			this.c_Comments = c_Comments;
			this.c_RegDate = c_RegDate;
			this.candidateFeedback = candidateFeedback;
		}
		
		
		public Candidate(String c_Name, Integer c_Phone, String c_Email, String c_Resume, String c_Comments,
				String c_RegDate, List<Feedback> candidateFeedback) {
			super();
			this.c_Name = c_Name;
			this.c_Phone = c_Phone;
			this.c_Email = c_Email;
			this.c_Resume = c_Resume;
			this.c_Comments = c_Comments;
			this.c_RegDate = c_RegDate;
			this.candidateFeedback = candidateFeedback;
		}
		
		
		
		public int getC_ID() {
			return c_ID;
		}
		public void setC_ID(int c_ID) {
			this.c_ID = c_ID;
		}
		public String getC_Name() {
			return c_Name;
		}
		public void setC_Name(String c_Name) {
			this.c_Name = c_Name;
		}
		public Integer getC_Phone() {
			return c_Phone;
		}
		public void setC_Phone(Integer c_Phone) {
			this.c_Phone = c_Phone;
		}
		public String getC_Email() {
			return c_Email;
		}
		public void setC_Email(String c_Email) {
			this.c_Email = c_Email;
		}
		public String getC_Resume() {
			return c_Resume;
		}
		public void setC_Resume(String c_Resume) {
			this.c_Resume = c_Resume;
		}
		public String getC_Comments() {
			return c_Comments;
		}
		public void setC_Comments(String c_Comments) {
			this.c_Comments = c_Comments;
		}
		public String getC_RegDate() {
			return c_RegDate;
		}
		public void setC_RegDate(String c_RegDate) {
			this.c_RegDate = c_RegDate;
		}
		public List<Feedback> getCandidateFeedback() {
			return candidateFeedback;
		}
		public void setCandidateFeedback(List<Feedback> candidateFeedback) {
			this.candidateFeedback = candidateFeedback;
		}
		@Override
		public String toString() {
			return "Candidate [c_ID=" + c_ID + ", c_Name=" + c_Name + ", c_Phone=" + c_Phone + ", c_Email=" + c_Email
					+ ", c_Resume=" + c_Resume + ", c_Comments=" + c_Comments + ", c_RegDate=" + c_RegDate
					+ ", candidateFeedback=" + candidateFeedback + "]";
		}
		
		

}
