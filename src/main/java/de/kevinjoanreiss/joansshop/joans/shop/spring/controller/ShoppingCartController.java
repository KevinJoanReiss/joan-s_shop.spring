package de.kevinjoanreiss.joansshop.joans.shop.spring.controller;

import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.CartItem;
import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.Product;
import de.kevinjoanreiss.joansshop.joans.shop.spring.service.ProductServiceIF;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShoppingCartController {

    @Autowired
    private ProductServiceIF productServiceIF;

   /* @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "cart";
    }

    @RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
    public String buy(
            @PathVariable("id") long id, ModelMap modelMap, HttpSession session) {
        System.out.println("hilo");
        if (session.getAttribute("cart") == null) {
            List<CartItem> cart = new ArrayList<>();
            cart.add(new CartItem(productServiceIF.findProduct(id), 1));
            session.setAttribute("cart", cart);
        } else {

        }
        return "redirect:../../index";
    }*/

    @RequestMapping("/cart/buy/{id}")
    public String buy(Model model, @PathVariable long id) {
        List<CartItem> cart = new ArrayList<>();
        cart.add(new CartItem(productServiceIF.findProduct(id)));
       // model.addAttribute("cart", cart);
        return "cart";
    }
}
