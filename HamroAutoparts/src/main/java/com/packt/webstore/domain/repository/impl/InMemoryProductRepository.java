package com.packt.webstore.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;

@Repository
public class InMemoryProductRepository implements ProductRepository{

	private List<Product> listOfProducts = new ArrayList<Product>();
	
	public InMemoryProductRepository() {
		Product steering = new Product("P1234" , "Honda Steering", new BigDecimal(500));
		steering.setDescription("This third party steering fits on Honda Accord 1995-2000");
		steering.setCategory("Sterring Accessories");
		steering.setManufacturer("Nexus Pvt Ltd");
		steering.setUnitsInStock(450);
		
		Product transmission = new Product("P1235", "Mazda Steering", new BigDecimal(800));
		transmission.setDescription("This transmission fits on any Mazda RX5 2005-2010");
		transmission.setCategory("Transmission Accessories");
		transmission.setManufacturer("Mazda Auto Ltd");
		transmission.setUnitsInStock(150);
		
		Product battery = new Product("P1236", "Toyota Battery", new BigDecimal(120));
		battery.setDescription("This battery compiles with any Toyota SUV ");
		battery.setCategory("Battery Accessories");
		battery.setManufacturer("Petboys Auto Ltd");
		battery.setUnitsInStock(150);
		
		listOfProducts.add(steering);
		listOfProducts.add(transmission);
		listOfProducts.add(battery);
	}

	public List<Product> getAllProducts() {
		return listOfProducts;
	}


	public Product getProductById(String productId) {
		Product productById = null;
		
		for (Product product: listOfProducts){
			if (product!=null && product.getProductId()!=null && product.getProductId().equals(productId)){
				productById=product;
				break;
			}
		}
		
		if (productById==null){
			throw new IllegalArgumentException("No such product found "+ productId);
		}
		return productById;
	}
}
