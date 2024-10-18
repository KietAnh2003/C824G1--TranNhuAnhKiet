package ss6_inheritance.circle_cylinder;

public class Circle {
    private double radius;
    private String color;

    public Circle(){
        this.radius = 2;
        this.color = "red";
    }
    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }
    public double getArea(){
        return Math.PI * radius * radius;
    }
    public String toString(){
        return "Circle{radius=" + radius + ", color=" + color + "}";
    }


}
