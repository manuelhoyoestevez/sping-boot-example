package com.inditex.retail.pricing.prices.infrastructure.rest.spring.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.inditex.retail.pricing.prices.core.model.Price;
import com.inditex.retail.pricing.prices.core.service.PriceServiceImpl;
import com.inditex.retail.pricing.prices.infrastructure.entity.PriceEntity;
import com.inditex.retail.pricing.prices.infrastructure.repository.PriceMemoryRepository;
import com.inditex.retail.pricing.prices.infrastructure.rest.spring.api.PricesApi;
import com.inditex.retail.pricing.prices.infrastructure.rest.spring.dto.PriceDto;
import com.inditex.retail.pricing.prices.infrastructure.rest.spring.mapper.PriceMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PriceControllerTest {
    private final PricesApi priceController;

    public PriceControllerTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        File resource = ResourceUtils.getFile("classpath:data.json");
        String data = new String(Files.readAllBytes(resource.toPath()));
        List<Price> prices = new ArrayList<>(objectMapper.readValue(data, new TypeReference<List<PriceEntity>>() {}));
        PriceMemoryRepository priceRepository = new PriceMemoryRepository(prices);
        PriceServiceImpl priceService = new PriceServiceImpl(priceRepository);
        PriceMapper priceMapper = PriceMapper.getInstance();
        priceController = new PriceController(priceMapper, priceService);
    }

    @Test
    public void getPrices() {
        ResponseEntity<List<PriceDto>> responseEntity = priceController.getPrices();
        List<PriceDto> body = responseEntity.getBody();
        assertNotNull(body);
        assertEquals(4, body.size());
    }

    @Test
    void findPrices0() {
        ResponseEntity<PriceDto> responseEntity = priceController.findPrice((long) 2, (long) 2, Instant.parse("2021-12-31T23:59:59Z").atOffset(ZoneOffset.UTC));
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }

    @Test
    void findPrices1() {
        ResponseEntity<PriceDto> responseEntity = priceController.findPrice((long) 1, (long) 35455, Instant.parse("2020-06-14T10:00:00Z").atOffset(ZoneOffset.UTC));
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        PriceDto body = responseEntity.getBody();
        assertNotNull(body);
        assertEquals(1, body.getId());
    }

    @Test
    void findPrices2() {
        ResponseEntity<PriceDto> responseEntity = priceController.findPrice((long) 1, (long) 35455, Instant.parse("2020-06-14T16:00:00Z").atOffset(ZoneOffset.UTC));
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        PriceDto body = responseEntity.getBody();
        assertNotNull(body);
        assertEquals(2, body.getId());
    }

    @Test
    void findPrices3() {
        ResponseEntity<PriceDto> responseEntity = priceController.findPrice((long) 1, (long) 35455, Instant.parse("2020-06-14T21:00:00Z").atOffset(ZoneOffset.UTC));
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        PriceDto body = responseEntity.getBody();
        assertNotNull(body);
        assertEquals(1, body.getId());
    }

    @Test
    void findPrices4() {
        ResponseEntity<PriceDto> responseEntity = priceController.findPrice((long) 1, (long) 35455, Instant.parse("2020-06-15T10:00:00Z").atOffset(ZoneOffset.UTC));
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        PriceDto body = responseEntity.getBody();
        assertNotNull(body);
        assertEquals(3, body.getId());
    }

    @Test
    void findPrices5() {
        ResponseEntity<PriceDto> responseEntity = priceController.findPrice((long) 1, (long) 35455, Instant.parse("2020-06-16T21:00:00Z").atOffset(ZoneOffset.UTC));
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        PriceDto body = responseEntity.getBody();
        assertNotNull(body);
        assertEquals(4, body.getId());
    }
}
