package com.example.myapp.dao.Student;

import com.example.myapp.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();
    Student findById(int id);
    Student findByRecoveryKey(String key);
    Student findByEmail(String mail);
    Student save(Student s);
    void deleteById(int id);
}
