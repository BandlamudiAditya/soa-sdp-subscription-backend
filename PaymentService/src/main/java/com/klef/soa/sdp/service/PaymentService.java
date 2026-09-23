package com.klef.soa.sdp.service;

import com.klef.soa.sdp.entity.Payment;

import java.util.List;

public interface PaymentService {

    Payment processPayment(Payment payment);

    Payment getPayment(Long id);

    List<Payment> getUserPayments(Long userId);

    List<Payment> getSubscriptionPayments(Long subscriptionId);

    Payment refundPayment(Long id);
}