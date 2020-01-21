package de.kevinjoanreiss.joansshop.joans.shop.spring.controller;

import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.CustomerOrder;
import de.kevinjoanreiss.joansshop.joans.shop.spring.service.CustomerOrderServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    CustomerOrderServiceIF customerOrderServiceIF;


    @RequestMapping(value = "/getOrderStatus/{id}/{status}", method = RequestMethod.POST)
    public CustomerOrder getOrderStatus(@PathVariable("id") long id, @PathVariable("status") String status) {
        CustomerOrder customerOrder = customerOrderServiceIF.findOrderbyId(id);
        customerOrder.setStatus(status);
        System.out.println("why are you running");
        customerOrderServiceIF.createOrder(customerOrder);
        return customerOrder;
    }
}
