package com.bbva.mailman.models;

import java.util.Date;

public class Order {
	
	private Person person;
	private Date startDate;
	private Date endDate;
	
	public Order() {
		
	}
	
	public Order(Person person, Date startDate) {
		super();
		this.person = person;
		this.startDate = startDate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Order [person=" + person + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
}
