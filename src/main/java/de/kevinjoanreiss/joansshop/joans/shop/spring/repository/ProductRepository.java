package de.kevinjoanreiss.joansshop.joans.shop.spring.repository;

import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
