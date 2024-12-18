package com.example.myapp.Service.Student_course;

import com.example.myapp.entity.Cart;
import com.example.myapp.entity.Courses;
import com.example.myapp.entity.student_courses;
import org.springframework.stereotype.Service;

import java.util.List;
//@Service
public interface Student_courseService {
    List<student_courses> findAll();
    List <Courses> findStudentCourses(int studentId);
    List<student_courses> enrollCoursesFromCart(List<Cart> cart);
    student_courses enrollCourse(student_courses sc);
    List<Courses> findStudentNotEnrolledCourses(List<Courses> z);
}
