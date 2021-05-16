package com.inditex.retail.pricing.prices.infrastructure.entity;

import com.inditex.retail.pricing.prices.core.model.Cost;
import com.inditex.retail.pricing.prices.core.model.Currency;
import com.inditex.retail.pricing.prices.core.model.Price;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "PRICES")
public class PriceEntity implements Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long brandId;
    private Long productId;
    private Long priority;
    private Instant startDate;
    private Instant endDate;
    private Long amount;
    private String currency;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Long getBrandId() {
        return brandId;
    }

    @Override
    public Long getProductId() {
        return productId;
    }

    @Override
    public Long getPriority() {
        return priority;
    }

    @Override
    public Instant getStartDate() {
        return startDate;
    }

    @Override
    public Instant getEndDate() {
        return endDate;
    }

    public Cost getCost() {
        Currency currency = Currency.valueOf(this.currency);
        Double amount = CostService.getInstance().toDouble(currency, this.amount);
        return new Cost(amount, currency);
    }
}
