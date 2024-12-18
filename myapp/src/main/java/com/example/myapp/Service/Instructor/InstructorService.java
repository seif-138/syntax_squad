package com.example.myapp.Service.Instructor;

import com.example.myapp.entity.Instructor;

import java.util.List;


public interface InstructorService{
    List<Instructor> findAll();
    Instructor findById(int id);
    Instructor findByEmail(String email);
    Instructor save(Instructor i);
    void deleteById(int id);
}
