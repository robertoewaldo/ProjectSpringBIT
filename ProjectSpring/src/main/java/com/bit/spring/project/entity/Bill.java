package com.bit.spring.project.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bills")
public class Bill {
	
	@Id
	private int id;
	private int month;
	private int year;
	private int bill_amount;
	private int remaining_amount;
	private Date due_date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getBill_amount() {
		return bill_amount;
	}
	public void setBill_amount(int bill_amount) {
		this.bill_amount = bill_amount;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public int getRemaining_amount() {
		return remaining_amount;
	}
	public void setRemaining_amount(int remaining_amount) {
		this.remaining_amount = remaining_amount;
	}
	
}
