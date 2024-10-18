package ss5_access_modifier;

public class Student {
    private String name = "John";
    private String classes = "C02";
    public Student(){
    }
    public void setName(String name){
        this.name = name;
    }
    public void setClasses(String classes){
        this.classes = classes;
    }
}
class Test{
    public static void main(String[] args) {
        Student student = new Student();

        student.setName("Kiet");
        student.setClasses("C04");
    }
}
