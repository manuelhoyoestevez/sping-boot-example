package com.inditex.retail.pricing.prices.infrastructure.rest.spring.mapper;

import com.inditex.retail.pricing.prices.core.model.Price;
import com.inditex.retail.pricing.prices.infrastructure.entity.PriceEntity;
import com.inditex.retail.pricing.prices.infrastructure.rest.spring.dto.PriceDto;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class PriceMapperTest {

    @Test
    public void toDto() {
        Price price = new PriceEntity()
                .setId(8L)
                .setBrandId(9L)
                .setProductId(7L)
                .setStartDate(Instant.parse("2020-06-16T21:00:00Z"))
                .setEndDate(Instant.parse("2020-06-30T10:00:00Z"))
                .setPriority(2L)
                .setAmount(3L)
                .setCurrency("EUR");

        PriceDto priceDto = PriceMapper.getInstance().toDto(price);

        assertEquals(price.getId(), priceDto.getId());
        assertEquals(price.getBrandId(), priceDto.getBrandId());
        assertEquals(price.getProductId(), priceDto.getProductId());
        assertEquals(price.getStartDate(), priceDto.getStartDate().toInstant());
        assertEquals(price.getEndDate(), priceDto.getEndDate().toInstant());
        assertEquals(price.getCost().getCurrency().getCurrencyCode(), priceDto.getCurrency().name());
        assertEquals(price.getCost().getNumber().floatValue(), priceDto.getPrice());
    }
}
