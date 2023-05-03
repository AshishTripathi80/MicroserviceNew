package com.payment.repo;

import com.payment.model.PaymentRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRequestRepo extends JpaRepository<PaymentRequest,String> {
    PaymentRequest findByEmail(String email);
}
