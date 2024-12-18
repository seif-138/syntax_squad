package com.example.myapp.dao.Courses;

import com.example.myapp.entity.Courses;

import java.util.List;

public interface CoursesDOA {
    List<Courses> findAll();
    Courses findById(int id);
    void deleteById(int id) throws Exception;
    Courses save(Courses c);

}
