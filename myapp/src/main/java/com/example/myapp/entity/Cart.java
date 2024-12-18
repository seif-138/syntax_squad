package com.example.myapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int cart_id;
    @Column(name = "student_id")
    private int student_id;
    @Column(name = "course_id")
    private int course_id;

    public Cart() {
    }

    public Cart(int cart_id, int student_id, int course_id) {
        this.cart_id = cart_id;
        this.student_id = student_id;
        this.course_id = course_id;
    }

    public Cart(int student_id, int course_id) {
        this.student_id = student_id;
        this.course_id = course_id;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cart_id=" + cart_id +
                ", student_id=" + student_id +
                ", course_id=" + course_id +
                '}';
    }
}
