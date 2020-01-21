package de.kevinjoanreiss.joansshop.joans.shop.spring.service;

import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.CustomerOrder;
import de.kevinjoanreiss.joansshop.joans.shop.spring.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderService implements CustomerOrderServiceIF {

   @Autowired
   CustomerOrderRepository customerOrderRepository;

    @Override
    public void createOrder(CustomerOrder customerOrder) {
        customerOrderRepository.save(customerOrder);
    }

    @Override
    public CustomerOrder findOrderbyId(long id) {
       return customerOrderRepository.findById(id).get();
    }
}
