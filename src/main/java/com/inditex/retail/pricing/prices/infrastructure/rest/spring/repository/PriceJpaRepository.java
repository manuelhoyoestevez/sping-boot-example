package com.inditex.retail.pricing.prices.infrastructure.rest.spring.repository;

import com.inditex.retail.pricing.prices.core.model.Price;
import com.inditex.retail.pricing.prices.core.repository.PriceRepository;
import com.inditex.retail.pricing.prices.infrastructure.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public interface PriceJpaRepository extends PriceRepository, JpaRepository<PriceEntity, Long> {

    @Query("SELECT P FROM PriceEntity P "
            + "WHERE P.productId = :productId AND P.brandId = :brandId AND :date BETWEEN P.startDate AND P.endDate"
    )
    List<PriceEntity> findPriceEntities(@Param("date") Instant date, @Param("productId") Long productId, @Param("brandId") Long brandId);

    default List<Price> findPrices(Instant date, Long productId, Long brandId) {
        return new ArrayList<>(findPriceEntities(date, productId, brandId));
    }

    default List<Price> getAllPrices() {
        return new ArrayList<>(findAll());
    }
}
