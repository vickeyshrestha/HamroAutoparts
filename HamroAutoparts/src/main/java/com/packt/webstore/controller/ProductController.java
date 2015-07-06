package com.packt.webstore.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.packt.webstore.domain.Product;
import com.packt.webstore.exception.NoProductsFoundUnderCategoryException;
import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	//we connect controller and repository through the ProductRepository interface reference to maximize loose coupling
	@Autowired	
	private ProductService productService;
	
	@RequestMapping
	public String allProducts (Model model){
		
		model.addAttribute("products", productService.getAllProducts());
		
		return "products";
	}
	
	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String category){
		List<Product> products = productService.getProductsByCategory(category);
		if (products == null || products.isEmpty()){
			throw new NoProductsFoundUnderCategoryException();
		}
		model.addAttribute("products", products);
		return "products";
	}
	
	@RequestMapping("/filter/{ByCriteria}") 
	public String getProductsByFilter(Model model, @MatrixVariable(pathVar="ByCriteria") Map<String,List<String>> filterParams){
		model.addAttribute("products", productService.getProductsByFilter(filterParams));
		return "products";
	}
	
	@RequestMapping("/product")
	public String getProductById(Model model, @RequestParam("id") String productId){
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}
	
	// THIS newProduct MUST BE SAME AS FORM MODELATTRIBUTE
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAddNewProductForm(Model model){
		Product newproduct= new Product();
		model.addAttribute("newProduct", newproduct);
		return "addProduct";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(	@ModelAttribute("newProduct") @Valid Product productToBeAdded, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "addProduct";
		}
		String [] suppressedFields = result.getSuppressedFields();
		if(suppressedFields.length > 0){
			throw new RuntimeException("Attempting to bind disallowed fields " +StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		MultipartFile productImage =productToBeAdded.getProductImage();
		String rootDirectory =	request.getSession().getServletContext().getRealPath("/");
		if (productImage!=null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new	File(rootDirectory+"resources\\images\\"+ productToBeAdded.getProductId() + ".png"));
			} 
			catch (Exception e) {
				throw new RuntimeException("Product Image saving failed",e);
			}
		}
		productService.addProduct(productToBeAdded);
		return "redirect:/products";
	}
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.setDisallowedFields("unitsInOrder","discontinued");
		binder.setAllowedFields("productId","name","unitPrice","description","manufacturer","category","unitsInStock", "productImage", "condition", "language");
	}
	
	
	//For exception handling that shows error in webpage rather than 404
	// It is associated with ProductNotFoundException
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception){
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidProductId", exception.getProductId());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString());
		mav.setViewName("productNotFound");			//instead of tyying return jsp page name, we did this to direct productNotFound.jsp
		return mav;
	}
	
	@RequestMapping("/invalidPromoCode")
	public String invalidPromoCode() {
		return "invalidPromoCode";
	}
		
}
