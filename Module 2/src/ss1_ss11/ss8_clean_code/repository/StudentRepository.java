package ss1_ss11.ss8_clean_code.repository;

import ss1_ss11.ss8_clean_code.entity.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    //    wrapper class , <> generic
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "Nguyễn Văn A", "Hà Nội", 10, "C0724G1"));
        students.add(new Student(3, "Trần Thị B", "Sì Gòn", 10, "C0724G1"));
        students.add(new Student(2, "Đỗ Đức C", "Hà Nội", 10, "C0724G1"));
    }

    public List<Student> getAll() {
        return students;
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public boolean editStudentByCode(long code, String newName, String newAddress, double newPoint, String newClassName) {
        for (Student student : students) {
            if (student.getCode() == code) {
                // Cập nhật thông tin
                student.setName(newName);
                student.setAddress(newAddress);
                student.setPoint(newPoint);
                student.setClassName(newClassName);
                return true;
            }
        }
        return false;
    }
    public Student getStudentByCode(long code) {
        for (Student student : students) {
            if (student.getCode() == code) {
                return student; // Trả về học sinh nếu tìm thấy
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }



    public void remove() {
//        students.remove();
    }
}