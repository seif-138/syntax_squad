package com.example.myapp.dao.Instructor;

import com.example.myapp.dao.Instructor.InstructorDOA;
import com.example.myapp.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class InstructorDOAImpl implements InstructorDOA {
    private EntityManager entityManager;
    @Autowired
    public InstructorDOAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Instructor> findAll() {
        TypedQuery<Instructor> q=entityManager.createQuery("from Instructor",Instructor.class);
        List<Instructor> i=q.getResultList();
        return i;

    }
    @Override
    public Instructor findById(int id){
        try{
        Instructor i=entityManager.find(Instructor.class,id);
        return i;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Instructor findByEmail(String email) {
        try {
            TypedQuery<Instructor> q = entityManager.createQuery("from Instructor i where i.email=:mail", Instructor.class);
            if (q == null) {
                throw new RuntimeException("No instructor found with this mail");
            } else {
                q.setParameter("mail", email);
                Instructor i = q.getSingleResult();
                return i;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Instructor save(Instructor i) {
        Instructor t=entityManager.merge(i);
        return t;
    }

    @Override
    public void deleteById(int id) {
        Instructor i=findById(id);
        entityManager.remove(i);
    }
}
