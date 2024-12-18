package com.example.myapp.Service.Cart;

import com.example.myapp.entity.Cart;
import com.example.myapp.entity.Courses;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CartService {
    List<Cart> findByStudentId(int id);
    List<Courses> findItems(int StudentId);
    List<Cart> findByCourseIdAndStudentId(int sid,int cid);
    void deleteListOfCartItems(List<Cart> c);
    void deleteByStudentAndCourseId(int sid,int cid);
    Cart addItem(Cart i);
}
