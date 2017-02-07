package com.bbva.mailman.models;

public class Person {
	
	private Long id;
	private String name;
	private String lastName;
	
	public Person(){
		
	}
	
	public Person(String name, String lastName) {
		super();
		this.name = name;
		this.lastName = lastName;
	}
	
	public Person(Long id, String name, String lastName) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", lastName=" + lastName
				+ "]";
	}
	
}
