package com.org.DigitalSignature.Model;

public class CustomerDetail {
	String id;
	String fname;
	String lname;
	String contact;
	String orgnization;
	public CustomerDetail(String id, String fname, String lname, String contact, String orgnization) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.contact = contact;
		this.orgnization = orgnization;
	}
	public CustomerDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getOrgnization() {
		return orgnization;
	}
	public void setOrgnization(String orgnization) {
		this.orgnization = orgnization;
	}

}
