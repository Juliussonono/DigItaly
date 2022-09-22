package com.example.DigItaly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping ("/cart")
    public String cart() {
        return "cart";
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
