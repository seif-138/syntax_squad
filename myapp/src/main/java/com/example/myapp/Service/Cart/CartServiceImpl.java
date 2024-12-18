package com.example.myapp.Service.Cart;

import com.example.myapp.dao.Cart.CartDOA;
import com.example.myapp.entity.Cart;
import com.example.myapp.entity.Courses;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    private CartDOA cartDOA;
    @Autowired

    public CartServiceImpl(CartDOA cartDOA) {
        this.cartDOA = cartDOA;
    }

    @Override
    public List<Cart> findByStudentId(int id) {
        return cartDOA.findByStudentId(id);
    }

    @Override
    public List<Courses> findItems(int StudentId) {
        return cartDOA.findItems(StudentId);
    }

    @Override
    public List<Cart> findByCourseIdAndStudentId(int sid, int cid) {
        return cartDOA.findByCourseIdAndStudentId(sid,cid);
    }
    @Transactional
    @Override
    public void deleteListOfCartItems(List<Cart> c) {
        cartDOA.deleteListOfCartItems(c);
    }

    @Transactional
    @Override
    public void deleteByStudentAndCourseId(int sid, int cid) {
        cartDOA.deleteByStudentAndCourseId(sid,cid);
    }
    @Transactional
    @Override
    public Cart addItem(Cart i) {
        return cartDOA.addItem(i);
    }
}
