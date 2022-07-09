package com.java.models;

public class Admin {
	private int idno;
	private String username,fullname,mobile,email,password,location,qualification,date;

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Admin(int idno, String username, String fullname, String mobile, String email, String password,
			String location, String qualification, String date) {
		super();
		this.idno = idno;
		this.username = username;
		this.fullname = fullname;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.location = location;
		this.qualification = qualification;
		this.date = date;
	}



	public int getIdno() {
		return idno;
	}

	public void setIdno(int idno) {
		this.idno = idno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
 
}
