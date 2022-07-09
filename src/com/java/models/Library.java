package com.java.models;

public class Library {
	
	private String libname,location,admin;
	private int id,seats;

	public Library() {
		// TODO Auto-generated constructor stub
	}

	public Library(int id,String libname, String location, String admin, int seats) {
		super();
		this.id = id;
		this.libname = libname;
		this.location = location;
		this.admin = admin;
		this.seats = seats;
	}

	public int getid() {
		return id;
	}

	public void setid(int id ){
		this.id = id;
	}

	public String getLibname() {
		return libname;
	}

	public void setLibname(String libname) {
		this.libname = libname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

}
