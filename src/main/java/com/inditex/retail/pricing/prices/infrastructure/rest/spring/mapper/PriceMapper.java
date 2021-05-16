package com.inditex.retail.pricing.prices.infrastructure.rest.spring.mapper;

import com.inditex.retail.pricing.prices.infrastructure.entity.PriceEntity;
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

    public PriceDto toDto(PriceEntity priceEntity) {
        return new PriceDto()
                .id(priceEntity.getId())
                .productId(priceEntity.getProductId())
                .brandId(priceEntity.getBrandId())
                .startDate(priceEntity.getStartDate().atOffset(ZoneOffset.UTC))
                .endDate(priceEntity.getEndDate().atOffset(ZoneOffset.UTC));
    }
}
