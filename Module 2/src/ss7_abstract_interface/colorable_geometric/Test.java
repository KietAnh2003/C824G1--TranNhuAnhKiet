package ss7_abstract_interface.colorable_geometric;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random rand = new Random();
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5.0);
        shapes[1] = new Rectangle(4.0, 6.0);
        shapes[2] = new Square(4.0);

        for (Shape shape : shapes) {
            System.out.println("Shape: " + shape);
            System.out.println("Initial Area: " + shape.getArea());

            double randomPercent = 1 + rand.nextInt(100);
            shape.resize(randomPercent);

            System.out.println("Resized by " + randomPercent + "%");
            System.out.println("New Area: " + shape.getArea());;
            System.out.println();
        }
    }
}
