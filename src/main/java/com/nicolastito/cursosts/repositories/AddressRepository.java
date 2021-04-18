package com.nicolastito.cursosts.repositories;

import com.nicolastito.cursosts.domain.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository  extends JpaRepository<Address, Integer>{

}
