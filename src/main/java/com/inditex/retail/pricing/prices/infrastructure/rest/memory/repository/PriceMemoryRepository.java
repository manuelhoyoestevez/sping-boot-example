package com.inditex.retail.pricing.prices.infrastructure.rest.memory.repository;

import com.inditex.retail.pricing.prices.core.model.Price;
import com.inditex.retail.pricing.prices.core.repository.PriceRepository;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class PriceMemoryRepository implements PriceRepository {
    private List<Price> prices;

    public PriceMemoryRepository(List<Price> prices) {
        this.prices = prices;
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
