package de.kevinjoanreiss.joansshop.joans.shop.spring.entity;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;

    private String productname;

    private double price;

    public Product(long productId, String productname, double price) {
        this.productId = productId;
        this.productname = productname;
        this.price = price;
    }

    public long getProductId() { return productId; }

    public void setProductId(long productId) { this.productId = productId; }

    public String getProductname() { return productname; }

    public void setProductname(String productname) { this.productname = productname; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }
}
