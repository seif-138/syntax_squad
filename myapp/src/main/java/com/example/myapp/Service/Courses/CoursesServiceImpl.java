package com.example.myapp.Service.Courses;

import com.example.myapp.dao.Courses.CoursesDOA;
import com.example.myapp.entity.Courses;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService{
    private CoursesDOA coursesDOA;
    @Autowired
    public CoursesServiceImpl(CoursesDOA coursesDOA) {
        this.coursesDOA = coursesDOA;
    }

    @Override
    public List<Courses> findAll() {
        return coursesDOA.findAll();
    }

    @Override
    public Courses findById(int id) {
        return coursesDOA.findById(id);
    }
    @Transactional
    @Override
    public void deleteById(int id) throws Exception {
        coursesDOA.deleteById(id);
    }
}
