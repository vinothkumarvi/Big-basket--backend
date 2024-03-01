package com.product.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.product.model.Category;
import com.product.product.repository.CategoryRepository;

@RestController
@RequestMapping("/api")
// @CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/category")
    public Category createCategory(@RequestBody Category category) throws Exception {

        Category isExist = categoryRepository.findByCategoryName(category.getCategoryName());
        if (isExist != null) {
            throw new Exception("Already exist" + " " + category.getCategoryName());
        }

        Category savedCategory = categoryRepository.save(category);

        return savedCategory;
    }

    @DeleteMapping("/category/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId) throws Exception {

        categoryRepository.deleteById(categoryId);

        return "Category is deleted";
    }

    @GetMapping("/GetAllCategory")
    public List<Category> getAllCategory() throws Exception {

        List<Category> category = categoryRepository.findAll();

        return category;
    }

}
