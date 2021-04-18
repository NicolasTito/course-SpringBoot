package com.nicolastito.cursosts.repositories;

import com.nicolastito.cursosts.domain.OrderItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository  extends JpaRepository<OrderItem, Integer>{

}
