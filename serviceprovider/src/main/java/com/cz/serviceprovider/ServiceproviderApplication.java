package com.cz.serviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServiceproviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceproviderApplication.class, args);
    }
}
