package de.kevinjoanreiss.joansshop.joans.shop.spring.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", updatable = false, nullable = false)
    private long productId;
    private String productName;
    private String imgPath;
    private double price;
    private String imgName;

    public String getImgPath() {
        System.out.println("TEST: " + this.imgPath);
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Product(long productId, String productname, double price, String imgPath, String imgName) {
        this.productId = productId;
        this.productName = productname;
        this.price = price;
        this.imgPath = imgPath;
        this.imgName = imgName;
    }

    public Product() {
    }

    public long getProductId() {
        return productId;
    }

    public String getProductIdString() {
        return String.valueOf(productId);
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productname) {
        this.productName = productname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgName() {
        return "images/" + this.imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getProductId() == product.getProductId() &&
                Double.compare(product.getPrice(), getPrice()) == 0 &&
                Objects.equals(getProductName(), product.getProductName()) &&
                Objects.equals(getImgPath(), product.getImgPath()) &&
                Objects.equals(getImgName(), product.getImgName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getProductName(), getImgPath(), getPrice(), getImgName());
    }
}
