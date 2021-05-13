package com.inditex.retail.pricing.prices.core.service;

import com.inditex.retail.pricing.prices.domain.entity.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);

    List<Book> getBooks();
}
