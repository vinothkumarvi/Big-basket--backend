package com.product.product.service;

import com.product.product.model.Category;

public interface CategoryService {

    public Category findCategoryById(Long categoryId) throws Exception;

}
