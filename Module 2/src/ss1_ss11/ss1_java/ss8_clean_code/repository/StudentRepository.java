package ss1_ss11.ss1_java.ss8_clean_code.repository;

import ss1_ss11.ss1_java.ss8_clean_code.entity.Student;

public class StudentRepository {
    private static  Student[] students = new Student[5];
    static {
        students[0] = new Student(1, "Trần Như A", "Hà Nội", 10, "C0824");
        students[1] = new Student(1, "Trần Như A", "Hà Nội", 10, "C0824");
        students[2] = new Student(1, "Trần Như A", "Hà Nội", 10, "C0824");
        students[3] = new Student(1, "Trần Như A", "Hà Nội", 10, "C0824");
        students[4] = new Student(1, "Trần Như A", "Hà Nội", 10, "C0824");
    }
    public Student[] getAll(){
        return students;
    }
}
