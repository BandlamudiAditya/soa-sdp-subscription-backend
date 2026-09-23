package com.klef.soa.sdp.repository;

import com.klef.soa.sdp.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository
        extends JpaRepository<Subscription, Long> {

    List<Subscription> findByUserId(Long userId);

    List<Subscription> findByStatus(String status);

    Optional<Subscription> findBySubscriptionIdAndUserId(
            Long subscriptionId,
            Long userId
    );
}