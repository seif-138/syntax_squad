package com.example.myapp.Service.Student;

import com.example.myapp.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(int id);
    Student findByEmail(String mail);
    Student save(Student s);
    void deleteById(int id);
}
