package com.klef.soa.sdp.service;

import com.klef.soa.sdp.entity.Payment;
import com.klef.soa.sdp.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment processPayment(Payment payment) {

        payment.setPaymentDate(LocalDate.now());
        payment.setStatus("SUCCESS");

        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPayment(Long id) {

        return paymentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Payment not found"));
    }

    @Override
    public List<Payment> getUserPayments(Long userId) {

        return paymentRepository.findByUserId(userId);
    }

    @Override
    public List<Payment> getSubscriptionPayments(Long subscriptionId) {

        return paymentRepository.findBySubscriptionId(subscriptionId);
    }

    @Override
    public Payment refundPayment(Long id) {

        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Payment not found"));

        if (!payment.getStatus().equals("SUCCESS")) {
            throw new RuntimeException(
                    "Only successful payments can be refunded");
        }

        payment.setStatus("REFUNDED");

        return paymentRepository.save(payment);
    }
}