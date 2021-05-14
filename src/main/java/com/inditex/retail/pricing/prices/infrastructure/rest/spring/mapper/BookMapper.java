package com.inditex.retail.pricing.prices.infrastructure.rest.spring.mapper;

import com.inditex.retail.pricing.prices.core.model.Book;
import com.inditex.retail.pricing.prices.infrastructure.entity.BookEntity;
import com.inditex.retail.pricing.prices.infrastructure.rest.spring.dto.BookDto;

public class BookMapper {
    private static BookMapper instance = null;

    public static BookMapper getInstance() {
        if(instance == null) {
            instance = new BookMapper();
        }

        return instance;
    }

    private BookMapper() {}

    public BookEntity fromDto(BookDto bookDto) {
        return new BookEntity()
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