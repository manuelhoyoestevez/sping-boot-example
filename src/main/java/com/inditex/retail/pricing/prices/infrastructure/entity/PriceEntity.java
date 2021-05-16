package com.inditex.retail.pricing.prices.infrastructure.entity;

import com.inditex.retail.pricing.prices.core.model.Cost;
import com.inditex.retail.pricing.prices.core.model.Currency;
import com.inditex.retail.pricing.prices.core.model.Price;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Entity
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
        Double amount = currency.toDouble(this.amount);
        return new Cost(amount, currency);
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

    public PriceEntity setCost(Cost cost) {
        this.currency = cost.getCurrency().name();
        this.amount = cost.getCurrency().toLong(cost.getAmount());
        return this;
    }
}
