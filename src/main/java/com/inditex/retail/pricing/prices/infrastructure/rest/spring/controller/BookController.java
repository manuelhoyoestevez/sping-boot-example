package com.inditex.retail.pricing.prices.infrastructure.rest.spring.controller;

import com.inditex.retail.pricing.prices.core.service.BookService;
import com.inditex.retail.pricing.prices.core.model.Book;
import com.inditex.retail.pricing.prices.infrastructure.rest.spring.api.BookApi;
import com.inditex.retail.pricing.prices.infrastructure.rest.spring.dto.BookDto;
import com.inditex.retail.pricing.prices.infrastructure.rest.spring.mapper.BookMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController implements BookApi {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public ResponseEntity<String> addBook(BookDto bookDto) {
        Book book = bookMapper.fromDto(bookDto);
        Book savedBook = bookService.saveBook(book);
        return ResponseEntity.ok(savedBook.getTitle() + " is added");
    }

    @Override
    public ResponseEntity<List<BookDto>> getBooks() {
        List<Book> books = bookService.getBooks();
        List<BookDto> bookDtoList = books.stream().map(bookMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(bookDtoList);
    }
}
