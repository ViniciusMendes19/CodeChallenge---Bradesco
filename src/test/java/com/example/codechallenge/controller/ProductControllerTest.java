package com.example.codechallenge.controller;

import com.example.codechallenge.dto.Product;
import com.example.codechallenge.dto.ProductsResponse;
import com.example.codechallenge.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllProducts_DeveRetornarCerto() {

        ProductsResponse mockResponse = new ProductsResponse();
        when(productService.getAllProducts()).thenReturn(mockResponse);

        ProductsResponse response = productController.getAllProducts();

        assertNotNull(response);
        assertEquals(mockResponse, response);
        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void getProductById_BuscarPorIdCerto() {

        int productId = 1;
        Product mockProduct = new Product();
        when(productService.getProductById(productId)).thenReturn(mockProduct);

        Product response = productController.getProductById(productId);

        assertNotNull(response);
        assertEquals(mockProduct, response);
        verify(productService, times(1)).getProductById(productId);
    }

    @Test
    void searchProducts_BuscarTodosOsProdutosCerto() {

        String query = "test";
        ProductsResponse mockResponse = new ProductsResponse();
        when(productService.searchProducts(query)).thenReturn(mockResponse);

        ProductsResponse response = productController.searchProducts(query);

        assertNotNull(response);
        assertEquals(mockResponse, response);
        verify(productService, times(1)).searchProducts(query);
    }

    @Test
    void getAllProducts_DeveRetornarErro() {

        when(productService.getAllProducts()).thenThrow(new RuntimeException("Service failed"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            productController.getAllProducts();
        });

        assertEquals("Service failed", exception.getMessage());
        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void getProductById_BuscarPorIdErro() {

        int productId = 1;
        when(productService.getProductById(productId)).thenThrow(new RuntimeException("Service failed"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            productController.getProductById(productId);
        });

        assertEquals("Service failed", exception.getMessage());
        verify(productService, times(1)).getProductById(productId);
    }

    @Test
    void searchProducts_BuscarTodosOsProdutosErro() {

        String query = "test";
        when(productService.searchProducts(query)).thenThrow(new RuntimeException("Service failed"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            productController.searchProducts(query);
        });

        assertEquals("Service failed", exception.getMessage());
        verify(productService, times(1)).searchProducts(query);
    }
}