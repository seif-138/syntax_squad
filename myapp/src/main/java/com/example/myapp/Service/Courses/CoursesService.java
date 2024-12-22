package com.example.myapp.Service.Courses;

import com.example.myapp.entity.Courses;

import java.util.List;

public interface CoursesService {
    List<Courses> findAll();
    Courses findById(int id);
    void deleteById(int id) throws Exception;
    Courses save(Courses c);
}
