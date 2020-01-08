package de.kevinjoanreiss.joansshop.joans.shop.spring.entity;

import java.util.Optional;

public class CartItem {

    private Product product;
    private int quantity;

    public CartItem(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
