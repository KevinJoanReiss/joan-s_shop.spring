package de.kevinjoanreiss.joansshop.joans.shop.spring.repository;

import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}
