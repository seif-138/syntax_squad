package com.example.myapp.Service.Student_course;
import com.example.myapp.dao.student_courses.student_coursesDOA;
import com.example.myapp.entity.Cart;
import com.example.myapp.entity.Courses;
import com.example.myapp.entity.student_courses;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Student_courseServiceImpl implements Student_courseService{
    private student_coursesDOA scDOA;
    @Autowired
    public Student_courseServiceImpl(student_coursesDOA scDOA) {
        this.scDOA = scDOA;
    }

    public List<student_courses> findAll(){
        return scDOA.findAll();
    };
    public List <Courses> findStudentCourses(int studentId){
        return scDOA.findStudentCourses(studentId);
    }
    @Transactional
    @Override
    public List<student_courses> enrollCoursesFromCart(List<Cart> cart) {
        return scDOA.enrollCoursesFromCart(cart);
    }
    @Transactional
    @Override
    public student_courses enrollCourse(student_courses sc) {
      return scDOA.enrollCourse(sc);
    }
    @Override
    public List<Courses> findStudentNotEnrolledCourses(List<Courses> z){return scDOA.findStudentNotEnrolledCourses(z);}

}
