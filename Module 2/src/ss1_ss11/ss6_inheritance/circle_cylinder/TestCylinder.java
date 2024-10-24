package ss1_ss11.ss6_inheritance.circle_cylinder;

public class TestCylinder {
    public static void main(String[] args) {
        Cylinder cylinder1 = new Cylinder();
        System.out.println(cylinder1);
        System.out.println("Volume cylinder1 is: " + cylinder1.getVolume());
        System.out.println();

        Cylinder cylinder2 = new Cylinder(4,5);
        System.out.println(cylinder2);
        System.out.println("Volume cylinder2 is: " + cylinder2.getVolume());
    }
}
