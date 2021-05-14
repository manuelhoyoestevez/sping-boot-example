package com.inditex.retail.pricing.prices.infrastructure.repository;

import com.inditex.retail.pricing.prices.core.repository.BookRepository;
import com.inditex.retail.pricing.prices.core.model.Book;
import com.inditex.retail.pricing.prices.infrastructure.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface BookJpaRepository extends BookRepository, JpaRepository<BookEntity, Long> {
    default List<Book> selectAll() {
        return new ArrayList<>(this.findAll());
    }

    default Book insert(Book book) {
        return this.save(BookEntity.fromBook(book));
    }
}
