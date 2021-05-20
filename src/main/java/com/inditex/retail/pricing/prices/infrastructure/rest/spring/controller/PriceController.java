package com.inditex.retail.pricing.prices.infrastructure.rest.spring.controller;

import com.inditex.retail.pricing.prices.core.model.Price;
import com.inditex.retail.pricing.prices.core.service.PriceService;
import com.inditex.retail.pricing.prices.infrastructure.rest.spring.api.PricesApi;
import com.inditex.retail.pricing.prices.infrastructure.rest.spring.dto.PriceDto;
import com.inditex.retail.pricing.prices.infrastructure.rest.spring.mapper.PriceMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class PriceController implements PricesApi {
    private PriceMapper priceMapper;

    private PriceService priceService;

    public PriceController(PriceMapper priceMapper, PriceService priceService) {
        this.priceMapper = priceMapper;
        this.priceService = priceService;
    }

    public ResponseEntity<List<PriceDto>> getPrices() {
        List<Price> prices = priceService.getAllPrices();
        List<PriceDto> priceDtos = prices.stream().map(priceMapper::toDto).collect(Collectors.toList());
        return new ResponseEntity<>(priceDtos, HttpStatus.OK);
    }

    public ResponseEntity<PriceDto> findPrice(Long brandId, Long productId, OffsetDateTime date) {
        Optional<Price> optionalPrice = priceService.findPrice(date.toInstant(), productId, brandId);

        if (optionalPrice.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        PriceDto priceDto = priceMapper.toDto(optionalPrice.get());

        return new ResponseEntity<>(priceDto, HttpStatus.OK);
    }
}
