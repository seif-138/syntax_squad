package com.example.myapp.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_courses")

public class student_courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private int id;
    @Column(name = "student_id" )
    private int student_id;
    @Column(name = "course_id")
    private int course_id;
    @Column(name = "enrolled_at")
    private LocalDateTime enrolled_at;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable=false, updatable=false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", insertable=false, updatable=false)
    private Courses course;

    public student_courses() {
    }

    public student_courses(int id, int student_id, int course_id) {
        this.id = id;
        this.student_id = student_id;
        this.course_id = course_id;
    }

    public student_courses(int id, int student_id, int course_id, LocalDateTime enrolled_at) {
        this.id = id;
        this.student_id = student_id;
        this.course_id = course_id;
        this.enrolled_at = enrolled_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDateTime getEnrolled_at() {
        return enrolled_at;
    }

    public void setEnrolled_at(LocalDateTime enrolled_at) {
        this.enrolled_at = enrolled_at;
    }

    @Override
    public String toString() {
        return "student_courses{" +
                "id=" + id +
                ", student_id=" + student_id +
                ", course_id=" + course_id +
                ", enrolled_at=" + enrolled_at +
                '}';
    }
}
