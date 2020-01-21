package de.kevinjoanreiss.joansshop.joans.shop.spring.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

public class CartItem implements Serializable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return cartItemId == cartItem.cartItemId&&
                Objects.equals(product, cartItem.product) &&
                Objects.equals(quantity, cartItem.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity);
    }
}
