package com.java.models;

public class Book {

	private String ISBN,bname,writer,publisher;
	private float price, total;
	private int edition,quantity;
	
//	public Book() {
//		// TODO Auto-generated constructor stub
//	}

	public Book(String iSBN, String bname, String writer, String publisher,int edition,int quantity, float price, float total) {
		super();
		ISBN = iSBN;
		this.bname = bname;
		this.writer = writer;
		this.publisher = publisher;
		this.edition = edition;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
			
	}

	
	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
