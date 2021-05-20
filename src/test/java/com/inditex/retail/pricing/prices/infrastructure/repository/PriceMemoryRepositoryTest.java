package com.inditex.retail.pricing.prices.infrastructure.repository;

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
    private final PriceRepository priceRepository;

    public PriceMemoryRepositoryTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        File resource = ResourceUtils.getFile("classpath:data.json");
        String data = new String(Files.readAllBytes(resource.toPath()));
        List<Price> prices = new ArrayList<>(objectMapper.readValue(data, new TypeReference<List<PriceEntity>>() {}));
        priceRepository = new PriceMemoryRepository(prices);
    }

    @Test
    void getAllPrices() {
        List<Price> prices = priceRepository.getAllPrices();
        assertEquals(4, prices.size());
    }

    @Test
    void findPrices0() {
        List<Price> prices = priceRepository.findPrices(Instant.parse("2020-06-14T10:00:00Z"), (long) 2, (long) 2);
        assertEquals(0, prices.size());
    }

    @Test
    void findPrices1() {
        List<Price> prices = priceRepository.findPrices(Instant.parse("2020-06-14T10:00:00Z"), (long) 35455, (long) 1);
        assertEquals(1, prices.size());
        assertEquals(1, prices.get(0).getId());
    }

    @Test
    void findPrices2() {
        List<Price> prices = priceRepository.findPrices(Instant.parse("2020-06-14T16:00:00Z"), (long) 35455, (long) 1);
        assertEquals(2, prices.size());
        prices.sort((a, b) -> (int) (b.getPriority() - a.getPriority()));
        assertEquals(2, prices.get(0).getId());
        assertEquals(1, prices.get(1).getId());
    }

    @Test
    void findPrices3() {
        List<Price> prices = priceRepository.findPrices(Instant.parse("2020-06-14T21:00:00Z"), (long) 35455, (long) 1);
        assertEquals(1, prices.size());
        assertEquals(1, prices.get(0).getId());
    }

    @Test
    void findPrices4() {
        List<Price> prices = priceRepository.findPrices(Instant.parse("2020-06-15T10:00:00Z"), (long) 35455, (long) 1);
        assertEquals(2, prices.size());
        prices.sort((a, b) -> (int) (b.getPriority() - a.getPriority()));
        assertEquals(3, prices.get(0).getId());
        assertEquals(1, prices.get(1).getId());
    }

    @Test
    void findPrices5() {
        List<Price> prices = priceRepository.findPrices(Instant.parse("2020-06-16T21:00:00Z"), (long) 35455, (long) 1);
        assertEquals(2, prices.size());
        prices.sort((a, b) -> (int) (b.getPriority() - a.getPriority()));
        assertEquals(4, prices.get(0).getId());
        assertEquals(1, prices.get(1).getId());
    }
}
