package de.kevinjoanreiss.joansshop.joans.shop.spring.service;

import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.User;
import de.kevinjoanreiss.joansshop.joans.shop.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserServiceIF {

    public void createUser(User user);

    public User login(String username, String password);

    public User findByUsername(String username);
}
