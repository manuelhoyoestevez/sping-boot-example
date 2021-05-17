package com.inditex.retail.pricing.prices.infrastructure.rest.spring.mapper;

import com.inditex.retail.pricing.prices.core.model.Price;
import com.inditex.retail.pricing.prices.infrastructure.rest.spring.dto.PriceDto;

import java.time.ZoneOffset;

public class PriceMapper {
    private static PriceMapper instance = null;

    public static PriceMapper getInstance() {
        if(instance == null) {
            instance = new PriceMapper();
        }

        return instance;
    }

    private PriceMapper() {}

    public PriceDto toDto(Price price) {
        return new PriceDto()
                .id(price.getId())
                .productId(price.getProductId())
                .brandId(price.getBrandId())
                .startDate(price.getStartDate().atOffset(ZoneOffset.UTC))
                .endDate(price.getEndDate().atOffset(ZoneOffset.UTC))
                .price(price.getCost().getNumber().floatValue())
                .currency(PriceDto.CurrencyEnum.valueOf(price.getCost().getCurrency().getCurrencyCode()));
    }
}
