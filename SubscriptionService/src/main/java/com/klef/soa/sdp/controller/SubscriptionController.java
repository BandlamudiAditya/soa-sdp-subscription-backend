package com.klef.soa.sdp.controller;

import com.klef.soa.sdp.entity.Subscription;
import com.klef.soa.sdp.service.SubscriptionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
@Tag(
    name = "Subscription Service",
    description = "Subscription management APIs"
)
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(
            SubscriptionService subscriptionService) {

        this.subscriptionService = subscriptionService;
    }


    @PostMapping
    @Operation(
        summary = "Create subscription",
        description = "Creates and activates a subscription"
    )
    public Subscription createSubscription(
            @Valid @RequestBody Subscription subscription) {

        return subscriptionService
                .createSubscription(subscription);
    }


    @GetMapping("/{id}")
    @Operation(
        summary = "Get subscription",
        description = "Returns subscription details"
    )
    public Subscription getSubscription(
            @PathVariable Long id) {

        return subscriptionService
                .getSubscription(id);
    }


    @GetMapping("/user/{userId}")
    @Operation(
        summary = "Get user subscriptions",
        description = "Returns all subscriptions belonging to a user"
    )
    public List<Subscription> getUserSubscriptions(
            @PathVariable Long userId) {

        return subscriptionService
                .getUserSubscriptions(userId);
    }


    @PutMapping("/{id}/cancel")
    @Operation(
        summary = "Cancel subscription",
        description = "Cancels an active subscription"
    )
    public Subscription cancelSubscription(
            @PathVariable Long id) {

        return subscriptionService
                .cancelSubscription(id);
    }


    @PutMapping("/{id}/renew")
    @Operation(
        summary = "Renew subscription",
        description = "Renews a subscription for the specified number of months"
    )
    public Subscription renewSubscription(
            @PathVariable Long id,
            @RequestParam int months) {

        return subscriptionService
                .renewSubscription(id, months);
    }
}