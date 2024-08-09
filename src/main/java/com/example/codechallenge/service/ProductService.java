package com.example.codechallenge.service;

import com.example.codechallenge.client.ProductClient;
import com.example.codechallenge.dto.ProductsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductClient productsClient;

    public ProductsResponse getAllProducts(){
        return productsClient.getAllProducts();
    }
}
