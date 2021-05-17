package com.inditex.retail.pricing.prices.core.repository;

import com.inditex.retail.pricing.prices.core.model.Price;

import java.time.Instant;
import java.util.List;

public interface PriceRepository {
    List<Price> getAllPrices();
    List<Price> findPrices(Instant date, Long productId, Long brandId);
}
