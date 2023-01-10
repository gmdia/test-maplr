package com.maplr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Gestion d'exception quantite
 * @author mamad
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidQuantityException extends RuntimeException {
	private static final long serialVersionUID = -2456740793083707844L;

	/**
	 * Renvoie le message quantite non valide
	 */
	public InvalidQuantityException() {
		super("Quantite non valide");
	}
}
