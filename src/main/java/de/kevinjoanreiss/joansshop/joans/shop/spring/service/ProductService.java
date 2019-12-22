/*package de.kevinjoanreiss.joansshop.joans.shop.spring.service;

import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.Product;
import de.kevinjoanreiss.joansshop.joans.shop.spring.repository.ProductRepository;
import de.kevinjoanreiss.joansshop.joans.shop.spring.service.ProductServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements ProductServiceIF {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        Product newProduct = productRepository.save(product);
        return newProduct;
    }
}
*/