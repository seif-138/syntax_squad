package com.example.myapp.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="instructor_id")
    private int id;
    @Column(name="username")
    private String user;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String pass;
    @Column(name="first_name")
    private String first_name;
    @Column(name="last_name")
    private String last_name;


    public Instructor(int id, String user, String email, String pass, String first_name, String last_name) {
        this.id = id;
        this.user = user;
        this.email = email;
        this.pass = pass;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Instructor(){};


    public Instructor(int id, String user, String email, String pass) {
        this.id = id;
        this.user = user;
        this.email = email;
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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



    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
