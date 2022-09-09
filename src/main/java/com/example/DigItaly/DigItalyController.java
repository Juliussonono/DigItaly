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
        System.out.println(customer.getFirstName());
        System.out.println(customer.getUsername());

        // customerRepository.add(customer); ---> kunden ska läggas in i customerRepository för att lista alla kunder
        return "registerUser";
    }

    @GetMapping ("/secretEdit")
    public String addProducts(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("products", productRepository);
        return "secretEdit";
    }

    @PostMapping("/secretEdit")
    public String sendToRepository(@ModelAttribute Product product, RestTemplate restTemplate){
        //restTemplate.postForObject("http://localhost:8080", product, Product.class);
        //restTemplate.put("http://localhost:8080/", product, Product.class);
        //restTemplate.put("http://localhost:8080/book/" + product.getId(), product, Product.class);
        productRepository.addProduct(product);


        return "redirect:/";
    }
}
