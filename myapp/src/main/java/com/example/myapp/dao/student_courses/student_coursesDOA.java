package com.example.myapp.dao.student_courses;

import com.example.myapp.entity.Cart;
import com.example.myapp.entity.Courses;
import com.example.myapp.entity.student_courses;

import java.util.List;

public interface student_coursesDOA {
    List<student_courses> findAll();
    List <Courses> findStudentCourses(int studentId);
    List<student_courses> enrollCoursesFromCart(List<Cart> cart);
    student_courses enrollCourse(student_courses sc);
    List<Courses> findStudentNotEnrolledCourses(List<Courses> z);
}
