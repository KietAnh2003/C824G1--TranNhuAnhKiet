package ss5_access_modifier;
public class Circle {
    private double radius = 1.0;
    private String color = "red";
    public Circle(){
    }
    public Circle(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    public double getArea(){
        return Math.PI * radius * radius;
    }
}
class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println("Radius: " + circle1.getRadius());
        System.out.println("Area: " + circle1.getArea());

        Circle circle2 = new Circle(3);
        System.out.println("Radius: " + circle2.getRadius());
        System.out.println("Area: " + circle2.getArea());
    }
}

