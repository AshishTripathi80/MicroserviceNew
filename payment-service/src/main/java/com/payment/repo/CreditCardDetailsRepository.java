package com.payment.repo;

import com.payment.model.CreditCardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardDetailsRepository extends JpaRepository<CreditCardDetails, Long> {

    CreditCardDetails findByCardNumber(String cardNumber);
}
