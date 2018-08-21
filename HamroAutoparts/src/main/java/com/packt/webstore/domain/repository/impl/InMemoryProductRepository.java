package com.packt.webstore.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.exception.ProductNotFoundException;

/*
 * 	I am still waiting for a super guy to provide me a REST interface for all products rather thank hardcoding these. Anyone please?
 */

@Repository
public class InMemoryProductRepository implements ProductRepository{

	private List<Product> listOfProducts = new ArrayList<Product>();
	
	public InMemoryProductRepository() {
		Product steering = new Product("P1234" , "Honda Power Steering", new BigDecimal(500));
		steering.setDescription("This third party steering fits on Honda Accord 1995-2000");
		steering.setCategory("Sterring");
		steering.setManufacturer("Nexus");
		steering.setUnitsInStock(450);
		
		Product transmission = new Product("P1235", "Mazda Transmission Automatic", new BigDecimal(800));
		transmission.setDescription("This transmission fits on any Mazda RX5 2005-2010");
		transmission.setCategory("Transmission");
		transmission.setManufacturer("Mazda");
		transmission.setUnitsInStock(150);
		
		Product battery = new Product("P1236", "Toyota heavy Duty Battery", new BigDecimal(120));
		battery.setDescription("This battery compiles with any Toyota SUV ");
		battery.setCategory("Battery");
		battery.setManufacturer("Petboys");
		battery.setUnitsInStock(150);
		
		Product headlight = new Product("P1237", "Infiniti HID Headlights", new BigDecimal(450));
		headlight.setDescription("This headlight compiles with Nissan Infiniti YZ6 year 200-2003 ");
		headlight.setCategory("Headlight");
		headlight.setManufacturer("Nissan");
		headlight.setUnitsInStock(15);
		
		listOfProducts.add(steering);
		listOfProducts.add(transmission);
		listOfProducts.add(battery);
		listOfProducts.add(headlight);
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
			throw new ProductNotFoundException(productId);
		}
		return productById;
	}


	public List<Product> getProductsByCategory(String category) {
		List<Product> productsByCategory = new ArrayList<Product>();
		for (Product product: listOfProducts){
			if(category.equalsIgnoreCase(product.getCategory())){
				productsByCategory.add(product);
			}
		}
		return productsByCategory;
	}


	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		Set<Product> productsByBrand = new HashSet<Product>();
		Set<Product> productsByCategory = new HashSet<Product>();
		
		Set<String> criterias = filterParams.keySet();
		
		if (criterias.contains("brand")) {
			for (String brandName : filterParams.get("brand")) {
				for (Product product : listOfProducts) {
					if (brandName.equalsIgnoreCase(product.getManufacturer())) {
						productsByBrand.add(product);
					}
				}
			}
		}
		
		if (criterias.contains("category")) {
			for (String category : filterParams.get("category")) {
				productsByCategory.addAll(this.getProductsByCategory(category));
			}
		}
		
		productsByCategory.retainAll(productsByBrand);
		return productsByCategory;
	}


	public void addProduct(Product product) {
		listOfProducts.add(product);
	}
	
}
