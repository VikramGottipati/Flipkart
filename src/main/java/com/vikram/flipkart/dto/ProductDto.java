package com.vikram.flipkart.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {
	
	private String name;
	
	private String productType;
	
	private int price;
	
	private String description;
	
	private int quantity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductDto [name=" + name + ", productType=" + productType + ", price=" + price + ", description="
				+ description + ", quantity=" + quantity + "]";
	}
	
}
