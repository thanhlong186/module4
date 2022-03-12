package com.bai_tap.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private String descripttionProduct;
    private String manufacture;

    public Product() {
    }

    public Product(int id, String name, double price, String descripttionProduct, String manufacture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.descripttionProduct = descripttionProduct;
        this.manufacture = manufacture;
    }

    public Product(String name, double price, String descripttionProduct, String manufacture) {
        this.name = name;
        this.price = price;
        this.descripttionProduct = descripttionProduct;
        this.manufacture = manufacture;
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

    public String getDescripttionProduct() {
        return descripttionProduct;
    }

    public void setDescripttionProduct(String descripttionProduct) {
        this.descripttionProduct = descripttionProduct;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}
