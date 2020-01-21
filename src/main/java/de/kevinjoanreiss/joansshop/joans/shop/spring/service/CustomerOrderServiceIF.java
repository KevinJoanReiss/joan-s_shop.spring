package de.kevinjoanreiss.joansshop.joans.shop.spring.service;

import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.CustomerOrder;

public interface CustomerOrderServiceIF {
    public void createOrder(CustomerOrder customerOrder);
    public CustomerOrder findOrderbyId(long id);
}
