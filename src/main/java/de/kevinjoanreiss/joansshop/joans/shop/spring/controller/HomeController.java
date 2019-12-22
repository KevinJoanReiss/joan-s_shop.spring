package de.kevinjoanreiss.joansshop.joans.shop.spring.controller;

import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String starten(Model model) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Pfeffer", 1.29));
        products.add(new Product(2, "Salz", 1.29));
        products.add(new Product(3, "Oregano", 1.29));

        model.addAttribute("poductlist", products);

        return "home";
    }

}
