package com.example.restapi.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "Order")
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    private Date orderDate;

    @OneToMany(targetEntity = OrderPosition.class , cascade = CascadeType.ALL)
    private List<OrderPosition> orderPositions = new ArrayList<>();

    public Order(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Order() {

    }

    public List<OrderPosition> getOrderPositions() {
        return orderPositions;
    }

    public void setOrderPositions(List<OrderPosition> orderPositions) {
        this.orderPositions = orderPositions;
    }

    public void setOrderPosition(OrderPosition orderPosition) {

       this.orderPositions.add(orderPosition);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
