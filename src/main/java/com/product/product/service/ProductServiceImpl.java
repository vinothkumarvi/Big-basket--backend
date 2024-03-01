package com.product.product.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.product.model.Category;
import com.product.product.model.Product;
import com.product.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product, Category category) {

        Product createdProduct = new Product();
        createdProduct.setSku(product.getSku());
        createdProduct.setName(product.getName());
        createdProduct.setPrice(product.getPrice());
        createdProduct.setShortName(product.getShortName());
        createdProduct.setDescription(product.getDescription());
        createdProduct.setCreatedAt(LocalDateTime.now());
        createdProduct.setDeliveryTimeSpan(product.getDeliveryTimeSpan());
        createdProduct.setCategory(category);
        createdProduct.setImageUrl(product.getImageUrl());

        return productRepository.save(createdProduct);
    }

    @Override
    public Product findProductById(Long id) throws Exception {
        Optional<Product> opt = productRepository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        }
        throw new Exception("product is not found" + id);

    }

    @Override
    public void deleteProduct(Long id) throws Exception {
        findProductById(id);
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Product product, Long id) throws Exception {
        Product oldProduct = findProductById(id);
        if (product.getSku() != null) {
            oldProduct.setSku(product.getSku());
        }
        if (product.getName() != null) {
            oldProduct.setName(product.getName());
        }
        if (product.getPrice() != null) {
            oldProduct.setPrice(product.getPrice());
        }
        if (product.getShortName() != null) {
            oldProduct.setShortName(product.getShortName());
        }
        if (product.getDescription() != null) {
            oldProduct.setDescription(product.getDescription());
        }
        if (product.getDeliveryTimeSpan() != null) {
            oldProduct.setDeliveryTimeSpan(product.getDeliveryTimeSpan());
        }
        if (product.getImageUrl() != null) {
            oldProduct.setImageUrl(product.getImageUrl());
        }
        return productRepository.save(oldProduct);
    }

    @Override
    public List<Product> findAllProduct() {

        return productRepository.findAll();
    }

    // @Override
    // public Product findByName(String name) {

    // throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    // }

}
