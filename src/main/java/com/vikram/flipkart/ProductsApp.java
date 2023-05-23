package com.vikram.flipkart;

import com.vikram.flipkart.dto.ProductDto;
import com.vikram.flipkart.repository.FlipkartRepository;

public class ProductsApp {
	public static void main(String[] args) {
		
		ProductDto productDto = new ProductDto();
		productDto.setName("Hp");
		productDto.setProductType("Laptop");
		productDto.setPrice(63000);
		productDto.setDescription("intel core i5,Rom:512GB,Ram:8GB");
		productDto.setQuantity(6);
		
		FlipkartRepository repository = new FlipkartRepository();
//		repository.prepareProductAndStockInfo(productDto);
		
		/*int priceById = repository.findProductPriceById(1);
		System.out.println(priceById);*/
		
		/*Product findById = repository.findProductDetailsById(1);
		System.out.println(findById);*/
		
		repository.updateStockByProductId(7, 1);
		
		
	}
}
