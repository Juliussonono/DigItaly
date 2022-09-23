package com.example.DigItaly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

   /* @GetMapping("/profileCustomer")
    public String profileCustomer(Model model) {
        List<Customer> profileCustomer = new ArrayList<>();
        model.addAttribute("profileCustomer", profileCustomer);
    return "profileCustomer";
    }*/

    @GetMapping("/ProfileCustomer/{id}")
    public String profile(Model model , @PathVariable int id) {
        Customer customer =customerRepository.findById(id).get();
        model.addAttribute("customer", customer);
        model.addAttribute("id",id);
        return "profileCustomer";
    }

    @PostMapping("/ProfileCustomer/{id}")
    public String showProfile(@ModelAttribute Customer customer , @PathVariable Integer id, @RequestParam String username, @RequestParam String password, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String address) {
        customerRepository.save(customer);
        return "profileCustomer";
    }
    @PostMapping ("/saveProfileCustomer")
    public String set(@ModelAttribute Customer profilecustomer) {
        return "redirect:/ProfileCustomer";
    }

}
