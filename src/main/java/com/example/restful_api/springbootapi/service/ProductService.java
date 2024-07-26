package com.example.restful_api.springbootapi.service;

import com.example.restful_api.springbootapi.entity.Product;
import com.example.restful_api.springbootapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();

    Optional<Product> getProductById(String id);

    Product saveProduct(Product product);

    Product updateProduct(String id, Product Product);

    void deleteProduct(String id);
}