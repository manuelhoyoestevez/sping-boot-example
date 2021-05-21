package com.inditex.retail.pricing.prices.core.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.inditex.retail.pricing.prices.core.model.Price;
import com.inditex.retail.pricing.prices.infrastructure.entity.PriceEntity;
import com.inditex.retail.pricing.prices.infrastructure.repository.PriceMemoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PriceServiceImplTest {
    private final PriceService priceService;

    PriceServiceImplTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        File resource = ResourceUtils.getFile("classpath:data.json");
        String data = new String(Files.readAllBytes(resource.toPath()));
        List<Price> prices = new ArrayList<>(objectMapper.readValue(data, new TypeReference<List<PriceEntity>>() {}));
        priceService = new PriceServiceImpl(new PriceMemoryRepository(prices));
    }

    @Test
    void getAllPrices() {
        List<Price> prices = priceService.getAllPrices();
        assertEquals(4, prices.size());
    }

    @Test
    void findPrices0() {
        Optional<Price> optionalPrice = priceService.findPrice(Instant.parse("2020-06-14T10:00:00Z"), (long) 2, (long) 2);
        assertTrue(optionalPrice.isEmpty());
    }

    @Test
    void findPrices1() {
        Optional<Price> optionalPrice = priceService.findPrice(Instant.parse("2020-06-14T10:00:00Z"), (long) 35455, (long) 1);
        assertTrue(optionalPrice.isPresent());
        assertEquals(1, optionalPrice.get().getId());
    }

    @Test
    void findPrices2() {
        Optional<Price> optionalPrice = priceService.findPrice(Instant.parse("2020-06-14T16:00:00Z"), (long) 35455, (long) 1);
        assertTrue(optionalPrice.isPresent());
        assertEquals(2, optionalPrice.get().getId());
    }

    @Test
    void findPrices3() {
        Optional<Price> optionalPrice = priceService.findPrice(Instant.parse("2020-06-14T21:00:00Z"), (long) 35455, (long) 1);
        assertTrue(optionalPrice.isPresent());
        assertEquals(1, optionalPrice.get().getId());
    }

    @Test
    void findPrices4() {
        Optional<Price> optionalPrice = priceService.findPrice(Instant.parse("2020-06-15T10:00:00Z"), (long) 35455, (long) 1);
        assertTrue(optionalPrice.isPresent());
        assertEquals(3, optionalPrice.get().getId());
    }

    @Test
    void findPrices5() {
        Optional<Price> optionalPrice = priceService.findPrice(Instant.parse("2020-06-16T21:00:00Z"), (long) 35455, (long) 1);
        assertTrue(optionalPrice.isPresent());
        assertEquals(4, optionalPrice.get().getId());
    }
}