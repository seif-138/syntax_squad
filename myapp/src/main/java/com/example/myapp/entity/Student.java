package com.example.myapp.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Student_id")
    private int Student_id;
    @Column(name="first_name")
   private String first_name;
    @Column(name="last_name")
    private String last_name;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
    @Column(name="Payment_Card")
    private int paymentCard;

    @OneToMany(mappedBy = "sp")
    private List<Payment> p;

    /**-------------------------------- */
    @OneToMany(mappedBy = "student")  // Define the relationship with student_courses
    private List<student_courses> studentCourses;

    //define constructor
    public Student(){};

    public Student(String first_name, String last_name, String username, String password, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Student(String first_name, String last_name, String username, String password, String email, int paymentCard) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.paymentCard = paymentCard;
    }
    // seters and getter

    public int getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(int student_id) {
        Student_id = student_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(int paymentCard) {
        this.paymentCard = paymentCard;
    }
    // to string method


    @Override
    public String toString() {
        return "Student{" +
                "Student_id=" + Student_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
