package ss12_ss23.ss17.entity;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private double price;
    private String company;
    private String describe;

    public Product(){

    }
    public Product(int id, String name, double price, String company, String describe){
        this.id = id;
        this.name = name;
        this.price = price;
        this.company = company;
        this.describe = describe;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
    public String toString (){
        return "Product {" + "id: " + id
                + ", name: " + name
                + ", price: " + price
                + ", company: " + company
                + ", describe: " + describe + "}";
    }
}
