package com.maplr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maplr.entity.Order;

/**
 * Repository commande
 * @author mamad
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
