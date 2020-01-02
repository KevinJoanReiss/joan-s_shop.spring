package de.kevinjoanreiss.joansshop.joans.shop.spring.service;

import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductServiceIF {

    public Product createProduct(Product product);

    public Iterable<Product> getProductlist();
}
