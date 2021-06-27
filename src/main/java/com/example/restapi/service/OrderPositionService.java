package com.example.restapi.service;

import com.example.restapi.entity.Customer;
import com.example.restapi.entity.Order;
import com.example.restapi.entity.OrderPosition;
import com.example.restapi.repository.OrderPositionRepository;
import com.example.restapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderPositionService {

    @Autowired
    private OrderPositionRepository orderPositionRepository;

    public List<OrderPosition> getOrderpositions() {
        return orderPositionRepository.findAll();
    }

    public OrderPosition getOrderPosition(Long id) {
        return orderPositionRepository.findById(id).orElse(null);
    }

    public OrderPosition addOrderPoisition(OrderPosition orderPosition) {
        return orderPositionRepository.save(orderPosition);
    }

    public String deleteOrderPosition(Long id) {
        try {
            orderPositionRepository.deleteById(id);
            return String.format("OrderPosition was successfully deleted");
        } catch (Exception e) {
            return String.format("OrderPosition not found");
        }

    }

    public OrderPosition updateOrderPosition(Long id, OrderPosition position ) {
        OrderPosition orderPosition= orderPositionRepository.findById(id).orElse(null);
        if(orderPosition != null) {
            orderPosition.setBuyingPrice(position.getBuyingPrice());
            orderPosition.setQuantity(position.getQuantity());
            orderPositionRepository.save(orderPosition);
        }
        return orderPosition;
    }
}
