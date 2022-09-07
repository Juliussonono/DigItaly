package com.example.DigItaly;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();

        for (int i = 1; i <= 22; i++) {
            products.add(new Product( "Product " + i,"Brand name " + i, 40 + i, (200+i)));
        }
    }

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

    public Product addProduct(Product product) {
        Product lastProduct = products.get(products.size()-1);
        product.setId(lastProduct.getId()+1);
        products.add(product);
        return product;
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
