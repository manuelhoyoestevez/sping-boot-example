package com.inditex.retail.pricing.prices.core.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.inditex.retail.pricing.prices.core.model.Price;
import com.inditex.retail.pricing.prices.infrastructure.entity.PriceEntity;
import com.inditex.retail.pricing.prices.infrastructure.rest.memory.repository.PriceMemoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PriceServiceImplTest {
    private final PriceService priceService;
    private final ObjectMapper objectMapper;
    private final List<Price> prices;

    PriceServiceImplTest() throws IOException {
        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        File resource = ResourceUtils.getFile("classpath:data.json");
        String data = new String(Files.readAllBytes(resource.toPath()));
        prices = new ArrayList<>(objectMapper.readValue(data, new TypeReference<List<PriceEntity>>(){}));
        priceService = new PriceServiceImpl(new PriceMemoryRepository(prices));
    }

    @Test
    void getAllPrices() {
        List<Price> prices = priceService.getAllPrices();
        assertEquals(4, prices.size());
    }

    @Test
    void findPrice() {


    }
}