package com.zenware;
import jakarta.validation.constraints.*;
class Producto {
	
	private Long id;
	@NotBlank(message="The name must not be empty")
	private  String name;
	@Min(value = 0, message ="The price must be greater than or equal to 0")
	private double price;
	public Producto() {
		
	}
	//Constructor method
	public Producto(Long id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	//Method to implement taxes
	public void applyTaxes(double percentage) {
		if(percentage >= 0 && percentage <= 50) {
			price += price * (percentage/100);
		}else {
			throw new IllegalArgumentException("The percentage should be between 0 - 50");
		}
		
	}
	
	

}
