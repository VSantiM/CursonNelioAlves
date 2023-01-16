package entities;

import java.util.ArrayList;

public class OrderItem {
    private Integer quantity;
    private Double price;
    public Product product;

    public OrderItem(String nameProduct, Integer quantity, Double price) {
        this.quantity = quantity;
        this.price = price;
        this.product = new Product(nameProduct, price);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Double subTotal() {
        return this.price * this.quantity;
    }
}
