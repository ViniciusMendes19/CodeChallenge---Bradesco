package com.example.codechallenge.client;

import com.example.codechallenge.dto.Product;
import com.example.codechallenge.dto.ProductsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "consumo", url = "https://dummyjson.com")
public interface ProductClient {

    @GetMapping("/products")
    ProductsResponse getAllProducts();

    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable("id") int id);

}
