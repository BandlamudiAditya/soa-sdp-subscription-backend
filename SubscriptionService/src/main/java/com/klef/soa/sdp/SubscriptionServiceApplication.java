package com.klef.soa.sdp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SubscriptionServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                SubscriptionServiceApplication.class,
                args
        );
        System.out.println("Subscription Service is Running..!!");
    }
}