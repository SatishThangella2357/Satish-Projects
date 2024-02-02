package com.Bootcamp.model;

import java.sql.Date;

public class Feedback 
{
	private int f_ID;
	private int e_ID;
	private int  c_ID;
	private Date f_Date;
	private String  FeedbackStatus;
	private String f_Comments;
	private String f_ScreeningLevel;
	private Evaluator fe_ID;
	private Candidate fc_ID;
	
	
	
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Feedback(int f_ID, int e_ID, int c_ID, Date f_Date, String feedbackStatus, String f_Comments,
			String f_ScreeningLevel, Evaluator fe_ID, Candidate fc_ID) {
		super();
		this.f_ID = f_ID;
		this.e_ID = e_ID;
		this.c_ID = c_ID;
		this.f_Date = f_Date;
		FeedbackStatus = feedbackStatus;
		this.f_Comments = f_Comments;
		this.f_ScreeningLevel = f_ScreeningLevel;
		this.fe_ID = fe_ID;
		this.fc_ID = fc_ID;
	}
	public int getF_ID() {
		return f_ID;
	}
	public void setF_ID(int f_ID) {
		this.f_ID = f_ID;
	}
	public int getE_ID() {
		return e_ID;
	}
	public void setE_ID(int e_ID) {
		this.e_ID = e_ID;
	}
	public int getC_ID() {
		return c_ID;
	}
	public void setC_ID(int i) {
		this.c_ID = i;
	}
	public Date getF_Date() {
		return f_Date;
	}
	public void setF_Date(Date f_Date) {
		this.f_Date = f_Date;
	}
	public String getFeedbackStatus() {
		return FeedbackStatus;
	}
	public void setFeedbackStatus(String feedbackStatus) {
		FeedbackStatus = feedbackStatus;
	}
	public String getF_Comments() {
		return f_Comments;
	}
	public void setF_Comments(String f_Comments) {
		this.f_Comments = f_Comments;
	}
	public String getF_ScreeningLevel() {
		return f_ScreeningLevel;
	}
	public void setF_ScreeningLevel(String f_ScreeningLevel) {
		this.f_ScreeningLevel = f_ScreeningLevel;
	}
	public Evaluator getFe_ID() {
		return fe_ID;
	}
	public void setFe_ID(Evaluator fe_ID) {
		this.fe_ID = fe_ID;
	}
	public Candidate getFc_ID() {
		return fc_ID;
	}
	public void setFc_ID(Candidate fc_ID) {
		this.fc_ID = fc_ID;
	}
	
	@Override
	public String toString() {
		return "Feedback [f_ID=" + f_ID + ", e_ID=" + e_ID + ", c_ID=" + c_ID + ", f_Date=" + f_Date
				+ ", FeedbackStatus=" + FeedbackStatus + ", f_Comments=" + f_Comments + ", f_ScreeningLevel="
				+ f_ScreeningLevel + ", fe_ID=" + fe_ID + ", fc_ID=" + fc_ID + "]";
	}

}
