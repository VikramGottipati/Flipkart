package com.vikram.flipkart.repository;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.vikram.flipkart.dto.OrderDto;
import com.vikram.flipkart.dto.ProductDto;
import com.vikram.flipkart.entity.Order;
import com.vikram.flipkart.entity.Product;
import com.vikram.flipkart.entity.Stock;
import com.vikram.flipkart.util.SessionFactoryUtil;

public class FlipkartRepository {
	
	private void saveProductDetails(Product product) {
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit();
	}
	
	public void prepareProductAndStockInfo(ProductDto productDto) {
		Product product = new Product();
		product.setName(productDto.getName()); 
		product.setProductType(productDto.getProductType()); 
		product.setPrice(productDto.getPrice());
		product.setDescription(productDto.getDescription());
		product.setManufactureDate(new Date());
		saveProductDetails(product);
		Stock stock = new Stock();
		stock.setProductId(product.getAltKey());
		stock.setQuantity(productDto.getQuantity());
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.merge(product);
		session.save(stock);
		transaction.commit();
	}
	
	public Product findProductDetailsById(int altKey) {
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		return session.get(Product.class, altKey);
	}
	
	public void placeOrder(OrderDto orderDto) {
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Order order = new Order();
		order.setProductId(orderDto.getProductId());
		order.setQuantity(orderDto.getQuantity());
		int productPrice=findProductPriceById(orderDto.getProductId());
		order.setTotalPrice(productPrice*orderDto.getQuantity());
		order.setSoldDate(new Date());
		order.setPaymentMode(orderDto.getPaymentMode());
		session.save(order);
		transaction.commit();
		System.out.println("Order Details : "+order);
		System.out.println("order Place Successfully");
	}

	public int findProductPriceById(int id) {
		String hql="select price from Product where altKey=:i";
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setParameter("i", id);
		return (int) query.getSingleResult();
	}
	
	 public void updateStockByProductId(int quantity,int id) {
		String hql="update Stock set quantity=:q where productId=:i";
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("q", quantity);
		query.setParameter("i", id);
		query.executeUpdate();
		transaction.commit();
	}

}
