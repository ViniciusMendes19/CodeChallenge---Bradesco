package com.example.codechallenge.service;

import com.example.codechallenge.client.ProductClient;
import com.example.codechallenge.dto.Product;
import com.example.codechallenge.dto.ProductsResponse;
import com.example.codechallenge.exceptions.ErroNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import feign.FeignException;


@Service
public class ProductService {

    @Autowired
    private ProductClient productsClient;

    public ProductsResponse getAllProducts() {
        ProductsResponse response = productsClient.getAllProducts();
        if (response == null || response.getProducts() == null || response.getProducts().isEmpty()) {
            throw new ErroNaoEncontrado("Nenhum dado encontrado");
        }
        return productsClient.getAllProducts();
    }

    public Product getProductById(int id) {
        try {
            return productsClient.getProductById(id);
        } catch (FeignException.NotFound ex) {
            throw new ErroNaoEncontrado("Produto não encontrado pelo id: " + id);
        }
    }

    public ProductsResponse searchProducts(String query) {
        ProductsResponse response = productsClient.searchProducts(query);
        if (response.getProducts().isEmpty()){
            throw new ErroNaoEncontrado("Nenhum dado encontrado com o parametro: " + query);
        }
            return productsClient.searchProducts(query);
    }

}
