package com.inditex.retail.pricing.prices.infrastructure.entity;

import com.inditex.retail.pricing.prices.core.model.Price;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
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

    @Override
    public MonetaryAmount getCost() {
        CurrencyUnit currencyUnit = Monetary.getCurrency(currency);
        return Monetary.getDefaultAmountFactory()
                .setNumber(CostService.getInstance().toDouble(currencyUnit, amount))
                .setCurrency(currencyUnit)
                .create();
    }

    public PriceEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public PriceEntity setBrandId(Long brandId) {
        this.brandId = brandId;
        return this;
    }

    public PriceEntity setProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    public PriceEntity setPriority(Long priority) {
        this.priority = priority;
        return this;
    }

    public PriceEntity setStartDate(Instant startDate) {
        this.startDate = startDate;
        return this;
    }

    public PriceEntity setEndDate(Instant endDate) {
        this.endDate = endDate;
        return this;
    }

    public PriceEntity setAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public PriceEntity setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}
