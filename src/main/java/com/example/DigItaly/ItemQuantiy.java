package com.example.DigItaly;

public class ItemQuantiy {
    private Product product;
    private int quantity;

    public ItemQuantiy(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public ItemQuantiy(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
