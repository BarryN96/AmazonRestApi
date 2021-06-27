package com.example.restapi.entity;



import javax.persistence.*;

@Entity
public class OrderPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  int quantity;

    private int buyingPrice;

    @ManyToOne
    @JoinColumn(name = "product_fk", referencedColumnName = "id")
    Product product;

    public OrderPosition(int quantity, int buyingPrice) {
        this.quantity = quantity;
        this.buyingPrice = buyingPrice;
    }

    public OrderPosition() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(int buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    @Override
    public String toString() {
        return "OrderPosition{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", buyingPrice=" + buyingPrice +
                '}';
    }
}
