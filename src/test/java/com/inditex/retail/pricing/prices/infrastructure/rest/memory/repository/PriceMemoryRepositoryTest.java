package com.inditex.retail.pricing.prices.infrastructure.rest.memory.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.inditex.retail.pricing.prices.core.model.Price;
import com.inditex.retail.pricing.prices.core.repository.PriceRepository;
import com.inditex.retail.pricing.prices.infrastructure.entity.PriceEntity;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PriceMemoryRepositoryTest {
    private ObjectMapper objectMapper;
    private File resource;
    private String data;
    private List<Price> prices;
    private PriceRepository priceRepository;

    public PriceMemoryRepositoryTest() throws IOException {
        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        resource = ResourceUtils.getFile("classpath:data.json");
        data = new String(Files.readAllBytes(resource.toPath()));
        prices = new ArrayList<>(objectMapper.readValue(data, new TypeReference<List<PriceEntity>>() {}));
        priceRepository = new PriceMemoryRepository(prices);
    }

    @Test
    void getAllPrices() {
        List<Price> prices = priceRepository.getAllPrices();
        assertEquals(4, prices.size());
    }

    @Test
    void findPrices() {
        List<Price> prices = priceRepository.findPrices(Instant.parse("2020-06-14T13:01:00Z"), (long) 35455, (long) 1);
        assertEquals(2, prices.size());
    }
}