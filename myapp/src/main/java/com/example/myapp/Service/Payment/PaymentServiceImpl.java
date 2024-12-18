package com.example.myapp.Service.Payment;

import com.example.myapp.dao.Payment.PaymentDAO;
import com.example.myapp.entity.Payment;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{
    PaymentDAO paymentDAO;
    @Autowired
    public PaymentServiceImpl(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }
    @Transactional
    @Override
    public Payment add(Payment p) {
        return paymentDAO.add(p);
    }
}
