package com.example.restapi.service;

import com.example.restapi.repository.OrderPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderPositionService {

    @Autowired
    private OrderPositionRepository orderPositionRepository;
}
