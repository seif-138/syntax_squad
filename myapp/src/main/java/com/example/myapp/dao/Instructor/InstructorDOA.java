package com.example.myapp.dao.Instructor;

import com.example.myapp.entity.Instructor;
import com.example.myapp.entity.Student;

import java.util.List;

public interface InstructorDOA {
    List<Instructor> findAll();
    Instructor findById(int id);
    Instructor findByEmail(String email);
    Instructor save(Instructor i);
    void deleteById(int id);
}
