package com.inditex.retail.pricing.prices.core.service;

import com.inditex.retail.pricing.prices.core.repository.BookRepository;
import com.inditex.retail.pricing.prices.core.model.Book;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.insert(book);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.selectAll();
    }
}
