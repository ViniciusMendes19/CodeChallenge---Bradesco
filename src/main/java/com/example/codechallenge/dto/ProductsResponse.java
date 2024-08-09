package com.example.codechallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsResponse {

    private List<Product> products;
    private int total;
    private int skip;
    private int limite;

    public List<Product> getProducts(){
        return products;
    }
}
