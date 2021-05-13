package com.inditex.retail.pricing.prices.core.repository;

import com.inditex.retail.pricing.prices.domain.entity.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();

    Book save(Book account);
}