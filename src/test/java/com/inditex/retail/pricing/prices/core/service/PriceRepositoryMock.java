package com.inditex.retail.pricing.prices.core.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.retail.pricing.prices.core.model.Price;
import com.inditex.retail.pricing.prices.core.repository.PriceRepository;
import com.inditex.retail.pricing.prices.infrastructure.entity.PriceEntity;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PriceRepositoryMock implements PriceRepository {
    private ObjectMapper objectMapper;
    private List<Price> prices;

    public PriceRepositoryMock() throws IOException {
        /*
        objectMapper = new ObjectMapper();
        File resource = ResourceUtils.getFile("classpath:data.json");
        String data = new String(Files.readAllBytes(resource.toPath()));
        prices = new ArrayList<>(objectMapper.readValue(data, new TypeReference<List<PriceEntity>>(){}));
         */
    }

    @Override
    public List<Price> getAllPrices() {
        return prices;
    }

    @Override
    public List<Price> findPrices(Instant date, Long productId, Long brandId) {
        return prices.stream().filter(
                price ->
                        price.getProductId().equals(productId) &&
                        price.getBrandId().equals(brandId) &&
                        price.getStartDate().isBefore(date) &&
                        price.getEndDate().isAfter(date)
        ).collect(Collectors.toList());
    }
}
