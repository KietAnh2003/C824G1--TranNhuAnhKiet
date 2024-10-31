package ss1_ss11.ss8_clean_code.repository;

import ss1_ss11.ss8_clean_code.entity.Student;

import java.io.*;
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
        List<Student> students = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/ss1_ss11/ss8_clean_code/datafiles/data.csv"));
            String line;
            long id;
            String name;
            String address;
            double point;
            String className;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    id = Long.parseLong(data[0]);
                    name = data[1];
                    address = data[2];
                    point = Double.parseDouble(data[3]);
                    className = data[4];
                    Student student = new Student((int) id, name, address, point, className);
                    students.add(student);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi");
        } catch (NumberFormatException e) {
            System.out.println("Lỗi");
        }
        return students;
    }

    public void addStudent(Student student) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/ss1_ss11/ss8_clean_code/datafiles/data.csv"));
            String studentData = student.getCode()
                    + "," + student.getName()
                    + "," + student.getAddress()
                    + "," + student.getPoint()
                    + "," + student.getClassName();
            bw.write(studentData);
            bw.newLine();
            System.out.println("Thêm học sinh thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi");
        }
    }


    public boolean editStudentByCode(long code, String newName, String newAddress, double newPoint, String newClassName) {
        for (Student student : students) {
            if (student.getCode() == code) {
                //cập nhật thông tin
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
                return student;
            }
        }
        return null;
    }

    public void remove() {
//        students.remove();
    }
}