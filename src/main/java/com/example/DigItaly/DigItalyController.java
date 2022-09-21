package com.example.DigItaly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

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
