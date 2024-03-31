package com.example.LabCycle05;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Product {
	@NotNull(message="Id is required")
	@Min(value = 0)
	@Max(value = 200)
	int id;
	
	@NotNull(message = "Price is required")
	@Min(value = 0)
	@Max(value = 200)
	int price;
	
	@NotBlank(message = "Name is required")
	String name;
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + ", name=" + name + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
}
