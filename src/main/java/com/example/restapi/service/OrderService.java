package com.example.restapi.service;

import com.example.restapi.entity.Order;
import com.example.restapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getById(Long id) {
        return Optional.of(orderRepository.findById(id)).orElse(null);
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order save(Order object) {
        return orderRepository.save(object);
    }


    public String deleteOrder(Long id) {
        try {
            orderRepository.deleteById(id);
            return String.format("Order is successfully deleted");
        } catch (Exception e) {
            return String.format("Order is not found");
        }

    }

    public List<Order> getByDate(Date date){
        return orderRepository.findAll().stream().filter(x -> x.getOrderDate().compareTo(date) == 0).collect(Collectors.toList());
    }


    public Order update(Long id, Order object) {
        Optional<Order> order = getById(object.getId());
        if(order.isPresent()){
            Order a = order.get();
            a.setOrderDate(object.getOrderDate());

            return save(a);
        }

        return null;
    }



}
