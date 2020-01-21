package de.kevinjoanreiss.joansshop.joans.shop.spring.repository;

import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.CustomerOrder;
import org.springframework.data.repository.CrudRepository;

public interface CustomerOrderRepository extends CrudRepository<CustomerOrder, Long> {
}
