package com.example.myapp.rest;

import com.example.myapp.Service.Courses.CoursesService;
import com.example.myapp.Service.Student.StudentService;
import com.example.myapp.Service.Student_course.Student_courseService;
import com.example.myapp.dao.student_courses.student_coursesDOA;
import com.example.myapp.entity.Courses;
import com.example.myapp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentRestController {
    private StudentService studentService;
    private Student_courseService d;
    private CoursesService coursesService;
    @Autowired
    public StudentRestController(StudentService studentService, Student_courseService d, CoursesService coursesService) {
        this.studentService = studentService;
        this.d = d;
        this.coursesService = coursesService;
    }


//    public StudentRestController(StudentService studentService,  Student_courseService d) {
//        this.studentService = studentService;
//        this.d = d;
//    }



//    public StudentRestController(StudentService studentService) {
//        this.studentService = studentService;
//    }



    @GetMapping("/api")
    public String hw(){
        return "Hello World!";
    }

    @GetMapping("/students")
    public List<Student> findAll(){
        return studentService.findAll();
    }
    @GetMapping("/students/{id}")
    public Student findById(@PathVariable int id){
        Student s=studentService.findById(id);
        if(s==null){
            throw  new RuntimeException("Student not found");
        }
        return s ;

    }
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student s){
        s.setStudent_id(0);
        Student tmp=studentService.save(s);
        return tmp;

    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student s){

        Student tmp=studentService.save(s);
        return tmp;

    }

    @GetMapping("/students/course/{id}")
    public List<Courses> c(@PathVariable int id){
       List<Courses>s= d.findStudentCourses(id);
        System.out.println(s);
       return s;
    }
    @GetMapping(value = "/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] img(@PathVariable int id){
        Courses c= coursesService.findById(id);
        ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG);
        return c.getImage_data();
    }
}
