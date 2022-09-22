package com.example.DigItaly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DigItalyController {

    /* // Now products is the default home page
    @GetMapping ("/")
    public String home() {
        return "home";
    }
     */
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProfileCustomerRepository customerRepository;

/*
    @GetMapping ("/cart/{id}")
    public String cart(Model model, @PathVariable Integer id, HttpSession session) {
        // Now it resets the cart each time, have to add if a cart in the session exists. If null make new, otherwise add to existing.
        Product product = productRepository.findById(id).get();
        model.addAttribute(product);
        List<Product> cart = new ArrayList<Product>();
        cart.add(product);
        session.setAttribute("cart", cart);
        return "cart";
    }

 */

    @PostMapping ("/cart/{id}")
    public String cart(Model model, @PathVariable Integer id, HttpSession session) {
        Product product = productRepository.findById(id).get();
        if (session.getAttribute("cart") == null) {
            List<ItemQuantity> cart = new ArrayList<ItemQuantity>();
            cart.add(new ItemQuantity(product, 1));
            session.setAttribute("cart", cart);
        } else {
            List<ItemQuantity> cart = (List<ItemQuantity>) session.getAttribute("cart");
            int index = this.exists(id, cart);
            if (index == -1) {
                cart.add(new ItemQuantity(product, 1));
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("cart", cart);
        } return "cart";
    }

    private int exists(Integer id, List<ItemQuantity> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    @GetMapping ("/login")
    public String login() {
        return "login";
    }

    @GetMapping ("/products")
    public String products() {
        return "products";
    }

    @GetMapping ("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping ("/registerUser")
    public String registerUser(Model model) {
        ProfileCustomer customer = new ProfileCustomer();
        model.addAttribute("customer", customer);

        return "registerUser";
    }

    @PostMapping("/registerUser")
    public String registerUserPost(@ModelAttribute ProfileCustomer customer) { //customerRepository must be added as input parameter
        customerRepository.addProfileCustomers(customer);
        System.out.println(customer.getFirstName());
        System.out.println(customer.getUsername());

        // customerRepository.add(customer); ---> kunden ska läggas in i customerRepository för att lista alla kunder
        return "redirect:/login";
    }

    @GetMapping ("/secretEdit")
    public String addProducts(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "secretEdit";
    }

    @PostMapping("/secretEdit")
    public String sendToRepository(@ModelAttribute Product product){

        productRepository.save(product);

        return "redirect:/";
    }
}
