package com.inditex.retail.pricing.prices.core.service;

import com.inditex.retail.pricing.prices.core.model.Price;

import java.time.Instant;
import java.util.Optional;

public interface PriceService {
    Optional<Price> findPrice(Instant date, Long productId, Long branchId);
}
