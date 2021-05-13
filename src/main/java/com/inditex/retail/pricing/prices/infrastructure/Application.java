package com.inditex.retail.pricing.prices.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.inditex.retail.pricing.prices.infrastructure")
@EntityScan(basePackages = "com.inditex.retail.pricing.prices.domain")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
