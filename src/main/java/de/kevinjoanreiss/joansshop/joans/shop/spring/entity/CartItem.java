package de.kevinjoanreiss.joansshop.joans.shop.spring.entity;

import java.util.Optional;

public class CartItem {

    private Product product;
    private int quantity;
    private long cartItemId;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.cartItemId = product.getProductId();
    }


    public long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getQuantityString() {
        return String.valueOf(quantity);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
