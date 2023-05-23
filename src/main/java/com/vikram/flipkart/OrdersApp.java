package com.vikram.flipkart;

import com.vikram.flipkart.dto.OrderDto;
import com.vikram.flipkart.entity.Product;
import com.vikram.flipkart.repository.FlipkartRepository;

public class OrdersApp {
	public static void main(String[] args) {
		
		FlipkartRepository repository = new FlipkartRepository();
		Product product = new Product();
		
//		Product findById = repository.findProductDetailsById(2);
//		System.out.println(findById);
		
		 OrderDto orderDto = new OrderDto();
		 orderDto.setProductId(2);
		 orderDto.setQuantity(1);
		 orderDto.setPaymentMode("Gpay");
		 
		repository.placeOrder(orderDto);
		 
	}
}
