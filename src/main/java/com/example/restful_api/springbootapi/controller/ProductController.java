package com.example.restful_api.springbootapi.controller;

import com.example.restful_api.springbootapi.entity.Product;
import com.example.restful_api.springbootapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    // Get all products.
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Create a new product.
    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product newProduct = productService.saveProduct(product);
        return ResponseEntity.ok(newProduct);
    }


    // Get a product by ID.
    @GetMapping("/product")
    public ResponseEntity<Product> getProductById(@RequestParam("id") Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Update a product by ID.
    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestParam("id") Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return ResponseEntity.ok(updatedProduct);
    }

    // Delete a product by ID.
    @DeleteMapping("/product")
    public ResponseEntity<String> deleteProduct(@RequestParam("id") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}