package com.example.myapp.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int payment_id;
    @Column(name = "student_id" )

    private int student_id;
    @Column(name = "course_id")
    private int course_id;
    @Column(name = "payment_date")
    private LocalDate payment_date;

    @ManyToOne
    @JoinColumn(name = "Student_id",insertable=false, updatable=false)
    private Student sp;

    public Payment() {
    }

    public Payment(int payment_id, int student_id, int course_id) {
        this.payment_id = payment_id;
        this.student_id = student_id;
        this.course_id = course_id;
    }

    public Payment(int payment_id, int student_id, int course_id, LocalDate payment_date) {
        this.payment_id = payment_id;
        this.student_id = student_id;
        this.course_id = course_id;
        this.payment_date = payment_date;

    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
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

    public LocalDate getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(LocalDate payment_date) {
        this.payment_date = payment_date;
    }

    public Student getSp() {
        return sp;
    }

    public void setSp(Student sp) {
        this.sp = sp;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment_id=" + payment_id +
                ", student_id=" + student_id +
                ", course_id=" + course_id +
                ", payment_date=" + payment_date +


                '}';
    }
}
