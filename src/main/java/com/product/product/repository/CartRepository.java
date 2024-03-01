package com.product.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.product.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
