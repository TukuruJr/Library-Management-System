package com.java.models;

public class issue {
	String date,st_adm,st_name,st_year,st_mobile,bk_isbn,b_name,b_witer,b_publisher;

	public issue() {
		// TODO Auto-generated constructor stub
	}

	public issue(String date, String st_adm, String st_name, String st_year, String st_mobile, String bk_isbn,
			String b_name, String b_witer, String b_publisher) {
		super();
		this.date = date;
		this.st_adm = st_adm;
		this.st_name = st_name;
		this.st_year = st_year;
		this.st_mobile = st_mobile;
		this.bk_isbn = bk_isbn;
		this.b_name = b_name;
		this.b_witer = b_witer;
		this.b_publisher = b_publisher;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSt_adm() {
		return st_adm;
	}

	public void setSt_adm(String st_adm) {
		this.st_adm = st_adm;
	}

	public String getSt_name() {
		return st_name;
	}

	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}

	public String getSt_year() {
		return st_year;
	}

	public void setSt_year(String st_year) {
		this.st_year = st_year;
	}

	public String getSt_mobile() {
		return st_mobile;
	}

	public void setSt_mobile(String st_mobile) {
		this.st_mobile = st_mobile;
	}

	public String getBk_isbn() {
		return bk_isbn;
	}

	public void setBk_isbn(String bk_isbn) {
		this.bk_isbn = bk_isbn;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getB_witer() {
		return b_witer;
	}

	public void setB_witer(String b_witer) {
		this.b_witer = b_witer;
	}

	public String getB_publisher() {
		return b_publisher;
	}

	public void setB_publisher(String b_publisher) {
		this.b_publisher = b_publisher;
	}

}
