package com.inditex.retail.pricing.prices.infrastructure.entity;

import javax.money.CurrencyUnit;

public class CostService {
    private static CostService instance = null;

    public static CostService getInstance() {
        if (instance == null) {
            instance = new CostService();
        }
        return instance;
    }

    private CostService() {}

    public Long toLong(CurrencyUnit currencyUnit, Double amount) {
        return Math.round(amount * Math.pow(10, currencyUnit.getDefaultFractionDigits()));
    }

    public Double toDouble(CurrencyUnit currencyUnit, Long amount) {
        return (double) amount / Math.pow(10, currencyUnit.getDefaultFractionDigits());
    }
}
