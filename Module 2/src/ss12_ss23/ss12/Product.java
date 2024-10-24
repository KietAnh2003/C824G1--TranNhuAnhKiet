package ss12_ss23.ss12;

public class Product {
    private int id;
    private String name;
    private double price;

    public Product (int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String toString(){
        return "ID: " + id + ", Name: " + name + ", Price: " + price;
    }
}
