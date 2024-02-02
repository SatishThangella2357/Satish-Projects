package com.Bootcamp.model;

public class Evaluator 
{
	private int e_ID;
	private String e_Name;
	private String e_DASID;
	private String e_Password;
	private String e_Email;
	private int e_GCMLevel;
	private String e_ManagerName;
	private int e_Phone;
	private boolean isLogin;
	
	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	
	
	public Evaluator() {
		super();
	
	}

	
	public int getE_ID() {
		return e_ID;
	}

	public void setE_ID(int e_ID) {
		this.e_ID = e_ID;
	}

	public String getE_Name() {
		return e_Name;
	}

	public void setE_Name(String e_Name) {
		this.e_Name = e_Name;
	}

	public String getE_DASID() {
		return e_DASID;
	}

	public void setE_DASID(String e_DASID) {
		this.e_DASID = e_DASID;
	}

	public String getE_Password() {
		return e_Password;
	}

	public void setE_Password(String e_Password) {
		this.e_Password = e_Password;
	}

	public String getE_Email() {
		return e_Email;
	}

	public void setE_Email(String e_Email) {
		this.e_Email = e_Email;
	}

	public int getE_GCMLevel() {
		return e_GCMLevel;
	}

	public void setE_GCMLevel(int e_GCMLevel) {
		this.e_GCMLevel = e_GCMLevel;
	}

	public String getE_ManagerName() {
		return e_ManagerName;
	}

	public void setE_ManagerName(String e_ManagerName) {
		this.e_ManagerName = e_ManagerName;
	}

	public int getE_Phone() {
		return e_Phone;
	}

	public void setE_Phone(int e_Phone) {
		this.e_Phone = e_Phone;
	}

	
	@Override
	public String toString() {
		return "Evaluator [e_ID=" + e_ID + ", e_Name=" + e_Name + ", e_DASID=" + e_DASID + ", e_Password=" + e_Password
				+ ", e_Email=" + e_Email + ", e_GCMLevel=" + e_GCMLevel + ", e_ManagerName=" + e_ManagerName
				+ ", e_Phone=" + e_Phone + "]";
	}
}
