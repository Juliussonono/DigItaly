package com.example.DigItaly;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class DigItalyController {

    /* // Now products is the default home page
    @GetMapping ("/")
    public String home() {
        return "home";
    }
     */

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

    @GetMapping ("/registerUser")
    public String registerUser(Model model) {
        ProfileCustomer customer = new ProfileCustomer();
        model.addAttribute("customer", customer);

        return "registerUser";
    }

    @PostMapping("/registerUser")
    public String registerUserPost(@ModelAttribute ProfileCustomer customer) {
        System.out.println(customer.getFirstName());
        System.out.println(customer.getUsername());

        // customerRepository.add(customer); ---> kunden ska läggas in i customerRepository för att lista alla kunder
        return "registerUser";
    }
}
