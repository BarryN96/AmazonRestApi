package com.example.restapi.service;

import com.example.restapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostumerService {

    @Autowired
    private CustomerRepository customerRepository;
}
