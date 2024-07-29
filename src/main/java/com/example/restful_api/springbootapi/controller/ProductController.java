package com.example.restful_api.springbootapi.controller;

import com.example.restful_api.model.entity.Product;
import com.example.restful_api.model.response.BaseResponse;
import com.example.restful_api.springbootapi.service.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // Get all products.
    @GetMapping("/products")
    public ResponseEntity<Object> getAllProducts(@RequestParam(required = false, defaultValue = "") String sort,
                                                 @Valid @NotNull @PositiveOrZero @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                 @Valid @NotNull @PositiveOrZero @RequestParam(value = "size", defaultValue = "5") Integer size) {

        return BaseResponse.ofSucceeded(productService.getAllProducts(sort, page, size));
    }

    // Create a new product.
    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product newProduct = productService.saveProduct(product);
        return ResponseEntity.ok(newProduct);
    }


    // Get a product by ID.
    @GetMapping("/product")

    public ResponseEntity<Product> getProductById(@RequestParam("id") String id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Update a product by ID.
    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestParam("id") String id, @RequestBody Product product) {

        Product updatedProduct = productService.updateProduct(id, product);
        return ResponseEntity.ok(updatedProduct);
    }

    // Delete a product by ID.
    @DeleteMapping("/product")
    public ResponseEntity<String> deleteProduct(@RequestParam("id") String id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}