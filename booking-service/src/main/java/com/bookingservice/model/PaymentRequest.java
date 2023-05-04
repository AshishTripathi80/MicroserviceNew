package com.bookingservice.model;


public class PaymentRequest {


    private Long paymentId;

    private String email;
    private CreditCardDetails creditCardDetails;

    private Double amount;

    // Constructors, getters and setters


    public PaymentRequest() {
    }

    public PaymentRequest(String email, CreditCardDetails creditCardDetails) {
        this.email = email;
        this.creditCardDetails = creditCardDetails;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CreditCardDetails getCreditCardDetails() {
        return creditCardDetails;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setCreditCardDetails(CreditCardDetails creditCardDetails) {
        this.creditCardDetails = creditCardDetails;
    }
}

