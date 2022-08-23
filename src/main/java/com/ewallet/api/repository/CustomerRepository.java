package com.ewallet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ewallet.api.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	//	@Query("select customer from Customer customer where customer.email=:email")
	Customer findByEmail(String email);

	void deleteByEmail(String email);
}