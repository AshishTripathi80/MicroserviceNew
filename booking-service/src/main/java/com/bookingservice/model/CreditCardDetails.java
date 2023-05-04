package com.bookingservice.model;

public class CreditCardDetails {
    private Long id;
    private String cardNumber;
    private String nameOnCard;
    private String expiryDate;
    private String cvv;

    private Double availableBalance=20000.00;


    // Getters and setters


    public CreditCardDetails(Long id, String cardNumber, String nameOnCard, String expiryDate, String cvv, Double availableBalance) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.availableBalance = availableBalance;
    }

    public Double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public CreditCardDetails() {
    }

    public CreditCardDetails(Long id, String cardNumber, String nameOnCard, String expiryDate, String cvv) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}

