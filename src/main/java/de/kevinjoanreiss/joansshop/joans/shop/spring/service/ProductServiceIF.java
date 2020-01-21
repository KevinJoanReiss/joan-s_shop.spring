package de.kevinjoanreiss.joansshop.joans.shop.spring.service;

import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServiceIF {

    public Product createProduct(Product product);

    public List<Product> getProductlist();

    public Optional<Product> findProduct(long id);

    public long generateIndex();

    public void deleteAll();
}
