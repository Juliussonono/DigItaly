package com.example.DigItaly;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DigItalyController {

    @GetMapping ("/")
    public String home() {
        return "home";
    }

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
    public String registerUser() {
        return "registerUser";
    }

}
