package com.java.models;

public class Student {
	private String adm,fullname,course,mobile,email,ethnicity,gender,location,year;


	public Student(String adm, String fullname, String course, String mobile, String email,
			String ethnicity, String gender, String location, String year) {
		super();
		this.adm = adm;
		this.fullname = fullname;
		this.course = course;
		this.mobile = mobile;
		this.email = email;
		this.ethnicity = ethnicity;
		this.gender = gender;
		this.location = location;
		this.year = year;
	}

	public String getAdm() {
		return adm;
	}

	public String getFullname() {
		return fullname;
	}

	public String getCourse() {
		return course;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}


	public String getEthnicity() {
		return ethnicity;
	}

	public String getGender() {
		return gender;
	}

	public String getLocation() {
		return location;
	}

	public String getYear() {
		return year;
	}
	

}
