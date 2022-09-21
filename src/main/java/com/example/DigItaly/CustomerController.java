package com.example.DigItaly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/profileCustomer")
    public String profileCustomer(Model model) {
        List<Customer> profileCustomer = new ArrayList<>();
        model.addAttribute("profileCustomer", profileCustomer);
    return "profileCustomer";
    }

    @GetMapping("*/AddProfileCustomer")
    public String add(Model model) {
        model.addAttribute("profileCustomer", new Customer());
        return "profileCustomerForm";
    }
    @PostMapping ("/saveProfileCustomer")
    public String set(@ModelAttribute Customer profilecustomer) {
        return "redirect:/ProfileCustomer";
    }

}
