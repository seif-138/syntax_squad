package com.example.myapp.dao.Cart;

import com.example.myapp.Service.Courses.CoursesService;
import com.example.myapp.entity.Cart;
import com.example.myapp.entity.Courses;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CartDOAImpl implements CartDOA{
   private EntityManager entityManager;
    private CoursesService coursesService;
    @Autowired
    public CartDOAImpl(EntityManager entityManager, CoursesService coursesService) {
        this.entityManager = entityManager;
        this.coursesService = coursesService;
    }





    @Override
    public List<Cart> findByStudentId(int id) {
       TypedQuery<Cart> query=entityManager.createQuery("from  Cart c where c.student_id=:StudId",Cart.class);
     query.setParameter("StudId",id);
     List<Cart> crt=query.getResultList();
        return crt;
    }

    @Override
    public List<Courses> findItems(int StudentId) {
        TypedQuery<Cart> query=entityManager.createQuery("from Cart c where c.student_id=:StudId ",Cart.class);
        query.setParameter("StudId",StudentId);
        List<Cart> c=query.getResultList();
        List<Courses> course=new ArrayList<>();
        for(Cart o:c){
            course.add(coursesService.findById(o.getCourse_id()));
        }
        System.out.println("cart: "+c);
        System.out.println(course);
        return course;
    }

    @Override
    public void deleteByStudentAndCourseId(int sid, int cid) {
        TypedQuery<Cart> query=entityManager.createQuery("from Cart c where c.student_id=:sid and c.course_id=:cid",Cart.class);
        query.setParameter("sid",sid);
        query.setParameter("cid",cid);
        List<Cart> c=query.getResultList();
        for(Cart car:c){
            entityManager.remove(car);
        }
    }

    @Override
    public List<Cart> findByCourseIdAndStudentId(int sid, int cid) {
        TypedQuery<Cart> query=entityManager.createQuery("from Cart c where c.student_id=:sid and c.course_id=:cid",Cart.class);
        query.setParameter("sid",sid);
        query.setParameter("cid",cid);
        List<Cart> c=query.getResultList();
        return c;
    }

    @Override
    public void deleteListOfCartItems(List<Cart> c) {
        for(Cart tmp:c){
            entityManager.remove(tmp);
        }
    }

    @Override
    public Cart addItem(Cart i) {
        Cart c=entityManager.merge(i);
        return c;
    }
}
