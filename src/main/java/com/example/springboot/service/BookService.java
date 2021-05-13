package com.example.springboot.service;

import com.example.springboot.model.Book;

import java.util.List;

public interface BookService {
    Book save(Book account);

    List<Book> getBooks();
}
