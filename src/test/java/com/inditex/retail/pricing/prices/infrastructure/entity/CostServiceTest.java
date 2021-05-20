package com.inditex.retail.pricing.prices.infrastructure.entity;

import org.junit.jupiter.api.Test;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

import static org.junit.jupiter.api.Assertions.*;

class CostServiceTest {

    @Test
    void toLong() {
        CurrencyUnit currencyUnit = Monetary.getCurrency("EUR");
        Long longValue = CostService.getInstance().toLong(currencyUnit, 12.45);
        assertEquals(1245, longValue);
    }

    @Test
    void toDouble() {
        CurrencyUnit currencyUnit = Monetary.getCurrency("EUR");
        Double doubleValue = CostService.getInstance().toDouble(currencyUnit, 1485L);
        assertEquals(14.85, doubleValue);
    }
}
