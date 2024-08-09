package com.example.codechallenge.client;

import com.example.codechallenge.dto.ProductsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "consumo", url = "https://dummyjson.com")
public interface ProductClient {

    @GetMapping("/products")
    ProductsResponse getAllProducts();

}
