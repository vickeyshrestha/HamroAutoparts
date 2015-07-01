package com.packt.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packt.webstore.domain.repository.ProductRepository;

@Controller
public class ProductController {
	
	//we connect controller and repository through the ProductRepository interface reference to maximize loose coupling
	@Autowired	
	private ProductRepository productRepository;
	
	@RequestMapping("/products")
	public String list (Model model){
		
		model.addAttribute("products", productRepository.getAllProducts());
		
		return "products";
	}
}
