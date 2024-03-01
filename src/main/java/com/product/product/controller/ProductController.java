package com.product.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.product.model.Category;
import com.product.product.model.Product;
import com.product.product.service.CategoryService;
import com.product.product.service.ProductService;

@RestController
@RequestMapping
// @CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @PostMapping("/api/CreateProduct/api/category/{categoryId}")
    public Product createProduct(@RequestBody Product product, @PathVariable Long categoryId) throws Exception {

        Category category = categoryService.findCategoryById(categoryId);

        // Product isExist = productService.findByName(product.getName());
        // if (isExist != null) {
        // throw new Exception("Already exist" + " " + product.getName());
        // }
        Product savedProduct = productService.createProduct(product, category);
        return savedProduct;
    }

    @GetMapping("/api/GetAllProducts")
    public List<Product> getAllProduct() throws Exception {

        List<Product> product = productService.findAllProduct();
        return product;
    }

    @DeleteMapping("/api/DeleteProductById/{productId}")
    public String deleteProduct(@PathVariable Long productId) throws Exception {

        productService.deleteProduct(productId);
        return "Product Delete Successfully";
    }

    // @GetMapping("/api/GetAllproductsByCategoryId?id=")
    // public List<Product> getAllProductById() throws Exception {

    // List<Product> product = productService.findAllProduct();
    // return product;
    // }

    @PutMapping("/api/product/{productId}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id) throws Exception {

        Product UpdatedProduct = productService.updateProduct(product, id);
        return UpdatedProduct;
    }

}
