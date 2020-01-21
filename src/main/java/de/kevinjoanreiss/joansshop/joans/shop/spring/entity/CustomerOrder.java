package de.kevinjoanreiss.joansshop.joans.shop.spring.entity;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Access(AccessType.FIELD)
public class CustomerOrder implements Serializable {
    @Id
    private long id;

    private ArrayList<CartItem> items;

    private double total;
    private Customer customer;
    private String status;

    public CustomerOrder(long id, double total, String status) {
        this.status = status;
        this.id = id;
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CustomerOrder(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<CartItem> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerOrder customerOrder = (CustomerOrder) o;
        return id == customerOrder.id &&
                Objects.equals(items, customerOrder.items) &&
                Objects.equals(total, customerOrder.total) &&
                Objects.equals(status, customerOrder.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, items, total, status);
    }
}
