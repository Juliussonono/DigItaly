package com.example.DigItaly;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfileCustomerController {

    @GetMapping("/profileCustomer")
    public String profileCustomer(Model model) {
        List<ProfileCustomer> profileCustomer = new ArrayList<>();
        model.addAttribute("profileCustomer", profileCustomer);
    return "profileCustomer";
    }

    @GetMapping("*/AddProfileCustomer")
    public String add(Model model) {
        model.addAttribute("profileCustomer", new ProfileCustomer());
        return "profileCustomerForm";
    }
    @PostMapping ("/saveProfileCustomer")
    public String set(@ModelAttribute ProfileCustomer profilecustomer) {
        return "redirect:/ProfileCustomer";
    }

}
