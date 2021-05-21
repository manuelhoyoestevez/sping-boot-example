package com.inditex.retail.pricing.prices.infrastructure.rest.spring;

import com.inditex.retail.pricing.prices.core.repository.PriceRepository;
import com.inditex.retail.pricing.prices.core.service.PriceService;
import com.inditex.retail.pricing.prices.core.service.PriceServiceImpl;
import com.inditex.retail.pricing.prices.infrastructure.rest.spring.mapper.PriceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.inditex.retail.pricing.prices"})
public class ApplicationConfig {

    @Bean
    public PriceMapper priceMapper() {
        return PriceMapper.getInstance();
    }

    @Bean
    public PriceService priceService(PriceRepository priceRepository) {
        return new PriceServiceImpl(priceRepository);
    }
}
