package com.pluralsight.dao;

import com.pluralsight.model.Student;

public interface RegistrationDAO {

    public Long persistStudent(Student student);
    public Student findById(Long id);
}