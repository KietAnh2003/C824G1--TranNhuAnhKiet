package ss1_ss11.ss8_clean_code.service;

import ss1_ss11.ss8_clean_code.entity.Student;

import java.util.List;

public interface IPersonService<E> {
    List<E> getAll();
    List<E> addStudent();
    List<E> getAllSortById();
    boolean editStudentByCode(long code, String name, String address, double point, String className);

    Student getStudentByCode(long code);
}
