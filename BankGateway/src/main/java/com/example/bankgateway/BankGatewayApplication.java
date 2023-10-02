package com.example.bankgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BankGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankGatewayApplication.class, args);
    }

}
