package com.example.thi_module_3.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private double discountRate;
    private int stockQuantity;

    public Product() {
    }

    public Product(int id, String name, double price, double discountRate, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discountRate = discountRate;
        this.stockQuantity = stockQuantity;
    }

    public Product(String name, double price, double discountRate, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.discountRate = discountRate;
        this.stockQuantity = stockQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
