package com.inditex.retail.pricing.prices.core.model;

import com.inditex.retail.pricing.prices.core.exception.InvalidCostException;

public class Cost {
    private Double amount;
    private Currency currency;

    public Cost(Double amount, Currency currency) {
        if (amount <= 0) {
            throw new InvalidCostException(amount);
        }
        this.amount = amount;
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }
}
