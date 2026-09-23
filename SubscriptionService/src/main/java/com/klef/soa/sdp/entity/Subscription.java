package com.klef.soa.sdp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscriptionId;

    @NotNull(message = "User ID is required")
    @Column(nullable = false)
    private Long userId;

    @NotBlank(message = "Plan name is required")
    @Column(nullable = false)
    private String planName;

    @NotNull(message = "Start date is required")
    @Column(nullable = false)
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    @Column(nullable = false)
    private LocalDate endDate;

    @NotBlank(message = "Status is required")
    @Column(nullable = false)
    private String status;


    // Default Constructor
    public Subscription() {
    }


    // Parameterized Constructor
    public Subscription(Long subscriptionId,
                        Long userId,
                        String planName,
                        LocalDate startDate,
                        LocalDate endDate,
                        String status) {

        this.subscriptionId = subscriptionId;
        this.userId = userId;
        this.planName = planName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
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


    // Getter and Setter for planName
    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }


    // Getter and Setter for startDate
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }


    // Getter and Setter for endDate
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}