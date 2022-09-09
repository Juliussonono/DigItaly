package com.example.DigItaly;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductRepository {
    private List<Product> products;


    public ProductRepository() {
        products = new ArrayList<>();
        
        products.add(new Product( "Parmigiano Reggiano", "Michelangelo", 49.0, 1));
        products.add(new Product( "Gelato Al Cioccolato", "GROM", 79.0, 2));
        products.add(new Product( "Italiensk Chokladglass", "Lejonet & Björnet", 55.0, 3));
        products.add(new Product( "Nougat Amaretti", "DigItaly", 39.0, 4));

        products.add(new Product( "Pasta", "Ambris", 39.0, 5));
        products.add(new Product( "Gianduiotti Cioccolato", "Sorini", 119.0, 6));
        products.add(new Product( "Vetemjöl", "Caputo", 55.0, 7));
        products.add(new Product( "Ferrero Rocher", "DigItaly", 79.0, 8));

    }


    /*
    public ProductRepository() {}

        for (int i = 1; i <= 22; i++) {
        products.add(new Product( "Product " + i,"Brand name " + i, 40 + i, (200+i)));
    }

     */

    public Product getProduct(int id) {
        for (Product product : products) {
            if (product.getId() ==id) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        Product lastProduct = products.get(products.size()-1);
        product.setId(lastProduct.getId()+1);
        products.add(product);
    }

    public Product editProduct(Product product) {
        Product productToEdit = this.getProduct(product.getId());
        if (productToEdit != null) {
            productToEdit.setBrand(product.getBrand());
            productToEdit.setName(product.getName());
            productToEdit.setPrice(product.getPrice());
        }
        return product;
    }

    public void deleteProduct(int id) {
        Product productToDelete = this.getProduct(id);
        if (productToDelete != null) {
            products.remove(productToDelete);
        }
    }
}
