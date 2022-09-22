package com.example.DigItaly;

public class ItemQuantity {

    private Product product;
    private int quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ItemQuantity() {
    }

    public ItemQuantity(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

}
