package com.example.myapp.dao.Payment;

import com.example.myapp.entity.Payment;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDAOImpl implements PaymentDAO{
    EntityManager entityManager;
    @Autowired
    public PaymentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Payment add(Payment p) {
        Payment tmp=entityManager.merge(p);
        return tmp;
    }
}
