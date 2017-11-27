package com.tm.model;

import java.util.Objects;

/**
 * Created by tudor.maier on 17/10/2017.
 */
public class Order {
    private int id;
    private int price;
    private int quantity;

    public Order(int id) {
        this.id = id;
    }

    public Order(int id, int price, int quantity) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return id == order.id && price == order.price && quantity == order.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price ,quantity);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public int compareTo(Order other){
        return Long.compare(this.id, other.id);
    }
}
