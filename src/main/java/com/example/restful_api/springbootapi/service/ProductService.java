package com.example.restful_api.springbootapi.service;

import com.example.restful_api.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    long getProductCount();

    List<Product> getAllProducts(String sort, Integer page, Integer size);

    Optional<Product> getProductById(String id);

    Product saveProduct(Product product);

    Product updateProduct(String id, Product Product);

    void deleteProduct(String id);
}