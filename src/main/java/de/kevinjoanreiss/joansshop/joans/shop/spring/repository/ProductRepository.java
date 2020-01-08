package de.kevinjoanreiss.joansshop.joans.shop.spring.repository;

import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
