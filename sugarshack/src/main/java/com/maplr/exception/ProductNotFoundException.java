package com.maplr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Gestion d'exception produit
 * @author mamad
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 6220492955522725267L;

	/**
	 * Renvoie le message produit non trouve
	 */
	public ProductNotFoundException() {
		super("Produit non trouve");
	}
}
