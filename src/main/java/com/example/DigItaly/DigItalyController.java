package com.example.DigItaly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    CustomerRepository customerRepository;


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

    @GetMapping ("/register")
    public String registerUser(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);

        return "registerCustomer";
    }

    @PostMapping("/register")
    public String registerUserPost(@ModelAttribute Customer customer) { //customerRepository must be added as input parameter
        customerRepository.save(customer);

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
