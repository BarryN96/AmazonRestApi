package com.example.restapi.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Product")
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    private int price;
    private String title;

    @OneToMany(targetEntity = OrderPosition.class , cascade = CascadeType.ALL)
   // @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private List<OrderPosition> orderPositions = new ArrayList<>();

    public int getPrice() {
        return price;
    }

    public void setPrice(int quantity) {
        this.price = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String buyingPrice) {
        this.title = buyingPrice;
    }

/*
    public List<OrderPosition> getOrderPositions() {
        return orderPositions;
    }

    public void setOrderPositions(List<OrderPosition> orderPositions) {
        this.orderPositions = orderPositions;
    }

 */

    public void setOrder(OrderPosition order) {this.orderPositions.add(order);}

    public Product(){}

    public Product(int quantity, String buyingPrice) {this.title = buyingPrice; this.price = quantity;}

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", orderPositions=" + orderPositions +
                '}';
    }
}
