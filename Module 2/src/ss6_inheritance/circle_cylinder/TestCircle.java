package ss6_inheritance.circle_cylinder;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println(circle1);
        System.out.println("Area circle1 is: " + circle1.getArea() );

        Circle circle2 = new Circle(3,"white");
        System.out.println(circle2);
        System.out.println("Area circle2 is: " + circle2.getArea());
    }
}
