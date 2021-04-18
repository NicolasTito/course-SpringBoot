package com.nicolastito.cursosts.repositories;

import com.nicolastito.cursosts.domain.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository  extends JpaRepository<Payment, Integer>{

}
