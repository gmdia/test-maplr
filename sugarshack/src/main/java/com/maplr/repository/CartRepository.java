package com.maplr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maplr.entity.CartLine;

@Repository
public interface CartRepository extends JpaRepository<CartLine, Long> {
	Optional<CartLine> findById(Long id);

	List<CartLine> findAll();

	void deleteByProductId(String productId);

	CartLine findByProductId(String productId);
}
