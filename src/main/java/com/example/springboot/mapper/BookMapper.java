package com.example.springboot.mapper;

import com.example.springboot.dto.BookDto;
import com.example.springboot.model.Book;

public class BookMapper {
    private static BookMapper instance = null;

    public static BookMapper getInstance() {
        if(instance == null) {
            instance = new BookMapper();
        }

        return instance;
    }

    private BookMapper() {}


    public Book fromDto(BookDto bookDto) {
        return new Book()
                .setId(bookDto.getId())
                .setAuthor(bookDto.getAuthor())
                .setTitle(bookDto.getTitle());
    }

    public BookDto toDto(Book book) {
        return new BookDto()
                .id(book.getId())
                .author(book.getAuthor())
                .title(book.getTitle());
    }
}
