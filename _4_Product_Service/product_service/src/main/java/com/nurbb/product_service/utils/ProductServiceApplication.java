package com.nurbb.product_service.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// Eureka
@EnableDiscoveryClient
@SpringBootApplication
public class ProductServiceApplication {

    // PSVM
    public static void main(String[] args) {


        // JOptional pane aktif etmek
        System.setProperty("java.awt.headless", "false");

        // Main
        SpringApplication.run(ProductServiceApplication.class, args);
    }

}
