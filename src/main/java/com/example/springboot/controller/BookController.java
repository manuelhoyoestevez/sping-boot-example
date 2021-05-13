package com.example.springboot.controller;

import com.example.springboot.api.BookApi;
import com.example.springboot.dto.BookDto;
import com.example.springboot.mapper.BookMapper;
import com.example.springboot.model.Book;
import com.example.springboot.service.BookService;
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
        bookService.save(book);
        return ResponseEntity.ok(book.getTitle() + " is added");
    }

    @Override
    public ResponseEntity<List<BookDto>> getBooks() {
        List<Book> books = bookService.getBooks();
        List<BookDto> bookDtoList = books.stream().map(bookMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(bookDtoList);
    }
}
