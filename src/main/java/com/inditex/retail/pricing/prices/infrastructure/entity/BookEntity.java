package com.inditex.retail.pricing.prices.infrastructure.entity;

import com.inditex.retail.pricing.prices.core.model.Book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookEntity implements Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String author;

    public Long getId() {
        return id;
    }

    public BookEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BookEntity setAuthor(String author) {
        this.author = author;
        return this;
    }

    public static BookEntity fromBook(Book book) {
        if (book instanceof BookEntity) {
            return (BookEntity) book;
        }

        return new BookEntity()
                .setId(book.getId())
                .setTitle(book.getTitle())
                .setAuthor(book.getAuthor());
    }
}
