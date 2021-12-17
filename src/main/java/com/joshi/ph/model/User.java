package com.joshi.ph.model;

public class User {

	private int id;
	private String name;
	private int ph_number;
	
	
	public User() {
		super();
	}
	
	
	
	public User(String name, int ph_number) {
		super();
		this.name = name;
		this.ph_number = ph_number;
	}
	
	
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPh_number() {
		return ph_number;
	}
	public void setPh_number(int ph_number) {
		this.ph_number = ph_number;
	}
	
	
	
	
	
}
