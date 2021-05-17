package com.inditex.retail.pricing.prices.core.service;

import com.inditex.retail.pricing.prices.core.repository.PriceRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PriceServiceImplTest {
    private static PriceService priceService;

    @BeforeAll
    public static void init() throws IOException {
        priceService = new PriceServiceImpl(new PriceRepositoryMock());
    }

    @Test
    void findPrice() {


    }
}