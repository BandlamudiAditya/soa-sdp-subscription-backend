package com.klef.soa.sdp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @NotNull(message = "Subscription ID is required")
    @Column(nullable = false)
    private Long subscriptionId;

    @NotNull(message = "User ID is required")
    @Column(nullable = false)
    private Long userId;

    @NotNull(message = "Amount is required")
    @Column(nullable = false)
    private Double amount;

    @NotBlank(message = "Payment method is required")
    @Column(nullable = false)
    private String paymentMethod;

    @Column(nullable = false)
    private LocalDate paymentDate;

    @Column(nullable = false)
    private String status;


    // Default Constructor
    public Payment() {
    }


    // Parameterized Constructor
    public Payment(Long paymentId,
                   Long subscriptionId,
                   Long userId,
                   Double amount,
                   String paymentMethod,
                   LocalDate paymentDate,
                   String status) {

        this.paymentId = paymentId;
        this.subscriptionId = subscriptionId;
        this.userId = userId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.status = status;
    }


    // Getter and Setter for paymentId

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }


    // Getter and Setter for subscriptionId

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }


    // Getter and Setter for userId

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    // Getter and Setter for amount

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


    // Getter and Setter for paymentMethod

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    // Getter and Setter for paymentDate

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }


    // Getter and Setter for status

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}