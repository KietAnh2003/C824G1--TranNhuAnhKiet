package ss1_ss11.ss8_clean_code.sort;

import ss1_ss11.ss8_clean_code.entity.Student;

import java.util.Comparator;

public class ComparatorStudentByName implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}