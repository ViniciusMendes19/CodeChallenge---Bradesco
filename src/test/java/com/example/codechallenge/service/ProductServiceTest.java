package com.example.codechallenge.service;

import com.example.codechallenge.client.ProductClient;
import com.example.codechallenge.dto.Product;
import com.example.codechallenge.dto.ProductsResponse;
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
public class ProductServiceTest {

    @Mock
    private ProductClient productClient;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllProducts_DeveRetornarCerto() {

        ProductsResponse mockResponse = new ProductsResponse();
        when(productClient.getAllProducts()).thenReturn(mockResponse);

        ProductsResponse result = productService.getAllProducts();

        assertNotNull(result);
        assertEquals(mockResponse, result);
        verify(productClient, times(1)).getAllProducts();
    }

    @Test
    void getProductById_BuscarPorIdCerto() {

        int productId = 1;
        Product mockProduct = new Product();
        when(productClient.getProductById(productId)).thenReturn(mockProduct);

        Product result = productService.getProductById(productId);

        assertNotNull(result);
        assertEquals(mockProduct, result);
        verify(productClient, times(1)).getProductById(productId);
    }

    @Test
    void searchProducts_BuscarTodosOsProdutosCerto() {

        String query = "test";
        ProductsResponse mockResponse = new ProductsResponse();
        when(productClient.searchProducts(query)).thenReturn(mockResponse);

        ProductsResponse result = productService.searchProducts(query);

        assertNotNull(result);
        assertEquals(mockResponse, result);
        verify(productClient, times(1)).searchProducts(query);
    }

    @Test
    void getAllProducts_DeveRetornarErro() {

        when(productClient.getAllProducts()).thenThrow(new RuntimeException("Service failed"));


        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            productService.getAllProducts();
        });

        assertEquals("Client failed", exception.getMessage());
        verify(productClient, times(1)).getAllProducts();
    }

    @Test
    void getProductById_BuscarPorIdErro() {

        int productId = 1;
        when(productClient.getProductById(productId)).thenThrow(new RuntimeException("Service failed"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            productService.getProductById(productId);
        });

        assertEquals("Client failed", exception.getMessage());
        verify(productClient, times(1)).getProductById(productId);
    }

    @Test
    void searchProducts_BuscarTodosOsProdutosErro() {

        String query = "test";
        when(productClient.searchProducts(query)).thenThrow(new RuntimeException("Service failed"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            productService.searchProducts(query);
        });

        assertEquals("Client failed", exception.getMessage());
        verify(productClient, times(1)).searchProducts(query);
    }
}
