package com.packt.webstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Vickey Shrestha
 *	This class does not thing magic but only displays the 404 error with custom message pg.140
 */

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No products found under this category")
public class NoProductsFoundUnderCategoryException extends RuntimeException{
	private static final long serialVersionUID =3935230281455340039L;
}
