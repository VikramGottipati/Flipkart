package com.vikram.flipkart.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vikram.flipkart.entity.Order;
import com.vikram.flipkart.entity.Product;
import com.vikram.flipkart.entity.Stock;

public class SessionFactoryUtil {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null) {
			Configuration cfg = new Configuration();
			cfg.setProperties(ConnectionPropertiesUtil.getMysqlDbProperties());
			cfg.addAnnotatedClass(Product.class);
			cfg.addAnnotatedClass(Order.class);
			cfg.addAnnotatedClass(Stock.class);
			sessionFactory = cfg.buildSessionFactory();
		}
		return sessionFactory;
	}
}
