package com.example.DigItaly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class ProductController {

    private static final int PAGE_SIZE = 10;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String products(RestTemplate restTemplate, Model model, @RequestParam(value="page", required=false, defaultValue="1") int page) {
        List<Product> products = getPage(page-1, PAGE_SIZE);
        int pageCount = numberOfPages(PAGE_SIZE);
        int[] pages = toArray(pageCount);

         model.addAttribute("products", products);
          model.addAttribute("pages", pages);
        model.addAttribute("currentPage", page);
        model.addAttribute("showPrev", page > 1);
        model.addAttribute("showNext", page < pageCount);



        return "products";
    }

    @GetMapping("/product/{page}/{id}")
    public String product(Model model, @PathVariable Integer page, @PathVariable Integer id) {
        Product product = productRepository.getProduct(id);
        model.addAttribute("page", page);
        model.addAttribute("products", product);

        return "product";
    }


    private int[] toArray(int num) {
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            result[i] = i+1;
        }
        return result;
    }

    private List<Product> getPage(int page, int pageSize) {
        List<Product> products = productRepository.getProducts();
        int from = Math.max(0,page*pageSize);
        int to = Math.min(products.size(),(page+1)*pageSize);

        return products.subList(from, to);
    }

    private int numberOfPages(int pageSize) {
        List<Product> products = productRepository.getProducts();
        return (int)Math.ceil(new Double(products.size()) / pageSize);
    }

    /*
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "form";
    }

    @PostMapping("/save")
    public String set(@ModelAttribute Product product) {
        if (product.isNew()) {
            productRepository.addProduct(product); // todo replace with call POST /book (with book object as json in request body)
        }
        else {
            productRepository.editProduct(product);
            // todo replace with call PUT /book/{id} (with book object as json in request body
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        Product product = productRepository.getProducts(id); // todo replace with call GET /book/{id}
        model.addAttribute(product);
        return "form";
    }

     */



}
