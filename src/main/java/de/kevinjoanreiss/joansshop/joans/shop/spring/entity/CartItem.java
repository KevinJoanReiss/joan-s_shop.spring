package de.kevinjoanreiss.joansshop.joans.shop.spring.entity;

import java.util.Optional;

public class CartItem {

    private Optional<Product> product;
    private int quantity;

    public CartItem(Optional<Product> product) {
        this.product = product;
    }

    public Optional<Product> getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
