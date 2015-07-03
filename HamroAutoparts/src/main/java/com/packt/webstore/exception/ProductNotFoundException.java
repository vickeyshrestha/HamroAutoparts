package com.packt.webstore.exception;

/**
 * @author Vickey Shrestha This one shows error in page itself rather than
 *         annoying 404
 */
public class ProductNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -694354952032299587L;
	private String productId;

	public ProductNotFoundException(String productId) {
		this.productId = productId;
	}

	public String getProductId() {
		return productId;
	}

}
