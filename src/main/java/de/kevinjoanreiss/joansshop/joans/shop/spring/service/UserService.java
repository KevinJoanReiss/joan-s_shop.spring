package de.kevinjoanreiss.joansshop.joans.shop.spring.service;

import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.User;
import de.kevinjoanreiss.joansshop.joans.shop.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
/*@Service
@Transactional
public class UserService implements UserServiceIF {

    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        User user = this.findByUsername(username);
        if(user != null) {

        }
        return null;
    }

    @Override
    public User findByUsername(String username) {
        Iterable<User> userList = userRepository.findAll();
        for(User user: userList) {
            if(user.getUsername() == username) {
                return user;
            }
        }
        return null;
    }
}*/
