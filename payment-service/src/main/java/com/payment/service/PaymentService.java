package com.payment.service;

import com.payment.model.CreditCardDetails;
import com.payment.model.PaymentRequest;
import com.payment.repo.CreditCardDetailsRepository;
import com.payment.repo.PaymentRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class PaymentService {


    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private CreditCardDetailsRepository creditCardDetailsRepository;

    @Autowired
    private PaymentRequestRepo paymentRequestRepo;

    private Map<String, String> otpMap = new HashMap<>();

    public String generateOTP(String email) {
        String otp = String.valueOf(new Random().nextInt(999999));
        otpMap.put(email, otp);
        return otp;
    }

    public boolean verifyOTP(String email, String otp) {
        if (otpMap.containsKey(email)) {
            String savedOTP = otpMap.get(email);
            if (savedOTP.equals(otp)) {
                otpMap.remove(email);
                return true;
            }
        }
        return false;
    }

    public void sendOTP(String email, String otp) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setSubject("OTP for payment");
        msg.setText("Your OTP is " + otp);
        javaMailSender.send(msg);
    }

    public void saveCreditCardDetails(CreditCardDetails creditCardDetails) {
        creditCardDetailsRepository.save(creditCardDetails);
    }

    public void performPaymentTransaction(PaymentRequest paymentRequest) {

        CreditCardDetails creditCardDetails = paymentRequest.getCreditCardDetails();
        CreditCardDetails card = creditCardDetailsRepository.findByCardNumber(creditCardDetails.getCardNumber());
        double paymentAmount = paymentRequest.getAmount();
        double availableBalance = card.getAvailableBalance();
        if (paymentAmount > availableBalance) {
            throw new RuntimeException("Insufficient funds");
        }
        card.setAvailableBalance(availableBalance - paymentAmount);
        creditCardDetailsRepository.save(card);
    }

    public void performPaymentCancellation(PaymentRequest paymentRequest,Double cancelledAmount) {
        CreditCardDetails creditCardDetails = paymentRequest.getCreditCardDetails();
        CreditCardDetails card = creditCardDetailsRepository.findByCardNumber(creditCardDetails.getCardNumber());
        if (card == null) {
            throw new RuntimeException("No credit card found for CardNumber: " + creditCardDetails.getCardNumber());
        }
        double availableBalance = card.getAvailableBalance();
        card.setAvailableBalance(availableBalance + cancelledAmount);
        creditCardDetailsRepository.save(card);
    }

}

