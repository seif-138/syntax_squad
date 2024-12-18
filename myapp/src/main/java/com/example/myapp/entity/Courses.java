package com.example.myapp.entity;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private double price;
    @Column(name = "instructor_id", insertable=false, updatable=false)
    private int instructorID;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor inst;
    @Column(name = "created_at")
    private char created_at;
    @Column(name = "description")
    private String description;
    @Lob
    @Column(name = "image_data")
    private byte[] image_data;

    public Courses() {
    }

    public Courses(int id, String title, double price, int instructorID, char created_at, byte[] image_data) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.instructorID = instructorID;
        this.created_at = created_at;
        this.image_data = image_data;
    }

    public Courses(int id, String title, double price, int instructorID, char created_at) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.instructorID = instructorID;
        this.created_at = created_at;
    }

    public Courses(int id, String title, double price, int instructorID, Instructor inst, char created_at, byte[] image_data) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.instructorID = instructorID;
        this.inst = inst;
        this.created_at = created_at;
        this.image_data = image_data;
    }

    public Courses(int id, String title, double price, int instructorID, Instructor inst, char created_at) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.instructorID = instructorID;
        this.inst = inst;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(int instructorID) {
        this.instructorID = instructorID;
    }

    public Instructor getInst() {
        return inst;
    }

    public void setInst(Instructor inst) {
        this.inst = inst;
    }

    public char getCreated_at() {
        return created_at;
    }

    public void setCreated_at(char created_at) {
        this.created_at = created_at;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage_data() {
        return image_data;
    }

    public void setImage_data(byte[] image_data) {
        this.image_data = image_data;
    }


    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", instructorID=" + instructorID +
                ", inst=" + inst +
                ", created_at=" + created_at +
                 +
                '}';
    }
}
