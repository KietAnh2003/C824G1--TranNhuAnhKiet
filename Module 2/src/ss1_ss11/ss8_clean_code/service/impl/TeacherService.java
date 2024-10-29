package ss1_ss11.ss8_clean_code.service.impl;

import ss1_ss11.ss8_clean_code.entity.Student;
import ss1_ss11.ss8_clean_code.entity.Teacher;
import ss1_ss11.ss8_clean_code.service.ITeacherService;

import java.util.List;
public class TeacherService implements ITeacherService {
    @Override
    public List<Teacher> getAll() {
        return List.of();
    }

    @Override
    public List<Teacher> addStudent() {
        return null;
    }

    @Override
    public List<Teacher> getAllSortById() {
        return List.of();
    }

    @Override
    public boolean editStudentByCode(long code, String name, String address, double point, String className) {
        return false;
    }

    @Override
    public Student getStudentByCode(long code) {
        return null;
    }
}