package com.example.bankingproductclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BankingProductClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingProductClientApplication.class, args);
    }

}
