package com.example.restful_api.springbootapi.service.impl;

import com.example.restful_api.model.entity.Product;
import com.example.restful_api.springbootapi.repository.ProductRepository;
import com.example.restful_api.springbootapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public long getProductCount() {
        return productRepository.count();
    }

    @Override
    public List<Product> getAllProducts(String sort, Integer page, Integer size) {
        sort = (sort == null || sort.isEmpty()) ? "name" : sort;
        page = (page == null || page < 0) ? 0 : page;
        size = (size == null || size <= 0) ? 5 : size;

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort).descending());

        Page<Product> pagedResult = productRepository.findAll(pageable);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Product>();
        }
    }

    @Override
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(String id, Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setQuantity(updatedProduct.getQuantity());
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

}