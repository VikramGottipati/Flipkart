package com.vikram.flipkart.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "order_details")
public class Order implements Serializable{

	@Id
	@GenericGenerator(name = "auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "alt_key")
	private int altKey;
	
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "total_price")
	private int totalPrice;
	
	@Column(name = "sold_date")
	private Date soldDate;
	
	@Column(name = "payment_mode")
	private String paymentMode;

	public int getAltKey() {
		return altKey;
	}

	public void setAltKey(int altKey) {
		this.altKey = altKey;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getSoldDate() {
		return soldDate;
	}

	public void setSoldDate(Date soldDate) {
		this.soldDate = soldDate;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	@Override
	public String toString() {
		return "Order [altKey=" + altKey + ", productId=" + productId + ", quantity=" + quantity + ", totalPrice="
				+ totalPrice + ", soldDate=" + soldDate + ", paymentMode=" + paymentMode + "]";
	}

}
