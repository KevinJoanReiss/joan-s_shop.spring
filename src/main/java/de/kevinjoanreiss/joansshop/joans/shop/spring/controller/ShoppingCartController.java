package de.kevinjoanreiss.joansshop.joans.shop.spring.controller;

import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.CartItem;
import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.Product;
import de.kevinjoanreiss.joansshop.joans.shop.spring.service.ProductServiceIF;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShoppingCartController {
    List<CartItem> cart = new ArrayList<>();
    private int quantity = 1;

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

    @RequestMapping("/cart")
    public String cart(Model model) {
        if (cart != null)
            model.addAttribute("cart", cart);
        return "cart";
    }

    @RequestMapping("/cart/buy/{id}")
    public String buy(Model model, @PathVariable long id) {
        if (!alreadyExists(id, cart)) {
            cart.add(new CartItem(productServiceIF.findProduct(id).get(), quantity));
            model.addAttribute("cart", cart);
        } else {
            CartItem cartItem = cart.get((int) (id - 1));
            int newQuantity = cartItem.getQuantity() + 1;
            cartItem.setQuantity(newQuantity);
            model.addAttribute("cart", cart);
        }
        return "cart";
    }

    @RequestMapping("/insertQuantity")
    public void addQuantity(@ModelAttribute("quantity") int quantity) {
        this.quantity = quantity;
    }

    private boolean alreadyExists(long id, List<CartItem> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getProductId() == id) {
                return true;
            }
        }
        return false;
    }

    @RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable long id, Model model) {
        cart.remove(findCartItem(id));
        model.addAttribute("cart", cart);
        return "cart";
    }

    public CartItem findCartItem(long id) {
        CartItem cartItem;
        for(int i = 0; i < cart.size(); i++) {
            if(cart.get(i).getCartItemId() == id) {
                cartItem = cart.get(i);
                return cartItem;
            }
        }
        return null;
    }
}
