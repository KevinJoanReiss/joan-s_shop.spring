package de.kevinjoanreiss.joansshop.joans.shop.spring.controller;

import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.CartItem;
import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.Customer;
import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.CustomerOrder;
import de.kevinjoanreiss.joansshop.joans.shop.spring.entity.Product;
import de.kevinjoanreiss.joansshop.joans.shop.spring.service.CustomerOrderServiceIF;
import de.kevinjoanreiss.joansshop.joans.shop.spring.service.ProductServiceIF;
import de.kevinjoanreiss.joansshop.joans.shop.spring.service.auth.AccountAuthenticationService;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShoppingCartController {
    ArrayList<CartItem> cart = new ArrayList<>();
    private int quantity = 1;
    private double total = 0;

    @Autowired
    private ProductServiceIF productServiceIF;

   @Autowired
   private AccountAuthenticationService accountAuthenticationService;

   @Autowired
   private CustomerOrderServiceIF customerOrderServiceIF;

    @RequestMapping("/cart")
    public String cart(Model model) {
        if (cart != null)
            model.addAttribute("cart", cart);
        return "cart";
    }

    @RequestMapping("/cart/buy/{id}")
    public String buy(Model model, @PathVariable long id) {
        if (!alreadyExists(id, cart)) {
            CartItem cartItem = new CartItem(productServiceIF.findProduct(id).get(), quantity);
            cart.add(cartItem);
            total = total + cartItem.getProduct().getPrice();
            model.addAttribute("cart", cart);
            model.addAttribute("total", String.valueOf(total));
        } else {
            CartItem cartItem = findCartItem(id);
            total = total + cartItem.getProduct().getPrice();
            int newQuantity = cartItem.getQuantity() + 1;
            cartItem.setQuantity(newQuantity);
            model.addAttribute("cart", cart);
            model.addAttribute("total", String.valueOf(total));
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
        CartItem cartItem = findCartItem(id);
        cart.remove(cartItem);
        total = total - cartItem.getQuantity() * cartItem.getProduct().getPrice();
        model.addAttribute("cart", cart);
        model.addAttribute("total", String.valueOf(total));
        return "cart";
    }

    public CartItem findCartItem(long id) {
        CartItem cartItem;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getCartItemId() == id) {
                cartItem = cart.get(i);
                return cartItem;
            }
        }
        return null;
    }

    @RequestMapping("/payOrder")
    public String payOrder() {
        Customer customer = accountAuthenticationService.getLoggedInUser();
        CustomerOrder customerOrder = new CustomerOrder(customer.getUserId(), total, "hilo");
        System.out.println(customerOrder.getStatus());
        customerOrderServiceIF.createOrder(customerOrder);
        System.out.println("successfully ordered");

        return "paymentSuccessful";
    }
}
