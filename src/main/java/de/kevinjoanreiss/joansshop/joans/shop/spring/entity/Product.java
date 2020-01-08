package de.kevinjoanreiss.joansshop.joans.shop.spring.entity;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", updatable = false, nullable = false)
    private long productId;

    private String productName;

    private double price;

    public Product(long productId, String productname, double price) {
        this.productId = productId;
        this.productName = productname;
        this.price = price;
    }

    public Product() {}

    public long getProductId() { return productId; }

    public String getProductIdString() { return String.valueOf(productId); }

    public void setProductId(long productId) { this.productId = productId; }

    public String getProductName() { return productName; }

    public void setProductName(String productname) { this.productName = productname; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }
}
