package com.inditex.retail.pricing.prices.infrastructure.repository;

import com.inditex.retail.pricing.prices.core.repository.BookRepository;
import com.inditex.retail.pricing.prices.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends BookRepository, JpaRepository<Book, Long> {}
