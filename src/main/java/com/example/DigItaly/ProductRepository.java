package com.example.DigItaly;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            products.add(new Product( "Product " + i,"Brand name " + i, 40 + i, (Integer)(200+i)));
        }
    }

    // get one book
    public Product getProduct(int id) {
        for (Product product : products) {
            if (product.getId() ==id) {
                return product;
            }
        }
        return null;
    }

    // get all books
    public List<Product> getBooks() {
        return products;
    }

    // add a book
    public Product addProduct(Product product) {
        Product lastBook = products.get(products.size()-1);
        product.setId(lastBook.getId()+1); // set an id on the new book, should be unique, will be done by the database in future exercises
        products.add(product);
        return product;
    }

    // edit a book
    public Product editProduct(Product product) {
        Product productToEdit = this.getProduct(product.getId());
        if (productToEdit != null) {
            productToEdit.setBrand(product.getBrand());
            productToEdit.setName(product.getName());
            productToEdit.setPrice(product.getPrice());
        }
        return product;
    }

    // delete a book
    public void deleteBook(int id) {
        Product bookToDelete = this.getProduct(id);
        if (bookToDelete != null) {
            products.remove(bookToDelete);
        }
    }
}
