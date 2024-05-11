package com.cts.medicineStore.entity;



import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MyCartList {
	@Id
	private int id;
	private String name;
	private String company;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expirydate;
	private double price;
	private String quantity;
	private int count;

	public MyCartList(int id, String name, String company, LocalDate expirydate, double price, String quantity,
			int count) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
		this.expirydate = expirydate;
		this.price = price;
		this.quantity = quantity;
		this.count = count;
	}

	public MyCartList() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public LocalDate getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(LocalDate expirydate) {
		this.expirydate = expirydate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
