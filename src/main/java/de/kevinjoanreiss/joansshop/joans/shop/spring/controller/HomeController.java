package de.kevinjoanreiss.joansshop.joans.shop.spring.controller;

import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.Customer;
import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.CustomerOrder;
import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.Product;
import de.kevinjoanreiss.joansshop.joans.shop.spring.service.CustomerOrderServiceIF;
import de.kevinjoanreiss.joansshop.joans.shop.spring.service.ProductServiceIF;
import de.kevinjoanreiss.joansshop.joans.shop.spring.service.auth.AccountAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProductServiceIF productServiceIF;

    @Autowired
    CustomerOrderServiceIF customerOrderServiceIF;

    @Autowired
    AccountAuthenticationService accountAuthenticationService;

    @RequestMapping("/")
    public String starten(Model model) {
        model.addAttribute("productlist", productServiceIF.getProductlist());
        return "home";
    }

    @RequestMapping("/createProduct")
    public String createProduct() {
        return "createProduct";
    }


    @RequestMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping("/myOrders")
    public String getOrderPage(Model model) {
        Customer customer = accountAuthenticationService.getLoggedInUser();
        CustomerOrder customerOrder = customerOrderServiceIF.findOrderbyId(customer.getUserId());
        model.addAttribute("status", customerOrder.getStatus());
        System.out.println(customerOrder.getStatus());
        return "myOrders";
    }
}
