package de.kevinjoanreiss.joansshop.joans.shop.spring.controller;

import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.Address;
import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.Customer;
import de.kevinjoanreiss.joansshop.joans.shop.spring.service.CustomerServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

    @Autowired
    private CustomerServiceIF customerServiceIF;

    @RequestMapping("/registration")
    public String showSignUp(Model model) {
        return "registrationPage";
    }

    @RequestMapping("/registerUser")
    public String registerCustomer(@ModelAttribute("firstName") String firstName,
                                   @ModelAttribute("lastName") String lastName,
                                   @ModelAttribute("email") String email,
                                   @ModelAttribute("passwordReg") String password,
                                   @ModelAttribute("streetName") String streetName,
                                   @ModelAttribute("zipCode") int zipCode,
                                   @ModelAttribute("city") String city) {
        System.out.println("hilo");

        Customer newCustormer = new Customer(email, firstName, lastName, password,
                new Address(streetName, zipCode, city));
        System.out.println("hilo jlo:" + newCustormer);
        customerServiceIF.registerNewUser(newCustormer);
        return "redirect:/";
    }
}
