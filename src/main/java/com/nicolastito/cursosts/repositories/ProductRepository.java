package com.nicolastito.cursosts.repositories;

import com.nicolastito.cursosts.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer>{

}
