
package com.klef.soa.sdp.service;

import com.klef.soa.sdp.entity.Subscription;
import com.klef.soa.sdp.repository.SubscriptionRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    // Create Subscription
    public Subscription createSubscription(Subscription subscription) {

        subscription.setStatus("ACTIVE");

        return subscriptionRepository.save(subscription);
    }

    // Get Subscription by ID
    public Subscription getSubscription(Long id) {

        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Subscription not found"));

        // Check whether subscription is expired
        if (subscription.getEndDate().isBefore(LocalDate.now())) {

            subscription.setStatus("EXPIRED");

            subscriptionRepository.save(subscription);
        }

        return subscription;
    }

    // Get all subscriptions of a user
    public List<Subscription> getUserSubscriptions(Long userId) {

        return subscriptionRepository.findByUserId(userId);
    }

    // Cancel Subscription
    public Subscription cancelSubscription(Long id) {

        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Subscription not found"));

        subscription.setStatus("CANCELLED");

        return subscriptionRepository.save(subscription);
    }

    // Renew Subscription
    public Subscription renewSubscription(Long id, int months) {

        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Subscription not found"));

        LocalDate currentEndDate = subscription.getEndDate();

        LocalDate newEndDate = currentEndDate.plusMonths(months);

        subscription.setEndDate(newEndDate);

        subscription.setStatus("ACTIVE");

        return subscriptionRepository.save(subscription);
    }
}
