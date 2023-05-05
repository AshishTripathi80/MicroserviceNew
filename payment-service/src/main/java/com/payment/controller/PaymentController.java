package com.payment.controller;

import com.payment.model.CreditCardDetails;
import com.payment.model.OTPRequest;
import com.payment.model.PaymentRequest;
import com.payment.service.PaymentService;
import com.payment.utility.GlobalResources;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private Logger logger = GlobalResources.getLogger(PaymentController.class);

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/initiate")
    public ResponseEntity<?> initiatePayment(@RequestBody PaymentRequest paymentRequest) {
        String email = paymentRequest.getEmail();
        CreditCardDetails creditCardDetails = paymentRequest.getCreditCardDetails();

        logger.info("Initiating payment for email: {}", email);

        // Generate and send OTP to the email address
        String otp = paymentService.generateOTP(email);
        paymentService.sendOTP(email, otp);

        // Save the credit card details in the database
        paymentService.saveCreditCardDetails(creditCardDetails);

        return ResponseEntity.ok("OTP sent successfully");
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyOTP(@RequestBody OTPRequest otpRequest, @RequestParam(value = "cardNumber") String cardNumber,@RequestParam(value = "price")Double price) {
        String otp = otpRequest.getOtp();
        String email=otpRequest.getEmail();
        CreditCardDetails card=paymentService.getCardByCardNumber(cardNumber);

        if (card == null) {
            logger.error("Invalid card number: {}", cardNumber);
            return ResponseEntity.badRequest().body("Invalid Card Number");
        }

        boolean isOTPValid = paymentService.verifyOTP(email, otp);

        if (isOTPValid) {
            // Perform payment transaction
            logger.info("OTP verified for card: {}", cardNumber);
            paymentService.performPaymentTransaction(card,price);
            return ResponseEntity.ok("Payment successful");
        } else {
            logger.error("Invalid OTP for card: {}", cardNumber);
            return ResponseEntity.badRequest().body("Invalid OTP");
        }
    }

    @PostMapping("/cancel")
    public ResponseEntity<?> cancelPayment(@RequestParam(value = "cardNumber") String cardNumber,@RequestParam(value = "price")Double price) {
        logger.info("Cancelling payment for card: {}", cardNumber);
        paymentService.performPaymentCancellation(cardNumber, price);
        return ResponseEntity.ok("Payment cancelled successfully");
    }

    @GetMapping("balance")
    public ResponseEntity<?> getBalance(@RequestParam(value = "cardNumber")String cardNumber){
        CreditCardDetails card=paymentService.getCardByCardNumber(cardNumber);
        if (card == null) {
            logger.error("Invalid card number: {}", cardNumber);
            return ResponseEntity.badRequest().body("Invalid Card Number");
        }
        logger.info("Retrieving balance for card: {}", cardNumber);
        return ResponseEntity.ok(card.getAvailableBalance());
    }

}
