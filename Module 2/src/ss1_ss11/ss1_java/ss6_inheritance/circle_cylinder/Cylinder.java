package ss1_ss11.ss1_java.ss6_inheritance.circle_cylinder;

public class Cylinder extends Circle{
    private double height;

    public Cylinder(){
        super();
        this.height = 2;
    }
    public Cylinder(double radius,double height){
        super(radius,"red");
        this.height = height;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public double getHeight(){
        return height;
    }
    public double getVolume(){
        return getArea() * height;
    }
    public String toString(){
        return "Cylinder{Radius=" + getRadius() + ", Height=" + height + ", Color=" + getColor() + "}" ;
    }

}
