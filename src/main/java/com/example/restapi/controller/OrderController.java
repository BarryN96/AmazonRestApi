package com.example.restapi.controller;

import com.example.restapi.entity.Order;
import com.example.restapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/order")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getOrders();
    }

    @GetMapping("orders/order/{id}")
    public Optional<Order> getOrderById(@PathVariable long id) {
        return orderService.getById(id);
    }

    @PutMapping("/order{id}")
    public Order updateClient(@PathVariable Long id, @RequestBody Order orderDetails) {
        return orderService.update(id, orderDetails);
    }

    @GetMapping("orders/{date}")
    public List<Order> getOrdersByDate(@PathVariable Date date) {
        return orderService.getByDate(date);
    }


    @PostMapping("orders/addOrders")
    public Order addOrder(@RequestBody Order order) {
        return orderService.save(order);
    }

    @PatchMapping("/order/{id}")
    public Order patchClient(@PathVariable Long id, @RequestBody Order order) {
        return orderService.update(id, order);
    }

    @DeleteMapping("orders/deleteOrder/{id}")
    public void deleteOrder(@PathVariable("id") Order order) {
        orderService.deleteOrder(order.getId());
    }

}
