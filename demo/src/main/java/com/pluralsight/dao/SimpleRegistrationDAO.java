package com.pluralsight.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pluralsight.model.Student;

// Component tells Spring to create an object from the class and
// identify it as RegistrationDAO type. If any other component
// requires a RegistrationDAO type it will use this object created
// by Spring.

// The default scope for the object is singleton. Which means that
// it will be available for the duration of the application

@Component
public class SimpleRegistrationDAO implements RegistrationDAO {

    private HashMap<Long, Student> hashMap;
    private Long counter = 60L;

    public SimpleRegistrationDAO() {
        this.hashMap = new HashMap<Long, Student>();

        this.hashMap.put(10L, new Student(10L, "Marie", "Curie", "Science"));
        this.hashMap.put(22L, new Student(22L, "Albert", "Einstein", "Science"));
        this.hashMap.put(44L, new Student(44L, "Niels", "Bohr", "Science"));
        this.hashMap.put(54L, new Student(54L, "Carl", "Jung", "Psychology"));
    }

    @Override
    public Long persistStudent(Student student) {
        long freshId = counter++;
        this.hashMap.put(freshId,
                new Student(freshId, student.getFirstName(),
                        student.getLastName(),
                        student.getMajor()));
        return freshId;
    }

    @Override
    public Student findById(Long id) {
        return hashMap.get(id);
    }

    @Override
    public List<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<Student>(this.hashMap.values());
        return students;
    }


}