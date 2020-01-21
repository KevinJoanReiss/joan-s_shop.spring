package de.kevinjoanreiss.joansshop.joans.shop.spring.controller;

import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.Product;
import de.kevinjoanreiss.joansshop.joans.shop.spring.service.ProductServiceIF;
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

    @RequestMapping("/")
    public String starten(Model model) {
        model.addAttribute("productlist", productServiceIF.getProductlist());
        return "home";
    }

    @RequestMapping("/createProduct")
    public String createProduct() {
        return "createProduct";
    }


    @RequestMapping("/loginPage")
    public String getLoginPage() {
        return "login";
    }
}
