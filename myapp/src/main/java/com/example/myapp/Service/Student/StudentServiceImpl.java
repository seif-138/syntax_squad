package com.example.myapp.Service.Student;

import com.example.myapp.Service.Student.StudentService;
import com.example.myapp.dao.Student.StudentDAO;
import com.example.myapp.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentDAO.findById(id);
    }
    @Override
    public Student findByEmail(String mail){
        return studentDAO.findByEmail(mail);
    }

    @Transactional
    @Override
    public Student save(Student s) {
        return studentDAO.save(s);

    }

    @Override
    public Student findByRecoveryKey(String key) {
        return studentDAO.findByRecoveryKey(key);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        studentDAO.deleteById(id);
    }
}
