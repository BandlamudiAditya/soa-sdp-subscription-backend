package com.klef.soa.sdp.controller;

import com.klef.soa.sdp.entity.Payment;
import com.klef.soa.sdp.service.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@Tag(
    name = "Payment Service",
    description = "Mock payment management APIs"
)
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    // Process Payment

    @PostMapping
    @Operation(
        summary = "Process payment",
        description = "Processes a mock payment and marks it as SUCCESS"
    )
    public Payment processPayment(
            @Valid @RequestBody Payment payment) {

        return paymentService.processPayment(payment);
    }


    // Get Payment

    @GetMapping("/{id}")
    @Operation(
        summary = "Get payment",
        description = "Returns payment details using payment ID"
    )
    public Payment getPayment(
            @PathVariable Long id) {

        return paymentService.getPayment(id);
    }


    // Get User Payments

    @GetMapping("/user/{userId}")
    @Operation(
        summary = "Get user payments",
        description = "Returns all payments made by a user"
    )
    public List<Payment> getUserPayments(
            @PathVariable Long userId) {

        return paymentService.getUserPayments(userId);
    }


    // Get Subscription Payments

    @GetMapping("/subscription/{subscriptionId}")
    @Operation(
        summary = "Get subscription payments",
        description = "Returns all payments for a subscription"
    )
    public List<Payment> getSubscriptionPayments(
            @PathVariable Long subscriptionId) {

        return paymentService
                .getSubscriptionPayments(subscriptionId);
    }


    // Refund Payment

    @PutMapping("/{id}/refund")
    @Operation(
        summary = "Refund payment",
        description = "Marks a successful mock payment as refunded"
    )
    public Payment refundPayment(
            @PathVariable Long id) {

        return paymentService.refundPayment(id);
    }
}