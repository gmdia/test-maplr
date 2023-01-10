package com.maplr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maplr.entity.CartLine;

/**
 * Repository panier
 * @author mamad
 *
 */
@Repository
public interface CartRepository extends JpaRepository<CartLine, Long> {
	/**
	 * Supprime un produit du panier par id produit
	 * @param productId : id produit
	 */
	void deleteByProductId(String productId);

	/**
	 * Renvoie un panier par id produit
	 * @param productId : id produit
	 * @return CartLine
	 */
	CartLine findByProductId(String productId);
}
