package de.kevinjoanreiss.joansshop.joans.shop.spring.repository;

import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
