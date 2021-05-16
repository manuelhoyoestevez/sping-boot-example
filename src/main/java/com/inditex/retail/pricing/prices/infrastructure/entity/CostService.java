package com.inditex.retail.pricing.prices.infrastructure.entity;

import com.inditex.retail.pricing.prices.core.model.Currency;

public class CostService {
    private static CostService instance = null;

    public static CostService getInstance() {
        if (instance == null) {
            instance = new CostService();
        }
        return instance;
    }

    private CostService() {}

    public Long toLong(Currency currency, Double amount) {
        return Math.round(amount * Math.pow(10, currency.getDecimalPlaces()));
    }

    public Double toDouble(Currency currency, Long amount) {
        return (double) amount / Math.pow(10, currency.getDecimalPlaces());
    }
}
