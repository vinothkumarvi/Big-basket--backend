package com.product.product.service;

import java.util.List;

import com.product.product.model.Category;
import com.product.product.model.Product;

public interface ProductService {

    public Product createProduct(Product product, Category category);

    public Product findProductById(Long id) throws Exception;

    public void deleteProduct(Long id) throws Exception;

    public Product updateProduct(Product product, Long id) throws Exception;

    public List<Product> findAllProduct();

    // public Product findByName(String name);

}
