package com.packt.webstore.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packt.webstore.domain.Product;

@Controller
public class ProductController {
	
	@RequestMapping("/products")
	public String list (Model model){
		Product steering = new Product("P1234" , "Honda Steering", new BigDecimal(500));
		steering.setDescription("This third party steering fits on Honda Accord 1995-2000");
		steering.setCategory("Sterring Accessories");
		steering.setManufacturer("Nexus Pvt Ltd");
		steering.setUnitsInStock(450);
		
		model.addAttribute("product", steering);
		
		return "products";
	}
}
