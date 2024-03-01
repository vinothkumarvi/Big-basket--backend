package com.product.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.product.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Category findByCategoryName(String categoryName);
}
