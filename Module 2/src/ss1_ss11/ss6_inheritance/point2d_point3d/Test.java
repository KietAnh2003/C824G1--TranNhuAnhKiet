package ss1_ss11.ss6_inheritance.point2d_point3d;

public class Test {
    public static void main(String[] args) {
        Point2D point2d1 = new Point2D();
        System.out.println("point2D1: " + point2d1);

        Point2D point2d2 = new Point2D(2.3f, 4.0f);
        System.out.println("point2D2: " + point2d2);

        point2d1.setXY(5.5f, 6.6f);
        float[] xy = point2d1.getXY();
        System.out.println("Set XY and get XY, point2D1: (" + xy[0] + ", " + xy[1] + ")");
        System.out.println();

        //point3D
        Point3D point3d1 = new Point3D();
        System.out.println("point3D1: " + point3d1);

        Point3D point3d2 = new Point3D(2.3f, 0.1f, 0.8f);
        System.out.println("point3D2: " + point3d2);

        point3d1.setXYZ(7.7f, 8.8f, 9.9f);
        float[] xyz = point3d1.getXYZ();
        System.out.println("Set XYZ and get XYZ, point3D1: (" + xyz[0] + ", " + xyz[1] + ", " + xyz[2] + ")");
    }
}
