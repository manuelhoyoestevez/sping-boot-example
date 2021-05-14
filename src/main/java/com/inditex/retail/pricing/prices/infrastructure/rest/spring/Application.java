package com.inditex.retail.pricing.prices.infrastructure.rest.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.inditex.retail.pricing.prices.infrastructure.rest.spring")
@EntityScan(basePackages = "com.inditex.retail.pricing.prices.infrastructure.entity")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
