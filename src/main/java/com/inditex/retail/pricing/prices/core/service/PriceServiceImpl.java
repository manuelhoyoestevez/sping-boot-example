package com.inditex.retail.pricing.prices.core.service;

import com.inditex.retail.pricing.prices.core.model.Price;
import com.inditex.retail.pricing.prices.core.repository.PriceRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public class PriceServiceImpl implements PriceService {
    private PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public List<Price> getAllPrices() {
        return this.priceRepository.getAllPrices();
    }

    @Override
    public Optional<Price> findPrice(Instant date, Long productId, Long brandId) {
        List<Price> prices = priceRepository.findPrices(date, productId, brandId);

        if (prices.isEmpty()) {
            return Optional.empty();
        }

        prices.sort((priceA, priceB) -> (int) (priceB.getPriority() - priceA.getPriority()));

        return Optional.of(prices.get(0));
    }
}
