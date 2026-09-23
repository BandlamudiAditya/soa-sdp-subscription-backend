package com.klef.soa.sdp.repository;

import com.klef.soa.sdp.entity.Payment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository
        extends JpaRepository<Payment, Long> {

    List<Payment> findByUserId(Long userId);

    List<Payment> findBySubscriptionId(Long subscriptionId);

    Optional<Payment> findByPaymentIdAndUserId(
            Long paymentId,
            Long userId
    );

    List<Payment> findByStatus(String status);
}