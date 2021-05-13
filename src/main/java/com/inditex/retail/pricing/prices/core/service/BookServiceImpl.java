package com.inditex.retail.pricing.prices.core.service;

import com.inditex.retail.pricing.prices.core.repository.BookRepository;
import com.inditex.retail.pricing.prices.domain.entity.Book;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
}
