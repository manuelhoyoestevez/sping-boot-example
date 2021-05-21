package com.inditex.retail.pricing.prices.core.model;

import javax.money.MonetaryAmount;
import java.time.Instant;

public interface Price {
    Long getId();

    Long getBrandId();

    Long getProductId();

    Long getPriority();

    Instant getStartDate();

    Instant getEndDate();

    MonetaryAmount getCost();
}
