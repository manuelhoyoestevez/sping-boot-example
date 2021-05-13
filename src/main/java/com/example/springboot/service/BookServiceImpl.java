package com.example.springboot.service;

import com.example.springboot.model.Book;
import com.example.springboot.repository.BookRepository;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private BookRepository repository;

    @Override
    @Transactional
    public Book save(Book account) {
        return repository.save(account);
    }

    @Override
    @Transactional
    public List<Book> getBooks() {
        return repository.findAll();
    }
}
