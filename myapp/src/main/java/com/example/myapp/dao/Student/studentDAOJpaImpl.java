package com.example.myapp.dao.Student;

import com.example.myapp.dao.Student.StudentDAO;
import com.example.myapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class studentDAOJpaImpl implements StudentDAO {
    private EntityManager entityManager;

    @Autowired
    public studentDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> query=entityManager.createQuery("from Student",Student.class);
        //excute query and get result
        List<Student> st=query.getResultList();
        //return result
        return st;
    }
    @Override
    public Student findById(int id){
        try {
            Student s = entityManager.find(Student.class, id);
            return s;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public Student findByEmail(String mail){
        try {
            TypedQuery<Student> query = entityManager.createQuery("from Student s where s.email=:mail", Student.class);
            query.setParameter("mail", mail);
            Student s = query.getSingleResult();
            return s;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public Student findByRecoveryKey(String key) {
        try {
            TypedQuery<Student> query = entityManager.createQuery("from Student s where s.recovery_key=:key", Student.class);
            query.setParameter("key", key);
            Student s = query.getSingleResult();
            return s;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Student save(Student s) {

        Student tmp=entityManager.merge(s);
        return tmp;
    }

    @Override
    public void deleteById(int id) {
       Student tmp= findById(id);
       entityManager.remove(tmp);
    }
}
