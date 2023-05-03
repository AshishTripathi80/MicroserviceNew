package com.payment.model;

public class OTPRequest {

    private String email;
    private String otp;

    private Double price;

    // Constructors, getters and setters


    public OTPRequest() {
    }

    public OTPRequest(String email, String otp) {
        this.email = email;
        this.otp = otp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
