package ss1_ss11.ss8_clean_code.entity;

public class Student extends Person{
    private double point;
    private String className;
    public Student(){

    }
    public Student(int id, String name, String address, double point, String className){
        super(id, name, address );
        this.point = point;
        this.className = className;
    }

    public double getPoint() {
        return point;
    }

    public String getClassName() {
        return className;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
