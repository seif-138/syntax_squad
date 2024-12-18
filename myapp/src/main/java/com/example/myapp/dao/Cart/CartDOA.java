package com.example.myapp.dao.Cart;

import com.example.myapp.entity.Cart;
import com.example.myapp.entity.Courses;

import java.util.List;

public interface CartDOA {
    List<Cart> findByStudentId(int id);
    List<Cart> findByCourseIdAndStudentId(int sid,int cid);
    List<Courses> findItems(int StudentId);
    void deleteByStudentAndCourseId(int sid,int cid);
    void deleteListOfCartItems(List<Cart> c);
    Cart addItem(Cart i);
}
