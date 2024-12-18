package com.example.myapp.Service.Instructor;

import com.example.myapp.Service.Instructor.InstructorService;
import com.example.myapp.dao.Instructor.InstructorDOA;
import com.example.myapp.entity.Instructor;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl  implements InstructorService {
    private InstructorDOA instructorDOA;
    @Autowired
    public InstructorServiceImpl(InstructorDOA instructorDOA) {
        this.instructorDOA = instructorDOA;
    }

    @Override
    public List<Instructor> findAll() {
        return instructorDOA.findAll();
    }

    @Override
    public Instructor findById(int id) {
        return instructorDOA.findById(id);
    }
    @Override
    public Instructor findByEmail(String email){
        return instructorDOA.findByEmail(email);
    }
    @Transactional
    @Override
    public Instructor save(Instructor i) {
        return instructorDOA.save(i);
    }
    @Transactional
    @Override
    public void deleteById(int id) {
        instructorDOA.deleteById(id);
    }
}
