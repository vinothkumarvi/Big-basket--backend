package com.product.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.product.model.Category;
import com.product.product.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category findCategoryById(Long categoryId) throws Exception {
        Optional<Category> opt = categoryRepository.findById(categoryId);
        if (opt.isPresent()) {
            return opt.get();
        }
        throw new Exception("Category Id is not find");
    }

}
