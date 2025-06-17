package com.pluralsight.dao;

import com.pluralsight.model.Student;

import java.util.List;

public interface RegistrationDAO {

    public Long persistStudent(Student student);
    public Student findById(Long id);
    public List<Student> getAllStudents();
}