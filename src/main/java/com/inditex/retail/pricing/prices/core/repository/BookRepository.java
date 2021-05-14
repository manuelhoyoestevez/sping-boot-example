package com.inditex.retail.pricing.prices.core.repository;

import com.inditex.retail.pricing.prices.core.model.Book;

import java.util.List;

public interface BookRepository {
    Book insert(Book book);
    List<Book> selectAll();
}
