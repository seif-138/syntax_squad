package com.example.myapp.dao.student_courses;

import com.example.myapp.Service.Cart.CartService;
import com.example.myapp.entity.Cart;
import com.example.myapp.entity.Courses;
import com.example.myapp.entity.Student;
import com.example.myapp.entity.student_courses;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class student_coursesDOAImpl implements student_coursesDOA{
    private EntityManager entityManager;
    private CartService cartService;
    @Autowired
    public student_coursesDOAImpl(EntityManager entityManager, CartService cartService) {
        this.entityManager = entityManager;
        this.cartService = cartService;
    }


//    public student_coursesDOAImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }




    @Override
    public List<student_courses> findAll() {
        TypedQuery<student_courses> query=entityManager.createQuery("from student_courses ",student_courses.class);
        List<student_courses> sc=query.getResultList();
        return sc;
    }

    @Override
    public List<Courses> findStudentCourses(int studentId) {
        TypedQuery<Courses> query=entityManager.createQuery(
                "select c from Courses c join student_courses sc on c.id=sc.course_id where sc.student_id=:sid",
                Courses.class);
        query.setParameter("sid",studentId);
        List<Courses> s=query.getResultList();
        return s;
    }
    @Override
    public List<Courses> findStudentNotEnrolledCourses(List<Courses> z) {
//        List<Integer> courseIds = z.stream().map(Courses::getId).collect(Collectors.toList());
        TypedQuery<Courses> query;
        System.out.println(z);
        if(!z.isEmpty()) {
            List<Integer> courseIds=new ArrayList<>();
            for(Courses cr:z){
                courseIds.add(cr.getId());
            }
           query = entityManager.createQuery(
                    "select c from Courses c where c.id not in :z",
                    Courses.class);
            query.setParameter("z", courseIds);
        }
        else{
           query=entityManager.createQuery("select c from Courses c", Courses.class);
        }
        List<Courses> s=query.getResultList();
        return s;
    }
    @Override
    public student_courses enrollCourse(student_courses sc){
        student_courses tmp= entityManager.merge(sc);
        return tmp;
    }
    @Override
    public List<student_courses> enrollCoursesFromCart(List<Cart> cart){
        List<student_courses> sc=new ArrayList<>();
        System.out.println("Cart: "+cart);
        for(Cart c:cart){
            student_courses s=new student_courses();
            System.out.println("c.getCourse_id():"+c.getCourse_id());
            System.out.println("c.getStudent_id():"+c.getStudent_id());

            s.setCourse_id(c.getCourse_id());
            s.setStudent_id(c.getStudent_id());
            s.setEnrolled_at(LocalDateTime.now());
            sc.add(s);
        }
        System.out.println("Sc:"+sc);
        List<student_courses> enrolled=new ArrayList<>();
        for(student_courses p:sc){
           entityManager.merge(p);
        }
        System.out.println("enr:"+enrolled);
        return enrolled;
    }
}
