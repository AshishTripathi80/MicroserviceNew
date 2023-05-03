package com.payment.controller;

import com.payment.model.CreditCardDetails;
import com.payment.model.OTPRequest;
import com.payment.model.PaymentRequest;
import com.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/initiate")
    public ResponseEntity<?> initiatePayment(@RequestBody PaymentRequest paymentRequest) {
        String email = paymentRequest.getEmail();
        CreditCardDetails creditCardDetails = paymentRequest.getCreditCardDetails();


        // Generate and send OTP to the email address
        String otp = paymentService.generateOTP(email);
        paymentService.sendOTP(email, otp);

        // Save the credit card details in the database
        paymentService.saveCreditCardDetails(creditCardDetails);

        return ResponseEntity.ok("OTP sent successfully");
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyOTP(@RequestBody OTPRequest otpRequest, @RequestBody PaymentRequest paymentRequest) {
        String email = otpRequest.getEmail();
        String otp = otpRequest.getOtp();

        boolean isOTPValid = paymentService.verifyOTP(email, otp);

        if (isOTPValid) {
            // Perform payment transaction
            paymentService.performPaymentTransaction(paymentRequest);
            return ResponseEntity.ok("Payment successful");
        } else {
            return ResponseEntity.badRequest().body("Invalid OTP");
        }
    }


    @PostMapping("/cancel")
    public ResponseEntity<?> cancelPayment(@RequestBody PaymentRequest paymentRequest, @RequestParam Double cancelAmount) {
        paymentService.performPaymentCancellation(paymentRequest, cancelAmount);
        return ResponseEntity.ok("Payment cancelled successfully");
    }

}

