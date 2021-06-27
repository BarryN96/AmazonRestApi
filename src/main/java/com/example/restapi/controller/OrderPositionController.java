package com.example.restapi.controller;

import com.example.restapi.entity.Customer;
import com.example.restapi.entity.Order;
import com.example.restapi.entity.OrderPosition;
import com.example.restapi.service.OrderPositionService;
import com.example.restapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/orderposition")
public class OrderPositionController {

    @Autowired
    private final OrderPositionService orderPositionService;

    public OrderPositionController(OrderPositionService orderPositionService) {
        this.orderPositionService = orderPositionService;
    }


    @GetMapping("/orderpositions")
    public List<OrderPosition> getAllOrderPositions() {
        return orderPositionService.getOrderpositions();
    }

    @GetMapping("orderpositions/orderposition/{id}")
    public OrderPosition getOrderPositionById(@PathVariable long id) {
        return orderPositionService.getOrderPosition(id);
    }

    @PutMapping("/orderposition{id}")
    public OrderPosition updateOrderPosition(@PathVariable Long id, @RequestBody OrderPosition orderPosition) {
        return orderPositionService.updateOrderPosition(id, orderPosition);
    }

    @PostMapping("orders/addOrderPositions")
    public OrderPosition addOrderPosition(@RequestBody OrderPosition orderPosition) {
        return orderPositionService.addOrderPoisition(orderPosition);
    }

    @PatchMapping("/orderposition/{id}")
    public OrderPosition patchorderPosition(@PathVariable Long id, @RequestBody OrderPosition orderPosition) {
        return orderPositionService.updateOrderPosition(id, orderPosition);
    }

    @DeleteMapping("orderpositions/deleteOrderPosition/{id}")
    public void deleteOrderPosition(@PathVariable("id") OrderPosition orderPosition) {
        orderPositionService.deleteOrderPosition(orderPosition.getId());
    }

}
