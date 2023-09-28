package com.example.movementclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovementClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovementClientApplication.class, args);
    }

}
