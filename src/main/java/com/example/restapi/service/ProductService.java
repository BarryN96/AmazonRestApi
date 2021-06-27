package com.example.restapi.service;


import com.example.restapi.entity.Product;
import com.example.restapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {

        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    private Optional<Product> getById(Long id) {
        return Optional.of(productRepository.findById(id)).orElse(null);
    }


    public Product save(Product object) {
        return productRepository.save(object);
    }


    public String deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
            return String.format("Product is successfully deleted");
        } catch (Exception e) {
            return String.format("Prodcut was not found");
        }

    }


    public Product update(Long id, Product object) {
        Optional<Product> product = getById(object.getId());
        if(product.isPresent()){
            Product a = product.get();
            a.setPrice(object.getPrice());
            a.setTitle(object.getTitle());

            return save(a);
        }

        return null;
    }




}
