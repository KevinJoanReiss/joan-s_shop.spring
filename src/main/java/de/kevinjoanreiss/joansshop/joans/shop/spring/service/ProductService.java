package de.kevinjoanreiss.joansshop.joans.shop.spring.service;

import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.Product;
import de.kevinjoanreiss.joansshop.joans.shop.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements ProductServiceIF {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        Product newProduct = productRepository.save(product);
        return newProduct;
    }

    @Override
    public Iterable<Product> getProductlist() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findProduct(long id) {
        return productRepository.findById(id);
    }

    @Override
    public long generateIndex() {
        Iterable<Product> list = getProductlist();
        long size = 0;
        for(Product product : list) {
            size++;
        }
        return size;
    }
}
