package com.inditex.retail.pricing.prices.core.model;

public interface Book {
    Long getId() ;
    String getTitle();
    String getAuthor();

    Book setId(Long id);
    Book setTitle(String title);
    Book setAuthor(String author);
}
