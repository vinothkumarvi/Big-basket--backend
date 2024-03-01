package com.product.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
