package de.kevinjoanreiss.joansshop.joans.shop.spring.service;

import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.Customer;

public interface CustomerServiceIF {

    public void createUser(Customer customer);

    public Customer login(String username, String password);

    public Customer findByUsername(String username);

    public void registerNewUser(Customer customer);
}
