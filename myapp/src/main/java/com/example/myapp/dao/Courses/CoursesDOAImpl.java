package com.example.myapp.dao.Courses;

import com.example.myapp.entity.Courses;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CoursesDOAImpl implements CoursesDOA{
    private EntityManager entityManager;
    @Autowired
    public CoursesDOAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Courses> findAll() {
        TypedQuery<Courses> query=entityManager.createQuery("from Courses ",Courses.class);
        List<Courses> c=query.getResultList();
        return c;
    }

    @Override
    public Courses findById(int id) {
        TypedQuery<Courses> query=entityManager.createQuery("from Courses c where c.id=:id ",Courses.class);
        query.setParameter("id",id);
        Courses c=query.getSingleResult();
        return c;
    }

    @Override
    public void deleteById(int id) throws Exception {
        Courses tmp=findById(id);
        if(tmp==null){
            throw new Exception("No course with this id");
        }
        entityManager.remove(tmp);
    }

    @Override
    public Courses save(Courses c) {
      Courses t=  entityManager.merge(c);
      return t;
    }
}
