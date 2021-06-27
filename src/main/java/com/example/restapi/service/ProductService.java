package com.example.restapi.service;

import com.example.restapi.entity.Product;
import com.example.restapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProduct() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(product -> findAllProduct().add(product));
        return products;
    }




}
