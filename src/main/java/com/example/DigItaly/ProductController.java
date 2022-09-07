package com.example.DigItaly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class ProductController {

    private static final int PAGE_SIZE = 10;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String products(Model model, @RequestParam (value="page", required=false, defaultValue="1") int page) {

        List<Product> products = getPage(page-1);
        int pageCount = numberOfPages();
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
        model.addAttribute("product", product);

        return "product";
    }

    private int[] toArray(int num) {
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            result[i] = i+1;
        }
        return result;
    }

    private List<Product> getPage(int page) {
        List<Product> products = productRepository.getProducts();
        int from = Math.max(0,page* ProductController.PAGE_SIZE);
        int to = Math.min(products.size(),(page+1)* ProductController.PAGE_SIZE);

        return products.subList(from, to);
    }

    private int numberOfPages() {
        List<Product> products = productRepository.getProducts();
        return (int)Math.ceil((double) products.size() / ProductController.PAGE_SIZE);
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "form";
    }

    @PostMapping("/save")
    public String set(@ModelAttribute Product product) {
        if (product.isNew()) {
            productRepository.addProduct(product);
        }
        else {
            productRepository.editProduct(product);
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Integer id) {
        Product product = productRepository.getProduct(id);
        model.addAttribute(product);
        return "form";
    }

}
