package com.example.codechallenge.controller;

import com.example.codechallenge.dto.Product;
import com.example.codechallenge.dto.ProductsResponse;
import com.example.codechallenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ProductsResponse getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/products/search")
    public ProductsResponse searchProducts(@RequestParam String query) {
        return productService.searchProducts(query);
    }
}
