package com.inditex.retail.pricing.prices.infrastructure.rest.spring;

import com.inditex.retail.pricing.prices.core.repository.BookRepository;
import com.inditex.retail.pricing.prices.core.service.BookService;
import com.inditex.retail.pricing.prices.core.service.BookServiceImpl;
import com.inditex.retail.pricing.prices.infrastructure.rest.spring.mapper.BookMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.inditex.retail.pricing.prices"})
public class ApplicationConfig {

    @Bean
    public BookMapper bookMapper() {
        return BookMapper.getInstance();
    }

    @Bean
    public BookService bookService(BookRepository bookRepository) {
        return new BookServiceImpl(bookRepository);
    }
}
