package com.example.demo.service;

import com.example.demo.entity.ProductEntity;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    ProductEntity createProduct(ProductEntity product);

    List<ProductEntity> findAllProducts();
}
