package com.product.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.product.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
